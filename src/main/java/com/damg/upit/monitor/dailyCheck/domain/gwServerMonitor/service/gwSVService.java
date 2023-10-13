package com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.service;


import com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.model.MInsertGwSVMain;
import com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.model.MInsertGwSVProcChk;
import com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.repository.gwSVRepository;
import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.service.xmlBasicService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class gwSVService {

    private gwSVRepository gwRepository;
    private xmlBasicService basicService;
    private Long gwSVId;

    public gwSVService(gwSVRepository gwRepository, xmlBasicService basicService){
        this.gwRepository = gwRepository;
        this.basicService = basicService;
    }

    @Transactional(rollbackFor=Exception.class)
    public void InsertGwSVMainData(JsonNode jsonFromGwSVXmlData) throws Exception {

        MInsertGwSVMain mInsertGwSVMain = new MInsertGwSVMain();

        mInsertGwSVMain.setGwSVCd(jsonFromGwSVXmlData.findValue("hostname").asText());
        mInsertGwSVMain.setGwSVOs(jsonFromGwSVXmlData.findValue("osVersion").asText());
        mInsertGwSVMain.setGwSVIp(jsonFromGwSVXmlData.findValue("ipAddress").asText());
        mInsertGwSVMain.setGwSVCpuUsage(jsonFromGwSVXmlData.findValue("cpuUsage").asText());
        mInsertGwSVMain.setGwSVMemUsage(jsonFromGwSVXmlData.findValue("memUsage").asText());
        //SwapUsage는 모든 서버점검에서 사용하지 않으므로, Optional.ofNullable
        mInsertGwSVMain.setGwSVSwapUsage(String.valueOf(Optional.ofNullable
                (jsonFromGwSVXmlData.findValue("swapUsage").asText())));
        LocalDateTime getDataResult = basicService.getFormateDateTime(jsonFromGwSVXmlData.findValue("datetime").asText(),
                jsonFromGwSVXmlData.findValue("timeDate").asText());

        mInsertGwSVMain.setGwSVDateTime(getDataResult);

        log.info("method=InsertGwSVMainData, mInsertGwSVMain={}",mInsertGwSVMain);

        gwRepository.insertGwSVMainData(mInsertGwSVMain);
        gwSVId = mInsertGwSVMain.getGwSVId();
    }

    @Transactional(rollbackFor= Exception.class)
    public void InsertGwSVProcData(JsonNode jsonFromGwSVXmlData) throws Exception {

        JsonNode gwSVProcData = jsonFromGwSVXmlData.findValue("processChk");
        log.info("method=InsertGwSVProcData, getGwSVProcData={}",gwSVProcData);

        List<String> procDataToList = new ArrayList<>();
        for(JsonNode nodeData: gwSVProcData){
            procDataToList.add(nodeData.asText());
        }

        List<MInsertGwSVProcChk> insertGwSVProcChkList = getInsertGwSVProcData(procDataToList);
        for(MInsertGwSVProcChk mInsertGwSVProcChk : insertGwSVProcChkList){
            gwRepository.insertGwSVProcData(mInsertGwSVProcChk);
        }
    }
    public void InsertGwSVDiskData(JsonNode jsonFromGwSVXmlData) throws Exception {

    }

    public void InsertGwSVClustData(JsonNode jsonFromGwSVXmlData) throws Exception {

    }

    private List<MInsertGwSVProcChk> getInsertGwSVProcData(List<String> procDataToList){

        HashMap<String,String> procListToMap = new HashMap<>();
        for(String listData : procDataToList){
            String[] procArr = listData.split(",");
            procListToMap.put(procArr[0],procArr[1]);
        }

        List<MInsertGwSVProcChk> insertGwSVProcDataList = new ArrayList<>();
        Set<String> keySet = procListToMap.keySet();

        log.info("method=getInsertGwSVProcData, gwSVProcData_keySet={}",keySet);

        for(String key : keySet){
            MInsertGwSVProcChk mInsertGwSVProcChkData = new MInsertGwSVProcChk();
            mInsertGwSVProcChkData.setGwSVId(gwSVId);
            mInsertGwSVProcChkData.setGwSVProcCd(key);
            mInsertGwSVProcChkData.setGwSVProcData(procListToMap.get(key));
            insertGwSVProcDataList.add(mInsertGwSVProcChkData);
        }
        return insertGwSVProcDataList;
    }
}

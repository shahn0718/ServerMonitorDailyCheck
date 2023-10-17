package com.damg.upit.monitor.dailyCheck.domain.erpServerMonitor.service;


import com.damg.upit.monitor.dailyCheck.domain.erpServerMonitor.model.MInsertErpSVDiskUsage;
import com.damg.upit.monitor.dailyCheck.domain.erpServerMonitor.model.MInsertErpSVMain;
import com.damg.upit.monitor.dailyCheck.domain.erpServerMonitor.model.MInsertErpSVProcChk;
import com.damg.upit.monitor.dailyCheck.domain.erpServerMonitor.repository.erpSVRepository;
import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.service.xmlBasicService;
import com.fasterxml.jackson.databind.JsonNode;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class erpSVService {

    private erpSVRepository erpRepository;
    private xmlBasicService basicService;
    private Long erpSVId;

    public erpSVService(erpSVRepository erpRepository, xmlBasicService basicService){
        this.erpRepository = erpRepository;
        this.basicService = basicService;
    }

    @Transactional(rollbackFor= Exception.class)
    public void InsertErpSVMainData(JsonNode jsonFromErpSVXmlData) throws Exception{

        MInsertErpSVMain mInsertErpSVMain = new MInsertErpSVMain();

        mInsertErpSVMain.setErpSVCd(jsonFromErpSVXmlData.findValue("hostname").asText());
        mInsertErpSVMain.setErpSVOs(jsonFromErpSVXmlData.findValue("osVersion").asText());
        mInsertErpSVMain.setErpSVIp(jsonFromErpSVXmlData.findValue("ipAddress").asText());
        mInsertErpSVMain.setErpSVCpuUsage(jsonFromErpSVXmlData.findValue("cpuUsage").asText());
        mInsertErpSVMain.setErpSVMemUsage(jsonFromErpSVXmlData.findValue("memUsage").asText());
        mInsertErpSVMain.setErpSVSwapUsage(jsonFromErpSVXmlData.findValue("swapUsage").asText());

        LocalDateTime getDataResult = basicService.getFormateDateTime(jsonFromErpSVXmlData.findValue("datetime").asText(),
                jsonFromErpSVXmlData.findValue("timeDate").asText());

        mInsertErpSVMain.setErpSVDateTime(getDataResult);

        log.info("method=InsertErpSVMainData, mInsertErpSVMain={}",mInsertErpSVMain);

        erpRepository.insertErpSVMainData(mInsertErpSVMain);
        erpSVId = mInsertErpSVMain.getErpSVId();
    }

    @Transactional(rollbackFor = Exception.class)
    public void InsertErpSVProcData(JsonNode jsonFromErpSVXmlData) throws Exception {

        JsonNode erpSVProcData = jsonFromErpSVXmlData.findValue("processChk");
        log.info("method=InsertErpSVProcData, getErpSVProcData = {}", erpSVProcData);

        List<String> procDataToList = new ArrayList<>();
        for(JsonNode nodeData : erpSVProcData){
            procDataToList.add(nodeData.asText());
        }

        List<MInsertErpSVProcChk> insertErpSVProcDataList = getInsertErpSVProcData(procDataToList);
        for(MInsertErpSVProcChk mInsertErpSVProcChk : insertErpSVProcDataList){
            erpRepository.insertErpSVProcData(mInsertErpSVProcChk);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void InsertErpSVDiskData(JsonNode jsonFromErpSVXmlData) throws Exception{

        JsonNode erpSVDiskData = jsonFromErpSVXmlData.findValue("diskUsage");
        log.info("method=InsertErpSVDiskData, getErpSVDiskData = {}" ,erpSVDiskData);

        List<String> diskDataToList = new ArrayList<>();
        for(JsonNode nodeData: erpSVDiskData){
            diskDataToList.add(nodeData.asText());
        }

        List<MInsertErpSVDiskUsage> insertErpSVDiskDataList = getInsertErpSVDiskData(diskDataToList);
        for(MInsertErpSVDiskUsage mInsertErpSVDiskUsage : insertErpSVDiskDataList){
            erpRepository.insertErpSVDiskData(mInsertErpSVDiskUsage);
        }

    }

    private List<MInsertErpSVProcChk> getInsertErpSVProcData(List<String> procDataToList){


        HashMap<String,String> procListToMap = new HashMap<>();
        for(String listData : procDataToList){
            String[] procArr = listData.split(",");
            procListToMap.put(procArr[0],procArr[1]);
        }

        List<MInsertErpSVProcChk> insertErpSVProcDataList = new ArrayList<>();
        Set<String> keySet = procListToMap.keySet();

        log.info("method=getInsertErpSVProcData, erpSVProcData_keySet={}",keySet);

        for(String key: keySet){
            MInsertErpSVProcChk mInsertErpSVProcChkData = new MInsertErpSVProcChk();
            mInsertErpSVProcChkData.setErpSVId(erpSVId);
            mInsertErpSVProcChkData.setErpSVProcCd(key);
            mInsertErpSVProcChkData.setErpSVProcData(procListToMap.get(key));
            insertErpSVProcDataList.add(mInsertErpSVProcChkData);
        }

        return insertErpSVProcDataList;
    }

    private List<MInsertErpSVDiskUsage> getInsertErpSVDiskData(List<String> diskDataToList){


        HashMap<String,String> diskListToMap = new HashMap<>();
        for(String listData : diskDataToList){
            String[] procArr = listData.split(",");
            diskListToMap.put(procArr[0],procArr[1]);
        }

        List<MInsertErpSVDiskUsage> insertErpSVdiskDataList = new ArrayList<>();
        Set<String> keySet = diskListToMap.keySet();

        log.info("method=getInsertErpSVDiskData, erpSVProcData_keySet={}",keySet);

        for(String key: keySet){
            MInsertErpSVDiskUsage mInsertErpSVDiskUsage = new MInsertErpSVDiskUsage();
            mInsertErpSVDiskUsage.setErpSVId(erpSVId);
            mInsertErpSVDiskUsage.setErpSVDiskCd(key);
            mInsertErpSVDiskUsage.setErpSVDiskData(diskListToMap.get(key));
            insertErpSVdiskDataList.add(mInsertErpSVDiskUsage);
        }

        return insertErpSVdiskDataList;
    }

}

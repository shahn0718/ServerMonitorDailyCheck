package com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.service;


import com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.model.MInsertGwSVClustChk;
import com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.model.MInsertGwSVDiskUsage;
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
import java.util.stream.Collectors;

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

//      //SwapUsage는 모든 서버점검에서 사용하지 않으므로, Optional.ofNullable
        if(!(Optional.ofNullable(jsonFromGwSVXmlData.findValue("swapUsage")).isEmpty())){
            mInsertGwSVMain.setGwSVSwapUsage(jsonFromGwSVXmlData.findValue("swapUsage").asText());
        }
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

        Optional<JsonNode> gwSVDiskData = Optional.of(jsonFromGwSVXmlData.findValue("diskUsage"));
        log.info("method=InsertGwSVDiskData, getGwSVDiskData={}", gwSVDiskData);

        List<String> diskDataToList = new ArrayList<>();
        if(!gwSVDiskData.isEmpty()){

            gwSVDiskData.get().forEach(nodeData -> diskDataToList.add(nodeData.asText()));

            List<MInsertGwSVDiskUsage> insertGwSVDiskList = getInsertGwSVDiskData(diskDataToList);
            for(MInsertGwSVDiskUsage mInsertGwSVDiskUsage: insertGwSVDiskList){
                gwRepository.insertGwSVDiskData(mInsertGwSVDiskUsage);
            }
        }
    }


    @Transactional(rollbackFor= Exception.class)
    public void InsertGwSVClustData(JsonNode jsonFromGwSVXmlData) throws Exception {

        Optional<JsonNode> gwSVClustData = Optional.ofNullable(jsonFromGwSVXmlData.findValue("clusterChk"));
        log.info("method=InsertGwSVClustData, getGwSVClustData={}", gwSVClustData);

        List<String> clustDataToList = new ArrayList<>();
        if(!gwSVClustData.isEmpty()){
            gwSVClustData.get()
                    .forEach(nodeData -> clustDataToList.add(nodeData.asText()));
            List<MInsertGwSVClustChk> insertGwSVClustList = getInsertGwSVClustData(clustDataToList);
            for(MInsertGwSVClustChk mInsertGwSVClustChk: insertGwSVClustList){
                gwRepository.insertGwSVClustData(mInsertGwSVClustChk);
            }
        }

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

    private List<MInsertGwSVDiskUsage> getInsertGwSVDiskData(List<String> diskDataToList){

        HashMap<String,String> diskListToMap = new HashMap<>();
        for(String diskData: diskDataToList){
            String[] diskArr = diskData.split(",");
            diskListToMap.put(diskArr[0],diskArr[1]);
        }

        List<MInsertGwSVDiskUsage> insertGwSVDiskUsageData = new ArrayList<>();
        Set<String> keySet = diskListToMap.keySet();

        log.info("method=getInsertGwSVDiskData, gwSVDiskData_keySet={}",keySet);
        for(String key : keySet){
            MInsertGwSVDiskUsage mInsertGwSVDiskUsageData = new MInsertGwSVDiskUsage();
            mInsertGwSVDiskUsageData.setGwSVId(gwSVId);
            mInsertGwSVDiskUsageData.setGwSVDiskCd(key);
            mInsertGwSVDiskUsageData.setGwSVDiskData(diskListToMap.get(key));
            insertGwSVDiskUsageData.add(mInsertGwSVDiskUsageData);
        }

        return insertGwSVDiskUsageData;
    }

    private List<MInsertGwSVClustChk> getInsertGwSVClustData(List<String> clustDataToList){

        HashMap<String, String> clustMap = new HashMap<>();
        List<String> clustList = new ArrayList<>();

        System.out.println("clustDataToList = " + clustDataToList);

        for(String data: clustDataToList){
            String[] array = data.split(",");
            if(array.length > 2){
                for(int i=0; i<array.length; i++) {
                    System.out.println("array[i}] = " + array[i]);
                    clustList.add(array[i]);
                }
            }else{
                clustMap.put(array[0],array[1]);
            }
        }

        log.info("clustList = {} ",clustList);
        log.info("clustMap = {} ",clustMap);

        List<MInsertGwSVClustChk> insertDbClustList = new ArrayList<>();

        int cnt=0;
        int listNum=0;
        while(cnt<clustList.size()/3) {
            MInsertGwSVClustChk mInsertGwSVClustChkData = new MInsertGwSVClustChk();
            mInsertGwSVClustChkData.setGwSVId(gwSVId);
            mInsertGwSVClustChkData.setGwSVClustCd(clustList.get(listNum));
            mInsertGwSVClustChkData.setGwSVClustPod(clustList.get(listNum+1));
            mInsertGwSVClustChkData.setGwSVClustStatus(clustList.get(listNum+2));
            insertDbClustList.add(mInsertGwSVClustChkData);
            cnt+=1;
            listNum+=3;
        }
        Set<String> keySet = clustMap.keySet();
        if(!clustMap.isEmpty()){
            for(String key: keySet){
                MInsertGwSVClustChk mInsertGwSVClustChkData = new MInsertGwSVClustChk();
                mInsertGwSVClustChkData.setGwSVId(gwSVId);
                mInsertGwSVClustChkData.setGwSVClustCd(key);
                mInsertGwSVClustChkData.setGwSVClustPod(clustMap.get(key));
                insertDbClustList.add(mInsertGwSVClustChkData);
            }
        }
        return insertDbClustList;
    }
}

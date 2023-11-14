package com.damg.upit.monitor.dailyCheck.domain.infraServerMonitor.service;


import com.damg.upit.monitor.dailyCheck.domain.infraServerMonitor.model.MInsertInfraSVDiskUsage;
import com.damg.upit.monitor.dailyCheck.domain.infraServerMonitor.model.MInsertInfraSVMain;
import com.damg.upit.monitor.dailyCheck.domain.infraServerMonitor.model.MInsertInfraSVProcChk;
import com.damg.upit.monitor.dailyCheck.domain.infraServerMonitor.repository.infraSVRepository;
import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.service.xmlBasicService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class infraSVService {

    private infraSVRepository infraRepository;
    private xmlBasicService basicService;
    private Long infraSVId;

    public infraSVService(infraSVRepository infraRepository, xmlBasicService basicService){
        this.infraRepository = infraRepository;
        this.basicService = basicService;
    }

    @Transactional(rollbackFor=Exception.class)
    public void InsertInfraSVMainData(JsonNode jsonFromInfraSVXmlData) throws Exception {

        MInsertInfraSVMain mInsertInfraSVMain = new MInsertInfraSVMain();

        mInsertInfraSVMain.setInfraSVCd(jsonFromInfraSVXmlData.findValue("hostname").asText());
        mInsertInfraSVMain.setInfraSVOs(jsonFromInfraSVXmlData.findValue("osVersion").asText());
        mInsertInfraSVMain.setInfraSVIp(jsonFromInfraSVXmlData.findValue("ipAddress").asText());
        mInsertInfraSVMain.setInfraSVCpuUsage(jsonFromInfraSVXmlData.findValue("cpuUsage").asText());
        mInsertInfraSVMain.setInfraSVMemUsage(jsonFromInfraSVXmlData.findValue("memUsage").asText());

        if(!Optional.ofNullable(jsonFromInfraSVXmlData.findValue("loadNum")).isEmpty()){
            mInsertInfraSVMain.setInfraSVLoadNum(jsonFromInfraSVXmlData.findValue("loadNum").asText());
        }

        if(!Optional.ofNullable(jsonFromInfraSVXmlData.findValue("swapUsage")).isEmpty()){
            mInsertInfraSVMain.setInfraSVSwapUsage(jsonFromInfraSVXmlData.findValue("swapUsage").asText());
        }

        LocalDateTime getDataResult = basicService.getFormateDateTime(jsonFromInfraSVXmlData.findValue("datetime").asText(),
                jsonFromInfraSVXmlData.findValue("timeDate").asText());

        mInsertInfraSVMain.setInfraSVDateTime(getDataResult);
        log.info("method=InsertInfraSVMainData, mInsertInfraSVMain={}", mInsertInfraSVMain);
        infraRepository.insertInfraSVMainData(mInsertInfraSVMain);
        infraSVId = mInsertInfraSVMain.getInfraSVId();
    }

    @Transactional(rollbackFor = Exception.class)
    public void InsertInfraSVProcData(JsonNode jsonFromInfraSVXmlData) throws Exception {

        Optional<JsonNode> infraSVProcData = Optional.ofNullable(jsonFromInfraSVXmlData.findValue("processChk"));
        log.info("method=InsertInfraSVProcData, getInfraSVProcData = {}", infraSVProcData);

        List<String> procDataToList = new ArrayList<>();
        if(!infraSVProcData.isEmpty()){

            infraSVProcData.get().forEach(nodeData-> procDataToList.add(nodeData.asText()));

            List<MInsertInfraSVProcChk> insertErpSVProcDataList = getInsertInfraSVProcData(procDataToList);
            for(MInsertInfraSVProcChk mInsertInfraSVProcChk : insertErpSVProcDataList){
                infraRepository.insertInfraSVProcData(mInsertInfraSVProcChk);
            }
        }
    }
    @Transactional(rollbackFor = Exception.class)
    public void InsertInfraSVDiskData(JsonNode jsonFromInfraSVXmlData) throws Exception {

        Optional <JsonNode> infraSVDiskData = Optional.ofNullable(jsonFromInfraSVXmlData.findValue("diskUsage"));
        log.info("method=InsertInfraSVDiskData, getInfraSVDiskData = {}", infraSVDiskData);

        List<String> diskDataToList = new ArrayList<>();
        if(!infraSVDiskData.isEmpty()){

            infraSVDiskData.get().forEach(nodeData -> diskDataToList.add(nodeData.asText()));

            List<MInsertInfraSVDiskUsage> insertInfraSVDiskList = getInsertInfraSVDiskData(diskDataToList);
            for(MInsertInfraSVDiskUsage mInsertInfraSVDiskUsage: insertInfraSVDiskList){
                infraRepository.insertInfraSVDiskData(mInsertInfraSVDiskUsage);
            }
        }
    }

    private List<MInsertInfraSVProcChk> getInsertInfraSVProcData(List<String> procDataToList){

        HashMap<String,String> procListToMap = new HashMap<>();
        for(String listData : procDataToList){
            String[] procArr = listData.split(",");
            procListToMap.put(procArr[0],procArr[1]);
        }

        List<MInsertInfraSVProcChk> insertInfraSVProcDataList = new ArrayList<>();
        Set<String> keySet = procListToMap.keySet();

        log.info("method=getInsertInfraSVProcData, infraSVProcData_keySet={}",keySet);

        for(String key : keySet){
            MInsertInfraSVProcChk mInsertInfraSVProcChkData = new MInsertInfraSVProcChk();
            mInsertInfraSVProcChkData.setInfraSVId(infraSVId);
            mInsertInfraSVProcChkData.setInfraSVProcCd(key);
            mInsertInfraSVProcChkData.setInfraSVProcData(procListToMap.get(key));
            insertInfraSVProcDataList.add(mInsertInfraSVProcChkData);
        }
        return insertInfraSVProcDataList;
    }

    private List<MInsertInfraSVDiskUsage> getInsertInfraSVDiskData(List<String> diskDataToList){

        HashMap<String,String> diskListToMap = new HashMap<>();
        for(String diskData: diskDataToList){
            String[] diskArr = diskData.split(",");
            diskListToMap.put(diskArr[0],diskArr[1]);
        }

        List<MInsertInfraSVDiskUsage> insertInfraSVDiskUsageData = new ArrayList<>();
        Set<String> keySet = diskListToMap.keySet();

        log.info("method=getInsertInfraSVDiskData, infraSVDiskData_keySet={}",keySet);
        for(String key : keySet){
            MInsertInfraSVDiskUsage mInsertInfraSVDiskUsageData = new MInsertInfraSVDiskUsage();
            mInsertInfraSVDiskUsageData.setInfraSVId(infraSVId);
            mInsertInfraSVDiskUsageData.setInfraSVDiskCd(key);
            mInsertInfraSVDiskUsageData.setInfraSVDiskData(diskListToMap.get(key));
            insertInfraSVDiskUsageData.add(mInsertInfraSVDiskUsageData);
        }

        return insertInfraSVDiskUsageData;
    }




}

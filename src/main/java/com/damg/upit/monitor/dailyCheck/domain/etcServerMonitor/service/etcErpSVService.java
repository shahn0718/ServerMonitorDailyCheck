package com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.service;

import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.model.MInsertEtcSVDiskUsage;
import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.model.MInsertEtcSVMain;
import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.model.MInsertEtcSVProcChk;
import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.repository.etcErpSVRepository;
import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.service.xmlBasicService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class etcErpSVService {

    private etcErpSVRepository etcRepository;
    private xmlBasicService basicService;
    private Long etcSVId;

    public etcErpSVService(etcErpSVRepository etcRepository, xmlBasicService basicService){
        this.etcRepository = etcRepository;
        this.basicService = basicService;
    }

    @Transactional(rollbackFor = Exception.class)
    public void InsertEtcSVMainData(JsonNode jsonFromEtcSVXmlData) throws Exception{

        MInsertEtcSVMain mInsertEtcSVMain = new MInsertEtcSVMain();

        mInsertEtcSVMain.setEtcSVCd(jsonFromEtcSVXmlData.findValue("hostname").asText());
        mInsertEtcSVMain.setEtcSVOs(jsonFromEtcSVXmlData.findValue("osVersion").asText());
        mInsertEtcSVMain.setEtcSVIp(jsonFromEtcSVXmlData.findValue("ipAddress").asText());
        mInsertEtcSVMain.setEtcSVCpuUsage(jsonFromEtcSVXmlData.findValue("cpuUsage").asText());
        mInsertEtcSVMain.setEtcSVMemUsage(jsonFromEtcSVXmlData.findValue("memUsage").asText());
        mInsertEtcSVMain.setEtcSVSwapUsage(jsonFromEtcSVXmlData.findValue("swapUsage").asText());

        LocalDateTime getDataResult = basicService.getFormateDateTime(jsonFromEtcSVXmlData.findValue("datetime").asText(),
                jsonFromEtcSVXmlData.findValue("timeDate").asText());

        mInsertEtcSVMain.setEtcSVDateTime(getDataResult);

        log.info("method=InsertEtcSVMainData, mInsertEtcSVMain={}", mInsertEtcSVMain);

        etcRepository.insertEtcSVMainData(mInsertEtcSVMain);
        etcSVId = mInsertEtcSVMain.getEtcSVId();

    }

    @Transactional(rollbackFor = Exception.class)
    public void InsertEtcSVProcData(JsonNode jsonFromEtcSVXmlData) throws Exception {

        Optional<JsonNode> etcSVProcData = Optional.ofNullable(jsonFromEtcSVXmlData.findValue("processChk"));
        log.info("method=InsertEtcSVProcData, getEtcSVProcData={}", etcSVProcData);

        List<String> procDataToList = new ArrayList<>();
        if(!etcSVProcData.isEmpty()){

            etcSVProcData.get().forEach(nodeData -> procDataToList.add(nodeData.asText()));

            List<MInsertEtcSVProcChk> insertEtcSVProcList = getInsertEtcSVProcData(procDataToList);
            for(MInsertEtcSVProcChk mInsertEtcSVProcChk : insertEtcSVProcList){
                etcRepository.insertEtcSVProcData(mInsertEtcSVProcChk);
            }
        }

    }

    @Transactional(rollbackFor = Exception.class)
    public void InsertEtcSVDiskData(JsonNode jsonFromEtcSVXmlData) throws Exception {

        Optional<JsonNode> etcSVDiskData = Optional.ofNullable(jsonFromEtcSVXmlData.findValue("diskUsage"));
        log.info("method=InsertEtcSVDiskData, getEtcSVDiskData={}", etcSVDiskData);

        List<String> diskDataToList = new ArrayList<>();
        if(!etcSVDiskData.isEmpty()){

            etcSVDiskData.get().forEach(nodeData-> diskDataToList.add(nodeData.asText()));

            List<MInsertEtcSVDiskUsage> insertEtcSVDiskList = getInsertEtcSVDiskData(diskDataToList);
            for(MInsertEtcSVDiskUsage mInsertEtcSVDiskUsage : insertEtcSVDiskList){
                etcRepository.insertEtcSVDiskData(mInsertEtcSVDiskUsage);
            }
        }

    }
    private List<MInsertEtcSVProcChk> getInsertEtcSVProcData(List<String> procDataToList){

        HashMap<String, String> procListToMap = new HashMap<>();
        for(String listData : procDataToList){
            String[] procArr = listData.split(",");
            procListToMap.put(procArr[0],procArr[1]);
        }

        List<MInsertEtcSVProcChk> insertEtcSVProcDataList = new ArrayList<>();
        Set<String> keySet = procListToMap.keySet();

        log.info("method=getInsertEtcSVProcData, etcSVProcData_keySet={}",keySet);

        for(String key : keySet){
            MInsertEtcSVProcChk mInsertEtcSVProcChk = new MInsertEtcSVProcChk();
            mInsertEtcSVProcChk.setEtcSVId(etcSVId);
            mInsertEtcSVProcChk.setEtcSVProcCd(key);
            mInsertEtcSVProcChk.setEtcSVProcData(procListToMap.get(key));
            insertEtcSVProcDataList.add(mInsertEtcSVProcChk);
        }

        return insertEtcSVProcDataList;
    }

    private List<MInsertEtcSVDiskUsage> getInsertEtcSVDiskData(List<String> diskDataToList){

        HashMap<String, String> diskListToMap = new HashMap<>();
        for(String diskData : diskDataToList){
            String[] diskArr = diskData.split(",");
            diskListToMap.put(diskArr[0],diskArr[1]);
        }

        List<MInsertEtcSVDiskUsage> insertEtcSVDiskUsageData = new ArrayList<>();
        Set<String> keySet = diskListToMap.keySet();

        log.info("method=getInsertEtcSVDiskData, etcSVDiskData_keySet={}", keySet);
        for(String key : keySet){
            MInsertEtcSVDiskUsage mInsertEtcSVDiskUsageData = new MInsertEtcSVDiskUsage();
            mInsertEtcSVDiskUsageData.setEtcSVDiskId(etcSVId);
            mInsertEtcSVDiskUsageData.setEtcSVDiskCd(key);
            mInsertEtcSVDiskUsageData.setEtcSVDiskData(diskListToMap.get(key));
            insertEtcSVDiskUsageData.add(mInsertEtcSVDiskUsageData);
        }

        return insertEtcSVDiskUsageData;
    }

}

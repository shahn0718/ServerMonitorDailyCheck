package com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.service;

import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.model.MInsertEtcSVDiskUsage;
import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.model.MInsertEtcSVMain;
import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.model.MInsertEtcSVProcChk;
import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.repository.etcSVRepository;
import com.damg.upit.monitor.dailyCheck.domain.infraServerMonitor.model.MInsertInfraSVDiskUsage;
import com.damg.upit.monitor.dailyCheck.domain.infraServerMonitor.model.MInsertInfraSVProcChk;
import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.service.xmlBasicService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class etcSVService {

    private etcSVRepository etcRepository;
    private xmlBasicService basicService;

    //한번 확인해보자
    private Long etcErpSVId;
    private Long etcEhrSVId;

    public etcSVService(etcSVRepository etcRepository, xmlBasicService basicService){
        this.etcRepository = etcRepository;
        this.basicService = basicService;
    }

    @Transactional(rollbackFor = Exception.class)
    public void InsertEtcErpSVMainData(JsonNode jsonFromEtcErpSVXmlData) throws Exception{

        MInsertEtcSVMain mInsertEtcErpSVMain = new MInsertEtcSVMain();

        mInsertEtcErpSVMain.setEtcSVCd(jsonFromEtcErpSVXmlData.findValue("hostname").asText());
        mInsertEtcErpSVMain.setEtcSVOs(jsonFromEtcErpSVXmlData.findValue("osVersion").asText());
        mInsertEtcErpSVMain.setEtcSVIp(jsonFromEtcErpSVXmlData.findValue("ipAddress").asText());
        mInsertEtcErpSVMain.setEtcSVCpuUsage(jsonFromEtcErpSVXmlData.findValue("cpuUsage").asText());
        mInsertEtcErpSVMain.setEtcSVMemUsage(jsonFromEtcErpSVXmlData.findValue("memUsage").asText());

        if(!Optional.ofNullable(jsonFromEtcErpSVXmlData.findValue("swapUsage")).isEmpty()) {
            mInsertEtcErpSVMain.setEtcSVSwapUsage(jsonFromEtcErpSVXmlData.findValue("swapUsage").asText());
        }

        LocalDateTime getDataResult = basicService.getFormateDateTime(jsonFromEtcErpSVXmlData.findValue("datetime").asText(),
                jsonFromEtcErpSVXmlData.findValue("timeDate").asText());

        mInsertEtcErpSVMain.setEtcSVDateTime(getDataResult);

        log.info("method=InsertEtcErpSVMainData, mInsertEtcErpSVMain={}", mInsertEtcErpSVMain);

        etcRepository.insertEtcErpSVMainData(mInsertEtcErpSVMain);
        etcErpSVId = mInsertEtcErpSVMain.getEtcErpSVId();

    }
    @Transactional(rollbackFor = Exception.class)
    public void InsertEtcErpSVProcData(JsonNode jsonFromEtcErpSVXmlData) throws Exception {

        Optional<JsonNode> etcSVErpProcData = Optional.ofNullable(jsonFromEtcErpSVXmlData.findValue("processChk"));
        log.info("method=InsertEtcErpSVProcData, getEtcErpSVProcData={}", etcSVErpProcData);

        List<String> procDataToList = new ArrayList<>();
        if(!etcSVErpProcData.isEmpty()){

            etcSVErpProcData.get().forEach(nodeData -> procDataToList.add(nodeData.asText()));

            List<MInsertEtcSVProcChk> insertEtcErpSVProcList = getInsertEtcErpSVProcData(procDataToList);
            for(MInsertEtcSVProcChk mInsertEtcSVProcChk : insertEtcErpSVProcList){
                etcRepository.insertEtcErpSVProcData(mInsertEtcSVProcChk);
            }
        }

    }
    @Transactional(rollbackFor = Exception.class)
    public void InsertEtcErpSVDiskData(JsonNode jsonFromEtcErpSVXmlData) throws Exception {

        Optional<JsonNode> etcSVErpDiskData = Optional.ofNullable(jsonFromEtcErpSVXmlData.findValue("diskUsage"));
        log.info("method=InsertEtcErpSVDiskData, getEtcErpSVDiskData={}", etcSVErpDiskData);

        List<String> diskDataToList = new ArrayList<>();
        if(!etcSVErpDiskData.isEmpty()){

            etcSVErpDiskData.get().forEach(nodeData-> diskDataToList.add(nodeData.asText()));

            List<MInsertEtcSVDiskUsage> insertEtcErpSVDiskList = getInsertEtcErpSVDiskData(diskDataToList);
            for(MInsertEtcSVDiskUsage mInsertEtcSVDiskUsage : insertEtcErpSVDiskList){
                etcRepository.insertEtcErpSVDiskData(mInsertEtcSVDiskUsage);
            }
        }
    }
    private List<MInsertEtcSVProcChk> getInsertEtcErpSVProcData(List<String> procDataToList){

        HashMap<String, String> procListToMap = new HashMap<>();
        for(String listData : procDataToList){
            String[] procArr = listData.split(",");
            procListToMap.put(procArr[0],procArr[1]);
        }

        List<MInsertEtcSVProcChk> insertEtcErpSVProcDataList = new ArrayList<>();
        Set<String> keySet = procListToMap.keySet();

        log.info("method=getInsertEtcErpSVProcData, etcErpSVProcData_keySet={}",keySet);

        for(String key : keySet){
            MInsertEtcSVProcChk mInsertEtcSVProcChk = new MInsertEtcSVProcChk();
            mInsertEtcSVProcChk.setEtcErpSVId(etcErpSVId);
            mInsertEtcSVProcChk.setEtcSVProcCd(key);
            mInsertEtcSVProcChk.setEtcSVProcData(procListToMap.get(key));
            insertEtcErpSVProcDataList.add(mInsertEtcSVProcChk);
        }
        return insertEtcErpSVProcDataList;
    }
    private List<MInsertEtcSVDiskUsage> getInsertEtcErpSVDiskData(List<String> diskDataToList){

        HashMap<String, String> diskListToMap = new HashMap<>();
        for(String diskData : diskDataToList){
            String[] diskArr = diskData.split(",");
            diskListToMap.put(diskArr[0],diskArr[1]);
        }

        List<MInsertEtcSVDiskUsage> insertEtcErpSVDiskUsageData = new ArrayList<>();
        Set<String> keySet = diskListToMap.keySet();

        log.info("method=getInsertEtcErpSVDiskData, etcErpSVDiskData_keySet={}", keySet);
        for(String key : keySet){
            MInsertEtcSVDiskUsage mInsertEtcSVDiskUsageData = new MInsertEtcSVDiskUsage();
            mInsertEtcSVDiskUsageData.setEtcErpSVId(etcErpSVId);
            mInsertEtcSVDiskUsageData.setEtcSVDiskCd(key);
            mInsertEtcSVDiskUsageData.setEtcSVDiskData(diskListToMap.get(key));
            insertEtcErpSVDiskUsageData.add(mInsertEtcSVDiskUsageData);
        }
        return insertEtcErpSVDiskUsageData;
    }

    @Transactional(rollbackFor = Exception.class)
    public void InsertEtcEhrSVMainData(JsonNode jsonFromEtcEhrSVXmlData) throws Exception{

        MInsertEtcSVMain mInsertEtcEhrSVMain = new MInsertEtcSVMain();
        mInsertEtcEhrSVMain.setEtcSVCd(jsonFromEtcEhrSVXmlData.findValue("hostname").asText());
        mInsertEtcEhrSVMain.setEtcSVOs(jsonFromEtcEhrSVXmlData.findValue("osVersion").asText());
        mInsertEtcEhrSVMain.setEtcSVIp(jsonFromEtcEhrSVXmlData.findValue("ipAddress").asText());
        mInsertEtcEhrSVMain.setEtcSVCpuUsage(jsonFromEtcEhrSVXmlData.findValue("cpuUsage").asText());
        mInsertEtcEhrSVMain.setEtcSVMemUsage(jsonFromEtcEhrSVXmlData.findValue("memUsage").asText());

        if(!Optional.ofNullable(jsonFromEtcEhrSVXmlData.findValue("swapUsage")).isEmpty()) {
            mInsertEtcEhrSVMain.setEtcSVSwapUsage(jsonFromEtcEhrSVXmlData.findValue("swapUsage").asText());
        }

        LocalDateTime getDataResult = basicService.getFormateDateTime(jsonFromEtcEhrSVXmlData.findValue("datetime").asText(),
                jsonFromEtcEhrSVXmlData.findValue("timeDate").asText());

        mInsertEtcEhrSVMain.setEtcSVDateTime(getDataResult);
        log.info("method=InsertEtcEhrSVMainData, mInsertEtcEhrSVMain={}", mInsertEtcEhrSVMain);

        etcRepository.insertEtcEhrSVMainData(mInsertEtcEhrSVMain);
        etcEhrSVId = mInsertEtcEhrSVMain.getEtcEhrSVId();
    }

    @Transactional(rollbackFor=Exception.class)
    public void InsertEtcEhrSVProcData(JsonNode jsonFromEtcEhrSVXmlData) throws Exception {

        Optional <JsonNode> etcEhrSVProcData = Optional.ofNullable(jsonFromEtcEhrSVXmlData.findValue("processChk"));
        log.info("method=InsertEtcEhrSVProcData, getEtcEhrSVProcData = {}", etcEhrSVProcData);

        List<String> procDataToList = new ArrayList<>();
        if(!etcEhrSVProcData.isEmpty()){

            etcEhrSVProcData.get().forEach(nodeData-> procDataToList.add(nodeData.asText()));

            List<MInsertEtcSVProcChk> insertEtcEhrSVProcDataList = getInsertEtcEhrSVProcData(procDataToList);
            for(MInsertEtcSVProcChk mInsertEtcSVProcChk : insertEtcEhrSVProcDataList){
                etcRepository.insertEtcEhrSVProcData(mInsertEtcSVProcChk);
            }
        }
    }

    @Transactional(rollbackFor=Exception.class)
    public void InsertEtcEhrSVDiskData(JsonNode jsonFromEtcEhrSVXmlData) throws Exception {

        Optional <JsonNode> etcEhrSVDiskData = Optional.ofNullable(jsonFromEtcEhrSVXmlData.findValue("diskUsage"));
        log.info("method=InsertEtcEhrSVDiskData, getEtcEhrSVDiskData = {}", etcEhrSVDiskData);

        List<String> diskDataToList = new ArrayList<>();
        if(!etcEhrSVDiskData.isEmpty()){

            etcEhrSVDiskData.get().forEach(nodeData->diskDataToList.add(nodeData.asText()));

            List<MInsertEtcSVDiskUsage> insertEtcEhrSVDiskDataList = getInsertEtcEhrSVDiskData(diskDataToList);
            for(MInsertEtcSVDiskUsage mInsertEtcSVDiskUsage : insertEtcEhrSVDiskDataList){
                etcRepository.insertEtcEhrSVDiskData(mInsertEtcSVDiskUsage);
            }
        }

    }
    private List<MInsertEtcSVProcChk> getInsertEtcEhrSVProcData(List<String> procDataToList){

        HashMap<String,String> procListToMap = new HashMap<>();
        for(String listData : procDataToList){
            String[] procArr = listData.split(",");
            procListToMap.put(procArr[0],procArr[1]);
        }

        List<MInsertEtcSVProcChk> insertEtcEhrSVProcDataList = new ArrayList<>();
        Set<String> keySet = procListToMap.keySet();

        log.info("method=getInsertEtcEhrSVProcData, etcEhrSVProcData_keySet={}",keySet);

        for(String key : keySet){
            MInsertEtcSVProcChk mInsertEtcEhrSVProcChkData = new MInsertEtcSVProcChk();
            mInsertEtcEhrSVProcChkData.setEtcEhrSVId(etcEhrSVId);
            mInsertEtcEhrSVProcChkData.setEtcSVProcCd(key);
            mInsertEtcEhrSVProcChkData.setEtcSVProcData(procListToMap.get(key));
            insertEtcEhrSVProcDataList.add(mInsertEtcEhrSVProcChkData);
        }
        return insertEtcEhrSVProcDataList;
    }

    private List<MInsertEtcSVDiskUsage> getInsertEtcEhrSVDiskData(List<String> diskDataToList){

        HashMap<String,String> diskListToMap = new HashMap<>();
        for(String diskData: diskDataToList){
            String[] diskArr = diskData.split(",");
            diskListToMap.put(diskArr[0],diskArr[1]);
        }

        List<MInsertEtcSVDiskUsage> insertEtcEhrSVDiskUsageData = new ArrayList<>();
        Set<String> keySet = diskListToMap.keySet();

        log.info("method=getInsertEtcEhrSVDiskData, etcEhrSVDiskData_keySet={}",keySet);
        for(String key : keySet){
            MInsertEtcSVDiskUsage mInsertEtcEhrSVDiskUsageData = new MInsertEtcSVDiskUsage();
            mInsertEtcEhrSVDiskUsageData.setEtcEhrSVId(etcEhrSVId);
            mInsertEtcEhrSVDiskUsageData.setEtcSVDiskCd(key);
            mInsertEtcEhrSVDiskUsageData.setEtcSVDiskData(diskListToMap.get(key));
            insertEtcEhrSVDiskUsageData.add(mInsertEtcEhrSVDiskUsageData);
        }

        return insertEtcEhrSVDiskUsageData;
    }

}

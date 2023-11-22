package com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.controller;


import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.service.etcSVService;
import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.model.MXmlFilePath;
import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.service.xmlBasicService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@Slf4j
@RestController
public class etcSVController {

    private final etcSVService etcService;
    private final xmlBasicService basicService;

    public etcSVController(etcSVService etcService, xmlBasicService basicService){
        this.etcService = etcService;
        this.basicService = basicService;
    }

    /**
     * ETC Erp 관련
     * @return
     * @throws Exception
     */
    @Scheduled(fixedRate = 930000)
    @GetMapping("/makeEtcErpSVXmlList")
    @Transactional(rollbackFor = Exception.class)
    public String getEtcErpSVXmlList() throws Exception{

        List<File> fileListFromDir = basicService.getFileFromDir(MXmlFilePath.chaErpSVFilePath);
        log.info("fileListFromDir= {}", fileListFromDir);

        for(File fileName : fileListFromDir){
            log.info("etcErpSVFileName={}", fileName);
            JsonNode jsonFromEtcErpSVXMlData = basicService.toJsonFromSVXmlData(String.valueOf(fileName));

            etcService.InsertEtcErpSVMainData(jsonFromEtcErpSVXMlData);
            etcService.InsertEtcErpSVProcData(jsonFromEtcErpSVXMlData);
            etcService.InsertEtcErpSVDiskData(jsonFromEtcErpSVXMlData);
        }
        return "makeEtcErpSVXmlList";
    }

    /**
     * ETC Ehr 관련
     * @return
     * @throws Exception
     */
    @Scheduled(fixedRate = 940000)
    @GetMapping("/makeEtcEhrSVXmlList")
    @Transactional(rollbackFor = Exception.class)
    public String getEtcEhrSVXmlList() throws Exception{

        List<File> fileListFromDir = basicService.getFileFromDir(MXmlFilePath.chaEhrSVFilePath);
        log.info("fileListFromDir={}", fileListFromDir);

        for(File fileName : fileListFromDir){
            log.info("etcEhrSVFileName={}" , fileName);
            JsonNode jsonFromEtcEhrSVXmlData = basicService.toJsonFromSVXmlData(String.valueOf(fileName));

            etcService.InsertEtcEhrSVMainData(jsonFromEtcEhrSVXmlData);
            etcService.InsertEtcEhrSVProcData(jsonFromEtcEhrSVXmlData);
            etcService.InsertEtcEhrSVDiskData(jsonFromEtcEhrSVXmlData);
        }
        return "makeEtcEhrSVXmlList";
    }
}

package com.damg.upit.monitor.dailyCheck.domain.erpServerMonitor.controller;

import com.damg.upit.monitor.dailyCheck.domain.erpServerMonitor.service.erpSVService;
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

@RestController
@Slf4j
public class erpSVController {

    private final erpSVService erpService;
    private final xmlBasicService basicService;

    public erpSVController(erpSVService erpService, xmlBasicService basicService){
        this.erpService = erpService;
        this.basicService = basicService;
    }

    @Scheduled(fixedRate = 960000)
    @GetMapping("/makeErpSVXmlList")
    @Transactional(rollbackFor = Exception.class)
    public String getErpSVXMlList() throws Exception{

        List<File> fileListFromDir = basicService.getFileFromDir(MXmlFilePath.erpSVFilePath);
        log.info("fileListFromDir={}",fileListFromDir);

        for(File fileName: fileListFromDir){
            log.info("erpSVFileName = {}", fileName);
            JsonNode jsonFromErpSVXmlData = basicService.toJsonFromSVXmlData(String.valueOf(fileName));
            erpService.InsertErpSVMainData(jsonFromErpSVXmlData);
            erpService.InsertErpSVProcData(jsonFromErpSVXmlData);
            erpService.InsertErpSVDiskData(jsonFromErpSVXmlData);
        }

        return "makeErpSVXmlList";
    }



}

package com.damg.upit.monitor.dailyCheck.domain.infraServerMonitor.controller;


import com.damg.upit.monitor.dailyCheck.domain.infraServerMonitor.service.infraSVService;
import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.model.MXmlFilePath;
import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.service.xmlBasicService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@Slf4j
@RestController
public class infraSVController {

    private final infraSVService infraService;
    private final xmlBasicService basicService;
    public infraSVController(infraSVService infraService, xmlBasicService basicService){
        this.infraService = infraService;
        this.basicService = basicService;
    }

    @Scheduled(fixedRate=920000)
    @GetMapping("/makeInfraSVXmlList")
    @Transactional(rollbackFor = Exception.class)
    public String getInfraSVXmlList() throws Exception {

        List<File> fileListFromDir = basicService.getFileFromDir(MXmlFilePath.infraSVFilePath);
        log.info("fileListFromDir={}",fileListFromDir);

        for(File fileName : fileListFromDir){
            log.info("infraSVFileName = {}", fileName);
            JsonNode jsonFromGwSVXmlData = basicService.toJsonFromSVXmlData(String.valueOf(fileName));

            infraService.InsertInfraSVMainData(jsonFromGwSVXmlData);
            infraService.InsertInfraSVProcData(jsonFromGwSVXmlData);
            infraService.InsertInfraSVDiskData(jsonFromGwSVXmlData);
        }
        return "makeInfraSVXmlList";
    }
}

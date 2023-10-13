package com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.controller;


import com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.service.gwSVService;
import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.model.MXmlFilePath;
import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.service.xmlBasicService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@Slf4j
@RestController
public class gwSVController {

    private final gwSVService gwService;
    private final xmlBasicService basicService;

    public gwSVController(gwSVService gwService, xmlBasicService basicService){
        this.gwService = gwService;
        this.basicService = basicService;
    }

    @GetMapping("/makeGwSVXmlList")
    @Transactional(rollbackFor = Exception.class)
    public String getGwSVXmlList() throws Exception {

        List<File> fileListFromDir = basicService.getFileFromDir(MXmlFilePath.gwSVFilePath);
        log.info("fileListFromDir={}",fileListFromDir);

        for(File fileName : fileListFromDir){
            log.info("gwSVFileName = {}", fileName);
            JsonNode jsonFromGwSVXmlData = basicService.toJsonFromSVXmlData(String.valueOf(fileName));
            gwService.InsertGwSVMainData(jsonFromGwSVXmlData);

        }

        return "makeGwSVXmlList";
    }
}

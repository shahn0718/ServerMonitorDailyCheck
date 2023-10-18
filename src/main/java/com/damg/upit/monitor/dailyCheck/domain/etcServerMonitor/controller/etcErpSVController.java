package com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.controller;


import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.service.etcErpSVService;
import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.model.MXmlFilePath;
import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.service.xmlBasicService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.util.List;

@Slf4j
@Controller
public class etcErpSVController {

    private final etcErpSVService etcService;
    private final xmlBasicService basicService;

    public etcErpSVController(etcErpSVService etcService,xmlBasicService basicService){
        this.etcService = etcService;
        this.basicService = basicService;
    }

    @GetMapping("/makeEtcSVXmlList")
    @Transactional(rollbackFor = Exception.class)
    public String getEtcErpSVXmlList() throws Exception{

        List<File> fileListFromDir = basicService.getFileFromDir(MXmlFilePath.etcErpSVFilePath);
        log.info("fileListFromDir= {}", fileListFromDir);

        for(File fileName : fileListFromDir){
            log.info("etcErpSVFileName={}", fileName);
            JsonNode jsonFromEtcSVXMlData = basicService.toJsonFromSVXmlData(String.valueOf(fileName));

            etcService.InsertEtcSVMainData(jsonFromEtcSVXMlData);
            etcService.InsertEtcSVProcData(jsonFromEtcSVXMlData);
            etcService.InsertEtcSVDiskData(jsonFromEtcSVXMlData);
        }
        return "makeEtcSVXmlList";
    }
}

package com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.controller;


import com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.service.gwSVService;
import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.model.MXmlFilePath;
import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.model.MXmlServerName;
import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.service.xmlBasicService;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.net.TLSClientHelloExtractor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@Slf4j
@Controller
public class gwSVController {

    private final gwSVService gwService;
    private final xmlBasicService basicService;

    public gwSVController(gwSVService gwService, xmlBasicService basicService){
        this.gwService = gwService;
        this.basicService = basicService;
    }

    @Scheduled(fixedRate = 900000)
    @GetMapping("/makeGwSVXmlList")
    @Transactional(rollbackFor = Exception.class)
    public String getGwSVXmlList() throws Exception {

        List<File> fileListFromDir = basicService.getFileFromDir(MXmlFilePath.gwSVFilePath);
        log.info("fileListFromDir={}",fileListFromDir);

        for(File fileName : fileListFromDir){

            log.info("gwSVFileName = {}", fileName);
            JsonNode jsonFromGwSVXmlData = basicService.toJsonFromSVXmlData(String.valueOf(fileName));

            gwService.InsertGwSVMainData(jsonFromGwSVXmlData);
            gwService.InsertGwSVProcData(jsonFromGwSVXmlData);
            gwService.InsertGwSVDiskData(jsonFromGwSVXmlData);
            gwService.InsertGwSVClustData(jsonFromGwSVXmlData);
        }
        return "makeGwSVXmlList";
    }


    @GetMapping("/getGwSVXmlList")
    public String makeGwSVXmlList(Model model, HttpServletRequest request) throws Exception {

        List<File> fileListFromDir = basicService.getFileFromDir(MXmlFilePath.gwSVFilePath);
        log.info("fileListFromDir={}",fileListFromDir);

        for(File fileName : fileListFromDir) {
            log.info("gwSVFileName = {}", fileName);
            JsonNode jsonFromGwSVXmlData = basicService.toJsonFromSVXmlData(String.valueOf(fileName));

            System.out.println("jsonFromGwSVXmlData = " + jsonFromGwSVXmlData.findValue("hostname").asText());




            if( jsonFromGwSVXmlData.findValue("hostname").asText().equals("gw-node3")){
                System.out.println("HELLO ");
            request.setAttribute("gwnode3",gwService.getGwSVMainData(jsonFromGwSVXmlData));
            }else if(jsonFromGwSVXmlData.findValue("hostname").asText().equals("gw-node1")){
                System.out.println("HELLO ");
                request.setAttribute("gwnode1",gwService.getGwSVMainData(jsonFromGwSVXmlData));
            }

        }

        return "gwServer/dailyChkGenieus";
    }
}

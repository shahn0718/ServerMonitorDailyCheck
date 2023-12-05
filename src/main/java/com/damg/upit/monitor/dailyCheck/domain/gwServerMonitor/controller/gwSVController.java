package com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.controller;


import com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.service.gwSVService;
import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.model.MXmlFilePath;
import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.model.MXmlServerInfo;
import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.service.xmlBasicService;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

            MXmlServerInfo.ServerXmlInfo[] values = MXmlServerInfo.ServerXmlInfo.values();
            for(int i=0; i<values.length; i++){
                System.out.println("values[i] = " + values[i]);
            }

//            MXmlServerInfo.ServerXmlInfo.valueOf(jsonFromGwSVXmlData.findValue("hostname").asText());
//            System.out.println("jsonFromGwSVXmlData = " + jsonFromGwSVXmlData.findValue("hostname").asText());

            if( jsonFromGwSVXmlData.findValue("hostname").asText().equals(MXmlServerInfo.ServerXmlInfo.GWNODE_3.getXmlServerName())){
                System.out.println("HELLO");
                request.setAttribute(MXmlServerInfo.ServerXmlInfo.GWNODE_3.getXmlViewName(),gwService.getGwSVMainData(jsonFromGwSVXmlData));
            }else if(jsonFromGwSVXmlData.findValue("hostname").asText().equals("gw-node1")){
                System.out.println("HELLO ");
                request.setAttribute("gwnode1",gwService.getGwSVMainData(jsonFromGwSVXmlData));
            }

        }
        return "gwServer/dailyChkGenieus";
    }
}

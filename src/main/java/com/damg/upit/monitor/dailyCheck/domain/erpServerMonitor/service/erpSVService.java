package com.damg.upit.monitor.dailyCheck.domain.erpServerMonitor.service;


import com.damg.upit.monitor.dailyCheck.domain.erpServerMonitor.repository.erpSVRepository;
import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.model.MXmlRootMain;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;

@Slf4j
@Service
public class erpSVService {

    private erpSVRepository erpRepository;
    private ObjectMapper objMapper;

    public erpSVService(erpSVRepository erpRepository){
        this.erpRepository = erpRepository;
    }

    public JsonNode toJsonFromErpSVXmlData(String fileName) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(fileName);

        //JSON {"etcXmlServer":[{"hostname": ...
        JAXBContext jaxbContext = JAXBContext.newInstance(MXmlRootMain.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Object xmlErpSVData = unmarshaller.unmarshal(fileInputStream);

        //JSON {"etcXmlServer":[{"hostname": ...
        String makeErpSVJsonData = objMapper.writeValueAsString(xmlErpSVData);
        log.info("makeErpSVJsonData={}",makeErpSVJsonData);
        JsonNode erpXmlSVMainData = objMapper.readValue(makeErpSVJsonData, JsonNode.class);

        //JSON [{"hostname":"monitor"
        JsonNode mainErpSVData = erpXmlSVMainData.findValue("xmlServerData");
        log.info("mainErpSVData = {}", mainErpSVData);


        return mainErpSVData;
    }


}

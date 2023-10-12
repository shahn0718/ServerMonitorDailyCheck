package com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.service;


import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.model.MXmlRootMain;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class xmlBasicService {

    public List<File> getFileFromDir(String filePath){

        File fileList = new File(filePath);
        List<File> getFileList = Arrays.asList(fileList.listFiles());

        return getFileList;
    }

    public LocalDateTime getFormateDateTime(String dateTime, String timeDate) throws ParseException{

        String beforeFormatDate = dateTime + timeDate ;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss");

        LocalDateTime afterFormatDate = LocalDateTime.parse(beforeFormatDate,formatter);
        return afterFormatDate;
    }

    public JsonNode toJsonFromSVXmlData(String fileName) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectMapper objMapper = new ObjectMapper();

        //JSON {"etcXmlServer":[{"hostname": ...
        JAXBContext jaxbContext = JAXBContext.newInstance(MXmlRootMain.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Object xmlErpSVData = unmarshaller.unmarshal(fileInputStream);

        //JSON {"etcXmlServer":[{"hostname": ...
        String makeJsonData = objMapper.writeValueAsString(xmlErpSVData);
        log.info("makeJsonData={}",makeJsonData);
        JsonNode xmlSVMainData = objMapper.readValue(makeJsonData, JsonNode.class);

        //JSON [{"hostname":"monitor" ...
        JsonNode jsonDataFromSVXml = xmlSVMainData.findValue("xmlServerData");
        log.info("resultJsonData = {}", jsonDataFromSVXml);

        return jsonDataFromSVXml;
    }
}

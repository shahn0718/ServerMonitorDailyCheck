package com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

    public String readFileFromDir(File fileName) throws Exception{

        FileInputStream fileInputStream = new FileInputStream(fileName);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String readData = "";
        String readTmpData="";

        while((readTmpData = bufferedReader.readLine()) != null){
            readData += readTmpData + "\n";
        }
        return readData;
    }

    public List<String> makeListFromDir(File fileName) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(fileName);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        ArrayList<String> fileData = new ArrayList<>();
        String readTmpData ="";

        while((readTmpData = bufferedReader.readLine()) != null){
            fileData.add(readTmpData);
        }

        return fileData;
    }
}

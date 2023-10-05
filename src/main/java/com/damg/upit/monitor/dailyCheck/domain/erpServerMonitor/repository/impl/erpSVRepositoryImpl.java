package com.damg.upit.monitor.dailyCheck.domain.erpServerMonitor.repository.impl;


import com.damg.upit.monitor.dailyCheck.domain.erpServerMonitor.mapper.erpSVMapper;
import com.damg.upit.monitor.dailyCheck.domain.erpServerMonitor.model.MInsertErpSVDiskUsage;
import com.damg.upit.monitor.dailyCheck.domain.erpServerMonitor.model.MInsertErpSVMain;
import com.damg.upit.monitor.dailyCheck.domain.erpServerMonitor.model.MInsertErpSVProcChk;
import com.damg.upit.monitor.dailyCheck.domain.erpServerMonitor.repository.erpSVRepository;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class erpSVRepositoryImpl implements erpSVRepository {

    private final erpSVMapper erpMapper;

    public erpSVRepositoryImpl(erpSVMapper erpMapper){
        this.erpMapper = erpMapper;
    }

    @Override
    public JsonNode toJsonFromErpSVXmlData(String fileName) throws Exception {
        return null;
    }

    @Override
    public void insertErpSVMainData(MInsertErpSVMain mInsertErpSVMain) throws Exception {
        erpMapper.insertErpSVMainData(mInsertErpSVMain);
    }

    @Override
    public void insertErpSVProcData(MInsertErpSVProcChk mInsertErpSVProChk) throws Exception {
        erpMapper.insertErpSVProcData(mInsertErpSVProChk);
    }

    @Override
    public void insertErpSVDiskData(MInsertErpSVDiskUsage mInsertErpSVDiskUsage) throws Exception {
        erpMapper.insertErpSVDiskData(mInsertErpSVDiskUsage);
    }
}

package com.damg.upit.monitor.dailyCheck.domain.erpServerMonitor.repository;

import com.damg.upit.monitor.dailyCheck.domain.erpServerMonitor.model.MInsertErpSVDiskUsage;
import com.damg.upit.monitor.dailyCheck.domain.erpServerMonitor.model.MInsertErpSVMain;
import com.damg.upit.monitor.dailyCheck.domain.erpServerMonitor.model.MInsertErpSVProcChk;
import com.fasterxml.jackson.databind.JsonNode;

public interface erpSVRepository {

    JsonNode toJsonFromErpSVXmlData(String fileName) throws Exception;
    void insertErpSVMainData(MInsertErpSVMain mInsertErpSVMain) throws Exception;
    void insertErpSVProcData(MInsertErpSVProcChk mInsertErpSVProChk) throws Exception;
    void insertErpSVDiskData(MInsertErpSVDiskUsage mInsertErpSVDiskUsage) throws Exception;

}

package com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.repository;

import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.model.MInsertEtcSVDiskUsage;
import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.model.MInsertEtcSVMain;
import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.model.MInsertEtcSVProcChk;

public interface etcSVRepository {

    /**
     * Etc Erp
     * @param mInsertEtcSVMain, mInsertEtcSVProcChk, mInsertEtcSVDiskUsage
     * @throws Exception
     */
    void insertEtcErpSVMainData(MInsertEtcSVMain mInsertEtcSVMain) throws Exception;
    void insertEtcErpSVProcData(MInsertEtcSVProcChk mInsertEtcSVProcChk) throws Exception;
    void insertEtcErpSVDiskData(MInsertEtcSVDiskUsage mInsertEtcSVDiskUsage) throws Exception;

    /**
     * Etc Ehr
     * @param mInsertEtcSVMain, mInsertEtcSVProcChk, mInsertEtcSVDiskUsage
     * @throws Exception
     */
    void insertEtcEhrSVMainData(MInsertEtcSVMain mInsertEtcSVMain) throws Exception;
    void insertEtcEhrSVProcData(MInsertEtcSVProcChk mInsertEtcSVProcChk) throws Exception;
    void insertEtcEhrSVDiskData(MInsertEtcSVDiskUsage mInsertEtcSVDiskUsage) throws Exception;

}

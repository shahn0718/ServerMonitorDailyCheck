package com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.repository;

import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.model.MInsertEtcSVDiskUsage;
import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.model.MInsertEtcSVMain;
import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.model.MInsertEtcSVProcChk;

public interface etcErpSVRepository {
    void insertEtcSVMainData(MInsertEtcSVMain mInsertEtcSVMain) throws Exception;
    void insertEtcSVProcData(MInsertEtcSVProcChk mInsertEtcSVProcChk) throws Exception;
    void insertEtcSVDiskData(MInsertEtcSVDiskUsage mInsertEtcSVDiskUsage) throws Exception;
}

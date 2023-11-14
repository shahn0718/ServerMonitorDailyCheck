package com.damg.upit.monitor.dailyCheck.domain.infraServerMonitor.repository;

import com.damg.upit.monitor.dailyCheck.domain.infraServerMonitor.model.MInsertInfraSVDiskUsage;
import com.damg.upit.monitor.dailyCheck.domain.infraServerMonitor.model.MInsertInfraSVMain;
import com.damg.upit.monitor.dailyCheck.domain.infraServerMonitor.model.MInsertInfraSVProcChk;

public interface infraSVRepository {

    void insertInfraSVMainData(MInsertInfraSVMain mInsertInfraSVMain) throws Exception;

    void insertInfraSVProcData(MInsertInfraSVProcChk mInsertInfraSVProcChk) throws Exception;

    void insertInfraSVDiskData(MInsertInfraSVDiskUsage mInsertInfraSVDiskUsage) throws Exception;
}

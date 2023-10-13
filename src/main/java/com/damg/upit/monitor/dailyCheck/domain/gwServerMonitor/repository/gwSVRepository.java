package com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.repository;

import com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.model.MInsertGwSVClustChk;
import com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.model.MInsertGwSVDiskUsage;
import com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.model.MInsertGwSVMain;
import com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.model.MInsertGwSVProcChk;

public interface gwSVRepository {

    void insertGwSVMainData(MInsertGwSVMain mInsertGwSVMain) throws Exception;
    void insertGwSVProcData(MInsertGwSVProcChk mInsertGwSVProcChk) throws Exception;
    void insertGwSVDiskData(MInsertGwSVDiskUsage mInsertGwSVDiskUSage) throws Exception;
    void insertGwSVClustData(MInsertGwSVClustChk mInsertGwSVClustChk) throws Exception;
}

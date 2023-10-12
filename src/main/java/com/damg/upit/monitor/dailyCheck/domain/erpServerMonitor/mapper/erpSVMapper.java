package com.damg.upit.monitor.dailyCheck.domain.erpServerMonitor.mapper;

import com.damg.upit.monitor.dailyCheck.domain.erpServerMonitor.model.MInsertErpSVDiskUsage;
import com.damg.upit.monitor.dailyCheck.domain.erpServerMonitor.model.MInsertErpSVMain;
import com.damg.upit.monitor.dailyCheck.domain.erpServerMonitor.model.MInsertErpSVProcChk;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface erpSVMapper {
    void insertErpSVMainData(MInsertErpSVMain mInsertErpSVMain);
    void insertErpSVProcData(MInsertErpSVProcChk mInsertErpSVProcChk);
    void insertErpSVDiskData(MInsertErpSVDiskUsage mInsertErpSVDiskUsage);
}

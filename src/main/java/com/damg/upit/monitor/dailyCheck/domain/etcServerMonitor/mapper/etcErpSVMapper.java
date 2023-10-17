package com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.mapper;


import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.model.MInsertEtcSVDiskUsage;
import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.model.MInsertEtcSVMain;
import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.model.MInsertEtcSVProcChk;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface etcErpSVMapper {

    void insertEtcSVMainData(MInsertEtcSVMain mInsertEtcSVMain);
    void insertEtcSVProcData(MInsertEtcSVProcChk mInsertEtcSVProcChk);
    void insertEtcSVDiskData(MInsertEtcSVDiskUsage mInsertEtcSVDiskUsage);
}

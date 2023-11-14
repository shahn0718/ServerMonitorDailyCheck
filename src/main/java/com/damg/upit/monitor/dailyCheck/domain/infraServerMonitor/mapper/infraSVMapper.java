package com.damg.upit.monitor.dailyCheck.domain.infraServerMonitor.mapper;


import com.damg.upit.monitor.dailyCheck.domain.infraServerMonitor.model.MInsertInfraSVDiskUsage;
import com.damg.upit.monitor.dailyCheck.domain.infraServerMonitor.model.MInsertInfraSVMain;
import com.damg.upit.monitor.dailyCheck.domain.infraServerMonitor.model.MInsertInfraSVProcChk;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface infraSVMapper {

    void insertInfraSVMainData(MInsertInfraSVMain mInsertInfraSVMain);
    void insertInfraSVProcData(MInsertInfraSVProcChk mInsertInfraSVProcChk);
    void insertInfraSVDiskData(MInsertInfraSVDiskUsage mInsertInfraSVDiskUsage);

}

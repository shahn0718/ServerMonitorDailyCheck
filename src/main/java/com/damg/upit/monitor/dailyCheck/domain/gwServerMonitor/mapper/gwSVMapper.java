package com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.mapper;

import com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.model.MInsertGwSVClustChk;
import com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.model.MInsertGwSVDiskUsage;
import com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.model.MInsertGwSVMain;
import com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.model.MInsertGwSVProcChk;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface gwSVMapper {

    void insertGwSVMainData(MInsertGwSVMain mInsertGwSVMain);
    void insertGwSVProcData(MInsertGwSVProcChk mInsertGwSVProcChk);
    void insertGwSVDiskData(MInsertGwSVDiskUsage mInsertGwSVDiskUsage);
    void insertGwSVClustData(MInsertGwSVClustChk mInsertGwSVClustChk);
}

package com.damg.upit.monitor.dailyCheck.domain.gwDaily.mapper;

import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyStorageMain;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface gwMapper {
    void insertGwDailyServerMain(MInsertGwDailyServerMain mInsertGwDailyServerMain);
    void insertGwDailyServiceMain(MInsertGwDailyServiceMain mInsertGwDailyServiceMain);
    void insertGwDailyStorageMain(MInsertGwDailyStorageMain mInsertGwDailyStorageMain);

}
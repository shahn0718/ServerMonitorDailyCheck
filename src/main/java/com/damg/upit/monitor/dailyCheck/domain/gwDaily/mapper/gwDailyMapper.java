package com.damg.upit.monitor.dailyCheck.domain.gwDaily.mapper;

import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyStorageMain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface gwDailyMapper {
    void insertGwDailyServerMain(MInsertGwDailyServerMain mInsertGwDailyServerMain);
    void insertGwDailyServiceMain(MInsertGwDailyServiceMain mInsertGwDailyServiceMain);
    void insertGwDailyStorageMain(MInsertGwDailyStorageMain mInsertGwDailyStorageMain);

    List<MInsertGwDailyServerMain> selectGwDailyServerMain(@Param("gwMainId")Long gwMainId);
    List<MInsertGwDailyServiceMain> selectGwDailyServiceMain(@Param("gwMainId")Long gwMainId);
    List<MInsertGwDailyStorageMain> selectGwDailyStorageMain(@Param("gwMainId")Long gwMainId);

}
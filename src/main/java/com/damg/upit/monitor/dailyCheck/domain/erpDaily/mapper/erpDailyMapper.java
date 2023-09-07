package com.damg.upit.monitor.dailyCheck.domain.erpDaily.mapper;


import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyStorageMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyVMMain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface erpDailyMapper {

    void insertErpDailyServerMain(MInsertErpDailyServerMain mInsertErpDailyServerMain);
    void insertErpDailyServiceMain(MInsertErpDailyServiceMain mInsertErpDailyServiceMain);
    void insertErpDailyVMMain(MInsertErpDailyVMMain mInsertErpDailyVMMain);
    void insertErpDailyStorageMain(MInsertErpDailyStorageMain mInsertErpDailyStorageMain);

    List<MInsertErpDailyServerMain> selectErpDailyServerMain(@Param("erpMainId")Long erpMainId);
    List<MInsertErpDailyServiceMain> selectErpDailyServiceMain(@Param("erpMainId")Long erpMainId);
    List<MInsertErpDailyVMMain> selectErpDailyVMMain(@Param("erpMainId")Long erpMainId);
    List<MInsertErpDailyStorageMain> selectErpDailyStorageMain(@Param("erpMainId")Long erpMainId);

    void updateErpDailyServerMain(MInsertErpDailyServerMain mInsertErpDailyServerMain);
    void updateErpDailyServiceMain(MInsertErpDailyServiceMain mInsertErpDailySErviceMain);
    void updateErpDailyVMMain(MInsertErpDailyVMMain mInsertErpDailyVMMain);
    void updateErpDailyStorageMain(MInsertErpDailyStorageMain mInsertErpDailyStorageMain);
}

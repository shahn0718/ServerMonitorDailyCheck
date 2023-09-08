package com.damg.upit.monitor.dailyCheck.domain.infraDaily.mapper;

import com.damg.upit.monitor.dailyCheck.domain.infraDaily.model.MInsertInfraDailyEtcMain;
import com.damg.upit.monitor.dailyCheck.domain.infraDaily.model.MInsertInfraDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.infraDaily.model.MInsertInfraDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.infraDaily.model.MInsertInfraDailyVMMain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface infraDailyMapper {

    void insertInfraDailyServiceMain(MInsertInfraDailyServiceMain mInsertInfraDailyServiceMain);
    void insertInfraDailyServerMain(MInsertInfraDailyServerMain mInsertInfraDailyServerMain);
    void insertInfraDailyVMMain(MInsertInfraDailyVMMain mInsertInfraDailyVMMain);
    void insertInfraDailyEtcMain(MInsertInfraDailyEtcMain mInsertInfraDailyEtcMain);

    List<MInsertInfraDailyServiceMain> selectInfraDailyServiceMain(@Param("infraMainId")Long infraMainId);
    List<MInsertInfraDailyServerMain> selectInfraDailyServerMain(@Param("infraMainId")Long infraMainId);
    List<MInsertInfraDailyVMMain> selectInfraDailyVMMain(@Param("infraMainId")Long infraMainId);
    List<MInsertInfraDailyEtcMain> selectInfraDailyEtcMain(@Param("infraMainId")Long infraMainId);

    void updateInfraDailyServiceMain(MInsertInfraDailyServiceMain mInsertInfraDailyServiceMain);
    void updateInfraDailyServerMain(MInsertInfraDailyServerMain mInsertInfraDailyServerMain);
    void updateInfraDailyVMMain(MInsertInfraDailyVMMain mInsertInfraDailyVMMain);
    void updateInfraDailyEtcMain(MInsertInfraDailyEtcMain mInsertInfraDailyEtcMain);
}

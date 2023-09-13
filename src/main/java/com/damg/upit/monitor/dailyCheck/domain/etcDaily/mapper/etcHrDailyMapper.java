package com.damg.upit.monitor.dailyCheck.domain.etcDaily.mapper;


import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.ehr.MInsertEtcHrDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.ehr.MInsertEtcHrDailyServiceMain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface etcHrDailyMapper {

    void insertEtcHrDailyServiceMain(MInsertEtcHrDailyServiceMain mInsertEtcHrDailyServiceMain);
    void insertEtcHrDailyServerMain(MInsertEtcHrDailyServerMain mInsertEtcHrDailyServerMain);

    List<MInsertEtcHrDailyServiceMain> selectEtcHrDailyServiceMain(@Param("etcHRMainId")Long etcHRMainId);
    List<MInsertEtcHrDailyServerMain> selectEtcHrDailyServerMain(@Param("etcHRMainId")Long etcHRMainId);

    void updateEtcHrDailyServiceMain(MInsertEtcHrDailyServiceMain mInsertEtcHrDailyServiceMain);
    void updateEtcHrDailyServerMain(MInsertEtcHrDailyServerMain mInsertEtcHrDailyServerMain);
}

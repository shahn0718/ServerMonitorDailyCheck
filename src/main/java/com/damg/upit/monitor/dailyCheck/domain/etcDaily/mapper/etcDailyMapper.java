package com.damg.upit.monitor.dailyCheck.domain.etcDaily.mapper;


import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.erp.MInsertEtcDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.erp.MInsertEtcDailyServiceMain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface etcDailyMapper {

    void insertEtcDailyServiceMain(MInsertEtcDailyServiceMain mInsertEtcDailyServiceMain);
    void insertEtcDailyServerMain(MInsertEtcDailyServerMain mInsertEtcDailyServerMain);
    List<MInsertEtcDailyServiceMain> selectEtcDailyServiceMain(@Param("etcMainId") Long etcMainId);
    List<MInsertEtcDailyServerMain> selectEtcDailyServerMain(@Param("etcMainId") Long etcMainId);
    void updateEtcDailyServiceMain(MInsertEtcDailyServiceMain mInsertEtcDailyServiceMain);
    void updateEtcDailyServerMain(MInsertEtcDailyServerMain mInsertEtcDailyServerMain);
    void deleteEtcDailyServiceMain(@Param("boardId") Long boardId);
    void deleteEtcDailyServerMain(@Param("boardId")Long boardId);

}

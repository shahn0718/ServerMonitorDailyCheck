package com.damg.upit.monitor.dailyCheck.domain.mainDaily.mapper;

import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckBoardMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MDailyBoardPagingMain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface mainPagingMapper {

    List<MSVDailyCheckBoardMain> findPagingBoardList(MDailyBoardPagingMain mDailyBoardPagingMain);
    int getBoardTotalList();
}

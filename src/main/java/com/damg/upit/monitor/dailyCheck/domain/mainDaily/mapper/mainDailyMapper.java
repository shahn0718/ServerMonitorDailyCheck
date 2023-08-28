package com.damg.upit.monitor.dailyCheck.domain.mainDaily.mapper;


import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckAdminMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckBoardMain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface mainDailyMapper {

    List<MSVDailyCheckBoardMain> getDailyCheckBoardList();
    List<MSVDailyCheckAdminMain> getDailyCheckAdminList();

}

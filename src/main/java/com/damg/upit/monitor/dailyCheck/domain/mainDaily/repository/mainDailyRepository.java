package com.damg.upit.monitor.dailyCheck.domain.mainDaily.repository;

import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckAdminMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckBoardMain;

import java.util.List;

public interface mainDailyRepository {

    List<MSVDailyCheckBoardMain> getDailyCheckBoardList();
    List<MSVDailyCheckAdminMain> getDailyCheckAdminList();
}

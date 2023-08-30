package com.damg.upit.monitor.dailyCheck.domain.gwDaily.repository;

import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyStorageMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckBoardMain;

import java.util.List;

public interface gwDailyRepository {
    /**
     * 지니어스 일일점검(서버))
     * @param mInsertGwDailyServerMain
     */
    void insertGwDailyServerMain(MInsertGwDailyServerMain mInsertGwDailyServerMain);
    List<MInsertGwDailyServerMain> selectGwDailyServerMain(Long gwMainId);
    /**
     * 지니어스 일일점검(서비스)
     * @param mInsertGwDailyServiceMain
     */
    void insertGwDailyServiceMain(MInsertGwDailyServiceMain mInsertGwDailyServiceMain);
    List<MInsertGwDailyServiceMain> selectGwDailyServiceMain(Long gwMainId);
    /**
     * 지니어스 일일점검(스토리지)
     * @param mInsertGwDailyStorageMain
     */
    void insertGwDailyStorageMain(MInsertGwDailyStorageMain mInsertGwDailyStorageMain);
    List<MInsertGwDailyStorageMain> selectGwDailyStroageMain(Long gwMainId);
    /**
     * 지니어스 일일점검 등록시, 메인 게시판 등록
     * @param msvDailyCheckBoardMain
     */
    void insertGwBoardMain(MSVDailyCheckBoardMain msvDailyCheckBoardMain);


}

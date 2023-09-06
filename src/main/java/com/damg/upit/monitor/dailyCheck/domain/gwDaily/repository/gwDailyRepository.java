package com.damg.upit.monitor.dailyCheck.domain.gwDaily.repository;

import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyStorageMain;

import java.util.List;

public interface gwDailyRepository {
    /**
     * 지니어스 일일점검(서버)
     * @param mInsertGwDailyServerMain
     */
    void insertGwDailyServerMain(MInsertGwDailyServerMain mInsertGwDailyServerMain);
    /**
     * 지니어스 일일점검(서비스)
     * @param mInsertGwDailyServiceMain
     */
    void insertGwDailyServiceMain(MInsertGwDailyServiceMain mInsertGwDailyServiceMain);
    /**
     * 지니어스 일일점검(스토리지)
     * @param mInsertGwDailyStorageMain
     */
    void insertGwDailyStorageMain(MInsertGwDailyStorageMain mInsertGwDailyStorageMain);
    List<MInsertGwDailyServerMain> selectGwDailyServerMain(Long gwMainId);
    List<MInsertGwDailyServiceMain> selectGwDailyServiceMain(Long gwMainId);
    List<MInsertGwDailyStorageMain> selectGwDailyStroageMain(Long gwMainId);
    void updateGwDailyServerMain(MInsertGwDailyServerMain mInsertGwDailyServerMain);
    void updateGwDailyServiceMain(MInsertGwDailyServiceMain mInsertGwDailyServiceMain);
    void updateGwDailyStorageMain(MInsertGwDailyStorageMain mInsertGwDailyStorageMain);
}

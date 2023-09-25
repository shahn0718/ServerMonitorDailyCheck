package com.damg.upit.monitor.dailyCheck.domain.gwDaily.repository;

import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyStorageMain;

import java.util.List;

public interface gwDailyRepository {
    /**
     * INSERT 지니어스 일일점검(서버)
     * @param mInsertGwDailyServerMain
     */
    void insertGwDailyServerMain(MInsertGwDailyServerMain mInsertGwDailyServerMain);
    /**
     * INSERT 지니어스 일일점검(서비스)
     * @param mInsertGwDailyServiceMain
     */
    void insertGwDailyServiceMain(MInsertGwDailyServiceMain mInsertGwDailyServiceMain);
    /**
     * INSERT 지니어스 일일점검(스토리지)
     * @param mInsertGwDailyStorageMain
     */
    void insertGwDailyStorageMain(MInsertGwDailyStorageMain mInsertGwDailyStorageMain);
    /**
     * SELECT 지니어스 일일점검(서버)
     * @param gwMainId
     * @return
     */
    List<MInsertGwDailyServerMain> selectGwDailyServerMain(Long gwMainId);
    /**
     * SELECT 지니어스 일일점검(서비스)
     * @param gwMainId
     * @return
     */
    List<MInsertGwDailyServiceMain> selectGwDailyServiceMain(Long gwMainId);
    /**
     * SELECT 지니어스 일일점검(스토리지)
     * @param gwMainId
     * @return
     */
    List<MInsertGwDailyStorageMain> selectGwDailyStroageMain(Long gwMainId);
    /**
     * UPDATE 지니어스 일일점검(서버)
     * @param mInsertGwDailyServerMain
     */
    void updateGwDailyServerMain(MInsertGwDailyServerMain mInsertGwDailyServerMain);
    /**
     * UPDATE 지니어스 일일점검(서비스)
     * @param mInsertGwDailyServiceMain
     */
    void updateGwDailyServiceMain(MInsertGwDailyServiceMain mInsertGwDailyServiceMain);
    /**
     * UPDATE 지니어스 일일점검(스토리지)
     * @param mInsertGwDailyStorageMain
     */
    void updateGwDailyStorageMain(MInsertGwDailyStorageMain mInsertGwDailyStorageMain);

    /**
     * DELETE 지니어스 일일점검(서버)
     * @param boardId
     */
    void deleteGwDailyServerMain(Long boardId);

    /**
     * DELETE 지니어스 일일점검(서비스)
     * @param boardId
     */
    void deleteGwDailyServiceMain(Long boardId);

    /**
     * DELETE 지니어스 일일점검(스토리지)
     * @param boardId
     */
    void deleteGwDailyStorageMain(Long boardId);
}

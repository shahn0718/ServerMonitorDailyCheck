package com.damg.upit.monitor.dailyCheck.domain.etcDaily.repository;

import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.ehr.MInsertEtcHrDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.erp.MInsertEtcDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.erp.MInsertEtcDailyServiceMain;

import java.util.List;

public interface etcDailyRepository {

    /**
     * INSERT 동아 외 ERP 일일점검(서비스)
     * @param mInsertEtcDailyServiceMain
     */
    void insertEtcDailyServiceMain(MInsertEtcDailyServiceMain mInsertEtcDailyServiceMain);
    /**
     * INSERT 동아 외 ERP 일일점검(서버)
     * @param mInsertEtcDailyServerMain
     */
    void insertEtcDailyServerMain(MInsertEtcDailyServerMain mInsertEtcDailyServerMain);
    /**
     * SELECT 동아 외 ERP 일일점검(서비스)
     * @param etcMainId
     * @return
     */
    List<MInsertEtcDailyServiceMain> selectEtcDailyServiceMain(Long etcMainId);
    /**
     * SELECT 동아 외 ERP 일일점검(서버)
     * @param etcMainId
     * @return
     */
    List<MInsertEtcDailyServerMain> selectEtcDailyServerMain(Long etcMainId);
    /**
     * UPDATE 동아 외 ERP 일일점검(서비스)
     * @param mInsertEtcDailyServiceMain
     */
    void updateEtcDailyServiceMain(MInsertEtcDailyServiceMain mInsertEtcDailyServiceMain);
    /**
     * UPDATE 동아 외 ERP 일일점검(서버)
     * @param mInsertEtcDailyServerMain
     */
    void updateEtcDailyServerMain(MInsertEtcDailyServerMain mInsertEtcDailyServerMain);
}

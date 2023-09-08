package com.damg.upit.monitor.dailyCheck.domain.etcDaily.repository;

import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.ehr.MInsertEtcHrDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.ehr.MInsertEtcHrDailyServiceMain;

import java.util.List;

public interface etcHrDailyRepository {
    /**
     * INSERT 동아 외 EHR 일일점검(서비스)
     * @param mInsertEtcHRDailyServiceMain
     */
    void insertEtcHrDailyServiceMain(MInsertEtcHrDailyServiceMain mInsertEtcHRDailyServiceMain);
    /**
     * INSERT 동아 외 EHR 일일점검(서버)
     * @param mInsertEtcHRDailyServerMain
     */
    void insertEtcHrDailyServerMain(MInsertEtcHrDailyServerMain mInsertEtcHRDailyServerMain);

    /**
     * SELECT 동아 외 EHR 일일점검(서비스)
     * @param etcHRMainId
     * @return
     */
    List<MInsertEtcHrDailyServiceMain> selectEtcHrDailyServiceMain(Long etcHRMainId);

    /**
     * SELECT 동아 외 EHR 일일점검(서버)
     * @param etcHRMainId
     * @return
     */
    List<MInsertEtcHrDailyServerMain> selectEtcHrDailyServerMain(Long etcHRMainId);
    /**
     * UPDATE 동아 외 EHR 일일점검(서비스)
     * @param mInsertEtcHRDailyServiceMain
     */
    void updateEtcHrDailyServiceMain(MInsertEtcHrDailyServiceMain mInsertEtcHRDailyServiceMain);
    /**
     * UPDATE 동아 외 EHR 일일점검(서버)
     * @param mInsertEtcHRDailyServerMain
     */
    void updateEtcHrDailyServerMain(MInsertEtcHrDailyServerMain mInsertEtcHRDailyServerMain);

}

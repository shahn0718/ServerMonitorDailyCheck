package com.damg.upit.monitor.dailyCheck.domain.infraDaily.repository;

import com.damg.upit.monitor.dailyCheck.domain.infraDaily.model.MInsertInfraDailyEtcMain;
import com.damg.upit.monitor.dailyCheck.domain.infraDaily.model.MInsertInfraDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.infraDaily.model.MInsertInfraDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.infraDaily.model.MInsertInfraDailyVMMain;

import java.util.List;

public interface infraDailyRepository {

    /**
     * INSERT 인프라 일일점검(서비스)
     * @param mInsertInfraDailyServiceMain
     */
    void insertInfraDailyServiceMain(MInsertInfraDailyServiceMain mInsertInfraDailyServiceMain);
    /**
     * INSERT 인프라 일일점검(서버)
     * @param mInsertInfraDailyServerMain
     */
    void insertInfraDailyServerMain(MInsertInfraDailyServerMain mInsertInfraDailyServerMain);
    /**
     * INSERT 인프라 일일점검(VM)
     * @param mInsertInfraDailyVMMain
     */
    void insertInfraDailyVMMain(MInsertInfraDailyVMMain mInsertInfraDailyVMMain);
    /**
     * INSERT 인프라 일일점검(보안 및 기타솔루션)
     * @param mInsertInfraDailyEtcMain
     */
    void insertInfraDailyEtcMain(MInsertInfraDailyEtcMain mInsertInfraDailyEtcMain);

    /**
     * SELECT 인프라 일일점검(서비스)
     * @param infraMainId
     * @return
     */
    List<MInsertInfraDailyServiceMain> selectInfraDailyServiceMain(Long infraMainId);

    /**
     * SELECT 인프라 일일점검(서버)
     * @param infraMainId
     * @return
     */
    List<MInsertInfraDailyServerMain> selectInfraDailyServerMain(Long infraMainId);

    /**
     * SELECT 인프라 일일점검(VM)
     * @param infraMainId
     * @return
     */
    List<MInsertInfraDailyVMMain> selectInfraDailyVMMain(Long infraMainId);

    /**
     * SELECT 인프라 일일점검(보안 및 기타솔루션)
     * @param infraMainId
     * @return
     */
    List<MInsertInfraDailyEtcMain> selectInfraDailyEtcMain(Long infraMainId);

    /**
     * UPDATE 인프라 일일점검(서비스)
     * @param mInsertInfraDailyServiceMain
     */
    void updateInfraDailyServiceMain(MInsertInfraDailyServiceMain mInsertInfraDailyServiceMain);

    /**
     * UPDATE 인프라 일일점검(서버)
     * @param mInsertInfraDailyServerMain
     */
    void updateInfraDailyServerMain(MInsertInfraDailyServerMain mInsertInfraDailyServerMain);

    /**
     * UPDATE 인프라 일일점검(VM)
     * @param mInsertInfraDailyVMMain
     */
    void updateInfraDailyVMMain(MInsertInfraDailyVMMain mInsertInfraDailyVMMain);

    /**
     * UPDATE 인프라 일일점검(보안 및 기타솔루션)
     * @param mInsertInfraDailyEtcMain
     */
    void updateInfraDailyEtcMain(MInsertInfraDailyEtcMain mInsertInfraDailyEtcMain);

    void deleteInfraDailyService(Long boardId);
    void deleteInfraDailyServer(Long boardId);
    void deleteInfraDailyVMMain(Long boardId);
    void deleteInfraDailyEtcMain(Long boardId);
}

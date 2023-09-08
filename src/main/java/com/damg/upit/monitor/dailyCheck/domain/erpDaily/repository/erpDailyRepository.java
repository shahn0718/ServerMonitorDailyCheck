package com.damg.upit.monitor.dailyCheck.domain.erpDaily.repository;

import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyStorageMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyVMMain;

import java.util.List;

public interface erpDailyRepository {
    /**
     * INSERT ERP 일일점검(서버)
     * @param minsertErpDailyServerMain
     */
    void insertErpDailyServerMain(MInsertErpDailyServerMain minsertErpDailyServerMain);
    /**
     * INSERT ERP 일일점검(서비스)
     * @param mInsertErpDailyServiceMain
     */
    void insertErpDailyServiceMain(MInsertErpDailyServiceMain mInsertErpDailyServiceMain);
    /**
     * INSERT ERP 일일점검(VM)
     * @param mInsertErpDailyVMMain
     */
    void insertErpDailyVMMain(MInsertErpDailyVMMain mInsertErpDailyVMMain);
    /**
     * INSERT ERP 일일점검(스토리지)
     * @param mInsertErpDailyStorageMain
     */
    void insertErpDailyStorageMain(MInsertErpDailyStorageMain mInsertErpDailyStorageMain);
    /**
     * SELECT ERP 일일점검(서버)
     * @param erpMainId
     * @return
     */
    List<MInsertErpDailyServerMain> selectErpDailyServerMain(Long erpMainId);
    /**
     * SELECT ERP 일일점검(서비스)
     * @param erpMainId
     * @return
     */
    List<MInsertErpDailyServiceMain> selectErpDailyServiceMain(Long erpMainId);
    /**
     * SELECT ERP 일일점검(VM)
     * @param erpMainId
     * @return
     */
    List<MInsertErpDailyVMMain> selectErpDailyVMMain(Long erpMainId);
    /**
     * SELECT ERP 일일점검(스토리지)
     * @param erpMainId
     * @return
     */
    List<MInsertErpDailyStorageMain> selectErpDailyStorageMain(Long erpMainId);
    /**
     * SELECT ERP 일일점검(서버)
     * @param mInsertErpDailyServerMain
     */
    void updateErpDailyServerMain(MInsertErpDailyServerMain mInsertErpDailyServerMain);
    /**
     * UPDATE ERP 일일점검(서비스)
     * @param mInsertErpDailyServiceMain
     */
    void updateErpDailyServiceMain(MInsertErpDailyServiceMain mInsertErpDailyServiceMain);
    /**
     * UPDATE ERP 일일점검(VM)
     * @param mInsertErpDailyVMMain
     */
    void updateErpDailyVMMain(MInsertErpDailyVMMain mInsertErpDailyVMMain);
    /**
     * UPDATE ERP 일일점검(스토리지)
     * @param mInsertErpDailyStorageMain
     */
    void updateErpDailyStorageMain(MInsertErpDailyStorageMain mInsertErpDailyStorageMain);
    
    
    
}

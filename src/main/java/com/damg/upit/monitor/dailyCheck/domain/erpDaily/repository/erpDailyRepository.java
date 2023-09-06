package com.damg.upit.monitor.dailyCheck.domain.erpDaily.repository;

import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyStorageMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyVMMain;

import java.util.List;

public interface erpDailyRepository {
    /**
     * ERP 일일점검(서버)
     * @param minsertErpDailyServerMain
     */
    void insertErpDailyServerMain(MInsertErpDailyServerMain minsertErpDailyServerMain);
    /**
     * ERP 일일점검(서비스)
     * @param mInsertErpDailyServiceMain
     */
    void insertErpDailyServiceMain(MInsertErpDailyServiceMain mInsertErpDailyServiceMain);
    /**
     * ERP 일일점검(VM)
     * @param mInsertErpDailyVMMain
     */
    void insertErpDailyVMMain(MInsertErpDailyVMMain mInsertErpDailyVMMain);
    /**
     * ERP 일일점검(스토리지)
     * @param mInsertErpDailyStorageMain
     */
    void insertErpDailyStorageMain(MInsertErpDailyStorageMain mInsertErpDailyStorageMain);
    /**
     * ERP 일일점검(서버) 조회
     * @param erpMainId
     * @return
     */
    List<MInsertErpDailyServerMain> selectErpDailyServerMain(Long erpMainId);
    /**
     * ERP 일일점검(서비스) 조회
     * @param erpMainId
     * @return
     */
    List<MInsertErpDailyServiceMain> selectErpDailyServiceMain(Long erpMainId);
    /**
     * ERP 일일점검(VM) 조회
     * @param erpMainId
     * @return
     */
    List<MInsertErpDailyVMMain> selectErpDailyVMMain(Long erpMainId);
    /**
     * ERP 일일점검(스토리지) 조회
     * @param erpMainId
     * @return
     */
    List<MInsertErpDailyStorageMain> selectErpDailyStorageMain(Long erpMainId);
    /**
     * ERP 일일점검(서버) 업데이트
     * @param mInsertErpDailyServerMain
     */
    void updateErpDailyServerMain(MInsertErpDailyServerMain mInsertErpDailyServerMain);
    /**
     * ERP 일일점검(서비스) 업데이트
     * @param mInsertErpDailyServiceMain
     */
    void updateErpDailyServiceMain(MInsertErpDailyServiceMain mInsertErpDailyServiceMain);
    /**
     * ERP 일일점검(VM) 업데이트
     * @param mInsertErpDailyVMMain
     */
    void updateErpDailyVMMain(MInsertErpDailyVMMain mInsertErpDailyVMMain);
    /**
     * ERP 일일점검(스토리지) 업데이트
     * @param mInsertErpDailyStorageMain
     */
    void updateErpDailyStorageMain(MInsertErpDailyStorageMain mInsertErpDailyStorageMain);
    
    
    
}

package com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.mapper;


import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.model.MInsertEtcSVDiskUsage;
import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.model.MInsertEtcSVMain;
import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.model.MInsertEtcSVProcChk;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface etcSVMapper {

    /**
     * ETC Erp
     * @param mInsertEtcSVMain, mInsertEtcSVProcChk, mInsertEtcSVDiskUsage
     */
    void insertEtcErpSVMainData(MInsertEtcSVMain mInsertEtcSVMain);
    void insertEtcErpSVProcData(MInsertEtcSVProcChk mInsertEtcSVProcChk);
    void insertEtcErpSVDiskData(MInsertEtcSVDiskUsage mInsertEtcSVDiskUsage);

    /**
     * Etc Ehr
     * @param mInsertEtcSVMain, mInsertEtcSVProcChk, mInsertEtcSVDiskUsage
     */

    void insertEtcEhrSVMainData(MInsertEtcSVMain mInsertEtcSVMain);
    void insertEtcEhrSVProcData(MInsertEtcSVProcChk mInsertEtcSVProcChk);
    void insertEtcEhrSVDiskData(MInsertEtcSVDiskUsage mInsertEtcSVDiskUsage);
}

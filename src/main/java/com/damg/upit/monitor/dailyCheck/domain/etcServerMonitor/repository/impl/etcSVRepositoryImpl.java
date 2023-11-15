package com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.repository.impl;

import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.mapper.etcSVMapper;
import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.model.MInsertEtcSVDiskUsage;
import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.model.MInsertEtcSVMain;
import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.model.MInsertEtcSVProcChk;
import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.repository.etcSVRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;


@Slf4j
@Repository
public class etcSVRepositoryImpl implements etcSVRepository {

    private final etcSVMapper etcMapper;

    public etcSVRepositoryImpl(etcSVMapper etcMapper){
        this.etcMapper = etcMapper;
    }

    @Override
    public void insertEtcErpSVMainData(MInsertEtcSVMain mInsertEtcSVMain) throws Exception {
        etcMapper.insertEtcErpSVMainData(mInsertEtcSVMain);
    }

    @Override
    public void insertEtcErpSVProcData(MInsertEtcSVProcChk mInsertEtcSVProcChk) throws Exception {
        etcMapper.insertEtcErpSVProcData(mInsertEtcSVProcChk);
    }

    @Override
    public void insertEtcErpSVDiskData(MInsertEtcSVDiskUsage mInsertEtcSVDiskUsage) throws Exception {
        etcMapper.insertEtcErpSVDiskData(mInsertEtcSVDiskUsage);
    }

    @Override
    public void insertEtcEhrSVMainData(MInsertEtcSVMain mInsertEtcSVMain) throws Exception {
        etcMapper.insertEtcEhrSVMainData(mInsertEtcSVMain);
    }

    @Override
    public void insertEtcEhrSVProcData(MInsertEtcSVProcChk mInsertEtcSVProcChk) throws Exception {
        etcMapper.insertEtcEhrSVProcData(mInsertEtcSVProcChk);
    }

    @Override
    public void insertEtcEhrSVDiskData(MInsertEtcSVDiskUsage mInsertEtcSVDiskUsage) throws Exception {
        etcMapper.insertEtcEhrSVDiskData(mInsertEtcSVDiskUsage);
    }


}

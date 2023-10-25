package com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.repository.impl;

import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.mapper.etcErpSVMapper;
import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.model.MInsertEtcSVDiskUsage;
import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.model.MInsertEtcSVMain;
import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.model.MInsertEtcSVProcChk;
import com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.repository.etcErpSVRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;


@Slf4j
@Repository
public class etcErpSVRepositoryImpl implements etcErpSVRepository {

    private final etcErpSVMapper etcMapper;

    public etcErpSVRepositoryImpl(etcErpSVMapper etcMapper){
        this.etcMapper = etcMapper;
    }

    @Override
    public void insertEtcSVMainData(MInsertEtcSVMain mInsertEtcSVMain) throws Exception {
        etcMapper.insertEtcSVMainData(mInsertEtcSVMain);
    }

    @Override
    public void insertEtcSVProcData(MInsertEtcSVProcChk mInsertEtcSVProcChk) throws Exception {
        etcMapper.insertEtcSVProcData(mInsertEtcSVProcChk);
    }

    @Override
    public void insertEtcSVDiskData(MInsertEtcSVDiskUsage mInsertEtcSVDiskUsage) throws Exception {
        etcMapper.insertEtcSVDiskData(mInsertEtcSVDiskUsage);
    }
}

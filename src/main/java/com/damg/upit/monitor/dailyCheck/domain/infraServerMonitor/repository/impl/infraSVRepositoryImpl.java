package com.damg.upit.monitor.dailyCheck.domain.infraServerMonitor.repository.impl;


import com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.model.MInsertGwSVDiskUsage;
import com.damg.upit.monitor.dailyCheck.domain.infraServerMonitor.mapper.infraSVMapper;
import com.damg.upit.monitor.dailyCheck.domain.infraServerMonitor.model.MInsertInfraSVDiskUsage;
import com.damg.upit.monitor.dailyCheck.domain.infraServerMonitor.model.MInsertInfraSVMain;
import com.damg.upit.monitor.dailyCheck.domain.infraServerMonitor.model.MInsertInfraSVProcChk;
import com.damg.upit.monitor.dailyCheck.domain.infraServerMonitor.repository.infraSVRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class infraSVRepositoryImpl implements infraSVRepository {

    private final infraSVMapper infraMapper;
    public infraSVRepositoryImpl(infraSVMapper infraMapper){
        this.infraMapper = infraMapper;
    }

    @Override
    public void insertInfraSVMainData(MInsertInfraSVMain mInsertInfraSVMain) throws Exception {
        infraMapper.insertInfraSVMainData(mInsertInfraSVMain);
    }

    @Override
    public void insertInfraSVProcData(MInsertInfraSVProcChk mInsertInfraSVProcChk) throws Exception {
        infraMapper.insertInfraSVProcData(mInsertInfraSVProcChk);
    }

    @Override
    public void insertInfraSVDiskData(MInsertInfraSVDiskUsage mInsertInfraSVDiskUsage) throws Exception {
        infraMapper.insertInfraSVDiskData(mInsertInfraSVDiskUsage);
    }
}

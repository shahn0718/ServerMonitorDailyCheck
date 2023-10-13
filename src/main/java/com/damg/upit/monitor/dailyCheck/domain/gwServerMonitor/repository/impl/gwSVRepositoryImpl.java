package com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.repository.impl;


import com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.mapper.gwSVMapper;
import com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.model.MInsertGwSVClustChk;
import com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.model.MInsertGwSVDiskUsage;
import com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.model.MInsertGwSVMain;
import com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.model.MInsertGwSVProcChk;
import com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.repository.gwSVRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class gwSVRepositoryImpl implements gwSVRepository {

    private final gwSVMapper gwMapper;
    public gwSVRepositoryImpl(gwSVMapper gwMapper){
        this.gwMapper = gwMapper;
    }
    @Override
    public void insertGwSVMainData(MInsertGwSVMain mInsertGwSVMain) throws Exception {
        gwMapper.insertGwSVMainData(mInsertGwSVMain);
    }

    @Override
    public void insertGwSVProcData(MInsertGwSVProcChk mInsertGwSVProcChk) throws Exception {
        gwMapper.insertGwSVProcData(mInsertGwSVProcChk);
    }

    @Override
    public void insertGwSVDiskData(MInsertGwSVDiskUsage mInsertGwSVDiskUSage) throws Exception {
        gwMapper.insertGwSVDiskData(mInsertGwSVDiskUSage);
    }

    @Override
    public void insertGwSVClustData(MInsertGwSVClustChk mInsertGwSVClustChk) throws Exception {
        gwMapper.insertGwSVClustData(mInsertGwSVClustChk);
    }
}

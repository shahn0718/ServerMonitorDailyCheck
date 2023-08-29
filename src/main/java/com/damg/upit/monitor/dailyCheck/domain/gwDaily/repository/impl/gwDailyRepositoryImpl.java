package com.damg.upit.monitor.dailyCheck.domain.gwDaily.repository.impl;

import com.damg.upit.monitor.dailyCheck.domain.gwDaily.mapper.gwDailyMapper;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyStorageMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.repository.gwDailyRepository;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckBoardMain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;


@Slf4j
@Repository
public class gwDailyRepositoryImpl implements gwDailyRepository {

    private final gwDailyMapper gwDailyMapper;

    public gwDailyRepositoryImpl(gwDailyMapper gwDailyMapper) {
        this.gwDailyMapper = gwDailyMapper;
    }
    @Override
    public void insertGwDailyServerMain(MInsertGwDailyServerMain mInsertGwDailyServerMain) {
        gwDailyMapper.insertGwDailyServerMain(mInsertGwDailyServerMain);
    }
    @Override
    public List<MInsertGwDailyServerMain> selectGwDailyServerMain(Long gwMainId) {
        return gwDailyMapper.selectGwDailyServerMain(gwMainId);
    }
    @Override
    public void insertGwDailyServiceMain(MInsertGwDailyServiceMain mInsertGwDailyServiceMain) {
        gwDailyMapper.insertGwDailyServiceMain(mInsertGwDailyServiceMain);
    }
    @Override
    public List<MInsertGwDailyServiceMain> selectGwDailyServiceMain(Long gwMainId) {
        return gwDailyMapper.selectGwDailyServiceMain(gwMainId);
    }
    @Override
    public void insertGwDailyStorageMain(MInsertGwDailyStorageMain mInsertGwDailyStorageMain) {
        gwDailyMapper.insertGwDailyStorageMain(mInsertGwDailyStorageMain);
    }
    @Override
    public List<MInsertGwDailyStorageMain> selectGwDailyStroageMain(Long gwMainId) {
        return gwDailyMapper.selectGwDailyStorageMain(gwMainId);
    }
    @Override
    public void insertGwBoardMain(MSVDailyCheckBoardMain msvDailyCheckBoardMain) {
        gwDailyMapper.insertGwBoardMain(msvDailyCheckBoardMain);
    }

}

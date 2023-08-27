package com.damg.upit.monitor.dailyCheck.domain.gwDaily.repository.impl;

import com.damg.upit.monitor.dailyCheck.domain.gwDaily.mapper.gwMapper;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyStorageMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.repository.gwDailyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Slf4j
@Repository
public class gwDailyRepositoryImpl implements gwDailyRepository {

    private final gwMapper gwMapper;

    public gwDailyRepositoryImpl(gwMapper gwMapper) {
        this.gwMapper = gwMapper;
    }

    @Override
    public void insertGwDailyServerMain(MInsertGwDailyServerMain mInsertGwDailyServerMain) {
        gwMapper.insertGwDailyServerMain(mInsertGwDailyServerMain);
        log.info("kkkkk");
    }
    @Override
    public void insertGwDailyServiceMain(MInsertGwDailyServiceMain mInsertGwDailyServiceMain) {
        gwMapper.insertGwDailyServiceMain(mInsertGwDailyServiceMain);
    }
    @Override
    public void insertGwDailyStorageMain(MInsertGwDailyStorageMain mInsertGwDailyStorageMain) {
        gwMapper.insertGwDailyStorageMain(mInsertGwDailyStorageMain);
    }
}

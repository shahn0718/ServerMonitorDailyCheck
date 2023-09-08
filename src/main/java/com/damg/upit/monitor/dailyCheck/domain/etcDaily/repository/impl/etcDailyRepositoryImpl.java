package com.damg.upit.monitor.dailyCheck.domain.etcDaily.repository.impl;

import com.damg.upit.monitor.dailyCheck.domain.etcDaily.mapper.etcDailyMapper;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.erp.MInsertEtcDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.erp.MInsertEtcDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.repository.etcDailyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class etcDailyRepositoryImpl implements etcDailyRepository {

    private final etcDailyMapper etcDailyMapper;

    public etcDailyRepositoryImpl(etcDailyMapper etcDailyMapper){
        this.etcDailyMapper = etcDailyMapper;
    }

    @Override
    public void insertEtcDailyServiceMain(MInsertEtcDailyServiceMain mInsertEtcDailyServiceMain) {
        etcDailyMapper.insertEtcDailyServiceMain(mInsertEtcDailyServiceMain);
    }

    @Override
    public void insertEtcDailyServerMain(MInsertEtcDailyServerMain mInsertEtcDailyServerMain) {
        etcDailyMapper.insertEtcDailyServerMain(mInsertEtcDailyServerMain);
    }

    @Override
    public List<MInsertEtcDailyServiceMain> selectEtcDailyServiceMain(Long etcMainId) {
        return etcDailyMapper.selectEtcDailyServiceMain(etcMainId);
    }

    @Override
    public List<MInsertEtcDailyServerMain> selectEtcDailyServerMain(Long etcMainId) {
        return etcDailyMapper.selectEtcDailyServerMain(etcMainId);
    }

    @Override
    public void updateEtcDailyServiceMain(MInsertEtcDailyServiceMain mInsertEtcDailyServiceMain) {
        etcDailyMapper.updateEtcDailyServiceMain(mInsertEtcDailyServiceMain);
    }

    @Override
    public void updateEtcDailyServerMain(MInsertEtcDailyServerMain mInsertEtcDailyServerMain) {
        etcDailyMapper.updateEtcDailyServerMain(mInsertEtcDailyServerMain);
    }
}

package com.damg.upit.monitor.dailyCheck.domain.etcDaily.repository.impl;

import com.damg.upit.monitor.dailyCheck.domain.etcDaily.mapper.etcHrDailyMapper;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.ehr.MInsertEtcHrDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.ehr.MInsertEtcHrDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.ehr.MInsertEtcHrDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.ehr.MInsertEtcHrDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.repository.etcHrDailyRepository;

import java.util.List;

public class etcHrDailyRepositoryImpl implements etcHrDailyRepository {

    private final etcHrDailyMapper hrDailyMapper;

    public etcHrDailyRepositoryImpl(etcHrDailyMapper hrDailyMapper){
        this.hrDailyMapper = hrDailyMapper;
    }
    @Override
    public void insertEtcHrDailyServiceMain(MInsertEtcHrDailyServiceMain mInsertEtcHrDailyServiceMain) {
        hrDailyMapper.insertEtcDailyServiceMain(mInsertEtcHrDailyServiceMain);
    }
    @Override
    public void insertEtcHrDailyServerMain(MInsertEtcHrDailyServerMain mInsertEtcHrDailyServerMain) {
        hrDailyMapper.insertEtcDailyServerMain(mInsertEtcHrDailyServerMain);
    }
    @Override
    public List<MInsertEtcHrDailyServiceMain> selectEtcHrDailyServiceMain(Long etcHRMainId) {
        return hrDailyMapper.selectEtcHrDailyServiceMain(etcHRMainId);
    }
    @Override
    public List<MInsertEtcHrDailyServerMain> selectEtcHrDailyServerMain(Long etcHRMainId) {
        return hrDailyMapper.selectEtcHrDailyServerMain(etcHRMainId);
    }
    @Override
    public void updateEtcHrDailyServiceMain(MInsertEtcHrDailyServiceMain mInsertEtcHrDailyServiceMain) {
        hrDailyMapper.updateEtcHrDailyServiceMain(mInsertEtcHrDailyServiceMain);
    }
    @Override
    public void updateEtcHrDailyServerMain(MInsertEtcHrDailyServerMain mInsertEtcHrDailyServerMain) {
        hrDailyMapper.updateEtcHrDailyServerMain(mInsertEtcHrDailyServerMain);
    }
}

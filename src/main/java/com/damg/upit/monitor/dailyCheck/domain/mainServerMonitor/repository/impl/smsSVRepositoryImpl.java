package com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.repository.impl;

import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.mapper.smsSVMapper;
import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.param.PInsertSmsElement;
import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.repository.smsSVRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class smsSVRepositoryImpl implements smsSVRepository {

    private final smsSVMapper smsMapper;

    public smsSVRepositoryImpl(smsSVMapper smsMapper){
        this.smsMapper = smsMapper;
    }

    @Override
    public void insertSmsData(PInsertSmsElement pInsertSmsList) {
        smsMapper.insertSmsData(pInsertSmsList);
    }
}

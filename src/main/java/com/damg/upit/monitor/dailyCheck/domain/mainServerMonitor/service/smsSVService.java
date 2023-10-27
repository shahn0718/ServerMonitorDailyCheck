package com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.service;

import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.param.PInsertSmsElement;
import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.repository.smsSVRepository;
import org.springframework.stereotype.Service;

@Service
public class smsSVService {

    private final smsSVRepository smsRepository;

    public smsSVService(smsSVRepository smsRepository){
        this.smsRepository = smsRepository;
    }

    public void insertSmsData(PInsertSmsElement pInsertSmsList) throws Exception {
        smsRepository.insertSmsData(pInsertSmsList);
    }

}

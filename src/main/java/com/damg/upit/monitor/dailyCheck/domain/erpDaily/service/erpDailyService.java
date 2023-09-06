package com.damg.upit.monitor.dailyCheck.domain.erpDaily.service;


import com.damg.upit.monitor.dailyCheck.domain.erpDaily.repository.erpDailyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class erpDailyService {

    private final erpDailyRepository erpRepository;

    public erpDailyService(erpDailyRepository erpRepository){
        this.erpRepository = erpRepository;
    }


}

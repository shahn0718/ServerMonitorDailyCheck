package com.damg.upit.monitor.dailyCheck.domain.gwDaily.service;


import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyStorageMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.repository.gwDailyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class gwDailyService {

    private final gwDailyRepository gwRepository;

    @Autowired
    public gwDailyService(gwDailyRepository gwRepository){
        this.gwRepository = gwRepository;
    }

    public void insertGwDailyServerMain(MInsertGwDailyServerMain mInsertGwDailyServerMain){
        gwRepository.insertGwDailyServerMain(mInsertGwDailyServerMain);
    }
    public void insertGwDailyServiceMain(MInsertGwDailyServiceMain mInsertGwDailyServiceMain){
        gwRepository.insertGwDailyServiceMain(mInsertGwDailyServiceMain);
    }
    public void insertGwDailyStorageMain(MInsertGwDailyStorageMain mInsertGwDailyStorageMain){
        gwRepository.insertGwDailyStorageMain(mInsertGwDailyStorageMain);
    }

}

package com.damg.upit.monitor.dailyCheck.domain.gwDaily.service;


import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyStorageMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.repository.gwDailyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class gwDailyService {

    private final gwDailyRepository gwRepository;

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
    public List<MInsertGwDailyServiceMain> selectGwDailyServiceMain(Long gwMainId){
        return gwRepository.selectGwDailyServiceMain(gwMainId);
    }
    public List<MInsertGwDailyServerMain> selectGwDailyServerMain(Long gwMainId){
        return gwRepository.selectGwDailyServerMain(gwMainId);
    }
    public List<MInsertGwDailyStorageMain> selectGwDailyStorageMain(Long gwMainId){
        return gwRepository.selectGwDailyStroageMain(gwMainId);
    }
    public void updateGwDailyServerMain(MInsertGwDailyServerMain mInsertGwDailyServerMain){
        gwRepository.updateGwDailyServerMain(mInsertGwDailyServerMain);
    }
    public void updateGwDailyServiceMain(MInsertGwDailyServiceMain mInsertGwDailyServiceMain){
        gwRepository.updateGwDailyServiceMain(mInsertGwDailyServiceMain);
    }
    public void updateGwDailyStorageMain(MInsertGwDailyStorageMain mInsertGwDailyStorageMain){
        gwRepository.updateGwDailyStorageMain(mInsertGwDailyStorageMain);
    }

}

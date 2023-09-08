package com.damg.upit.monitor.dailyCheck.domain.etcDaily.service;

import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.erp.MInsertEtcDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.erp.MInsertEtcDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.repository.etcDailyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class etcDailyService {

    private final etcDailyRepository etcRepository;

    public etcDailyService(etcDailyRepository etcRepository){
        this.etcRepository = etcRepository;
    }

    public void insertEtcDailyServiceMain(MInsertEtcDailyServiceMain mInsertEtcDailyServiceMain){
        etcRepository.insertEtcDailyServiceMain(mInsertEtcDailyServiceMain);
    }
    public void insertEtcDailyServerMain(MInsertEtcDailyServerMain mInsertEtcDailyServerMain){
        etcRepository.insertEtcDailyServerMain(mInsertEtcDailyServerMain);
    }
    public List<MInsertEtcDailyServiceMain> selectEtcDailyServiceMain(Long etcMainId){
        return etcRepository.selectEtcDailyServiceMain(etcMainId);
    }
    public List<MInsertEtcDailyServerMain> selectEtcDailyServerMain(Long etcMainId){
        return etcRepository.selectEtcDailyServerMain(etcMainId);
    }
    public void updateEtcDailyServiceMain(MInsertEtcDailyServiceMain mInsertEtcDailyServiceMain){
        etcRepository.updateEtcDailyServiceMain(mInsertEtcDailyServiceMain);
    }
    public void updateEtcDailyServerMain(MInsertEtcDailyServerMain mInsertEtcDailyServerMain){
        etcRepository.updateEtcDailyServerMain(mInsertEtcDailyServerMain);
    }

}

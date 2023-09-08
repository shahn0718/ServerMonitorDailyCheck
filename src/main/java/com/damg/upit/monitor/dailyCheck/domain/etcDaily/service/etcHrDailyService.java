package com.damg.upit.monitor.dailyCheck.domain.etcDaily.service;


import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.ehr.MInsertEtcHrDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.ehr.MInsertEtcHrDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.repository.etcHrDailyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class etcHrDailyService {

    private final etcHrDailyRepository ehrRepository;

    public etcHrDailyService(etcHrDailyRepository ehrRepository){
        this.ehrRepository = ehrRepository;
    }
    public void insertEtcHrDailyServiceMain(MInsertEtcHrDailyServiceMain mInsertEtcHrDailyServiceMain){
        ehrRepository.insertEtcHrDailyServiceMain(mInsertEtcHrDailyServiceMain);
    }
    public void insertEtcHrDailyServerMain(MInsertEtcHrDailyServerMain mInsertEtcHrDailyServerMain){
        ehrRepository.insertEtcHrDailyServerMain(mInsertEtcHrDailyServerMain);
    }
    public List<MInsertEtcHrDailyServiceMain> selectEtcHrDailyServiceMain(Long etcHRMainId){
        return ehrRepository.selectEtcHrDailyServiceMain(etcHRMainId);
    }
    public List<MInsertEtcHrDailyServerMain> selectEtcHrDailyServerMain(Long etcHRMainId){
        return ehrRepository.selectEtcHrDailyServerMain(etcHRMainId);
    }
    public void updateEtcHrDailyServiceMain(MInsertEtcHrDailyServiceMain mInsertEtcHrDailyServiceMain){
        ehrRepository.updateEtcHrDailyServiceMain(mInsertEtcHrDailyServiceMain);
    }
    public void updateEtcHrDailyServerMain(MInsertEtcHrDailyServerMain mInsertEtcHrDailyServerMain){
        ehrRepository.updateEtcHrDailyServerMain(mInsertEtcHrDailyServerMain);
    }

}

package com.damg.upit.monitor.dailyCheck.domain.etcDaily.service;


import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.ehr.MInsertEtcHrDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.ehr.MInsertEtcHrDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.erp.MInsertEtcDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.erp.MInsertEtcDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.repository.etcHrDailyRepository;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckBoardMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.repository.mainDailyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class etcHrDailyService {

    private final etcHrDailyRepository ehrRepository;
    private final mainDailyRepository mainRepository;

    public etcHrDailyService(etcHrDailyRepository ehrRepository, mainDailyRepository mainRepository){
        this.ehrRepository = ehrRepository;
        this.mainRepository =mainRepository;
    }

    public List<MInsertEtcHrDailyServiceMain> selectEtcHrDailyServiceMain(Long etcHRMainId){
        return ehrRepository.selectEtcHrDailyServiceMain(etcHRMainId);
    }
    public List<MInsertEtcHrDailyServerMain> selectEtcHrDailyServerMain(Long etcHRMainId){
        return ehrRepository.selectEtcHrDailyServerMain(etcHRMainId);
    }

    @Transactional(rollbackFor=Exception.class)
    public void insertEtcHrDailyCheckMain(MInsertEtcHrDailyServiceMain mInsertEtcHrDailyServiceMain,
                                          MInsertEtcHrDailyServerMain mInsertEtcHrDailyServerMain,
                                          MSVDailyCheckBoardMain msvDailyCheckBoardMain){

        mainRepository.insertDailyCheckBoardList(msvDailyCheckBoardMain);

        mInsertEtcHrDailyServiceMain.setEtcHRMainId(msvDailyCheckBoardMain.getDailyMainBoardId());
        mInsertEtcHrDailyServerMain.setEtcHRMainId(msvDailyCheckBoardMain.getDailyMainBoardId());

        ehrRepository.insertEtcHrDailyServiceMain(mInsertEtcHrDailyServiceMain);
        ehrRepository.insertEtcHrDailyServerMain(mInsertEtcHrDailyServerMain);
    }

    @Transactional(rollbackFor=Exception.class)
    public void updateEtcHrDailyCheckMain(Long mainBoardId,
                                          int dailyMainViewCnt,
                                          MInsertEtcHrDailyServiceMain mInsertEtcHrDailyServiceMain,
                                          MInsertEtcHrDailyServerMain mInsertEtcHrDailyServerMain){


        mainRepository.updateDailyCheckBoard(LocalDateTime.now(),dailyMainViewCnt,mainBoardId);

        mInsertEtcHrDailyServiceMain.setEtcHRMainId(mainBoardId);
        mInsertEtcHrDailyServerMain.setEtcHRMainId(mainBoardId);

        ehrRepository.updateEtcHrDailyServiceMain(mInsertEtcHrDailyServiceMain);
        ehrRepository.updateEtcHrDailyServerMain(mInsertEtcHrDailyServerMain);
    }

    @Transactional(rollbackFor=Exception.class)
    public void deleteEtcHrDailyCheckMain(Long mainBoardId){


        ehrRepository.deleteEtcHrDailyServerMain(mainBoardId);
        ehrRepository.deleteEtcHrDailyServiceMain(mainBoardId);

        mainRepository.deleteDailyCheckBoard(mainBoardId);

    }
}

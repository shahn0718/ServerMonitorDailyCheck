package com.damg.upit.monitor.dailyCheck.domain.etcDaily.service;

import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.erp.MInsertEtcDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.erp.MInsertEtcDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.repository.etcDailyRepository;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckBoardMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.repository.mainDailyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
@Slf4j
@Service
public class etcDailyService {

    private final etcDailyRepository etcRepository;

    private final mainDailyRepository mainRepository;

    public etcDailyService(etcDailyRepository etcRepository, mainDailyRepository mainRepository){
        this.etcRepository = etcRepository;
        this.mainRepository =mainRepository;
    }

    public List<MInsertEtcDailyServiceMain> selectEtcDailyServiceMain(Long etcMainId){
        return etcRepository.selectEtcDailyServiceMain(etcMainId);
    }
    public List<MInsertEtcDailyServerMain> selectEtcDailyServerMain(Long etcMainId){
        return etcRepository.selectEtcDailyServerMain(etcMainId);
    }

    @Transactional(rollbackFor=Exception.class)
    public void insertEtcDailyCheckMain(MInsertEtcDailyServiceMain mInsertEtcDailyServiceMain,
                                        MInsertEtcDailyServerMain mInsertEtcDailyServerMain,
                                        MSVDailyCheckBoardMain msvDailyCheckBoardMain){


        mainRepository.insertDailyCheckBoardList(msvDailyCheckBoardMain);

        mInsertEtcDailyServiceMain.setEtcMainId(msvDailyCheckBoardMain.getDailyMainBoardId());
        mInsertEtcDailyServerMain.setEtcMainId(msvDailyCheckBoardMain.getDailyMainBoardId());

        etcRepository.insertEtcDailyServiceMain(mInsertEtcDailyServiceMain);
        etcRepository.insertEtcDailyServerMain(mInsertEtcDailyServerMain);

    }

    @Transactional(rollbackFor = Exception.class)
    public void updateEtcDailyCheckMain(Long mainBoardId,
                                        MInsertEtcDailyServiceMain mInsertEtcDailyServiceMain,
                                        MInsertEtcDailyServerMain mInsertEtcDailyServerMain){

        mainRepository.updateDailyCheckBoard(LocalDateTime.now(),mainBoardId);

        mInsertEtcDailyServiceMain.setEtcMainId(mainBoardId);
        mInsertEtcDailyServerMain.setEtcMainId(mainBoardId);

        etcRepository.updateEtcDailyServiceMain(mInsertEtcDailyServiceMain);
        etcRepository.updateEtcDailyServerMain(mInsertEtcDailyServerMain);
    }
    @Transactional(rollbackFor=Exception.class)
    public void deleteEtcDailyCheckMain(Long boardId){

        mainRepository.deleteDailyCheckBoard(boardId);

        etcRepository.deleteEtcDailyServerMain(boardId);
        etcRepository.deleteEtcDailyServerMain(boardId);
    }

}

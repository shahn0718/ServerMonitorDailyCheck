package com.damg.upit.monitor.dailyCheck.domain.infraDaily.service;

import com.damg.upit.monitor.dailyCheck.domain.infraDaily.model.MInsertInfraDailyEtcMain;
import com.damg.upit.monitor.dailyCheck.domain.infraDaily.model.MInsertInfraDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.infraDaily.model.MInsertInfraDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.infraDaily.model.MInsertInfraDailyVMMain;
import com.damg.upit.monitor.dailyCheck.domain.infraDaily.repository.infraDailyRepository;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckBoardMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.repository.mainDailyRepository;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class infraDailyService {

    private final infraDailyRepository infraRepository;

    private final mainDailyRepository mainRepository;

    public infraDailyService(infraDailyRepository infraRepository, mainDailyRepository mainRepository){
        this.infraRepository = infraRepository;
        this.mainRepository= mainRepository;
    }
    public List<MInsertInfraDailyVMMain> selectInfraDailyVMMain(Long infraMainId){
        return infraRepository.selectInfraDailyVMMain(infraMainId);
    }
    public List<MInsertInfraDailyEtcMain> selectInfraDailyEtcMain(Long infraMainId){
        return infraRepository.selectInfraDailyEtcMain(infraMainId);
    }

    public List<MInsertInfraDailyServiceMain> selectInfraDailyServiceMain(Long infraMainId){
        return infraRepository.selectInfraDailyServiceMain(infraMainId);
    }
    public List<MInsertInfraDailyServerMain> selectInfraDailyServerMain(Long infraMainId){
        return infraRepository.selectInfraDailyServerMain(infraMainId);
    }
    @Transactional(rollbackFor=Exception.class)
    public void insertInfraDailyCheckMain(MInsertInfraDailyServiceMain mInsertInfraDailyServiceMain,
                                          MInsertInfraDailyServerMain mInsertInfraDailyServerMain,
                                          MInsertInfraDailyVMMain mInsertInfraDailyVMMain,
                                          MInsertInfraDailyEtcMain mInsertInfraDailyEtcMain,
                                          MSVDailyCheckBoardMain msvDailyCheckBoardMain){

        mainRepository.insertDailyCheckBoardList(msvDailyCheckBoardMain);

        mInsertInfraDailyServiceMain.setInfraMainId(msvDailyCheckBoardMain.getDailyMainBoardId());
        mInsertInfraDailyServerMain.setInfraMainId(msvDailyCheckBoardMain.getDailyMainBoardId());
        mInsertInfraDailyVMMain.setInfraMainId(msvDailyCheckBoardMain.getDailyMainBoardId());
        mInsertInfraDailyEtcMain.setInfraMainId(msvDailyCheckBoardMain.getDailyMainBoardId());

        infraRepository.insertInfraDailyServiceMain(mInsertInfraDailyServiceMain);
        infraRepository.insertInfraDailyServerMain(mInsertInfraDailyServerMain);
        infraRepository.insertInfraDailyVMMain(mInsertInfraDailyVMMain);
        infraRepository.insertInfraDailyEtcMain(mInsertInfraDailyEtcMain);
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateInfraDailyCheckBoard(Long mainBoardId,
                                           int dailyMainViewCnt,
                                           MInsertInfraDailyServiceMain mInsertInfraDailyServiceMain,
                                           MInsertInfraDailyServerMain mInsertInfraDailyServerMain,
                                           MInsertInfraDailyVMMain mInsertInfraDailyVMMain,
                                           MInsertInfraDailyEtcMain mInsertInfraDailyEtcMain){

        mainRepository.updateDailyCheckBoard(LocalDateTime.now(),dailyMainViewCnt,mainBoardId);

        mInsertInfraDailyServiceMain.setInfraMainId(mainBoardId);
        mInsertInfraDailyServerMain.setInfraMainId(mainBoardId);
        mInsertInfraDailyVMMain.setInfraMainId(mainBoardId);
        mInsertInfraDailyEtcMain.setInfraMainId(mainBoardId);

        infraRepository.updateInfraDailyServiceMain(mInsertInfraDailyServiceMain);
        infraRepository.updateInfraDailyServerMain(mInsertInfraDailyServerMain);
        infraRepository.updateInfraDailyVMMain(mInsertInfraDailyVMMain);
        infraRepository.updateInfraDailyEtcMain(mInsertInfraDailyEtcMain);
    }
    @Transactional(rollbackFor=Exception.class)
    public void deleteInfraDailyCheckBoard(Long boardId){

        infraRepository.deleteInfraDailyService(boardId);
        infraRepository.deleteInfraDailyServer(boardId);
        infraRepository.deleteInfraDailyVMMain(boardId);
        infraRepository.deleteInfraDailyEtcMain(boardId);

        mainRepository.deleteDailyCheckBoard(boardId);
    }
}

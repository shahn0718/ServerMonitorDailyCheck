package com.damg.upit.monitor.dailyCheck.domain.erpDaily.service;


import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyStorageMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyVMMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.repository.erpDailyRepository;
import com.damg.upit.monitor.dailyCheck.domain.infraDaily.model.MInsertInfraDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.infraDaily.model.MInsertInfraDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckBoardMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.repository.mainDailyRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class erpDailyService {

    private final erpDailyRepository erpRepository;
    private final mainDailyRepository mainRepository;

    public erpDailyService(erpDailyRepository erpRepository, mainDailyRepository mainRepository){
        this.erpRepository = erpRepository;
        this.mainRepository =mainRepository;
    }

    public List<MInsertErpDailyServerMain> selectErpDailyServerMain(Long erpMainId){
        return erpRepository.selectErpDailyServerMain(erpMainId);
    }

    public List<MInsertErpDailyServiceMain> selectErpDailyServiceMain(Long erpMainId){
        return erpRepository.selectErpDailyServiceMain(erpMainId);
    }

    public List<MInsertErpDailyVMMain> selectErpDailyVMMain(Long erpMainId){
        return erpRepository.selectErpDailyVMMain(erpMainId);
    }

    public List<MInsertErpDailyStorageMain> selectErpDailyStorageMain(Long erpMainId){
        return erpRepository.selectErpDailyStorageMain(erpMainId);
    }

    @Transactional(rollbackFor= Exception.class)
    public void insertErpDailyCheckMain(MInsertErpDailyServiceMain mInsertErpDailyServiceMain,
                                     MInsertErpDailyServerMain mInsertErpDailyServerMain,
                                     MInsertErpDailyVMMain mInsertErpDailyVMMain,
                                     MInsertErpDailyStorageMain mInsertErpDailyStorageMain,
                                     MSVDailyCheckBoardMain msvDailyCheckBoardMain){

        mainRepository.insertDailyCheckBoardList(msvDailyCheckBoardMain);

        mInsertErpDailyServiceMain.setErpMainId(msvDailyCheckBoardMain.getDailyMainBoardId());
        mInsertErpDailyServerMain.setErpMainId(msvDailyCheckBoardMain.getDailyMainBoardId());
        mInsertErpDailyVMMain.setErpMainId(msvDailyCheckBoardMain.getDailyMainBoardId());
        mInsertErpDailyStorageMain.setErpMainId(msvDailyCheckBoardMain.getDailyMainBoardId());

        erpRepository.insertErpDailyServiceMain(mInsertErpDailyServiceMain);
        erpRepository.insertErpDailyServerMain(mInsertErpDailyServerMain);
        erpRepository.insertErpDailyStorageMain(mInsertErpDailyStorageMain);
        erpRepository.insertErpDailyVMMain(mInsertErpDailyVMMain);
    }

    @Transactional(rollbackFor=Exception.class)
    public void updateErpDailyCheckMain(Long mainBoardId,
                                        MInsertErpDailyServiceMain mInsertErpDailyServiceMain, MInsertErpDailyServerMain mInsertErpDailyServerMain,
                                        MInsertErpDailyVMMain mInsertErpDailyVMMain, MInsertErpDailyStorageMain mInsertErpDailyStorageMain){

        mainRepository.updateDailyCheckBoard(LocalDateTime.now(),mainBoardId);

        mInsertErpDailyServiceMain.setErpMainId(mainBoardId);
        mInsertErpDailyServerMain.setErpMainId(mainBoardId);
        mInsertErpDailyVMMain.setErpMainId(mainBoardId);
        mInsertErpDailyStorageMain.setErpMainId(mainBoardId);

        erpRepository.updateErpDailyServiceMain(mInsertErpDailyServiceMain);
        erpRepository.updateErpDailyServerMain(mInsertErpDailyServerMain);
        erpRepository.updateErpDailyVMMain(mInsertErpDailyVMMain);
        erpRepository.updateErpDailyStorageMain(mInsertErpDailyStorageMain);


    }
}

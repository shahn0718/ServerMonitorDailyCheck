package com.damg.upit.monitor.dailyCheck.domain.gwDaily.service;


import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyStorageMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyVMMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyStorageMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.repository.gwDailyRepository;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckBoardMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.repository.mainDailyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class gwDailyService {

    private final gwDailyRepository gwRepository;

    private final mainDailyRepository mainRepository;

    public gwDailyService(gwDailyRepository gwRepository, mainDailyRepository mainRepository){
        this.gwRepository = gwRepository;
        this.mainRepository =mainRepository;
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

    @Transactional(rollbackFor = Exception.class)
    public void insertGwDailyCheckMain(MInsertGwDailyServiceMain mInsertGwDailyServiceMain,
                                       MInsertGwDailyServerMain mInsertGwDailyServerMain,
                                       MInsertGwDailyStorageMain mInsertGwDailyStorageMain,
                                       MSVDailyCheckBoardMain msvDailyCheckBoardMain){


        mainRepository.insertDailyCheckBoardList(msvDailyCheckBoardMain);

        mInsertGwDailyServiceMain.setGwMainId(msvDailyCheckBoardMain.getDailyMainBoardId());
        mInsertGwDailyServerMain.setGwMainId(msvDailyCheckBoardMain.getDailyMainBoardId());
        mInsertGwDailyStorageMain.setGwMainId(msvDailyCheckBoardMain.getDailyMainBoardId());

        gwRepository.insertGwDailyServiceMain(mInsertGwDailyServiceMain);
        gwRepository.insertGwDailyServerMain(mInsertGwDailyServerMain);
        gwRepository.insertGwDailyStorageMain(mInsertGwDailyStorageMain);

    }

    @Transactional(rollbackFor=Exception.class)
    public void updateGwDailyCheckMain(Long mainBoardId,
                                        MInsertGwDailyServiceMain mInsertGwDailyServiceMain,
                                        MInsertGwDailyServerMain mInsertGwDailyServerMain,
                                        MInsertGwDailyStorageMain mInsertGwDailyStorageMain){

        mainRepository.updateDailyCheckBoard(LocalDateTime.now(),mainBoardId);

        mInsertGwDailyServiceMain.setGwMainId(mainBoardId);
        mInsertGwDailyServerMain.setGwMainId(mainBoardId);
        mInsertGwDailyStorageMain.setGwMainId(mainBoardId);

        gwRepository.updateGwDailyServiceMain(mInsertGwDailyServiceMain);
        gwRepository.updateGwDailyServerMain(mInsertGwDailyServerMain);
        gwRepository.updateGwDailyStorageMain(mInsertGwDailyStorageMain);

    }

    @Transactional(rollbackFor=Exception.class)
    public void deletGwDailyCheckMain(Long mainBoardId){

        gwRepository.deleteGwDailyServerMain(mainBoardId);
        gwRepository.deleteGwDailyServiceMain(mainBoardId);
        gwRepository.deleteGwDailyStorageMain(mainBoardId);

        mainRepository.deleteDailyCheckBoard(mainBoardId);


    }
}

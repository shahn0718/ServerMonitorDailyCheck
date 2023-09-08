package com.damg.upit.monitor.dailyCheck.domain.infraDaily.service;

import com.damg.upit.monitor.dailyCheck.domain.infraDaily.model.MInsertInfraDailyEtcMain;
import com.damg.upit.monitor.dailyCheck.domain.infraDaily.model.MInsertInfraDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.infraDaily.model.MInsertInfraDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.infraDaily.model.MInsertInfraDailyVMMain;
import com.damg.upit.monitor.dailyCheck.domain.infraDaily.repository.infraDailyRepository;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class infraDailyService {

    private final infraDailyRepository infraRepository;

    public infraDailyService(infraDailyRepository infraRepository){
        this.infraRepository = infraRepository;
    }

    public void insertInfraDailyServiceMain(MInsertInfraDailyServiceMain mInsertInfraDailyServiceMain){
        infraRepository.insertInfraDailyServiceMain(mInsertInfraDailyServiceMain);
    }
    public void insertInfraDailyServerMain(MInsertInfraDailyServerMain mInsertInfraDailyServerMain){
        infraRepository.insertInfraDailyServerMain(mInsertInfraDailyServerMain);
    }
    public void insertInfraDailyVMMain(MInsertInfraDailyVMMain mInsertInfraDailyVMMain){
        infraRepository.insertInfraDailyVMMain(mInsertInfraDailyVMMain);
    }
    public void insertInfraDailyEtcMain(MInsertInfraDailyEtcMain mInsertInfraDailyEtcMain){
        infraRepository.insertInfraDailyEtcMain(mInsertInfraDailyEtcMain);
    }
    public List<MInsertInfraDailyServiceMain> selectInfraDailyServiceMain(Long infraMainId){
        return infraRepository.selectInfraDailyServiceMain(infraMainId);
    }
    public List<MInsertInfraDailyServerMain> selectInfraDailyServerMain(Long infraMainId){
        return infraRepository.selectInfraDailyServerMain(infraMainId);
    }
    public List<MInsertInfraDailyVMMain> selectInfraDailyVMMain(Long infraMainId){
        return infraRepository.selectInfraDailyVMMain(infraMainId);
    }
    public List<MInsertInfraDailyEtcMain> selectInfraDailyEtcMain(Long infraMainId){
        return infraRepository.selectInfraDailyEtcMain(infraMainId);
    }
    public void updateInfraDailyServiceMain(MInsertInfraDailyServiceMain mInsertInfraDailyServiceMain){
        infraRepository.updateInfraDailyServiceMain(mInsertInfraDailyServiceMain);
    }
    public void updateInfraDailyServerMain(MInsertInfraDailyServerMain mInsertInfraDailyServerMain){
        infraRepository.updateInfraDailyServerMain(mInsertInfraDailyServerMain);
    }
    public void updateInfraDailyVMMain(MInsertInfraDailyVMMain mInsertInfraDailyVMMain){
        infraRepository.updateInfraDailyVMMain(mInsertInfraDailyVMMain);
    }

    public void updateInfraDailyEtcMain(MInsertInfraDailyEtcMain mInsertInfraDailyEtcMain){
        infraRepository.updateInfraDailyEtcMain(mInsertInfraDailyEtcMain);
    }

}

package com.damg.upit.monitor.dailyCheck.domain.erpDaily.service;


import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyStorageMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyVMMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.repository.erpDailyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class erpDailyService {

    private final erpDailyRepository erpRepository;

    public erpDailyService(erpDailyRepository erpRepository){
        this.erpRepository = erpRepository;
    }


    public void insertErpDailyServerMain(MInsertErpDailyServerMain miNsertErpDailyServerMain){
        erpRepository.insertErpDailyServerMain(miNsertErpDailyServerMain);
    }
    public void insertErpDailyServiceMain(MInsertErpDailyServiceMain mInsertErpDailyServiceMain){
        erpRepository.insertErpDailyServiceMain(mInsertErpDailyServiceMain);
    }
    public void insertErpDailyVMMain(MInsertErpDailyVMMain mInsertErpDailyVMMain){
        erpRepository.insertErpDailyVMMain(mInsertErpDailyVMMain);
    }
    public void insertErpDailyStorageMain(MInsertErpDailyStorageMain mInsertErpDailyStorageMain){
        erpRepository.insertErpDailyStorageMain(mInsertErpDailyStorageMain);
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

    public void updateErpDailyServerMain(MInsertErpDailyServerMain mInsertErpDailyServerMain){
        erpRepository.updateErpDailyServerMain(mInsertErpDailyServerMain);
    }

    public void updateErpDailyServiceMain(MInsertErpDailyServiceMain mInsertErpDailyServiceMain){
        erpRepository.updateErpDailyServiceMain(mInsertErpDailyServiceMain);
    }

    public void updateErpDailyVMMain(MInsertErpDailyVMMain mInsertErpDailyVMMain){
        erpRepository.updateErpDailyVMMain(mInsertErpDailyVMMain);
    }

    public void updateErpDailyStorageMain(MInsertErpDailyStorageMain mInsertErpDailyStorageMain){
        erpRepository.updateErpDailyStorageMain(mInsertErpDailyStorageMain);
    }


}

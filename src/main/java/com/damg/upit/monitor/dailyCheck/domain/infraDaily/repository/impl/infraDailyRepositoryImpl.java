package com.damg.upit.monitor.dailyCheck.domain.infraDaily.repository.impl;

import com.damg.upit.monitor.dailyCheck.domain.infraDaily.mapper.infraDailyMapper;
import com.damg.upit.monitor.dailyCheck.domain.infraDaily.model.MInsertInfraDailyEtcMain;
import com.damg.upit.monitor.dailyCheck.domain.infraDaily.model.MInsertInfraDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.infraDaily.model.MInsertInfraDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.infraDaily.model.MInsertInfraDailyVMMain;
import com.damg.upit.monitor.dailyCheck.domain.infraDaily.repository.infraDailyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;


@Slf4j
@Repository
public class infraDailyRepositoryImpl implements infraDailyRepository {

    private final infraDailyMapper infraMapper;

    public infraDailyRepositoryImpl(infraDailyMapper infraMapper){
        this.infraMapper =infraMapper;
    }


    @Override
    public void insertInfraDailyServiceMain(MInsertInfraDailyServiceMain mInsertInfraDailyServiceMain) {
        infraMapper.insertInfraDailyServiceMain(mInsertInfraDailyServiceMain);
    }

    @Override
    public void insertInfraDailyServerMain(MInsertInfraDailyServerMain mInsertInfraDailyServerMain) {
        infraMapper.insertInfraDailyServerMain(mInsertInfraDailyServerMain);
    }

    @Override
    public void insertInfraDailyVMMain(MInsertInfraDailyVMMain mInsertInfraDailyVMMain) {
        infraMapper.insertInfraDailyVMMain(mInsertInfraDailyVMMain);
    }

    @Override
    public void insertInfraDailyEtcMain(MInsertInfraDailyEtcMain mInsertInfraDailyEtcMain) {
        infraMapper.insertInfraDailyEtcMain(mInsertInfraDailyEtcMain);
    }

    @Override
    public List<MInsertInfraDailyServiceMain> selectInfraDailyServiceMain(Long infraMainId) {
        return infraMapper.selectInfraDailyServiceMain(infraMainId);
    }

    @Override
    public List<MInsertInfraDailyServerMain> selectInfraDailyServerMain(Long infraMainId) {
        return infraMapper.selectInfraDailyServerMain(infraMainId);
    }

    @Override
    public List<MInsertInfraDailyVMMain> selectInfraDailyVMMain(Long infraMainId) {
        return infraMapper.selectInfraDailyVMMain(infraMainId);
    }

    @Override
    public List<MInsertInfraDailyEtcMain> selectInfraDailyEtcMain(Long infraMainId) {
        return infraMapper.selectInfraDailyEtcMain(infraMainId);
    }

    @Override
    public void updateInfraDailyServiceMain(MInsertInfraDailyServiceMain mInsertInfraDailyServiceMain) {
        infraMapper.updateInfraDailyServiceMain(mInsertInfraDailyServiceMain);
    }

    @Override
    public void updateInfraDailyServerMain(MInsertInfraDailyServerMain mInsertInfraDailyServerMain) {
        infraMapper.updateInfraDailyServerMain(mInsertInfraDailyServerMain);
    }

    @Override
    public void updateInfraDailyVMMain(MInsertInfraDailyVMMain mInsertInfraDailyVMMain) {
        infraMapper.updateInfraDailyVMMain(mInsertInfraDailyVMMain);
    }

    @Override
    public void updateInfraDailyEtcMain(MInsertInfraDailyEtcMain mInsertInfraDailyEtcMain) {
        infraMapper.updateInfraDailyEtcMain(mInsertInfraDailyEtcMain);
    }

    @Override
    public void deleteInfraDailyService(Long boardId) {

    }

    @Override
    public void deleteInfraDailyServer(Long boardId) {

    }

    @Override
    public void deleteInfraDailyVMMain(Long boardId) {

    }

    @Override
    public void deleteInfraDailyEtcMain(Long boardId) {

    }
}

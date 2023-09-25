package com.damg.upit.monitor.dailyCheck.domain.erpDaily.repository.impl;

import com.damg.upit.monitor.dailyCheck.domain.erpDaily.mapper.erpDailyMapper;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyStorageMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyVMMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.repository.erpDailyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class erpDailyRepositoryImpl implements erpDailyRepository {

    private final erpDailyMapper erpDailyMapper;

    public erpDailyRepositoryImpl(erpDailyMapper erpDailyMapper){
        this.erpDailyMapper = erpDailyMapper;
    }
    @Override
    public void insertErpDailyServerMain(MInsertErpDailyServerMain minsertErpDailyServerMain) {
        erpDailyMapper.insertErpDailyServerMain(minsertErpDailyServerMain);
    }

    @Override
    public void insertErpDailyServiceMain(MInsertErpDailyServiceMain mInsertErpDailyServiceMain) {
        erpDailyMapper.insertErpDailyServiceMain(mInsertErpDailyServiceMain);
    }

    @Override
    public void insertErpDailyVMMain(MInsertErpDailyVMMain mInsertErpDailyVMMain) {
        erpDailyMapper.insertErpDailyVMMain(mInsertErpDailyVMMain);
    }

    @Override
    public void insertErpDailyStorageMain(MInsertErpDailyStorageMain mInsertErpDailyStorageMain) {
        erpDailyMapper.insertErpDailyStorageMain(mInsertErpDailyStorageMain);
    }

    @Override
    public List<MInsertErpDailyServerMain> selectErpDailyServerMain(Long erpMainId) {
        return erpDailyMapper.selectErpDailyServerMain(erpMainId);
    }

    @Override
    public List<MInsertErpDailyServiceMain> selectErpDailyServiceMain(Long erpMainId) {
        return erpDailyMapper.selectErpDailyServiceMain(erpMainId);
    }

    @Override
    public List<MInsertErpDailyVMMain> selectErpDailyVMMain(Long erpMainId) {
        return erpDailyMapper.selectErpDailyVMMain(erpMainId);
    }

    @Override
    public List<MInsertErpDailyStorageMain> selectErpDailyStorageMain(Long erpMainId) {
        return erpDailyMapper.selectErpDailyStorageMain(erpMainId);
    }

    @Override
    public void updateErpDailyServerMain(MInsertErpDailyServerMain mInsertErpDailyServerMain) {
        erpDailyMapper.updateErpDailyServerMain(mInsertErpDailyServerMain);
    }

    @Override
    public void updateErpDailyServiceMain(MInsertErpDailyServiceMain mInsertErpDailyServiceMain) {
        erpDailyMapper.updateErpDailyServiceMain(mInsertErpDailyServiceMain);
    }

    @Override
    public void updateErpDailyVMMain(MInsertErpDailyVMMain mInsertErpDailyVMMain) {
        erpDailyMapper.updateErpDailyVMMain(mInsertErpDailyVMMain);
    }

    @Override
    public void updateErpDailyStorageMain(MInsertErpDailyStorageMain mInsertErpDailyStorageMain) {
        erpDailyMapper.updateErpDailyStorageMain(mInsertErpDailyStorageMain);
    }

    @Override
    public void deleteErpDailyServiceMain(Long boardId) {
        erpDailyMapper.deleteErpDailyServiceMain(boardId);
    }

    @Override
    public void deleteErpDailyServerMain(Long boardId) {
        erpDailyMapper.deleteErpDailyServerMain(boardId);
    }

    @Override
    public void deleteErpDailyVMMain(Long boardId) {
        erpDailyMapper.deleteErpDailyVMMain(boardId);
    }

    @Override
    public void deleteErpDailyStorageMain(Long boardId) {
        erpDailyMapper.deleteErpDailyStorageMain(boardId);
    }


}

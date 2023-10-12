package com.damg.upit.monitor.dailyCheck.domain.mainDaily.repository.impl;

import com.damg.upit.monitor.dailyCheck.domain.mainDaily.mapper.mainDailyMapper;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckAdminMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckBoardMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.repository.mainDailyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Slf4j
@Repository
public class mainDailyRepositoryImpl implements mainDailyRepository {

    private final mainDailyMapper dailyMapper;
    public mainDailyRepositoryImpl(mainDailyMapper dailyMapper){
        this.dailyMapper = dailyMapper;
    }
    @Override
    public List<MSVDailyCheckBoardMain> selectDailyCheckBoardList() {
        return dailyMapper.selectDailyCheckBoardList();
    }

    @Override
    public MSVDailyCheckBoardMain selectDailyCheckBoard(Long mainBoardId) {
        return dailyMapper.selectDailyCheckBoard(mainBoardId);
    }
    @Override
    public List<MSVDailyCheckAdminMain> selectDailyCheckAdminList() {
        return dailyMapper.selectDailyCheckAdminList();
    }

    @Override
    public MSVDailyCheckAdminMain selectDailyCheckAdmin(String admin_nm) {
        return dailyMapper.selectDailyCheckAdmin(admin_nm);
    }
    @Override
    public void insertDailyCheckBoardList(MSVDailyCheckBoardMain msvDailyCheckBoardMain) {
        dailyMapper.insertDailyCheckBoardList(msvDailyCheckBoardMain);
    }

    @Override
    public void updateDailyCheckBoard(LocalDateTime mainBoardModDate, int dailyMainViewCnt, Long mainBoadId) {
        dailyMapper.updateDailyCheckBoardNew(mainBoardModDate, dailyMainViewCnt, mainBoadId);
    }

    @Override
    public void deleteDailyCheckBoard(Long boardId) {
        dailyMapper.deleteDailyCheckBoard(boardId);
    }

}

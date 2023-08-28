package com.damg.upit.monitor.dailyCheck.domain.mainDaily.repository.impl;

import com.damg.upit.monitor.dailyCheck.domain.mainDaily.mapper.mainDailyMapper;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckAdminMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckBoardMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.repository.mainDailyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;


@Slf4j
@Repository
public class mainDailyRepositoryImpl implements mainDailyRepository {
    private final mainDailyMapper dailyMapper;
    public mainDailyRepositoryImpl(mainDailyMapper dailyMapper){
        this.dailyMapper = dailyMapper;
    }
    @Override
    public List<MSVDailyCheckBoardMain> getDailyCheckBoardList() {
        return dailyMapper.getDailyCheckBoardList();
    }
    @Override
    public List<MSVDailyCheckAdminMain> getDailyCheckAdminList() {
        return dailyMapper.getDailyCheckAdminList();
    }


}

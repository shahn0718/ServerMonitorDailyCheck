package com.damg.upit.monitor.dailyCheck.domain.mainPaging.repository.impl;

import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckBoardMain;
import com.damg.upit.monitor.dailyCheck.domain.mainPaging.mapper.mainPagingMapper;
import com.damg.upit.monitor.dailyCheck.domain.mainPaging.model.MDailyBoardPagingMain;
import com.damg.upit.monitor.dailyCheck.domain.mainPaging.repository.mainPagingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;


@Slf4j
@Repository
public class mainPagingRepositoryImpl implements mainPagingRepository {


    private final mainPagingMapper pagingMapper;

    public mainPagingRepositoryImpl(mainPagingMapper pagingMapper){
        this.pagingMapper =pagingMapper;
    }

    @Override
    public List<MSVDailyCheckBoardMain> findPagingBoardList(MDailyBoardPagingMain mDailyBoardPagingMain) {
        return pagingMapper.findPagingBoardList(mDailyBoardPagingMain);
    }

    @Override
    public int getBoardTotalList() {
       return pagingMapper.getBoardTotalList();
    }


}

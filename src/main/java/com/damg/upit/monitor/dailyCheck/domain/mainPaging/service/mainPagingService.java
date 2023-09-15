package com.damg.upit.monitor.dailyCheck.domain.mainPaging.service;

import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckBoardMain;
import com.damg.upit.monitor.dailyCheck.domain.mainPaging.model.MDailyBoardPagingMain;
import com.damg.upit.monitor.dailyCheck.domain.mainPaging.repository.mainPagingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class mainPagingService {

    private final mainPagingRepository pagingRepository;

    public mainPagingService(mainPagingRepository pagingRepository){
        this.pagingRepository =pagingRepository;
    }

    /**
     *
     * @param mDailyBoardPagingMain
     * @return
     */
    public List<MSVDailyCheckBoardMain> findPagingBoardList(MDailyBoardPagingMain mDailyBoardPagingMain) {
        return pagingRepository.findPagingBoardList(mDailyBoardPagingMain);
    }

    /**
     *
     * @param mDailyBoardPagingMain
     * @return
     */
    public int countPerPageBoardList(MDailyBoardPagingMain mDailyBoardPagingMain) {
        return pagingRepository.countPerPageBoardList(mDailyBoardPagingMain);
    }
}

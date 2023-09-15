package com.damg.upit.monitor.dailyCheck.domain.mainPaging.repository;

import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckBoardMain;
import com.damg.upit.monitor.dailyCheck.domain.mainPaging.model.MDailyBoardPagingMain;

import java.util.List;

public interface mainPagingRepository {

    /**
     * 게시글리스트 조회
     * @param mDailyBoardPagingMain
     * @return 게시글 리스트
     */
    List<MSVDailyCheckBoardMain> findPagingBoardList(MDailyBoardPagingMain mDailyBoardPagingMain);

    /**
     * 게시글 수 카운팅
     * @param mDailyBoardPagingMain
     * @return 게시글 수
     */
    int countPerPageBoardList(MDailyBoardPagingMain mDailyBoardPagingMain);
}

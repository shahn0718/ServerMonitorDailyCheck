package com.damg.upit.monitor.dailyCheck.domain.mainDaily.repository;

import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckAdminMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckBoardMain;

import java.util.List;

public interface mainDailyRepository {

    /**
     * 게시판 메인화면 전체조회
     * @return
     */
    List<MSVDailyCheckBoardMain> getDailyCheckBoardList();

    /**
     * 담당자 전체조회 (작성자 콤보박스 노출 부분)
     * @return
     */
    List<MSVDailyCheckAdminMain> getDailyCheckAdminList();
    /**
     * 담당자 개인조회 (작성자 입력 후, 등록할 때 조회해오기)
     * @return
     */
    MSVDailyCheckAdminMain getDailyCheckAdmin(String admin_nm);

    void insertDailyCheckBoardList(MSVDailyCheckBoardMain msvDailyCheckBoardMain);

}

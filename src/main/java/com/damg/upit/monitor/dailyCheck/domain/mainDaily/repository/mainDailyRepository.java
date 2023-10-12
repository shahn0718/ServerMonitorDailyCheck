package com.damg.upit.monitor.dailyCheck.domain.mainDaily.repository;

import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckAdminMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckBoardMain;

import java.time.LocalDateTime;
import java.util.List;

public interface mainDailyRepository {

    /**
     * 게시판 메인화면 전체조회
     * @return
     */
    List<MSVDailyCheckBoardMain> selectDailyCheckBoardList();
    MSVDailyCheckBoardMain selectDailyCheckBoard(Long mainBoardId);
    /**
     * 담당자 전체조회 (작성자 콤보박스 노출 부분)
     * @return
     */
    List<MSVDailyCheckAdminMain> selectDailyCheckAdminList();
    /**
     * 담당자 개인조회 (작성자 입력 후, 등록할 때 조회해오기)
     * @return
     */
    MSVDailyCheckAdminMain selectDailyCheckAdmin(String admin_nm);
    void insertDailyCheckBoardList(MSVDailyCheckBoardMain msvDailyCheckBoardMain);
    void updateDailyCheckBoard(LocalDateTime mainBoardModDate, int dailyMainViewCnt, Long mainBoardId);
    void deleteDailyCheckBoard(Long boardId);

}

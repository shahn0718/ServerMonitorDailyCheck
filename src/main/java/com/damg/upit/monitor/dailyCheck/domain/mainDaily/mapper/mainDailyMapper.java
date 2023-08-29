package com.damg.upit.monitor.dailyCheck.domain.mainDaily.mapper;


import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckAdminMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckBoardMain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface mainDailyMapper {
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
     MSVDailyCheckAdminMain getDailyCheckAdmin(@Param("admin_nm")String admin_nm);

     void insertDailyCheckBoardList(MSVDailyCheckBoardMain msvDailyCheckBoardMain);

}

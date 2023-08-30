package com.damg.upit.monitor.dailyCheck.domain.mainDaily.service;

import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckAdminMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckBoardMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.repository.mainDailyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class mainDailyService {

    private final mainDailyRepository dailyRepository;

    public mainDailyService(mainDailyRepository dailyRepository){
        this.dailyRepository = dailyRepository;
    }
    /**
     * 게시판 메인화면 전체조회
     * @return
     */
    public List<MSVDailyCheckBoardMain> selectDailyCheckBoardList(){
        return dailyRepository.selectDailyCheckBoardList();
    }

    public MSVDailyCheckBoardMain selectDailyCheckBoard(Long mainBoardId){
        return dailyRepository.selectDailyCheckBoard(mainBoardId);
    }

    /**
     * 담당자 전체조회 (작성자 콤보박스 노출 부분)
     * @return
     */
    public List<MSVDailyCheckAdminMain> selectDailyCheckAdminList(){
        return dailyRepository.selectDailyCheckAdminList();
    }
    /**
     * 담당자 개인조회 (작성자 입력 후, 등록할 때 조회해오기)
     * @return
     */
    public MSVDailyCheckAdminMain selectDailyCheckAdmin(String admin_nm){
        return dailyRepository.selectDailyCheckAdmin(admin_nm);
    }
    public void insertDailyCheckBoardList(MSVDailyCheckBoardMain msvDailyCheckBoardMain){
        dailyRepository.insertDailyCheckBoardList(msvDailyCheckBoardMain);
    }
    public void updateDailyCheckBoard(LocalDateTime mainBoardModDate, Long mainBoardId){
        dailyRepository.updateDailyCheckBoard(mainBoardModDate,mainBoardId);
    }

}

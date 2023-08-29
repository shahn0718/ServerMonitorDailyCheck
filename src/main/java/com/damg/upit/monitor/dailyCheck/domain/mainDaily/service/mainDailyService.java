package com.damg.upit.monitor.dailyCheck.domain.mainDaily.service;

import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckAdminMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckBoardMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.repository.mainDailyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
    public List<MSVDailyCheckBoardMain> getDailyCheckBoardList(){
        return dailyRepository.getDailyCheckBoardList();
    }
    /**
     * 담당자 전체조회 (작성자 콤보박스 노출 부분)
     * @return
     */
    public List<MSVDailyCheckAdminMain> getDailyCheckAdminList(){
        return dailyRepository.getDailyCheckAdminList();
    }
    /**
     * 담당자 개인조회 (작성자 입력 후, 등록할 때 조회해오기)
     * @return
     */
    public MSVDailyCheckAdminMain getDailyCheckAdmin(String admin_nm){
        return dailyRepository.getDailyCheckAdmin(admin_nm);
    }
    public void insertDailyCheckBoardList(MSVDailyCheckBoardMain msvDailyCheckBoardMain){
        dailyRepository.insertDailyCheckBoardList(msvDailyCheckBoardMain);
    }


}

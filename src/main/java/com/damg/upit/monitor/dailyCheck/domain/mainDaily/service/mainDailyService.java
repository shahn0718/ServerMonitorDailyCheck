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

    public List<MSVDailyCheckBoardMain> getDailyCheckBoardList(){
        return dailyRepository.getDailyCheckBoardList();
    }

    public List<MSVDailyCheckAdminMain> getDailyCheckAdminList(){
        return dailyRepository.getDailyCheckAdminList();
    }


}

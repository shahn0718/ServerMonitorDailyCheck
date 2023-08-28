package com.damg.upit.monitor.dailyCheck.domain.mainDaily.controller;


import com.damg.upit.monitor.dailyCheck.domain.mainDaily.service.mainDailyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class mainDailyController {

    private final mainDailyService mainService;

    public mainDailyController(mainDailyService mainService){
        this.mainService = mainService;
    }

    @GetMapping("/mainDailyCheck")
    public String mainHome(Model model){

        Model mainDailyBoardList = model.addAttribute("mainDailyBoardList", mainService.getDailyCheckBoardList());
        log.info("mainDailyBoardList= {}", mainDailyBoardList);

        return "mainBoard";
    }

}

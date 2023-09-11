package com.damg.upit.monitor.dailyCheck.domain.infraDaily.controller;


import com.damg.upit.monitor.dailyCheck.domain.infraDaily.service.infraDailyService;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MDailyCheckElement;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.service.mainDailyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Slf4j
@Controller
public class infraDailyController {

    private final infraDailyService infraService;
    private final mainDailyService mainService;

    public infraDailyController(infraDailyService infraService, mainDailyService mainService){
        this.infraService = infraService;
        this.mainService  = mainService;
    }
    private MDailyCheckElement mDailyCheckElement;

    @GetMapping("/infraDailyCheck")
    public String home(Model model){

        model.addAttribute("adminUser", mainService.selectDailyCheckAdminList());
        model.addAttribute("createdTime", LocalDateTime.now());

        return "infraServer/dailyChkInfraInput";
    }

}

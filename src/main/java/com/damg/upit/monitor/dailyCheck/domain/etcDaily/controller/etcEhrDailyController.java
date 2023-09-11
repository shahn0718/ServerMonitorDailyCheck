package com.damg.upit.monitor.dailyCheck.domain.etcDaily.controller;


import com.damg.upit.monitor.dailyCheck.domain.etcDaily.service.etcHrDailyService;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.service.mainDailyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Slf4j
@Controller
public class etcEhrDailyController {

    private final etcHrDailyService etcHRService;
    private final mainDailyService mainService;

    public etcEhrDailyController(etcHrDailyService etcHRService, mainDailyService mainService){
        this.etcHRService = etcHRService;
        this.mainService = mainService;
    }

    @GetMapping("/etcEhrDailyCheck")
    public String home(Model model){
        model.addAttribute("adminUser", mainService.selectDailyCheckAdminList());
        model.addAttribute("createdTime", LocalDateTime.now());

        return "etcServer/ehr/dailyChkEtcEhrInput";

    }


}

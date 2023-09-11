package com.damg.upit.monitor.dailyCheck.domain.etcDaily.controller;


import com.damg.upit.monitor.dailyCheck.domain.etcDaily.service.etcDailyService;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.service.etcHrDailyService;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MDailyCheckElement;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.service.mainDailyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Slf4j
@Controller
public class etcDailyController {

    private final etcDailyService etcService;
    private final mainDailyService mainService;

    public etcDailyController(etcDailyService etcService, mainDailyService mainService){
        this.etcService = etcService;
        this.mainService= mainService;
    }
    private MDailyCheckElement mdailyCheckElement;

    @GetMapping("/etcDailyCheck")
    public String home(Model model){
        model.addAttribute("adminUser", mainService.selectDailyCheckAdminList());
        model.addAttribute("createdTime", LocalDateTime.now());

        return "etcServer/erp/dailyChkEtcErpInput";
    }
}

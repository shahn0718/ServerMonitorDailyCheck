package com.damg.upit.monitor.dailyCheck.domain.gwDaily.controller;

import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyStorageMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.service.gwDailyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class gwDailyController {

    private final gwDailyService gwService;

    public gwDailyController(gwDailyService gwService) {
        this.gwService = gwService;
    }

    @GetMapping("/geniousDailyChk")
    public String home(){
        return "gwServer/dailyChkGeniousInput";
    }


    @PostMapping ("/geniousDailyChk")
    public String getHome(
                          @ModelAttribute("gwDailyServiceMain")MInsertGwDailyServiceMain mInsertGwDailyServiceMain,
                          @ModelAttribute("gwDailyServerMain")MInsertGwDailyServerMain mInsertGwDailyServerMain,
                          @ModelAttribute("gwDailyStorageMain")MInsertGwDailyStorageMain mInsertGwDailyStorageMain,
                          Model model){


        Model gwDailyCheck = model.addAttribute("gwDailyCheck");
        gwService.insertGwDailyServerMain(mInsertGwDailyServerMain);
        gwService.insertGwDailyStorageMain(mInsertGwDailyStorageMain);
        gwService.insertGwDailyServiceMain(mInsertGwDailyServiceMain);

        System.out.println("gwDailyCheck = " + gwDailyCheck);

        
        return "gwServer/main";

        /*
         @PostMapping("/add")
            public String addItemV2(@ModelAttribute("item") Item item, Model model) {
            itemRepository.save(item); //model.addAttribute("item", item); //자동 추가, 생략 가능
      return "basic/item";
  }
         */
    }
}

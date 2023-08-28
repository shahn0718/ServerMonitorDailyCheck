package com.damg.upit.monitor.dailyCheck.domain.gwDaily.controller;

import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyStorageMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.service.gwDailyService;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.service.mainDailyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@Slf4j
public class gwDailyController {

    private final gwDailyService gwService;

    @Autowired
    private mainDailyService mainService;

    public gwDailyController(gwDailyService gwService) {
        this.gwService = gwService;
    }


    @GetMapping("/GW/{boardId}")
    public String getGwDailyCheck(@PathVariable("boardId")Long gwMainId, Model model){

        System.out.println(gwMainId);

        List<MInsertGwDailyServiceMain> mInsertGwDailyServiceMain = gwService.selectGwDailyServiceMain(gwMainId);
        List<MInsertGwDailyServerMain> mInsertGwDailyServerMain = gwService.selectGwDailyServerMain(gwMainId);
        List<MInsertGwDailyStorageMain> mInsertGwDailyStorageMain = gwService.selectGwDailyStorageMain(gwMainId);

        model.addAttribute("gwService", mInsertGwDailyServiceMain);
        model.addAttribute("gwServer", mInsertGwDailyServerMain);
        model.addAttribute("gwStorage", mInsertGwDailyStorageMain);

        System.out.println("model = " + model);


        return "gwServer/dailyChkGeniousOutput";
    }



    @GetMapping("/geniousDailyCheck")
    public String home(Model model){

        model.addAttribute("adminUser", mainService.getDailyCheckAdminList());
        model.addAttribute("createdTime", LocalDateTime.now());

        return "gwServer/dailyChkGeniousInput";
    }

    @PostMapping ("/geniousDailyCheck")
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

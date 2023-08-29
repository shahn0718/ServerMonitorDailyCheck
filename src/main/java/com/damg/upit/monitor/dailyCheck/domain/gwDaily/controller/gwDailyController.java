package com.damg.upit.monitor.dailyCheck.domain.gwDaily.controller;

import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.model.MInsertGwDailyStorageMain;
import com.damg.upit.monitor.dailyCheck.domain.gwDaily.service.gwDailyService;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MDailyCheckElement;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckAdminMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckBoardMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.service.mainDailyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@Slf4j
public class gwDailyController {

    private final gwDailyService gwService;

    @Autowired
    private mainDailyService mainService;

    private long gwSVMainId;

    public MDailyCheckElement mDailyCheckElement;

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

        System.out.println("model = " + model);
        return "gwServer/dailyChkGeniousInput";
    }

    @PostMapping ("/geniousDailyCheck")
    public String writeGeniousDailyCheck(
                          @ModelAttribute("gwDailyServiceMain")MInsertGwDailyServiceMain mInsertGwDailyServiceMain,
                          @ModelAttribute("gwDailyServerMain")MInsertGwDailyServerMain mInsertGwDailyServerMain,
                          @ModelAttribute("gwDailyStorageMain")MInsertGwDailyStorageMain mInsertGwDailyStorageMain,
                          @RequestParam String admin_nm,
                          Model model){

        Model gwDailyCheckSubmit = model.addAttribute("gwDailyCheck");


        String contentDate = DateTimeFormatter.ofPattern("yyyy.MM.dd").format(LocalDateTime.now());


        MSVDailyCheckAdminMain msvDailyCheckAdminMain = mainService.getDailyCheckAdmin(admin_nm);

        MSVDailyCheckBoardMain msvDailyCheckBoardMain = new MSVDailyCheckBoardMain();
        msvDailyCheckBoardMain.setDailyMainCd(mDailyCheckElement.GW);
        msvDailyCheckBoardMain.setDailyMainCdNm(mDailyCheckElement.GW_KOR);
        msvDailyCheckBoardMain.setDailyMainContent(mDailyCheckElement.GW_KOR+" 서버 일일점검 "+"("+contentDate+")");
        msvDailyCheckBoardMain.setDailyMainWriter(msvDailyCheckAdminMain.getAdmin_nm());
        msvDailyCheckBoardMain.setDailyMainWriterNo(msvDailyCheckAdminMain.getAdmin_no());
        msvDailyCheckBoardMain.setDailyMainCreateDate(LocalDateTime.now());

        mainService.insertDailyCheckBoardList(msvDailyCheckBoardMain);

        System.out.println("msvDailyCheckBoardMain = " + msvDailyCheckBoardMain);

        Long mainBoardId = msvDailyCheckBoardMain.getDailyMainBoardId();
        System.out.println("mainBoardId = " + mainBoardId);

        mInsertGwDailyServerMain.setGwMainId(mainBoardId);
        mInsertGwDailyServiceMain.setGwMainId(mainBoardId);
        mInsertGwDailyStorageMain.setGwMainId(mainBoardId);

        gwService.insertGwDailyServerMain(mInsertGwDailyServerMain);
        gwService.insertGwDailyStorageMain(mInsertGwDailyStorageMain);
        gwService.insertGwDailyServiceMain(mInsertGwDailyServiceMain);

        System.out.println("msvDailyCheckBoardMain = " + msvDailyCheckBoardMain);
        log.info("gwDailyCheckSubmit={}", gwDailyCheckSubmit);


        return "redirect:/mainDailyCheck";

    }


}

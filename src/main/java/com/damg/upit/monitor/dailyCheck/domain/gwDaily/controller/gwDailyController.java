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

@Slf4j
@Controller
public class gwDailyController {

    private final gwDailyService gwService;
    private final mainDailyService mainService;

    public gwDailyController(gwDailyService gwService, mainDailyService mainService) {
        this.gwService = gwService;
        this.mainService = mainService;
    }

    private long gwSVMainId;

    public MDailyCheckElement mDailyCheckElement;

    @GetMapping("/geniousDailyCheck")
    public String home(Model model){

        model.addAttribute("adminUser", mainService.selectDailyCheckAdminList());
        model.addAttribute("createdTime", LocalDateTime.now());

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

        MSVDailyCheckAdminMain msvDailyCheckAdminMain = mainService.selectDailyCheckAdmin(admin_nm);

        MSVDailyCheckBoardMain msvDailyCheckBoardMain = new MSVDailyCheckBoardMain();
        msvDailyCheckBoardMain.setDailyMainCd(mDailyCheckElement.GW);
        msvDailyCheckBoardMain.setDailyMainCdNm(mDailyCheckElement.GW_KOR);
        msvDailyCheckBoardMain.setDailyMainContent(mDailyCheckElement.GW_KOR+" 서버 일일점검 "+"("+contentDate+")");
        msvDailyCheckBoardMain.setDailyMainWriter(msvDailyCheckAdminMain.getAdmin_nm());
        msvDailyCheckBoardMain.setDailyMainWriterNo(msvDailyCheckAdminMain.getAdmin_no());
        msvDailyCheckBoardMain.setDailyMainCreateDate(LocalDateTime.now());

        mainService.insertDailyCheckBoardList(msvDailyCheckBoardMain);
        Long mainBoardId = msvDailyCheckBoardMain.getDailyMainBoardId();

        mInsertGwDailyServerMain.setGwMainId(mainBoardId);
        mInsertGwDailyServiceMain.setGwMainId(mainBoardId);
        mInsertGwDailyStorageMain.setGwMainId(mainBoardId);

        gwService.insertGwDailyServerMain(mInsertGwDailyServerMain);
        gwService.insertGwDailyStorageMain(mInsertGwDailyStorageMain);
        gwService.insertGwDailyServiceMain(mInsertGwDailyServiceMain);

        return "redirect:/";
    }

    /**
     * 서버점검 상세조회
     * @param gwMainId
     * @param model
     * @return
     */
    @GetMapping("/GW/{boardId}")
    public String getGwDailyCheck(@PathVariable("boardId")Long gwMainId, Model model){

        log.info("gwMainId={}",gwMainId);

        List<MInsertGwDailyServiceMain> mInsertGwDailyServiceMain = gwService.selectGwDailyServiceMain(gwMainId);
        List<MInsertGwDailyServerMain> mInsertGwDailyServerMain = gwService.selectGwDailyServerMain(gwMainId);
        List<MInsertGwDailyStorageMain> mInsertGwDailyStorageMain = gwService.selectGwDailyStorageMain(gwMainId);
        MSVDailyCheckBoardMain msvDailyCheckBoardMain = mainService.selectDailyCheckBoard(gwMainId);


        model.addAttribute("gwService", mInsertGwDailyServiceMain);
        model.addAttribute("gwServer", mInsertGwDailyServerMain);
        model.addAttribute("gwStorage", mInsertGwDailyStorageMain);
        model.addAttribute("mainBoardInfo",msvDailyCheckBoardMain);

        log.info("gwService={}",mInsertGwDailyServiceMain);
        log.info("mainBoardInfo={}",msvDailyCheckBoardMain);

        return "gwServer/dailyChkGeniousOutput";
    }
    @GetMapping("/GW/{boardId}/Update")
    public String getUpdateGwDailyCheck(@PathVariable("boardId")Long gwMainId, Model model){

        List<MInsertGwDailyServiceMain> mInsertGwDailyServiceMain = gwService.selectGwDailyServiceMain(gwMainId);
        List<MInsertGwDailyServerMain> mInsertGwDailyServerMain = gwService.selectGwDailyServerMain(gwMainId);
        List<MInsertGwDailyStorageMain> mInsertGwDailyStorageMain = gwService.selectGwDailyStorageMain(gwMainId);

        model.addAttribute("gwService", mInsertGwDailyServiceMain);
        model.addAttribute("gwServer", mInsertGwDailyServerMain);
        model.addAttribute("gwStorage", mInsertGwDailyStorageMain);

        return "gwServer/dailyChkGeniousUpdate";
    }

    @PostMapping("/GW/{boardId}/Update")
    public String completeUpdateGwDailyCheck(@PathVariable("boardId")Long mainBoardId,
                                             @ModelAttribute("gwDailyServiceMain")MInsertGwDailyServiceMain mInsertGwDailyServiceMain,
                                             @ModelAttribute("gwDailyServerMain")MInsertGwDailyServerMain mInsertGwDailyServerMain,
                                             @ModelAttribute("gwDailyStorageMain")MInsertGwDailyStorageMain mInsertGwDailyStorageMain,
                                             Model model){


        //메인 게시판 수정일자 업데이트
        mainService.updateDailyCheckBoard(LocalDateTime.now(),mainBoardId);


        System.out.println("mainBoardId = " + mainBoardId);


        mInsertGwDailyServerMain.setGwMainId(mainBoardId);
        mInsertGwDailyServiceMain.setGwMainId(mainBoardId);
        mInsertGwDailyStorageMain.setGwMainId(mainBoardId);

        log.info("gwDailyUpdateCheck={}", mInsertGwDailyServerMain);
        log.info("gwDailyUpdateCheck={}", mInsertGwDailyServiceMain);
        log.info("gwDailyUpdateCheck={}", mInsertGwDailyStorageMain);

        gwService.updateGwDailyServiceMain(mInsertGwDailyServiceMain);
        gwService.updateGwDailyServerMain(mInsertGwDailyServerMain);
        gwService.updateGwDailyStorageMain(mInsertGwDailyStorageMain);

        return "redirect:/";
    }

}

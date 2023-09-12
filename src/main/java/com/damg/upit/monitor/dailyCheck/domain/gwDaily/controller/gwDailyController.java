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
    private MDailyCheckElement mDailyCheckElement;

    @GetMapping("/genieusDailyCheck")
    public String homeGenieusDailyCheck(Model model){

        model.addAttribute("adminUser", mainService.selectDailyCheckAdminList());
        model.addAttribute("createdTime", LocalDateTime.now());

        return "gwServer/dailyChkGenieusInput";
    }

    @PostMapping ("/genieusDailyCheck")
    public String doInsertGenieusDailyCheck(
            @ModelAttribute("gwDailyServiceMain")MInsertGwDailyServiceMain mInsertGwDailyServiceMain,
            @ModelAttribute("gwDailyServerMain")MInsertGwDailyServerMain mInsertGwDailyServerMain,
            @ModelAttribute("gwDailyStorageMain")MInsertGwDailyStorageMain mInsertGwDailyStorageMain,
            @RequestParam String admin_nm,
            Model model){

        Model gwDailyCheckSubmit = model.addAttribute("gwDailyCheck");
        log.info("gwDailyCheckSubmit={}",gwDailyCheckSubmit);

        String contentDate = DateTimeFormatter.ofPattern("yyyy.MM.dd").format(LocalDateTime.now());
        MSVDailyCheckAdminMain msvDailyCheckAdminMain = mainService.selectDailyCheckAdmin(admin_nm);

        MSVDailyCheckBoardMain msvDailyCheckBoardMain = new MSVDailyCheckBoardMain();
        msvDailyCheckBoardMain.setDailyMainCd(mDailyCheckElement.GW);
        msvDailyCheckBoardMain.setDailyMainCdNm(mDailyCheckElement.GW_KOR);
        msvDailyCheckBoardMain.setDailyMainContent(mDailyCheckElement.GW_KOR+" 서버 일일점검 "+"("+contentDate+")");
        msvDailyCheckBoardMain.setDailyMainWriter(msvDailyCheckAdminMain.getAdmin_nm());
        msvDailyCheckBoardMain.setDailyMainWriterNo(msvDailyCheckAdminMain.getAdmin_no());
        msvDailyCheckBoardMain.setDailyMainCreateDate(LocalDateTime.now());

        gwService.insertGwDailyCheckMain(mInsertGwDailyServiceMain,mInsertGwDailyServerMain,
                mInsertGwDailyStorageMain,msvDailyCheckBoardMain);

        return "redirect:/";
    }

    /**
     * 서버점검 상세조회
     * @param gwMainId
     * @param model
     * @return
     */
    @GetMapping("/GW/{boardId}")
    public String doSelectGenieusDailyCheck(@PathVariable("boardId")Long gwMainId, Model model){

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

        return "gwServer/dailyChkGenieusOutput";
    }
    @GetMapping("/GW/{boardId}/Update")
    public String getUpdateGwDailyCheck(@PathVariable("boardId")Long gwMainId, Model model){

        List<MInsertGwDailyServiceMain> mInsertGwDailyServiceMain = gwService.selectGwDailyServiceMain(gwMainId);
        List<MInsertGwDailyServerMain> mInsertGwDailyServerMain = gwService.selectGwDailyServerMain(gwMainId);
        List<MInsertGwDailyStorageMain> mInsertGwDailyStorageMain = gwService.selectGwDailyStorageMain(gwMainId);

        model.addAttribute("gwService", mInsertGwDailyServiceMain);
        model.addAttribute("gwServer", mInsertGwDailyServerMain);
        model.addAttribute("gwStorage", mInsertGwDailyStorageMain);

        return "gwServer/dailyChkGenieusUpdate";
    }

    @PostMapping("/GW/{boardId}/Update")
    public String doUpdateGwDailyCheck (@PathVariable("boardId")Long mainBoardId,
                                        @ModelAttribute("gwDailyServiceMain")MInsertGwDailyServiceMain mInsertGwDailyServiceMain,
                                        @ModelAttribute("gwDailyServerMain")MInsertGwDailyServerMain mInsertGwDailyServerMain,
                                        @ModelAttribute("gwDailyStorageMain")MInsertGwDailyStorageMain mInsertGwDailyStorageMain){

        gwService.updateErpDailyCheckMain(mainBoardId,mInsertGwDailyServiceMain
                ,mInsertGwDailyServerMain,mInsertGwDailyStorageMain);

        log.info("gwDailyUpdateCheck={}", mInsertGwDailyServerMain);
        log.info("gwDailyUpdateCheck={}", mInsertGwDailyServiceMain);
        log.info("gwDailyUpdateCheck={}", mInsertGwDailyStorageMain);

        return "redirect:/";
    }

}

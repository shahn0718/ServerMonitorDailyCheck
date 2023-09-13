package com.damg.upit.monitor.dailyCheck.domain.etcDaily.controller;


import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.ehr.MInsertEtcHrDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.ehr.MInsertEtcHrDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.erp.MInsertEtcDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.erp.MInsertEtcDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.service.etcHrDailyService;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MDailyCheckElement;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckAdminMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckBoardMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.service.mainDailyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Controller
public class etcHrDailyController {

    private final etcHrDailyService etcHRService;
    private final mainDailyService mainService;
    private MDailyCheckElement mDailyCheckElement;

    public etcHrDailyController(etcHrDailyService etcHRService, mainDailyService mainService) {
        this.etcHRService = etcHRService;
        this.mainService = mainService;
    }

    @GetMapping("/etcHrDailyCheck")
    public String homeEtcHrDailyCheck(Model model) {
        model.addAttribute("adminUser", mainService.selectDailyCheckAdminList());
        model.addAttribute("createdTime", LocalDateTime.now());

        return "etcServer/ehr/dailyChkEtcEhrInput";

    }

    @PostMapping("/etcHrDailyCheck")
    public String doInsertEtcHrDailyCheck(
            @ModelAttribute("etcHrDailyServiceMain") MInsertEtcHrDailyServiceMain mInsertEtcHrDailyServiceMain,
            @ModelAttribute("etcHrDailyServerMain") MInsertEtcHrDailyServerMain mInsertEtcHrDailyServerMain,
            @RequestParam String admin_nm,
            Model model) {


        Model etcHrDailyCheck = model.addAttribute("etcHrDailyCheck");
        log.info("etcHrDailyCheck={}", etcHrDailyCheck);

        String contentDate = DateTimeFormatter.ofPattern("yyyy.MM.dd").format(LocalDateTime.now());
        MSVDailyCheckAdminMain msvDailyCheckAdminMain = mainService.selectDailyCheckAdmin(admin_nm);

        MSVDailyCheckBoardMain msvDailyCheckBoardMain = new MSVDailyCheckBoardMain();

        msvDailyCheckBoardMain.setDailyMainCd(mDailyCheckElement.HR);
        msvDailyCheckBoardMain.setDailyMainCdNm(mDailyCheckElement.HR_KOR);
        msvDailyCheckBoardMain.setDailyMainContent(mDailyCheckElement.HR_KOR + " 서버 일일점검 " + "(" + contentDate + ")");
        msvDailyCheckBoardMain.setDailyMainWriter(msvDailyCheckAdminMain.getAdmin_nm());
        msvDailyCheckBoardMain.setDailyMainWriterNo(msvDailyCheckAdminMain.getAdmin_no());
        msvDailyCheckBoardMain.setDailyMainCreateDate(LocalDateTime.now());

        etcHRService.insertEtcHrDailyCheckMain(mInsertEtcHrDailyServiceMain, mInsertEtcHrDailyServerMain, msvDailyCheckBoardMain);

        return "redirect:/";
    }

    @GetMapping("/HR/{boardId}")
    public String doSelectEtcHrDailyCheck(@PathVariable("boardId")Long etcHrMainId, Model model){

        List<MInsertEtcHrDailyServiceMain> mInsertEtcHrDailyServiceMain = etcHRService.selectEtcHrDailyServiceMain(etcHrMainId);
        List<MInsertEtcHrDailyServerMain> mInsertEtcHrDailyServerMain = etcHRService.selectEtcHrDailyServerMain(etcHrMainId);
        MSVDailyCheckBoardMain msvDailyCheckBoardMain = mainService.selectDailyCheckBoard(etcHrMainId);

        model.addAttribute("etcHrService",mInsertEtcHrDailyServiceMain);
        model.addAttribute("etcHrServer",mInsertEtcHrDailyServerMain);
        model.addAttribute("mainBoardInfo",msvDailyCheckBoardMain);

        return "etcServer/ehr/dailyChkEtcEhrOutput";
    }

    @GetMapping("/HR/{boardId}/Update")
    public String getUpdateEtcHrDailyCheck(@PathVariable("boardId")Long etcHrMainId, Model model){

        List<MInsertEtcHrDailyServiceMain> mInsertEtcHrDailyServiceMain = etcHRService.selectEtcHrDailyServiceMain(etcHrMainId);
        List<MInsertEtcHrDailyServerMain> mInsertEtcHrDailyServerMain = etcHRService.selectEtcHrDailyServerMain(etcHrMainId);

        model.addAttribute("etcHrService",mInsertEtcHrDailyServiceMain);
        model.addAttribute("etcHrServer",mInsertEtcHrDailyServerMain);


        return "/etcServer/ehr/dailyChkEtcEhrUpdate";
    }

    @PostMapping("HR/{boardId}/Update")
    public String doUpdateEtcHrDailyCheck(@PathVariable("boardId")Long etcHrMainId,
                                        @ModelAttribute("etcHrDailyServiceMain") MInsertEtcHrDailyServiceMain mInsertEtcHrDailyServiceMain,
                                        @ModelAttribute("etcHrDailyServerMain")MInsertEtcHrDailyServerMain mInsertEtcHrDailyServerMain){

        etcHRService.updateEtcHrDailyCheckMain(etcHrMainId,mInsertEtcHrDailyServiceMain,mInsertEtcHrDailyServerMain);

        log.info("etcHrDailyServiceMain={}",mInsertEtcHrDailyServiceMain);
        log.info("etcHrDailyServerMain={}",mInsertEtcHrDailyServerMain);

        return "redirect:/";
    }
}

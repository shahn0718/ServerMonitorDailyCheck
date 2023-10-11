package com.damg.upit.monitor.dailyCheck.domain.infraDaily.controller;


import com.damg.upit.monitor.dailyCheck.domain.infraDaily.model.MInsertInfraDailyEtcMain;
import com.damg.upit.monitor.dailyCheck.domain.infraDaily.model.MInsertInfraDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.infraDaily.model.MInsertInfraDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.infraDaily.model.MInsertInfraDailyVMMain;
import com.damg.upit.monitor.dailyCheck.domain.infraDaily.service.infraDailyService;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MDailyCheckElement;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckAdminMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckBoardMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.service.mainDailyService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
    public String homeInfraDailyCheck(Model model){

        model.addAttribute("adminUser", mainService.selectDailyCheckAdminList());
        model.addAttribute("createdTime", LocalDateTime.now());

        return "infraServer/dailyChkInfraInput";
    }

    @PostMapping("/infraDailyCheck")
    public String doInsertInfraDailyCheck(
            @ModelAttribute("infraDailyServiceMain")MInsertInfraDailyServiceMain mInsertInfraDailyServiceMain,
            @ModelAttribute("infraDailyServerMain") MInsertInfraDailyServerMain mInsertInfraDailyServerMain,
            @ModelAttribute("infraDailyVMMain")MInsertInfraDailyVMMain mInsertInfraDailyVMMain,
            @ModelAttribute("infraDailyEtcMain")MInsertInfraDailyEtcMain mInsertInfraDailyEtcMain,
            @RequestParam String admin_nm,
            HttpServletRequest request,
            Model model
            ){

        Model infraDailyCheck = model.addAttribute("infraDailyCheck");
        String dailyMainViewCnt = request.getParameter("dailyMainViewCnt");
        log.info("infraDailyCheck={}", infraDailyCheck);

        String contentDate = DateTimeFormatter.ofPattern("yyyy.MM.dd").format(LocalDateTime.now());
        MSVDailyCheckAdminMain msvDailyCheckAdminMain = mainService.selectDailyCheckAdmin(admin_nm);

        MSVDailyCheckBoardMain msvDailyCheckBoardMain = new MSVDailyCheckBoardMain();

        msvDailyCheckBoardMain.setDailyMainCd(mDailyCheckElement.INFRA);
        msvDailyCheckBoardMain.setDailyMainCdNm(mDailyCheckElement.INFRA_CDNM);
        msvDailyCheckBoardMain.setDailyMainContent(mDailyCheckElement.INFRA_KOR+" 서버 일일점검 "+"("+contentDate+")");
        msvDailyCheckBoardMain.setDailyMainWriter(msvDailyCheckAdminMain.getAdmin_nm());
        msvDailyCheckBoardMain.setDailyMainWriterNo(msvDailyCheckAdminMain.getAdmin_no());
        msvDailyCheckBoardMain.setDailyMainViewCnt(Integer.parseInt(dailyMainViewCnt));
        msvDailyCheckBoardMain.setDailyMainCreateDate(LocalDateTime.now());

        infraService.insertInfraDailyCheckMain(mInsertInfraDailyServiceMain,mInsertInfraDailyServerMain,
                mInsertInfraDailyVMMain,mInsertInfraDailyEtcMain,msvDailyCheckBoardMain);

        return "redirect:/";
    }

    @GetMapping("/INFRA/{boardId}")
    public String doSelectInfraDailyCheck(@PathVariable("boardId")Long infraMainId, Model model){

        List<MInsertInfraDailyServiceMain> mInsertInfraDailyServiceMain = infraService.selectInfraDailyServiceMain(infraMainId);
        List<MInsertInfraDailyServerMain> mInsertInfraDailyServerMain = infraService.selectInfraDailyServerMain(infraMainId);
        List<MInsertInfraDailyVMMain> mInsertInfraDailyVMMain = infraService.selectInfraDailyVMMain(infraMainId);
        List<MInsertInfraDailyEtcMain> mInsertInfraDailyEtcMain = infraService.selectInfraDailyEtcMain(infraMainId);
        MSVDailyCheckBoardMain msvDailyCheckBoardMain= mainService.selectDailyCheckBoard(infraMainId);

        model.addAttribute("infraService", mInsertInfraDailyServiceMain);
        model.addAttribute("infraServer", mInsertInfraDailyServerMain);
        model.addAttribute("infraVM", mInsertInfraDailyVMMain);
        model.addAttribute("infraEtc", mInsertInfraDailyEtcMain);
        model.addAttribute("mainBoardInfo",msvDailyCheckBoardMain);

        return "infraServer/dailyChkInfraOutput";
    }

    @GetMapping("/INFRA/{boardId}/Update")
    public String getUpdateInfraDailyCheck(@PathVariable("boardId")Long infraMainId, Model model){

        List<MInsertInfraDailyServiceMain> mInsertInfraDailyServiceMain = infraService.selectInfraDailyServiceMain(infraMainId);
        List<MInsertInfraDailyServerMain> mInsertInfraDailyServerMain = infraService.selectInfraDailyServerMain(infraMainId);
        List<MInsertInfraDailyVMMain> mInsertInfraDailyVMMain = infraService.selectInfraDailyVMMain(infraMainId);
        List<MInsertInfraDailyEtcMain> mInsertInfraDailyEtcMain = infraService.selectInfraDailyEtcMain(infraMainId);

        model.addAttribute("infraService",mInsertInfraDailyServiceMain);
        model.addAttribute("infraServer",mInsertInfraDailyServerMain);
        model.addAttribute("infraVM",mInsertInfraDailyVMMain);
        model.addAttribute("infraEtc",mInsertInfraDailyEtcMain);

        return "infraServer/dailyChkInfraUpdate";
    }

    @PostMapping("/INFRA/{boardId}/Update")
    public String doUpdateInfraDailyCheck(@PathVariable("boardId")Long infraMainId,
                                          @ModelAttribute("infraDailyServiceMain") MInsertInfraDailyServiceMain mInsertInfraDailyServiceMain,
                                          @ModelAttribute("infraDailyServerMain") MInsertInfraDailyServerMain mInsertInfraDailyServerMain,
                                          @ModelAttribute("infraDailyVMMain") MInsertInfraDailyVMMain mInsertInfraDailyVMMain,
                                          @ModelAttribute("infraDailyEtcMain")MInsertInfraDailyEtcMain mInsertInfraDailyEtcMain,
                                          HttpServletRequest request){

        int dailyMainViewCnt = Integer.parseInt(request.getParameter("dailyMainViewCnt"));
        log.info("dailyMainViewCnt={}",dailyMainViewCnt);

        infraService.updateInfraDailyCheckBoard(infraMainId,dailyMainViewCnt,
                mInsertInfraDailyServiceMain,mInsertInfraDailyServerMain,mInsertInfraDailyVMMain,mInsertInfraDailyEtcMain);

        log.info("method=doUpdateInfraDailyCheck() infraDailyServiceMain={}",mInsertInfraDailyServiceMain);
        log.info("method=doUpdateInfraDailyCheck() infraDailyServerMain={}",mInsertInfraDailyServerMain);
        log.info("method=doUpdateInfraDailyCheck() infraDailyVMMain={}",mInsertInfraDailyVMMain);
        log.info("method=doUpdateInfraDailyCheck() infraDailyEtcMain={}",mInsertInfraDailyEtcMain);

        return "redirect:/";
    }

    @GetMapping ("/INFRA/delete/{boardId}")
    public String doDeleteInfraDailyCheck(@PathVariable("boardId")Long boardId, Model model){

        log.info("method=doDeleteGwDailyCheck() boardId={}",boardId);
        mainService.deleteDailyCheckBoard(boardId);
        infraService.deleteInfraDailyCheckBoard(boardId);


        return "redirect:/";
    }
}

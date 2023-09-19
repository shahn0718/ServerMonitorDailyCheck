package com.damg.upit.monitor.dailyCheck.domain.etcDaily.controller;


import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.erp.MInsertEtcDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.erp.MInsertEtcDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.service.etcDailyService;
import com.damg.upit.monitor.dailyCheck.domain.etcDaily.service.etcHrDailyService;
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
public class etcDailyController {

    private final etcDailyService etcService;
    private final mainDailyService mainService;

    public etcDailyController(etcDailyService etcService, mainDailyService mainService){
        this.etcService = etcService;
        this.mainService= mainService;
    }

    private MDailyCheckElement mDailyCheckElement;

    @GetMapping("/etcDailyCheck")
    public String homeEtcDailyCheck(Model model){
        model.addAttribute("adminUser", mainService.selectDailyCheckAdminList());
        model.addAttribute("createdTime", LocalDateTime.now());

        return "etcServer/erp/dailyChkEtcErpInput";
    }

    @PostMapping("/etcDailyCheck")
    public String doInsertEtcDailyCheck(
            @ModelAttribute("etcDailyServiceMain")MInsertEtcDailyServiceMain mInsertEtcDailyServiceMain,
            @ModelAttribute("etcDailyServerMain")MInsertEtcDailyServerMain mInsertEtcDailyServerMain,
            @RequestParam String admin_nm,
            Model model){

        Model etcDailyCheckSubmit = model.addAttribute("etcDailyCheck");
        log.info("method=doInsertEtcDailyCheck() etcDailyCheck={}",etcDailyCheckSubmit);

        String contentDate = DateTimeFormatter.ofPattern("yyyy.MM.dd").format(LocalDateTime.now());
        MSVDailyCheckAdminMain msvDailyCheckAdminMain = mainService.selectDailyCheckAdmin(admin_nm);

        MSVDailyCheckBoardMain msvDailyCheckBoardMain = new MSVDailyCheckBoardMain();

        msvDailyCheckBoardMain.setDailyMainCd(mDailyCheckElement.ETC_ERP);
        msvDailyCheckBoardMain.setDailyMainCdNm(mDailyCheckElement.ETC_ERP_CDNM);
        msvDailyCheckBoardMain.setDailyMainContent(mDailyCheckElement.ETC_ERP_KOR+" 서버 일일점검 "+"("+contentDate+")");
        msvDailyCheckBoardMain.setDailyMainWriter(msvDailyCheckAdminMain.getAdmin_nm());
        msvDailyCheckBoardMain.setDailyMainWriterNo(msvDailyCheckAdminMain.getAdmin_no());
        msvDailyCheckBoardMain.setDailyMainCreateDate(LocalDateTime.now());

        etcService.insertEtcDailyCheckMain(mInsertEtcDailyServiceMain,mInsertEtcDailyServerMain,msvDailyCheckBoardMain);

        return "redirect:/";
    }

    @GetMapping("/ERP_ETC/{boardId}")
    public String doSelectEtcDailyCheck(@PathVariable("boardId")Long etcMainId, Model model){

        List<MInsertEtcDailyServiceMain> mInsertEtcDailyServiceMain = etcService.selectEtcDailyServiceMain(etcMainId);
        List<MInsertEtcDailyServerMain> mInsertEtcDailyServerMain = etcService.selectEtcDailyServerMain(etcMainId);
        MSVDailyCheckBoardMain msvDailyCheckBoardMain = mainService.selectDailyCheckBoard(etcMainId);

        model.addAttribute("etcErpService",mInsertEtcDailyServiceMain);
        model.addAttribute("etcErpServer",mInsertEtcDailyServerMain);
        model.addAttribute("mainBoardInfo",msvDailyCheckBoardMain);

        return "etcServer/erp/dailyChkEtcErpOutput";
    }

    @GetMapping("/ERP_ETC/{boardId}/Update")
    public String getUpdateEtcDailyCheck(@PathVariable("boardId")Long etcMainId, Model model){

        List<MInsertEtcDailyServiceMain> mInsertEtcDailyServiceMain = etcService.selectEtcDailyServiceMain(etcMainId);
        List<MInsertEtcDailyServerMain> mInsertEtcDailyServerMain = etcService.selectEtcDailyServerMain(etcMainId);

        model.addAttribute("etcErpService",mInsertEtcDailyServiceMain);
        model.addAttribute("etcErpServer",mInsertEtcDailyServerMain);

        return "etcServer/erp/dailyChkEtcErpUpdate";
    }

    @PostMapping("/ERP_ETC/{boardId}/Update")
    public String doUpdateEtcDailyCheck(@PathVariable("boardId")Long etcMainId,
                                        @ModelAttribute("etcDailyServiceMain") MInsertEtcDailyServiceMain mInsertEtcDailyServiceMain,
                                        @ModelAttribute("etcDailyServerMain")MInsertEtcDailyServerMain mInsertEtcDailyServerMain){

        etcService.updateEtcDailyCheckMain(etcMainId,mInsertEtcDailyServiceMain,mInsertEtcDailyServerMain);

        log.info("method=doUpdateEtcDailyCheck() etcDailyServiceMain={}",mInsertEtcDailyServiceMain);
        log.info("method=doUpdateEtcDailyCheck() etcDailyServerMain={}",mInsertEtcDailyServerMain);

        return "redirect:/";
    }
}

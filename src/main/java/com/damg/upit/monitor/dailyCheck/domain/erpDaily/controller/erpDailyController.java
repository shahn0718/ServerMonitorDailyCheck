package com.damg.upit.monitor.dailyCheck.domain.erpDaily.controller;


import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyServerMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyServiceMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyStorageMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.MInsertErpDailyVMMain;
import com.damg.upit.monitor.dailyCheck.domain.erpDaily.service.erpDailyService;
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
public class erpDailyController {

    private final erpDailyService erpService;
    private final mainDailyService mainService;

    public erpDailyController (erpDailyService erpService, mainDailyService mainService){
        this.erpService = erpService;
        this.mainService = mainService;
    }

    private MDailyCheckElement mDailyCheckElement;

    @GetMapping("/erpDailyCheck")
    public String homeErpDailyCheck(Model model){

        model.addAttribute("adminUser", mainService.selectDailyCheckAdminList());
        model.addAttribute("createdTime", LocalDateTime.now());

        return "erpServer/dailyChkErpInput";
    }

    @PostMapping("/erpDailyCheck")
    public String doInsertErpDailyCheck(
            @ModelAttribute("erpDailyServiceMain") MInsertErpDailyServiceMain mInsertErpDailyServiceMain,
            @ModelAttribute("erpDailyServerMain") MInsertErpDailyServerMain mInsertErpDailyServerMain,
            @ModelAttribute("erpDailyStorageMain")MInsertErpDailyStorageMain mInsertErpDailyStorageMain,
            @ModelAttribute("erpDailyVMMain")MInsertErpDailyVMMain mInsertErpDailyVMMain,
            @RequestParam String admin_nm,
            Model model){

        Model erpDailyCheckSubmit = model.addAttribute("erpDailyCheck");
        log.info("method=doInsertErpDailyCheck() erpDailyCheck={}",erpDailyCheckSubmit);

        String contentDate = DateTimeFormatter.ofPattern("yyyy.MM.dd").format(LocalDateTime.now());
        MSVDailyCheckAdminMain msvDailyCheckAdminMain = mainService.selectDailyCheckAdmin(admin_nm);

        MSVDailyCheckBoardMain msvDailyCheckBoardMain = new MSVDailyCheckBoardMain();
        msvDailyCheckBoardMain.setDailyMainCd(mDailyCheckElement.ERP);
        msvDailyCheckBoardMain.setDailyMainCdNm(mDailyCheckElement.ERP_CDNM);
        msvDailyCheckBoardMain.setDailyMainContent(mDailyCheckElement.ERP_KOR+" 서버 일일점검 "+"("+contentDate+")");
        msvDailyCheckBoardMain.setDailyMainWriter(msvDailyCheckAdminMain.getAdmin_nm());
        msvDailyCheckBoardMain.setDailyMainWriterNo(msvDailyCheckAdminMain.getAdmin_no());
        msvDailyCheckBoardMain.setDailyMainCreateDate(LocalDateTime.now());

        erpService.insertErpDailyCheckMain(mInsertErpDailyServiceMain,mInsertErpDailyServerMain,
                mInsertErpDailyVMMain,mInsertErpDailyStorageMain,msvDailyCheckBoardMain);

        return "redirect:/";
    }

    @GetMapping("/ERP/{boardId}")
    public String doSelectErpDailyCheck(@PathVariable("boardId")Long erpMainId, Model model){

        List<MInsertErpDailyServiceMain> mInsertErpDailyServiceMain = erpService.selectErpDailyServiceMain(erpMainId);
        List<MInsertErpDailyServerMain> mInsertErpDailyServerMain = erpService.selectErpDailyServerMain(erpMainId);
        List<MInsertErpDailyVMMain> mInsertErpDailyVMMain = erpService.selectErpDailyVMMain(erpMainId);
        List<MInsertErpDailyStorageMain> mInsertErpDailyStorageMain = erpService.selectErpDailyStorageMain(erpMainId);
        MSVDailyCheckBoardMain msvDailyCheckBoardMain = mainService.selectDailyCheckBoard(erpMainId);

        model.addAttribute("erpService" ,mInsertErpDailyServiceMain);
        model.addAttribute("erpServer",mInsertErpDailyServerMain);
        model.addAttribute("erpVM",mInsertErpDailyVMMain);
        model.addAttribute("erpStorage",mInsertErpDailyStorageMain);
        model.addAttribute("mainBoardInfo",msvDailyCheckBoardMain);

        return "erpServer/dailyChkErpOutput";
    }

    @GetMapping("/ERP/{boardId}/Update")
    public String getUpdateErpDailyCheck(@PathVariable("boardId")Long erpMainId, Model model){

        List<MInsertErpDailyServiceMain> mInsertErpDailyServiceMain = erpService.selectErpDailyServiceMain(erpMainId);
        List<MInsertErpDailyServerMain> mInsertErpDailyServerMain = erpService.selectErpDailyServerMain(erpMainId);
        List<MInsertErpDailyVMMain> mInsertErpDailyVMMain = erpService.selectErpDailyVMMain(erpMainId);
        List<MInsertErpDailyStorageMain> mInsertErpDailyStorageMain = erpService.selectErpDailyStorageMain(erpMainId);

        model.addAttribute("erpService" ,mInsertErpDailyServiceMain);
        model.addAttribute("erpServer",mInsertErpDailyServerMain);
        model.addAttribute("erpVM",mInsertErpDailyVMMain);
        model.addAttribute("erpStorage",mInsertErpDailyStorageMain);

        return "erpServer/dailyChkErpUpdate";
    }

    @PostMapping("/ERP/{boardId}/Update")
    public String doUpdateErpDailyCheck(@PathVariable("boardId")Long erpMainId,
                                        @ModelAttribute("erpDailyServiceMain")MInsertErpDailyServiceMain mInsertErpDailyServiceMain,
                                        @ModelAttribute("erpDailyServerMain")MInsertErpDailyServerMain mInsertErpDailyServerMain,
                                        @ModelAttribute("erpDailyVMMain")MInsertErpDailyVMMain mInsertErpDailyVMMain,
                                        @ModelAttribute("erpDailyStorageMain")MInsertErpDailyStorageMain mInsertErpDailyStorageMain){

        erpService.updateErpDailyCheckMain(erpMainId,mInsertErpDailyServiceMain,
                mInsertErpDailyServerMain,mInsertErpDailyVMMain,mInsertErpDailyStorageMain);

        log.info("method=doUpdateErpDailyCheck() erpDailyServiceMain={}",mInsertErpDailyServiceMain);
        log.info("method=doUpdateErpDailyCheck() erpDailyServerMain={}",mInsertErpDailyServerMain);
        log.info("method=doUpdateErpDailyCheck() erpDailyVMMain={}",mInsertErpDailyVMMain);
        log.info("method=doUpdateErpDailyCheck() erpDailyStorageMain={}",mInsertErpDailyStorageMain);

        return "redirect:/";
    }
}

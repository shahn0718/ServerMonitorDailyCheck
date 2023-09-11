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
//    private Long erpMainId;
    private MDailyCheckElement mDailyCheckElement;

    @GetMapping("/erpDailyCheck")
    public String home(Model model){

        model.addAttribute("adminUser", mainService.selectDailyCheckAdminList());
        model.addAttribute("createdTime", LocalDateTime.now());

        return "erpServer/dailyChkErpInput";
    }

    @PostMapping("/erpDailyCheck")
    public String writeErpDailyCheck(
            @ModelAttribute("erpDailyServiceMain") MInsertErpDailyServiceMain mInsertErpDailyServiceMain,
            @ModelAttribute("erpDailyServerMain") MInsertErpDailyServerMain mInsertErpDailyServerMain,
            @ModelAttribute("erpDailyStorageMain")MInsertErpDailyStorageMain mInsertErpDailyStorageMain,
            @ModelAttribute("erpDailyVMMain")MInsertErpDailyVMMain mInsertErpDailyVMMain,
            @RequestParam String admin_nm,
            Model model){

        Model erpDailyCheckSubmit = model.addAttribute("erpDailyCheck");
        log.info("erpDailyCheck={}",erpDailyCheckSubmit);

        String contentDate = DateTimeFormatter.ofPattern("yyyy.MM.dd").format(LocalDateTime.now());
        MSVDailyCheckAdminMain msvDailyCheckAdminMain = mainService.selectDailyCheckAdmin(admin_nm);

        MSVDailyCheckBoardMain msvDailyCheckBoardMain = new MSVDailyCheckBoardMain();
        msvDailyCheckBoardMain.setDailyMainCd(mDailyCheckElement.ERP);
        msvDailyCheckBoardMain.setDailyMainCdNm(mDailyCheckElement.ERP_KOR);
        msvDailyCheckBoardMain.setDailyMainContent(mDailyCheckElement.ERP_KOR+" 서버 일일점검 "+"("+contentDate+")");
        msvDailyCheckBoardMain.setDailyMainWriter(msvDailyCheckAdminMain.getAdmin_nm());
        msvDailyCheckBoardMain.setDailyMainWriterNo(msvDailyCheckAdminMain.getAdmin_no());
        msvDailyCheckBoardMain.setDailyMainCreateDate(LocalDateTime.now());

        mainService.insertDailyCheckBoardList(msvDailyCheckBoardMain);
        Long mainBoardId = msvDailyCheckBoardMain.getDailyMainBoardId();

        mInsertErpDailyServiceMain.setErpMainId(mainBoardId);
        mInsertErpDailyServerMain.setErpMainId(mainBoardId);
        mInsertErpDailyVMMain.setErpMainId(mainBoardId);
        mInsertErpDailyStorageMain.setErpMainId(mainBoardId);

        erpService.insertErpDailyServiceMain(mInsertErpDailyServiceMain);
        erpService.insertErpDailyServerMain(mInsertErpDailyServerMain);
        erpService.insertErpDailyVMMain(mInsertErpDailyVMMain);
        erpService.insertErpDailyStorageMain(mInsertErpDailyStorageMain);

        return "redirect:/";
    }

    @GetMapping("/ERP/{boardId}")
    public String getErpDailyCheck(@PathVariable("boardId")Long erpMainId, Model model){

        List<MInsertErpDailyServiceMain> mInsertErpDailyServiceMain = erpService.selectErpDailyServiceMain(erpMainId);
        List<MInsertErpDailyServerMain> mInsertErpDailyServerMain = erpService.selectErpDailyServerMain(erpMainId);
        List<MInsertErpDailyVMMain> mInsertErpDailyVMMain = erpService.selectErpDailyVMMain(erpMainId);
        List<MInsertErpDailyStorageMain> mInsertErpDailyStorageMain = erpService.selectErpDailyStorageMain(erpMainId);

        model.addAttribute("erpService" ,mInsertErpDailyServiceMain);
        model.addAttribute("erpServer",mInsertErpDailyServerMain);
        model.addAttribute("erpVM",mInsertErpDailyVMMain);
        model.addAttribute("erpStorage",mInsertErpDailyStorageMain);

        return "erpServer/dailyChkErpOutput";
    }
}

package com.damg.upit.monitor.dailyCheck.domain.mainDaily.controller;


import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckBoardMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.service.mainDailyService;
import com.damg.upit.monitor.dailyCheck.domain.mainPaging.model.MDailyBoardPaginationMain;
import com.damg.upit.monitor.dailyCheck.domain.mainPaging.model.MDailyBoardPagingMain;
import com.damg.upit.monitor.dailyCheck.domain.mainPaging.service.mainPagingService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
public class mainDailyController {

    private final mainDailyService mainService;

    private final mainPagingService pagingService;

    public mainDailyController(mainDailyService mainService, mainPagingService pagingService){
        this.mainService = mainService;
        this.pagingService = pagingService;
    }

    @GetMapping("/")
    public String homeMainDailyBoard(MDailyBoardPagingMain mDailyBoardPagingMain,
                                     Model model) {

        List<MSVDailyCheckBoardMain> mainDailyBoardList = pagingService.getPageList(mDailyBoardPagingMain);
        model.addAttribute("mainDailyBoardList", mainDailyBoardList);

        MDailyBoardPaginationMain mDailyBoardPaginationMain = new MDailyBoardPaginationMain(pagingService.getBoardTotalList(), 10, mDailyBoardPagingMain);
        model.addAttribute("pageMaker",mDailyBoardPaginationMain);


        log.info("method=homeMainDailyBoard(), mainDailyBoardList={}", mainDailyBoardList);
        log.info("method=homeMainDailyBoard(), pageMaker={}", mDailyBoardPaginationMain);


        return "mainBoard";
    }

    @GetMapping("board")
    public String homeMainDailyBoardGetPage(@RequestParam("page")Integer pageNum,
                                            MDailyBoardPagingMain mDailyBoardPagingMain,
                                            Model model){

        mDailyBoardPagingMain.setPageNum(pageNum);
        List<MSVDailyCheckBoardMain> mainDailyBoardListWithPaging = pagingService.getPageList(mDailyBoardPagingMain);
        model.addAttribute("mainDailyBoardList", mainDailyBoardListWithPaging);
        MDailyBoardPaginationMain mDailyBoardPaginationMain = new MDailyBoardPaginationMain(pagingService.getBoardTotalList(), 10, mDailyBoardPagingMain);
        model.addAttribute("pageMaker",mDailyBoardPaginationMain);

        log.info("method=homeMainDailyBoardGetPage(), mainDailyBoardList={}", mainDailyBoardListWithPaging);
        log.info("method=homeMainDailyBoardGetPage(), pageMaker={}", mDailyBoardPaginationMain);

        return "mainBoard";
    }
}


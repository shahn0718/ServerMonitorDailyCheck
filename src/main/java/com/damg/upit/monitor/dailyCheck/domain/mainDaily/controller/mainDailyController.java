package com.damg.upit.monitor.dailyCheck.domain.mainDaily.controller;


import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckBoardMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.service.mainDailyService;
import com.damg.upit.monitor.dailyCheck.domain.mainPaging.model.MDailyBoardPaginationMain;
import com.damg.upit.monitor.dailyCheck.domain.mainPaging.model.MDailyBoardPagingMain;
import com.damg.upit.monitor.dailyCheck.domain.mainPaging.service.mainPagingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

        /**
         * 기존에 존재하던 페이지 작업 형식
         */
//        Model mainDailyBoardList = model.addAttribute("mainDailyBoardList", mainService.selectDailyCheckBoardList());
//        log.info("mainDailyBoardList= {}", mainDailyBoardList);

        System.out.println("mDailyBoardPagingMain#### = " + mDailyBoardPagingMain.getPageNum());
        System.out.println("mDailyBoardPagingMain##### = " + mDailyBoardPagingMain.getPageAmount());

        List<MSVDailyCheckBoardMain> mainDailyBoardListWithPaging = pagingService.getPageList(mDailyBoardPagingMain);
        model.addAttribute("mainDailyBoardList", mainDailyBoardListWithPaging);

        MDailyBoardPaginationMain mDailyBoardPaginationMain = new MDailyBoardPaginationMain(pagingService.getBoardTotalList(), 10, mDailyBoardPagingMain);
        model.addAttribute("pageMaker",mDailyBoardPaginationMain);

        model.addAttribute("list",mDailyBoardPagingMain);

        log.info("getPagingList={}", mainDailyBoardListWithPaging);
        log.info("pagingService.getBoardTotalList()={}",pagingService.getBoardTotalList());
        log.info("=========================");
        log.info("List");
        log.info("mainDailyBoardList= {}", mainDailyBoardListWithPaging);
        log.info("getPagingList={}", mDailyBoardPaginationMain);
        log.info("=========================");

        return "mainBoard";
    }

    @GetMapping("/{num}")
    public String homeMainDailyBoardGetPage(@PathVariable("num")int pageNum,
                                            MDailyBoardPagingMain mDailyBoardPagingMain,
                                            Model model){

        mDailyBoardPagingMain.setPageNum(pageNum);
        System.out.println("mDailyBoardPagingMain #####= " + mDailyBoardPagingMain.getPageNum());
        List<MSVDailyCheckBoardMain> mainDailyBoardListWithPaging = pagingService.getPageList(mDailyBoardPagingMain);
        model.addAttribute("mainDailyBoardList", mainDailyBoardListWithPaging);
        MDailyBoardPaginationMain mDailyBoardPaginationMain = new MDailyBoardPaginationMain(pagingService.getBoardTotalList(), 10, mDailyBoardPagingMain);
        model.addAttribute("pageMaker",mDailyBoardPaginationMain);

        return "mainBoard";
    }
}

    /**
     *   // 게시글 리스트 페이지
     *     @GetMapping("/post/list.do")
     *     public String openPostList(@ModelAttribute("params") final SearchDto params, Model model) {
     *         PagingResponse<PostResponse> response = postService.findAllPost(params);
     *         model.addAttribute("response", response);
     *         return "post/list";
     *     }
     *
     */

package com.damg.upit.monitor.dailyCheck.domain.mainDaily.controller;


import com.damg.upit.monitor.dailyCheck.domain.mainDaily.model.MSVDailyCheckBoardMain;
import com.damg.upit.monitor.dailyCheck.domain.mainDaily.service.mainDailyService;
import com.damg.upit.monitor.dailyCheck.domain.mainPaging.model.MDailyBoardPagingMain;
import com.damg.upit.monitor.dailyCheck.domain.mainPaging.model.MDailyBoardPagingResponse;
import com.damg.upit.monitor.dailyCheck.domain.mainPaging.service.mainPagingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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

        Model mainDailyBoardList = model.addAttribute("mainDailyBoardList", mainService.selectDailyCheckBoardList());
        log.info("mainDailyBoardList= {}", mainDailyBoardList);

        List<MSVDailyCheckBoardMain> getPagingList = pagingService.getPageList(mDailyBoardPagingMain);
        model.addAttribute("getPagingList", getPagingList);

        /**
         * 여기서부터
         */

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

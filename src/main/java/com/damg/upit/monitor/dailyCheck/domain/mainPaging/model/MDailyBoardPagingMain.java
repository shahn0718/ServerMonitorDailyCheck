package com.damg.upit.monitor.dailyCheck.domain.mainPaging.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MDailyBoardPagingMain {
    /**
     *  현재 페이지  int (pageNum)
     *
     *  페이지당 출력할 갯수  int (pageAmount)
     *
     *  화면 하단에 출력할 페이지의 크기 int (pageDataCnt) -> 변수 이름 고민 더 해보기
     *
     */
    private int pageNum;

    //***
    private int pageCal;
    private int pageAmount;
    private MDailyBoardPaginationMain pagination;

    public MDailyBoardPagingMain(){
        this.pageNum = 1;
        this.pageCal = 1;
        this.pageAmount = 10;
    }
    public MDailyBoardPagingMain(int pageNum, int pageAmount){
        this.pageNum = pageNum;
        this.pageAmount = pageAmount;
    }
}

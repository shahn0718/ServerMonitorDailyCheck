package com.damg.upit.monitor.dailyCheck.domain.mainPaging.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MDailyBoardPaginationMain {

    /**
     *  <페이지 네이션>
     *          1 2 3 4 5 6 7 8 9 10 다음
     *  이전    11 12 13 14 15 ...
     *
     *  1. 화면 하단에 출력할 페이지의 사이즈를 의미 (pageCount)
     *  2. 전체페이지
     *  3. 첫페이지
     *  4. 끝페이지
     *  5. Limit 시작위치**
     *  6. 이전페이지 존재여부
     *  7. 다음페이지 존재여부
     *
     */

    private int pageCount;
    private int startPage;
    private int endPage;
    private int finalPage;
    private boolean existPrevPageChk;
    private boolean existNextPageChk;
    private int total;
    public MDailyBoardPagingMain mDailyBoardPagingMain;

    public MDailyBoardPaginationMain(){}

    public MDailyBoardPaginationMain(int total, int pageCount, MDailyBoardPagingMain mDailyBoardPagingMain){

        this.total = total;
        this.mDailyBoardPagingMain = mDailyBoardPagingMain;
        this.pageCount = pageCount;

        this.endPage = (int)(Math.ceil(mDailyBoardPagingMain.getPageNum()*1.0/pageCount))*pageCount;
        System.out.println("endPage= " + endPage);
        //endPage = 10;

        this.startPage = endPage- (pageCount-1);
        //pageCount -1 = 10 -1 = 9;
        //startPage = 1;
        System.out.println("startPage = " + startPage);


        finalPage = (int)(Math.ceil(total*1.0/mDailyBoardPagingMain.getPageAmount()));
        System.out.println("finalPage = " + finalPage);

        //finalPage = 2;
        if(endPage>finalPage){
            endPage = finalPage == 0 ? 1 : finalPage;
        }

        existPrevPageChk = startPage > 1;
        System.out.println("existPrevPageChk = " + existPrevPageChk);
        existNextPageChk = endPage < finalPage;
        System.out.println("existNextPageChk = " + existNextPageChk);
    }
}

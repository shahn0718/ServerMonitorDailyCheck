package com.damg.upit.monitor.dailyCheck.domain.mainPaging.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MDailyBoardPagnationMain {

    /**
     *  <페이지 네이션>
     *          1 2 3 4 5 6 7 8 9 10 다음
     *  이전    11 12 13 14 15 ...
     *
     *  1. 전체데이터
     *  2. 전체페이지
     *  3. 첫페이지
     *  4. 끝페이지
     *  5. Limit 시작위치**
     *  6. 이전페이지 존재여부
     *  7. 다음페이지 존재여부
     *
     */

    private int totalBoardListCnt;
    private int totalPageCnt;
    private int startPageNum;
    private int endPageNum;
    private int startLimitNum;
    private boolean existPrevPageChk;
    private boolean existNextPageChk;

    public MDailyBoardPagnationMain(int totalBoardListCnt, MDailyBoardPagingMain mDailyBoardPagingMain){
        if(totalBoardListCnt > 0){
            this.totalBoardListCnt = totalBoardListCnt;

        }
    }

    public void calPagnationInfo(MDailyBoardPagingMain mDailyBoardPagingMain){

        //전체 페이지 수 계산 =  ( (전체페이지수 - 1 ) /  페이지당 출력할 갯수 ) + 1 ;
        totalPageCnt = ((totalBoardListCnt - 1 ) / mDailyBoardPagingMain.getPerPageDataCnt()) + 1;

        //현재 페이지 번호가 전체페이지 수보다 큰 경우, 현재페이지 번호에 전체페이지 수 저장
        if(mDailyBoardPagingMain.getCurrentPage() > totalPageCnt) mDailyBoardPagingMain.setCurrentPage(totalPageCnt);

        // 첫 페이지 번호 계산
        startPageNum = ((mDailyBoardPagingMain.getCurrentPage() -1 ) / mDailyBoardPagingMain.getPageDataCnt()) * mDailyBoardPagingMain.getPerPageDataCnt() + 1;

        // 끝 페이지 번호 계산
        endPageNum = startPageNum + mDailyBoardPagingMain.getPageDataCnt() - 1;

        // 끝 페이지가 전체 페이지 수보다 큰 경우, 끝 페이지 전체 페이지 수 저장
        if (endPageNum > totalPageCnt){
            endPageNum = totalPageCnt;
        }

        // Limit 시작위치 계산
        startLimitNum = (mDailyBoardPagingMain.getCurrentPage() - 1) * mDailyBoardPagingMain.getPerPageDataCnt();

        // 이전 페이지 존재 여부 확인
        existPrevPageChk = startPageNum != 1;

        // 다음 페이지 존재 여부 확인
        existNextPageChk = (endPageNum * mDailyBoardPagingMain.getPerPageDataCnt() < totalPageCnt);
    }
}

package com.damg.upit.monitor.dailyCheck.domain.mainPaging.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MDailyBoardPagingMain {


    /**
     *  현재 페이지  int (currentPage)
     *
     *  페이지당 출력할 갯수  int (perPageDataCnt)
     *
     *  화면 하단에 출력할 페이지의 크기 int (pageDataCnt) -> 변수 이름 고민 더 해보기
     *
     */

    private int currentPage;
    private int perPageDataCnt;
    private int pageDataCnt;

    public MDailyBoardPagingMain(){
        this.currentPage = 1;
        this.perPageDataCnt = 20;
        this.pageDataCnt = 10;
    }

    /**
     * SQL Query 에서 LIMIT 의 기능을 사용하기 위해 설정
     * @return
     */
    public int boardPagingLimit() {
        return (currentPage - 1 ) * perPageDataCnt;
    }

}

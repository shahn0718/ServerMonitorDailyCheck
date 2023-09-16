package com.damg.upit.monitor.dailyCheck.domain.mainPaging.model;


import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MDailyBoardPagingResponse<T> {

     private List<T> responseList= new ArrayList<>();
     private MDailyBoardPagnationMain pagination;

     public MDailyBoardPagingResponse(List<T> responseList, MDailyBoardPagnationMain pagination){
         this.responseList.addAll(responseList);
         this.pagination = pagination;
     }
}

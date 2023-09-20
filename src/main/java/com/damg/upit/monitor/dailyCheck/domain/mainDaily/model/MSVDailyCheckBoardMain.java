package com.damg.upit.monitor.dailyCheck.domain.mainDaily.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
public class MSVDailyCheckBoardMain {

    private int dailyMainBoardNum;
    private Long dailyMainId;
    private Long dailyMainBoardId;

    private String dailyMainCd;
    private String dailyMainCdNm;
    private String dailyMainContent;
    private String dailyMainWriter;
    private String dailyMainWriterNo;
    private int dailyMainViewCnt;
    private LocalDateTime dailyMainCreateDate;
    private LocalDateTime dailyMainModDate;

}

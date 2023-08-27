package com.damg.upit.monitor.dailyCheck.domain.admin.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
public class MSVMonitorDailyCheckMain {

    private Long dailyChkId;
    private String dailyChkTitle;
    private String dailyChkContent;
    private String dailyChkWriter;
    private int dailyChkViewCnt;
    private LocalDateTime dailyChkCreateDate;
    private LocalDateTime dailyChkModDate;
}

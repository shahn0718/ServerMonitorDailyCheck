package com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.param;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class PInsertSmsElement {

    private String trSendDate;
    private String trSendStat;
    private String trMsgType;
    private String trPhone;
    private String trCallBack;
    private String trMsg;
    private String trEtc3;

}

package com.damg.upit.monitor.dailyCheck.domain.erpDaily.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MInsertErpDailyServiceMain {

    private long erpServiceId;
    private long erpMainId;

    //MailService 메일서비스
    private String erpMailServiceChk;
    private String erpMailServiceBigo;

    //ApproveService 결재서비스
    private String erpApproveServiceChk;
    private String erpApproveServiceBigo;

    //BackupService 백업서비스
    private String erpBackUpServiceChk;
    private String erpBackUpServiceBigo;
}

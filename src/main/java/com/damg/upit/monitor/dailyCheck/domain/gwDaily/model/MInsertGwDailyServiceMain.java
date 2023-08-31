package com.damg.upit.monitor.dailyCheck.domain.gwDaily.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MInsertGwDailyServiceMain {

    private Long gwServiceId;
    private Long gwMainId;

    //MailService 메일서비스
    private String gwMailServiceChk;
    private String gwMailServiceBigo;

    //ApproveService 결재서비스
    private String gwApproveServiceChk;
    private String gwApproveServiceBigo;

    //BackupService 백업서비스
    private String gwBackUpServiceChk;
    private String gwBackUpServiceBigo;





}

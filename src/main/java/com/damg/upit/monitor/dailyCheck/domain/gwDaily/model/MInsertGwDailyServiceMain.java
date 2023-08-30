package com.damg.upit.monitor.dailyCheck.domain.gwDaily.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MInsertGwDailyServiceMain {

    /**
     * GW 서비스 메일, 전자결재, 백업 (이상유무, 비고)
     */

    private long gwServiceId;
    private long gwMainId;

    //MailService
    private String gwMailServiceChk;
    private String gwMailServiceBigo;

    //ApprovService
    private String gwApproveServiceChk;
    private String gwApproveServiceBigo;

    //BackupService
    private String gwBackUpServiceChk;
    private String gwBackUpServiceBigo;





}

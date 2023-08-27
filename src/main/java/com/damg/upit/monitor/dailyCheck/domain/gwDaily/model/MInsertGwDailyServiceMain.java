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

    //MailService
    public String gwMailServiceChk;
    public String gwMailServiceBigo;

    //ApprovService
    public String gwApproveServiceChk;
    public String gwApproveServiceBigo;

    //BackupService
    public String gwBackupServiceChk;
    public String gwBackupServiceBigo;





}

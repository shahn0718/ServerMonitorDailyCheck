package com.damg.upit.monitor.dailyCheck.domain.erpDaily.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MInsertErpDailyServiceMain {

    /**
     *         <td>서비스</td>
     *         <td>
     *           <p></p>
     *           <p></p>
     *           <p>백업</p>
     *         </td>
     *         <td>
     *           <p>-</p>
     *           <p>-</p>
     *           <p> </p>
     *         </td>
     *         <td>
     *           <p></p>
     *           <p></p>
     *           <p>백업스케쥴</p>
     *          2023.9 월 기준 현재 백업관련 스케쥴만 존재.
     */

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

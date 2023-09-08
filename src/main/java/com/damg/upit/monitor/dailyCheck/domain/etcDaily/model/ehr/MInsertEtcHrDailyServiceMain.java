package com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.ehr;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MInsertEtcHrDailyServiceMain {
    /**
     *           <td>서비스</td>
     *           <td>
     *             <p></p>
     *             <p></p>
     *             <p>백업</p>
     *           </td>
     *           <td>
     *             <p>-</p>
     *             <p>-</p>
     *             <p> </p>
     *           </td>
     *           <td>
     *             <p></p>
     *             <p></p>
     *             <p>백업스케쥴</p>
     *            2023.9월 기준 백업스케쥴 사용
     */

    private long etcHrServiceId;
    private long etcHRMainId;

    //MailService 메일서비스
    private String etcHrMailServiceChk;
    private String etcHrMailServiceBigo;

    //ApproveService 결재서비스
    private String etcHrApproveServiceChk;
    private String etcHrApproveServiceBigo;

    //BackupService 백업서비스
    private String etcHrBackUpServiceChk;
    private String etcHrBackUpServiceBigo;
}

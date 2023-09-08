package com.damg.upit.monitor.dailyCheck.domain.etcDaily.model.erp;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MInsertEtcDailyServiceMain {

    private long etcServiceId;
    private long etcMainId;
    /**
     *     <td>서비스</td>
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
     *          2023.9월 기준 백업 관련 서비스만 등록
     */

    //MailService 메일서비스
    private String etcMailServiceChk;
    private String etcMailServiceBigo;

    //ApproveService 결재서비스
    private String etcApproveServiceChk;
    private String etcApproveServiceBigo;

    //BackupService 백업서비스
    private String etcBackUpServiceChk;
    private String etcBackUpServiceBigo;
}

package com.damg.upit.monitor.dailyCheck.domain.gwDaily.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MInsertGwDailyServiceMain {

    private Long gwServiceId;
    private Long gwMainId;

    /**
     *           <p>메일</p>
     *           <p>전자결재</p>
     *           <p>백업</p>
     *           <p>인물정보</p>
     *         </td>
     *         <td>
     *           <p>-</p>
     *           <p>-</p>
     *           <p>-</p>
     *            <p>-</p>
     *         </td>
     *         <td>
     *           <p>송수신</p>
     *           <p>리스트확인</p>
     *           <p>백업스케쥴</p>
     *           <p>리스트확인</p>
     */

    //MailService 메일서비스
    private String gwMailServiceChk;
    private String gwMailServiceBigo;

    //ApproveService 결재서비스
    private String gwApproveServiceChk;
    private String gwApproveServiceBigo;

    //BackupService 백업서비스
    private String gwBackUpServiceChk;
    private String gwBackUpServiceBigo;

    //InmulService 인물정보서비스
    private String gwInmulServiceChk;
    private String gwInmulServiceBigo;





}

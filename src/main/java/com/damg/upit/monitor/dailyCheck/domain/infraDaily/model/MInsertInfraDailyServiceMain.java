package com.damg.upit.monitor.dailyCheck.domain.infraDaily.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MInsertInfraDailyServiceMain {

    private Long infraServiceId;
    private Long infraMainId;

    /**
     *           <td>서비스</td>
     *           <td>
     *             <p>백업</p>
     *             <p>스팸 솔루션</p>
     *             <p>메일</p>
     *             <p>DNS</p>
     *           </td>
     */

    //BackUpService 백업서비스
    private String infraBackUpServiceChk;
    private String infraBackUpServiceBigo;

    //Spam 스팸솔루션
    private String infraSpamServiceChk;
    private String infraSpamServiceBigo;

    //MailService 메일서비스
    private String infraMailServiceChk;
    private String infraMailServiceBigo;

    //DNS DNS서비스
    private String infraDNSServiceChk;
    private String infraDNSServiceBigo;
}

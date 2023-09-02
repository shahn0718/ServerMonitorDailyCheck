package com.damg.upit.monitor.dailyCheck.domain.infraDaily.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MInsertInfraDailyEtcMain {

    private Long infraEtcId;
    private Long infraMainId;

    /**
     *             <td rowspan="12">보안 및 기타 솔루션</td>
     *             <td>VPN-1</td>
     *             <td>-</td>
     *             <td>
     *               <p>클러스터</p>
     *               <p>이벤트 로그</p>
     */

    private String vpn1ClustChk;
    private String vpn1ClustBigo;
    private String vpn1EventChk;
    private String vpn1EventBigo;

    /**
     *             <td>VPN-2</td>
     *             <td>-</td>
     *             <td>
     *               <p>클러스터</p>
     *               <p>이벤트 로그</p>
     */

    private String vpn2ClustChk;
    private String vpn2ClustBigo;
    private String vpn2EventChk;
    private String vpn2EventBigo;

    /**
     *             <td>SSO-1</td>
     *             <td>-</td>
     *             <td>
     *               <p>클러스터</p>
     *               <p>이벤트 로그</p>
     */

    private String sso1ClustChk;
    private String sso1ClustBigo;
    private String sso1EventChk;
    private String sso1EventBigo;

    /**
     *             <td>SSO-2</td>
     *             <td>-</td>
     *             <td>
     *               <p>클러스터</p>
     *               <p>이벤트 로그</p>
     */

    private String sso2ClustChk;
    private String sso2ClustBigo;
    private String sso2EventChk;
    private String sso2EventBigo;

    /**
     *             <td>DDoS-1</td>
     *             <td>-</td>
     *             <td>
     *               <p>클러스터</p>
     *               <p>이벤트 로그</p>
     */

    private String ddos1ClustChk;
    private String ddos1ClustBigo;
    private String ddos1EventChk;
    private String ddos1EventBigo;

    /**
     *             <td>DDoS-2</td>
     *             <td>-</td>
     *             <td>
     *               <p>클러스터</p>
     *               <p>이벤트 로그</p>
     */

    private String ddos2ClustChk;
    private String ddos2ClustBigo;
    private String ddos2EventChk;
    private String ddos2EventBigo;

    /**
     *             <td>FW-1</td>
     *             <td>-</td>
     *             <td>
     *               <p>클러스터</p>
     *               <p>이벤트 로그</p>
     */

    private String fw1ClustChk;
    private String fw1ClustBigo;
    private String fw1EventChk;
    private String fw1EventBigo;

    /**
     *             <td>FW-2</td>
     *             <td>-</td>
     *             <td>
     *               <p>클러스터</p>
     *               <p>이벤트 로그</p>
     */

    private String fw2ClustChk;
    private String fw2ClustBigo;
    private String fw2EventChk;
    private String fw2EventBigo;


    /**
     *             <td>SPAM-1</td>
     *             <td>-</td>
     *             <td>
     *               <p>클러스터</p>
     *               <p>이벤트 로그</p>
     */

    private String spam1ClustChk;
    private String spam1ClustBigo;
    private String spam1EventChk;
    private String spam1EventBigo;

    /**
     *             <td>SPAM-2</td>
     *             <td>-</td>
     *             <td>
     *               <p>클러스터</p>
     *               <p>이벤트 로그</p>
     */

    private String spam2ClustChk;
    private String spam2ClustBigo;
    private String spam2EventChk;
    private String spam2EventBigo;

    /**
     *             <td>지니어스모니터링</td>
     *             <td>-</td>
     *             <td>
     *               <p>클러스터</p>
     *               <p>이벤트 로그</p>
     */

    private String gMonitorClustChk;
    private String gMonitorClustBigo;
    private String gMonitorEventChk;
    private String gMonitorEventBigo;

    /**
     *             <td>ERP모니터링</td>
     *             <td>-</td>
     *             <td>
     *               <p>클러스터</p>
     *               <p>이벤트 로그</p>
     */

    private String eMonitorClustChk;
    private String eMonitorClustBigo;
    private String eMonitorEventChk;
    private String eMonitorEventBigo;

}

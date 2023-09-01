package com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.etc;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MInsertEtcHRDailyServerMain {

    private long etcHrServerId;
    private long etcMainId;


    /**
     *           <td rowspan="4">서버</td>
     *           <td>CHA-EHR-DB</td>
     *           <td>윈도우</td>
     *           <td>
     *             <p>CPU 사용량</p>
     *             <p>메모리 사용량</p>
     *             <p>디스크 사용량</p>
     *             <p>이벤트 로그</p>
     */

    private String chaEhrDbCpuUsageChk;
    private String chaEhrDbCpuUsageBigo;
    private String chaEhrDbMemUsageChk;
    private String chaEhrDbMemUsageBigo;
    private String chaEhrDbDiskUsageChk;
    private String chaEhrDbDiskUsageBigo;
    private String chaEhrDbEventChk;
    private String chaEhrDbEventBigo;

    /**
     *             <td>CHA-EHR-WEB</td>
     *             <td>윈도우</td>
     *             <td>
     *               <p>CPU 사용량</p>
     *               <p>메모리 사용량</p>
     *               <p>디스크 사용량</p>
     *               <p>이벤트 로그</p>
     *             </td>
     *             <td>
     */

    private String chaEhrWebCpuUsageChk;
    private String chaEhrWebCpuUsageBigo;
    private String chaEhrWebMemUsageChk;
    private String chaEhrWebMemUsageBigo;
    private String chaEhrWebDiskUsageChk;
    private String chaEhrWebDiskUsageBigo;
    private String chaEhrWebEventChk;
    private String chaEhrWebEventBigo;

    /**
     *             <td>CHA-EHR-DEV</td>
     *             <td>윈도우</td>
     *             <td>
     *               <p>CPU 사용량</p>
     *               <p>메모리 사용량</p>
     *               <p>디스크 사용량</p>
     *               <p>이벤트 로그</p>
     */

    private String chaEhrDevCpuUsageChk;
    private String chaEhrDevCpuUsageBigo;
    private String chaEhrDevMemUsageChk;
    private String chaEhrDevMemUsageBigo;
    private String chaEhrDevDiskUsageChk;
    private String chaEhrDevDiskUsageBigo;
    private String chaEhrDevEventChk;
    private String chaEhrDevEventBigo;

    /**
     *             <td>DDC-EHR-WEB</td>
     *             <td>윈도우</td>
     *             <td>
     *               <p>CPU 사용량</p>
     *               <p>메모리 사용량</p>
     *               <p>디스크 사용량</p>
     *               <p>이벤트 로그</p>
     *             </td>
     */

    private String ddcEhrWebCpuUsageChk;
    private String ddcEhrWebCpuUsageBigo;
    private String ddcEhrWebMemUsageChk;
    private String ddcEhrWebMemUsageBigo;
    private String ddcEhrWebDiskUsageChk;
    private String ddcEhrWebDiskUsageBigo;
    private String ddcEhrWebEventChk;
    private String ddcEhrWebEventBigo;

}

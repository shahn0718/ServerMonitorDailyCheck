package com.damg.upit.monitor.dailyCheck.domain.erpDaily.model.etc;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MInsertEtcErpDailyServerMain {

    private long etcErpServerId;
    private long etcMainId;

    /**
     *           <td>서버</td>
     *           <td>CHA-ERP-LINK</td>
     *           <td>윈도우</td>
     *           <td>
     *             <p>CPU 사용량</p>
     *             <p>메모리 사용량</p>
     *             <p>디스크 사용량</p>
     *             <p>이벤트 로그</p>
     */

    private String chaErpLinkCpuUsageChk;
    private String chaErpLinkCpuUsageBigo;
    private String chaErpLinkMemUsageChk;
    private String chaErpLinkMemUsageBigo;
    private String chaErpLinkDiskUsageChk;
    private String chaErpLinkDiskUsageBigo;
    private String chaErpLinkEventChk;
    private String chaErpLinkEventBigo;

    /**
     *             <td>CHA-ERP-APP-1</td>
     *             <td>윈도우</td>
     *             <td>
     *               <p>CPU 사용량</p>
     *               <p>메모리 사용량</p>
     *               <p>디스크 사용량</p>
     *               <p>이벤트 로그</p>
     */

    private String chaErpApp1CpuUsageChk;
    private String chaErpApp1CpuUsageBigo;
    private String chaErpApp1MemUsageChk;
    private String chaErpApp1MemUsageBigo;
    private String chaErpApp1DiskUsageChk;
    private String chaErpApp1DiskUsageBigo;
    private String chaErpApp1EventChk;
    private String chaErpApp1EventBigo;

    /**
     *             <td>CHA-ERP-APP2</td>
     *             <td>윈도우</td>
     *             <td>
     *               <p>CPU 사용량</p>
     *               <p>메모리 사용량</p>
     *               <p>디스크 사용량</p>
     *               <p>이벤트 로그</p>
     *             </td>
     */

    private String chaErpApp2CpuUsageChk;
    private String chaErpApp2CpuUsageBigo;
    private String chaErpApp2MemUsageChk;
    private String chaErpApp2MemUsageBigo;
    private String chaErpApp2DiskUsageChk;
    private String chaErpApp2DiskUsageBigo;
    private String chaErpApp2EventChk;
    private String chaErpApp2EventBigo;

    /**
     *   <td>CHA-ERP-DB-1</td>
     *             <td>윈도우</td>
     *             <td>
     *               <p>CPU 사용량</p>
     *               <p>메모리 사용량</p>
     *               <p>디스크 사용량</p>
     *               <p>이벤트 로그</p>
     */
    private String chaErpDb1CpuUsageChk;
    private String chaErpDb1CpuUsageBigo;
    private String chaErpDb1MemUsageChk;
    private String chaErpDb1MemUsageBigo;
    private String chaErpDb1DiskUsageChk;
    private String chaErpDb1DiskUsageBigo;
    private String chaErpDb1DiskEventChk;
    private String chaErpDb1DiskEventBigo;

    /**
     *    <td>CHA-ERP-DB-2</td>
     *             <td>윈도우</td>
     *             <td>
     *               <p>CPU 사용량</p>
     *               <p>메모리 사용량</p>
     *               <p>디스크 사용량</p>
     *               <p>이벤트 로그</p>
     */
    private String chaErpDb2CpuUsageChk;
    private String chaErpDb2CpuUsageBigo;
    private String chaErpDb2MemUsageChk;
    private String chaErpDb2MemUsageBigo;
    private String chaErpDb2DiskUsageChk;
    private String chaErpDb2DiskUsageBigo;
    private String chaErpDb2DiskEventChk;
    private String chaErpDb2DiskEventBigo;

    /**
     *             <td>CHA-ERP-DEV</td>
     *             <td>윈도우</td>
     *             <td>
     *               <p>CPU 사용량</p>
     *               <p>메모리 사용량</p>
     *               <p>디스크 사용량</p>
     *               <p>이벤트 로그</p>
     */
    private String chaErpDevCpuUsageChk;
    private String chaErpDevCpuUsageBigo;
    private String chaErpDevMemUsageChk;
    private String chaErpDevMemUsageBigo;
    private String chaErpDevDiskUsageChk;
    private String chaErpDevDiskUsageBigo;
    private String chaErpDevEventChk;
    private String chaErpDevEventBigo;

    /**
     *              <td>DDC-ETI</td>
     *             <td>윈도우</td>
     *             <td>
     *               <p>CPU 사용량</p>
     *               <p>메모리 사용량</p>
     *               <p>디스크 사용량</p>
     *               <p>이벤트 로그</p>
     */

    private String ddcEtiCpuUsageChk;
    private String ddcEtiCpuUsageBigo;
    private String ddcEtiMemUsageChk;
    private String ddcEtiMemUsageBigo;
    private String ddcEtiDiskUsageChk;
    private String ddcEtiDiskUsageBigo;
    private String ddcEtiEventChk;
    private String ddcEtiEventBigo;

    /**
     *             <td>DDC-MIS-APP</td>
     *             <td>윈도우</td>
     *             <td>
     *               <p>CPU 사용량</p>
     *               <p>메모리 사용량</p>
     *               <p>디스크 사용량</p>
     *               <p>이벤트 로그</p>
     */

    private String ddcMisAppCpuUsageChk;
    private String ddcMisAppCpuUsageBigo;
    private String ddcMisAppMemUsageChk;
    private String ddcMisAppMemUsageBigo;
    private String ddcMisAppDiskUsageChk;
    private String ddcMisAppDiskUsageBigo;
    private String ddcMisAppEventChk;
    private String ddcMisAppEventBigo;

    /**
     *             <td>DDC-ERP-DB</td>
     *             <td>윈도우</td>
     *             <td>
     *               <p>CPU 사용량</p>
     *               <p>메모리 사용량</p>
     *               <p>디스크 사용량</p>
     *               <p>이벤트 로그</p>
     */

    private String ddcErpDbCpuUsageChk;
    private String ddcErpDbCpuUsageBigo;
    private String ddcErpDbMemUsageChk;
    private String ddcErpDbMemUsageBigo;
    private String ddcErpDbDiskUsageChk;
    private String ddcErpDbDiskUsageBigo;
    private String ddcErpDbEventChk;
    private String ddcErpDbEventBigo;

    /**
     *             <td>DKF-1</td>
     *             <td>윈도우</td>
     *             <td>
     *               <p>CPU 사용량</p>
     *               <p>메모리 사용량</p>
     *               <p>디스크 사용량</p>
     *               <p>이벤트 로그</p>
     */
    private String dkf1CpuUsageChk;
    private String dkf1CpuUsageBigo;
    private String dkf1MemUsageChk;
    private String dkf1MemUsageBigo;
    private String dkf1DiskUsageChk;
    private String dkf1DiskUsageBigo;
    private String dkf1EventChk;
    private String dkf1EventBigo;
    /**
     *             <td>DKF-2</td>
     *             <td>윈도우</td>
     *             <td>
     *               <p>CPU 사용량</p>
     *               <p>메모리 사용량</p>
     *               <p>디스크 사용량</p>
     *               <p>이벤트 로그</p>
     */
    private String dkf2CpuUsageChk;
    private String dkf2CpuUsageBigo;
    private String dkf2MemUsageChk;
    private String dkf2MemUsageBigo;
    private String dkf2DiskUsageChk;
    private String dkf2DiskUsageBigo;
    private String dkf2EventChk;
    private String dkf2EventBigo;

    /**
     *             <td>DongaBill</td>
     *             <td>윈도우</td>
     *             <td>
     *               <p>CPU 사용량</p>
     *               <p>메모리 사용량</p>
     *               <p>디스크 사용량</p>
     *               <p>이벤트 로그</p>
     */
    private String dongaBCpuUsageChk;
    private String dongaBCpuUsageBigo;
    private String dongaBMemUsageChk;
    private String dongaBMemUsageBigo;
    private String dongaBDiskUsageChk;
    private String dongaBDiskUsageBigo;
    private String dongaBEventChk;
    private String dongaBEventBigo;
}

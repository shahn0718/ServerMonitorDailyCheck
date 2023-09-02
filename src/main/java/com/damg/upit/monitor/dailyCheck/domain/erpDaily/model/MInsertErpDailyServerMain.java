package com.damg.upit.monitor.dailyCheck.domain.erpDaily.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter @Setter
@ToString
public class MInsertErpDailyServerMain {

    private Long erpServerId;
    private Long erpMainId;

    /**
     *         <td>Main-1</td>
     *         <td>윈도우</td>
     *         <td>
     *           <p>CPU 사용량</p>
     *           <p>메모리 사용량</p>
     *           <p>디스크 사용량</p>
     *           <p>클러스터</p>
     *           <p>이벤트 로그</p>
     */
    private String main1CpuUsageChk;
    private String main1CpuUsageBigo;
    private String main1MemUsageChk;
    private String main1MemUsageBigo;
    private String main1DiskUsageChk;
    private String main1DiskUsageBigo;
    private String main1ClustChk;
    private String main1ClustBigo;
    private String main1EventChk;
    private String main1EventBigo;

    /**
     *         <td>Main-2</td>
     *         <td>윈도우</td>
     *         <td>
     *           <p>CPU 사용량</p>
     *           <p>메모리 사용량</p>
     *           <p>디스크 사용량</p>
     *           <p>클러스터</p>
     *           <p>이벤트 로그</p>
     */

    private String main2CpuUsageChk;
    private String main2CpuUsageBigo;
    private String main2MemUsageChk;
    private String main2MemUsageBigo;
    private String main2DiskUsageChk;
    private String main2DiskUsageBigo;
    private String main2ClustChk;
    private String main2ClustBigo;
    private String main2EventChk;
    private String main2EventBigo;

    /**
     *         <td>Main-3</td>
     *         <td>윈도우</td>
     *         <td>
     *           <p>CPU 사용량</p>
     *           <p>메모리 사용량</p>
     *           <p>디스크 사용량</p>
     *           <p>클러스터</p>
     *           <p>이벤트 로그</p>
     */


    private String main3CpuUsageChk;
    private String main3CpuUsageBigo;
    private String main3MemUsageChk;
    private String main3MemUsageBigo;
    private String main3DiskUsageChk;
    private String main3DiskUsageBigo;
    private String main3ClustChk;
    private String main3ClustBigo;
    private String main3EventChk;
    private String main3EventBigo;

    /**
     *         <td>DB-1</td>
     *         <td>리눅스</td>
     *         <td>
     *           <p>CPU 사용량</p>
     *           <p>메모리 사용량</p>
     *           <p>SWAP 사용량</p>
     *           <p>부하수치</p>
     *           <p>디스크 사용량</p>
     *           <p>프로세스</p>
     */

    private String db1CpuUsageChk;
    private String db1CpuUsageBigo;
    private String db1MemUsageChk;
    private String db1MemUsageBigo;
    private String db1SwapUsageChk;
    private String db1SwapUsageBigo;
    private String db1OverLoadChk;
    private String db1OverLoadBigo;
    private String db1DiskUsageChk;
    private String db1DiskUsageBigo;
    private String db1ProcessChk;
    private String db1ProcessBigo;

    /**
     *         <td>DB-2</td>
     *         <td>리눅스</td>
     *         <td>
     *           <p>CPU 사용량</p>
     *           <p>메모리 사용량</p>
     *           <p>SWAP 사용량</p>
     *           <p>부하수치</p>
     *           <p>디스크 사용량</p>
     *           <p>프로세스</p>
     */

    private String db2CpuUsageChk;
    private String db2CpuUsageBigo;
    private String db2MemUsageChk;
    private String db2MemUsageBigo;
    private String db2SwapUsageChk;
    private String db2SwapUsageBigo;
    private String db2OverLoadChk;
    private String db2OverLoadBigo;
    private String db2DiskUsageChk;
    private String db2DiskUsageBigo;
    private String db2ProcessChk;
    private String db2ProcessBigo;

    /**
     *         <td>DEV-DB</td>
     *         <td>리눅스</td>
     *         <td>
     *           <p>CPU 사용량</p>
     *           <p>메모리 사용량</p>
     *           <p>SWAP 사용량</p>
     *           <p>부하수치</p>
     *           <p>디스크 사용량</p>
     *           <p>프로세스</p>
     */

    private String devDbCpuUsageChk;
    private String devDbCpuUsageBigo;
    private String devDbMemUsageChk;
    private String devDbMemUsageBigo;
    private String devDbSwapUsageChk;
    private String devDbSwapUsageBigo;
    private String devDbOverLoadChk;
    private String devDbOverLoadBigo;
    private String devDbDiskUsageChk;
    private String devDbDiskUsageBigo;
    private String devDbProcessChk;
    private String devDbProcessBigo;

    /**
     *         <td>Backup</td>
     *         <td>리눅스</td>
     *         <td>
     *           <p>CPU 사용량</p>
     *           <p>메모리 사용량</p>
     *           <p>SWAP 사용량</p>
     *           <p>부하수치</p>
     *           <p>디스크 사용량</p>
     *           <p>프로세스</p>
     */

    private String backUpCpuUsageChk;
    private String backUpCpuUsageBigo;
    private String backUpMemUsageChk;
    private String backUpMemUsageBigo;
    private String backUpSwapUsageChk;
    private String backUpSwapUsageBigo;
    private String backUpOverLoadChk;
    private String backUpOverLoadBigo;
    private String backUpDiskUsageChk;
    private String backUpDiskUsageBigo;
    private String backUpProcessChk;
    private String backUpProcessBigo;
}

package com.damg.upit.monitor.dailyCheck.domain.etcDaily.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter @Setter
@ToString
public class MInsertErpDailyServerMain {

    private Long erpServerId;
    private Long erpMainId;

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

    /**
     *         <td>BNK-1</td>
     *         <td>윈도우</td>
     *         <td>
     *           <p>CPU 사용량</p>
     *           <p>메모리 사용량</p>
     *           <p>디스크 사용량</p>
     *           <p>이벤트 로그</p>
     */

    private String bnk1CpuUsageChk;
    private String bnk1CpuUsageBigo;
    private String bnk1MemUsageChk;
    private String bnk1MemUsageBigo;
    private String bnk1DiskUsageChk;
    private String bnk1DiskUsageBigo;
    private String bnk1EventChk;
    private String bnk1EventBigo;

    private String bnk2CpuUsageChk;
    private String bnk2CpuUsageBigo;
    private String bnk2MemUsageChk;
    private String bnk2MemUsageBigo;
    private String bnk2DiskUsageChk;
    private String bnk2DiskUsageBigo;
    private String bnk2EventChk;
    private String bnk2EventBigo;

    private String tax1CpuUsageChk;
    private String tax1CpuUsageBigo;
    private String tax1MemUsageChk;
    private String tax1MemUsageBigo;
    private String tax1DiskUsageChk;
    private String tax1DiskUsageBigo;
    private String tax1EventChk;
    private String tax1EventBigo;

    private String tax2CpuUsageChk;
    private String tax2CpuUsageBigo;
    private String tax2MemUsageChk;
    private String tax2MemUsageBigo;
    private String tax2DiskUsageChk;
    private String tax2DiskUsageBigo;
    private String tax2EventChk;
    private String tax2EventBigo;

    /**
     *         <td>EXWEB-1</td>
     *         <td>리눅스</td>
     *         <td>
     *           <p>CPU 사용량</p>
     *           <p>메모리 사용량</p>
     *           <p>SWAP 사용량</p>
     *           <p>부하수치</p>
     *           <p>디스크 사용량</p>
     *           <p>프로세스</p>
     *         </td>
     */

    private String exWeb1CpuUsageChk;
    private String exWeb1CpuUsageBigo;
    private String exWeb1MemUsageChk;
    private String exWeb1MemUsageBigo;
    private String exWeb1SwapUsageChk;
    private String exWeb1SwapUsageBigo;
    private String exWeb1OverLoadChk;
    private String exWeb1OverLoadBigo;
    private String exWeb1DiskUsageChk;
    private String exWeb1DiskUsageBigo;
    private String exWeb1ProcessChk;
    private String exWeb1ProcessBigo;

    private String exWeb2CpuUsageChk;
    private String exWeb2CpuUsageBigo;
    private String exWeb2MemUsageChk;
    private String exWeb2MemUsageBigo;
    private String exWeb2SwapUsageChk;
    private String exWeb2SwapUsageBigo;
    private String exWeb2OverLoadChk;
    private String exWeb2OverLoadBigo;
    private String exWeb2DiskUsageChk;
    private String exWeb2DiskUsageBigo;
    private String exWeb2ProcessChk;
    private String exWeb2ProcessBigo;

    private String inWeb1CpuUsageChk;
    private String inWeb1CpuUsageBigo;
    private String inWeb1MemUsageChk;
    private String inWeb1MemUsageBigo;
    private String inWeb1SwapUsageChk;
    private String inWeb1SwapUsageBigo;
    private String inWeb1OverLoadChk;
    private String inWeb1OverLoadBigo;
    private String inWeb1DiskUsageChk;
    private String inWeb1DiskUsageBigo;
    private String inWeb1ProcessChk;
    private String inWeb1ProcessBigo;

    private String inWeb2CpuUsageChk;
    private String inWeb2CpuUsageBigo;
    private String inWeb2MemUsageChk;
    private String inWeb2MemUsageBigo;
    private String inWeb2SwapUsageChk;
    private String inWeb2SwapUsageBigo;
    private String inWeb2OverLoadChk;
    private String inWeb2OverLoadBigo;
    private String inWeb2DiskUsageChk;
    private String inWeb2DiskUsageBigo;
    private String inWeb2ProcessChk;
    private String inWeb2ProcessBigo;

    private String was1CpuUsageChk;
    private String was1CpuUsageBigo;
    private String was1MemUsageChk;
    private String was1MemUsageBigo;
    private String was1SwapUsageChk;
    private String was1SwapUsageBigo;
    private String was1OverLoadChk;
    private String was1OverLoadBigo;
    private String was1DiskUsageChk;
    private String was1DiskUsageBigo;
    private String was1ProcessChk;
    private String was1ProcessBigo;

    private String was2CpuUsageChk;
    private String was2CpuUsageBigo;
    private String was2MemUsageChk;
    private String was2MemUsageBigo;
    private String was2SwapUsageChk;
    private String was2SwapUsageBigo;
    private String was2OverLoadChk;
    private String was2OverLoadBigo;
    private String was2DiskUsageChk;
    private String was2DiskUsageBigo;
    private String was2ProcessChk;
    private String was2ProcessBigo;

    private String erpMgntCpuUsageChk;
    private String erpMgntCpuUsageBigo;
    private String erpMgntMemUsageChk;
    private String erpMgntMemUsageBigo;
    private String erpMgntSwapUsageChk;
    private String erpMgntSwapUsageBigo;
    private String erpMgntOverLoadChk;
    private String erpMgntOverLoadBigo;
    private String erpMgntDiskUsageChk;
    private String erpMgntDiskUsageBigo;
    private String erpMgntProcessChk;
    private String erpMgntProcessBigo;

    private String devWebCpuUsageChk;
    private String devWebCpuUsageBigo;
    private String devWebMemUsageChk;
    private String devWebMemUsageBigo;
    private String devWebSwapUsageChk;
    private String devWebSwapUsageBigo;
    private String devWebOverLoadChk;
    private String devWebOverLoadBigo;
    private String devWebDiskUsageChk;
    private String devWebDiskUsageBigo;
    private String devWebProcessChk;
    private String devWebProcessBigo;

    private String devWasCpuUsageChk;
    private String devWasCpuUsageBigo;
    private String devWasMemUsageChk;
    private String devWasMemUsageBigo;
    private String devWasSwapUsageChk;
    private String devWasSwapUsageBigo;
    private String devWasOverLoadChk;
    private String devWasOverLoadBigo;
    private String devWasDiskUsageChk;
    private String devWasDiskUsageBigo;
    private String devWasProcessChk;
    private String devWasProcessBigo;

    private String jeniusCpuUsageChk;
    private String jeniusCpuUsageBigo;
    private String jeniusMemUsageChk;
    private String jeniusMemUsageBigo;
    private String jeniusSwapUsageChk;
    private String jeniusSwapUsageBigo;
    private String jeniusOverLoadChk;
    private String jeniusOverLoadBigo;
    private String jeniusDiskUsageChk;
    private String jeniusDiskUsageBigo;
    private String jeniusProcessChk;
    private String jeniusProcessBigo;
}

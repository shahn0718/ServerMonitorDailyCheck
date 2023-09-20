package com.damg.upit.monitor.dailyCheck.domain.erpDaily.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MInsertErpDailyVMMain {


    private Long erpVmId;
    private Long erpMainId;


    /**
     *         <td>BNK-1</td>
     *         <td>윈도우</td>
     *         <td>
     *           <p>CPU 사용량</p>
     *           <p>메모리 사용량</p>
     *           <p>디스크 사용량</p>
     *           <p>이벤트 로그</p>
     *           <p>V3</p>
     */

    private String bnk1CpuUsageChk;
    private String bnk1CpuUsageBigo;
    private String bnk1MemUsageChk;
    private String bnk1MemUsageBigo;
    private String bnk1DiskUsageChk;
    private String bnk1DiskUsageBigo;
    private String bnk1EventChk;
    private String bnk1EventBigo;
    private String bnk1V3Chk;
    private String bnk1V3Bigo;

    /**
     *         <td>BNK-2</td>
     *         <td>윈도우</td>
     *         <td>
     *           <p>CPU 사용량</p>
     *           <p>메모리 사용량</p>
     *           <p>디스크 사용량</p>
     *           <p>이벤트 로그</p>
     *           <p>V3</p>
     *         </td>
     */

    private String bnk2CpuUsageChk;
    private String bnk2CpuUsageBigo;
    private String bnk2MemUsageChk;
    private String bnk2MemUsageBigo;
    private String bnk2DiskUsageChk;
    private String bnk2DiskUsageBigo;
    private String bnk2EventChk;
    private String bnk2EventBigo;
    private String bnk2V3Chk;
    private String bnk2V3Bigo;

    /**
     *         <td>TAX-1</td>
     *         <td>윈도우</td>
     *         <td>
     *           <p>CPU 사용량</p>
     *           <p>메모리 사용량</p>
     *           <p>디스크 사용량</p>
     *           <p>이벤트 로그</p>
     *           <p>V3</p>
     *         </td>
     */
    private String tax1CpuUsageChk;
    private String tax1CpuUsageBigo;
    private String tax1MemUsageChk;
    private String tax1MemUsageBigo;
    private String tax1DiskUsageChk;
    private String tax1DiskUsageBigo;
    private String tax1EventChk;
    private String tax1EventBigo;
    private String tax1V3Chk;
    private String tax1V3Bigo;

    /**
     *         <td>TAX-2</td>
     *         <td>윈도우</td>
     *         <td>
     *           <p>CPU 사용량</p>
     *           <p>메모리 사용량</p>
     *           <p>디스크 사용량</p>
     *           <p>이벤트 로그</p>
     *           <p>V3</p>
     */
    private String tax2CpuUsageChk;
    private String tax2CpuUsageBigo;
    private String tax2MemUsageChk;
    private String tax2MemUsageBigo;
    private String tax2DiskUsageChk;
    private String tax2DiskUsageBigo;
    private String tax2EventChk;
    private String tax2EventBigo;
    private String tax2V3Chk;
    private String tax2V3Bigo;

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

    /**
     *         <td>EXWEB-2</td>
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

    /**
     *         <td>INWEB-1</td>
     *         <td>리눅스</td>
     *         <td>
     *           <p>CPU 사용량</p>
     *           <p>메모리 사용량</p>
     *           <p>SWAP 사용량</p>
     *           <p>부하수치</p>
     *           <p>디스크 사용량</p>
     *           <p>프로세스</p>
     */
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

    /**
     *         <td>INWEB-2</td>
     *         <td>리눅스</td>
     *         <td>
     *           <p>CPU 사용량</p>
     *           <p>메모리 사용량</p>
     *           <p>SWAP 사용량</p>
     *           <p>부하수치</p>
     *           <p>디스크 사용량</p>
     *           <p>프로세스</p>
     */
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

    /**
     *         <td>WAS-1</td>
     *         <td>리눅스</td>
     *         <td>
     *           <p>CPU 사용량</p>
     *           <p>메모리 사용량</p>
     *           <p>SWAP 사용량</p>
     *           <p>부하수치</p>
     *           <p>디스크 사용량</p>
     *           <p>프로세스</p>
     */
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

    /**
     *         <td>WAS-2</td>
     *         <td>리눅스</td>
     *         <td>
     *           <p>CPU 사용량</p>
     *           <p>메모리 사용량</p>
     *           <p>SWAP 사용량</p>
     *           <p>부하수치</p>
     *           <p>디스크 사용량</p>
     *           <p>프로세스</p>
     */

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

    /**
     *         <td>ERPMGNT</td>
     *         <td>리눅스</td>
     *         <td>
     *           <p>CPU 사용량</p>
     *           <p>메모리 사용량</p>
     *           <p>SWAP 사용량</p>
     *           <p>부하수치</p>
     *           <p>디스크 사용량</p>
     *           <p>프로세스</p>
     */

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

    /**
     *         <td>DEV-WEB</td>
     *         <td>리눅스</td>
     *         <td>
     *           <p>CPU 사용량</p>
     *           <p>메모리 사용량</p>
     *           <p>SWAP 사용량</p>
     *           <p>부하수치</p>
     *           <p>디스크 사용량</p>
     *           <p>프로세스</p>
     */

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

    /**
     *         <td>DEV-WAS</td>
     *         <td>리눅스</td>
     *         <td>
     *           <p>CPU 사용량</p>
     *           <p>메모리 사용량</p>
     *           <p>SWAP 사용량</p>
     *           <p>부하수치</p>
     *           <p>디스크 사용량</p>
     *           <p>프로세스</p>
     */

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

    /**
     *         <td>Jenius</td>
     *         <td>리눅스</td>
     *         <td>
     *           <p>CPU 사용량</p>
     *           <p>메모리 사용량</p>
     *           <p>SWAP 사용량</p>
     *           <p>부하수치</p>
     *           <p>디스크 사용량</p>
     *           <p>프로세스</p>
     */

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

package com.damg.upit.monitor.dailyCheck.domain.infraDaily.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MInsertInfraDailyServerMain {

    private Long infraServerId;
    private Long infraMainId;

    /**
     *           <td>Nwblock-1</td>
     *           <td>윈도우</td>
     *           <td>
     *             <p>CPU 사용량</p>
     *             <p>메모리 사용량</p>
     *             <p>디스크 사용량</p>
     *             <p>이벤트 로그</p>
     */

    private String nwblock1CpuUsageChk;
    private String nwblock1CpuUsageBigo;
    private String nwblock1MemUsageChk;
    private String nwblock1MemUsageBigo;
    private String nwblock1DiskUsageChk;
    private String nwblock1DiskUsageBigo;
    private String nwblock1EventChk;
    private String nwblock1EventBigo;

    /**
     *            <td>Nwblock-2</td>
     *             <td>윈도우</td>
     *             <td>
     *               <p>CPU 사용량</p>
     *               <p>메모리 사용량</p>
     *               <p>디스크 사용량</p>
     *               <p>이벤트 로그</p>
     */

    private String nwblock2CpuUsageChk;
    private String nwblock2CpuUsageBigo;
    private String nwblock2MemUsageChk;
    private String nwblock2MemUsageBigo;
    private String nwblock2DiskUsageChk;
    private String nwblock2DiskUsageBigo;
    private String nwblock2EventChk;
    private String nwblock2EventBigo;

    /**
     *             <td>DDC-Backup</td>
     *             <td>윈도우</td>
     *             <td>
     *               <p>CPU 사용량</p>
     *               <p>메모리 사용량</p>
     *               <p>디스크 사용량</p>
     *               <p>이벤트 로그</p>
     *             </td>
     */

    private String ddcBackUpCpuUsageChk;
    private String ddcBackUpCpuUsageBigo;
    private String ddcBackUpMemUsageChk;
    private String ddcBackUpMemUsageBigo;
    private String ddcBackUpDiskUsageChk;
    private String ddcBackUpDiskUsageBigo;
    private String ddcBackUpEventChk;
    private String ddcBackUpEventBigo;

    /**
     *             <td>CHA-Backup</td>
     *             <td>윈도우</td>
     *             <td>
     *               <p>CPU 사용량</p>
     *               <p>메모리 사용량</p>
     *               <p>디스크 사용량</p>
     *               <p>이벤트 로그</p>
     */

    private String chaBackUpCpuUsageChk;
    private String chaBackUpCpUUsageBigo;
    private String chaBackUpMemUsageChk;
    private String chaBackUpMemUsageBigo;
    private String chaBackUpDiskUsageChk;
    private String chaBackUpDiskUsageBigo;
    private String chaBackUpEventChk;
    private String chaBackUpEventBigo;

    /**
     *             <td>NewFile</td>
     *             <td>윈도우</td>
     *             <td>
     *               <p>CPU 사용량</p>
     *               <p>메모리 사용량</p>
     *               <p>디스크 사용량</p>
     *               <p>이벤트 로그</p>
     *             </td>
     */

    private String newFileCpuUsageChk;
    private String newFileCpuUsageBigo;
    private String newFileMemUsageChk;
    private String newFileMemUsageBigo;
    private String newFileDiskUsageChk;
    private String newFileDiskUsageBigo;
    private String newFileEventChk;
    private String newFileEventBigo;

    /**
     *             <td>AD-1</td>
     *             <td>윈도우</td>
     *             <td>
     *               <p>CPU 사용량</p>
     *               <p>메모리 사용량</p>
     *               <p>디스크 사용량</p>
     *               <p>이벤트 로그</p>
     */

    private String ad1CpuUsageChk;
    private String ad1CpuUsageBigo;
    private String ad1MemUsageChk;
    private String ad1MemUsageBigo;
    private String ad1DiskUsageChk;
    private String ad1DiskUsageBigo;
    private String ad1EventChk;
    private String ad1EventBigo;

    /**
     *             <td>AD-2</td>
     *             <td>윈도우</td>
     *             <td>
     *               <p>CPU 사용량</p>
     *               <p>메모리 사용량</p>
     *               <p>디스크 사용량</p>
     *               <p>이벤트 로그</p>
     */

    private String ad2CpuUsageChk;
    private String ad2CpuUsageBigo;
    private String ad2MemUsageChk;
    private String ad2MemUsageBigo;
    private String ad2DiskUsageChk;
    private String ad2DiskUsageBigo;
    private String ad2EventChk;
    private String ad2EventBigo;

}
package com.damg.upit.monitor.dailyCheck.domain.gwDaily.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MInsertGwDailyServerMain {

    //GW Node1, Node2, Node3, Node4 (유/무, 비고)
    /**
     * GW Node1, Node2, Node3, Node4 (이상유무, 비고)
     * 각 노드별 CPU사용량 메모리사용량, 부하수치, 디스크사용량, 프로세스, 쿠버네티스
     *
     */
    private String node1CpuUsageChk;
    private String node1CpuUsageBigo;
    private String node1MemUsageChk;
    private String node1MemUsageBigo;
    private String node1OverLoadChk;
    private String node1OverLoadBigo;
    private String node1DiskUsageChk;
    private String node1DiskUsageBigo;
    private String node1ProcessChk;
    private String node1ProcessBigo;
    private String node1KubChk;
    private String node1KubBigo;

    //node2
    private String node2CpuUsageChk;
    private String node2CpuUsageBigo;
    private String node2MemUsageChk;
    private String node2MemUsageBigo;
    private String node2OverLoadChk;
    private String node2OverLoadBigo;
    private String node2DiskUsageChk;
    private String node2DiskUsageBigo;
    private String node2ProcessChk;
    private String node2ProcessBigo;
    private String node2KubChk;
    private String node2KubBigo;

    //node3
    private String node3CpuUsageChk;
    private String node3CpuUsageBigo;
    private String node3MemUsageChk;
    private String node3MemUsageBigo;
    private String node3OverLoadChk;
    private String node3OverLoadBigo;
    private String node3DiskUsageChk;
    private String node3DiskUsageBigo;
    private String node3ProcessChk;
    private String node3ProcessBigo;
    private String node3KubChk;
    private String node3KubBigo;

    //node4
    private String node4CpuUsageChk;
    private String node4CpuUsageBigo;
    private String node4MemUsageChk;
    private String node4MemUsageBigo;
    private String node4OverLoadChk;
    private String node4OverLoadBigo;
    private String node4DiskUsageChk;
    private String node4DiskUsageBigo;
    private String node4ProcessChk;
    private String node4ProcessBigo;
    private String node4KubChk;
    private String node4KubBigo;

    //dev-node
    private String devNodeCpuUsageChk;
    private String devNodeCpuUsageBigo;
    private String devNodeMemUsageChk;
    private String devNodeMemUsageBigo;
    private String devNodeOverLoadChk;
    private String devNodeOverLoadBigo;
    private String devNodeDiskUsageChk;
    private String devNodeDiskUsageBigo;
    private String devNodeProcessChk;
    private String devNodeProcessBigo;
    private String devNodeKubChk;
    private String devNodeKubBigo;

    // arch5
    private String archCpuUsageChk;
    private String archCpuUsageBigo;
    private String archMemUsageChk;
    private String archMemUsageBigo;
    private String archSwapUsageChk;
    private String archSwapUsageBigo;
    private String archOverLoadChk;
    private String archOverLoadBigo;
    private String archProcessChk;
    private String archProcessBigo;

    //backup
    private String backCpuUsageChk;
    private String backCpuUsageBigo;
    private String backMemUsageChk;
    private String backMemUsageBigo;
    private String backSwapUsageChk;
    private String backSwapUsageBigo;
    private String backOverLoadChk;
    private String backOverLoadBigo;
    private String backDiskUsageChk;
    private String backDiskUsageBigo;
    private String backProcessChk;
    private String backProcessBigo;

}

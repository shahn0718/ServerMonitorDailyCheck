package com.damg.upit.monitor.dailyCheck.domain.infraDaily.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MInsertInfraDailyVMMain {

    private Long infraVMId;
    private Long infraMainId;

    /**
     *             <td>ERP-HVDC-01</td>
     *             <td>윈도우</td>
     *             <td>
     *               <p>CPU 사용량</p>
     *               <p>메모리 사용량</p>
     *               <p>디스크 사용량</p>
     *               <p>이벤트 로그</p>
     */

    private String erpHvdc1CpuUsageChk;
    private String erpHvdc1CpuUsageBigo;
    private String erpHvdc1MemUsageChk;
    private String erpHvdc1MemUsageBigo;
    private String erpHvdc1DiskUsageChk;
    private String erpHvdc1DiskUsageBigo;
    private String erpHvdc1EventChk;
    private String erpHvdc1EventBigo;


    /**
     *             <td>ERP-HVDC-02</td>
     *             <td>윈도우</td>
     *             <td>
     *               <p>CPU 사용량</p>
     *               <p>메모리 사용량</p>
     *               <p>디스크 사용량</p>
     *               <p>이벤트 로그</p>
     */

    private String erpHvdc2CpuUsageChk;
    private String erpHvdc2CpuUsageBigo;
    private String erpHvdc2MemUsageChk;
    private String erpHvdc2MemUsageBigo;
    private String erpHvdc2DiskUsageChk;
    private String erpHvdc2DiskUsageBigo;
    private String erpHvdc2EventChk;
    private String erpHvdc2EventBigo;

}

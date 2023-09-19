package com.damg.upit.monitor.dailyCheck.domain.erpServerMonitor.model;

import java.time.LocalDateTime;

public class MInsertErpSVMain {
    /**
     * <server>
     * <info>
     * <hostname>donga-erpmgmt</hostname>
     * → erpSVCd
     * <date>2023-06-21</date>
     * <time>13:30:02</time>
     * → erpSVDateTime
     * <osver>CentOS Stream release 8</osver>
     * → erpSVOs
     * <ipaddr>10.75.1.65</ipaddr>
     * → erpSVIp
     * <cpu_usage>41</cpu_usage>
     * → erpSVCpuUsage
     * <mem_usage>19</mem_usage>
     * → erpSVMemUsage
     * <swap_usage>18</swap_usage>
     * → erpSVSwapUsage
     * <load_num>1</load_num>
     * → erpSVLoadNum
     *
     * → 하위는 MInsertErpSVDiskUSage 및 MInsertErpSVProcChk 분류
     * <disk_usage>/,35</disk_usage>
     * <disk_usage>/boot,79</disk_usage>
     * <disk_usage>/boot/efi,2</disk_usage>
     * <disk_usage>/home,36</disk_usage>
     * <proc_chk>http,7</proc_chk>
     * <proc_chk>java,6</proc_chk>
     * <proc_chk>mysql,2</proc_chk>
     * </info>
     * </server>
     */

    private Long erpSVId;
    private String erpSVCd;
    /**
     * <hostname>donga-erpmgmt</hostname>
     * → erpSVCd
     */
    private String erpSVOs;
    /**
     * <osver>CentOS Stream release 8</osver>
     * → erpSVOs
     */
    private String erpSVIp;
    /**
     * <ipaddr>10.75.1.65</ipaddr>
     * → erpSVIp
     */
    private String erpSVCpuUsage;
    /**
     * <cpu_usage>41</cpu_usage>
     * → erpSVCpuUsage
     */
    private String erpSVMemUsage;
    /**
     * <mem_usage>19</mem_usage>
     * → erpSVMemUsage
     */
    private String erpSVSwapUsage;
    /**
     * <swap_usage>18</swap_usage>
     * → erpSVSwapUsage
     */
    private String erpSVLoadNum;
    /**
     * <load_num>1</load_num>
     * → erpSVLoadNum
     */
    private LocalDateTime erpSVDateTime;
    /**
     * <date>2023-06-21</date>
     * <time>13:30:02</time>
     * → erpSVDateTime
     */





}

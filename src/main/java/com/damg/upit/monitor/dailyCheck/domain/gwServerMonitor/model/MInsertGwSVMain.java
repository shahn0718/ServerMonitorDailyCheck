package com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
public class MInsertGwSVMain {

    /**
     * <server>
     *     <info>
     *         <hostname>gw-backup</hostname>
     *         <date>2023-05-23</date>
     *         <time>15:00:01</time>
     *         <osver>CentOS Linux release 7.8.2003 (Core)</osver>
     *         <ipaddr>10.14.21.31</ipaddr>
     *         <cpu_usage>18</cpu_usage>
     *         <mem_usage>19</mem_usage>
     *         <swap_usage>0</swap_usage>
     *         <load_num>0</load_num>
     *
     * → 하위는 MInserGwSVDiskUSage 및 MInsertGwSVProcChk 및 MInsertGwSvClustChk분류
     *         <disk_usage>/,32</disk_usage>
     *         <disk_usage>/boot,26</disk_usage>
     *         <disk_usage>/boot/efi,3</disk_usage>
     *         <disk_usage>/home,59</disk_usage>
     *         <disk_usage>/gw_nas,42</disk_usage>
     *         <proc_chk>netbackup,35</proc_chk>
     *     </info>
     * </server>
     */

    private Long gwSVId;
    private String gwSVCd;
    /**
     * <hostname>gw-backup</hostname>
     * → gwSVCd;
     */
    private String gwSVOs;
    /**
     * <osver>CentOS Linux release 7.8.2003 (Core)</osver>
     * → gwSVOs;
     */
    private String gwSVIp;
    /**
     * <ipaddr>10.14.21.31</ipaddr>
     * → gwSVIp
     */
    private String gwSVCpuUsage;
    /**
     * <cpu_usage>18</cpu_usage>
     * → gwSVCpuUsage
     */
    private String gwSVMemUsage;
    /**
     * <mem_usage>19</mem_usage>
     * → gwSVMemUsage
     */
    private String gwSVSwapUsage;
    /**
     * <swap_usage>0</swap_usage>
     * → gwSVSwapUsage
     */
    private String gwSVClustUsage;
    /**
     * → 예비 생성
     */
    private String gwSVLoadNum;
    /**
     * <load_num>0</load_num>
     * → gwSVLoadNum
     */
    private LocalDateTime gwSVDateTime;
    /**
     *  <date>2023-05-23</date>
     *  <time>15:00:01</time>
     * → gwSVDateTime;
     */
}

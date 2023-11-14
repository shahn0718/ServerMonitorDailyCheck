package com.damg.upit.monitor.dailyCheck.domain.infraServerMonitor.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
public class MInsertInfraSVMain {
    /**
     * <server>
     * <info>
     * <hostname>monitor</hostname>
     * <date>2023-11-14</date>
     * <time>15:00:01</time>
     * <osver>CentOS Linux release 7.6.1810 (Core)</osver>
     * <ipaddr>10.13.7.142</ipaddr>
     * <cpu_usage>0</cpu_usage>
     * <mem_usage>4</mem_usage>
     * <swap_usage>0</swap_usage>
     * <load_num>0</load_num>
     * <disk_usage>/,5</disk_usage>
     * <disk_usage>/boot,43</disk_usage>
     * <proc_chk>ftp,2</proc_chk>
     * <proc_chk>httpd,10</proc_chk>
     * <proc_chk>mysql,1</proc_chk>
     * </info>
     * </server>
     */

    private Long infraMainId;
    private Long infraSVId;

    private String infraSVCd;
    /**
     * <hostname>monitor</hostname>
     * → infraSVCd;
     */
    private String infraSVOs;
    /**
     * <osver>CentOS Linux release 7.8.2003 (Core)</osver>
     * → infraSVOs;
     */
    private String infraSVIp;
    /**
     * <ipaddr>10.13.7.142</ipaddr>
     * → infraSVIp
     */
    private String infraSVCpuUsage;
    /**
     * <cpu_usage>0</cpu_usage>
     * → infraSVCpuUsage
     */
    private String infraSVMemUsage;
    /**
     * <mem_usage>4</mem_usage>
     * → infraSVMemUsage
     */
    private String infraSVSwapUsage;
    /**
     * <swap_usage>0</swap_usage>
     * → infraSVSwapUsage
     */
    private String infraSVClustUsage;
    /**
     * → 예비 생성
     */
    private String infraSVLoadNum;
    /**
     * <load_num>0</load_num>
     * → infraSVLoadNum
     */
    private LocalDateTime infraSVDateTime;
    /**
     *  <date>2023-05-23</date>
     *  <time>15:00:01</time>
     * → infraSVDateTime;
     */


}

package com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
public class MInsertEtcSVMain {

    /**
     * <server>
     * <info>
     * <hostname>donga-inweb2</hostname>
     * <date>2023-09-20</date>
     * <time>14:10:01</time>
     * <osver>CentOS Stream release 8</osver>
     * <ipaddr>10.75.1.60</ipaddr>
     * <cpu_usage>7</cpu_usage>
     * <mem_usage>4</mem_usage>
     * <swap_usage>0</swap_usage>
     * <load_num>0</load_num>
     *
     * <disk_usage>/,16</disk_usage>
     * <disk_usage>/home,2</disk_usage>
     * <disk_usage>/boot,79</disk_usage>
     * <disk_usage>/boot/efi,2</disk_usage>
     * <proc_chk>webtob,3</proc_chk>
     * </info>
     * </server>
     */

    private Long etcMainId;
    private Long etcSVId;
    private String etcSVCd;
    /**
     * <hostname>donga-inweb2</hostname>
     * → etcSVCd
     */
    private String etcSVOs;
    /**
     * <osver>CentOS Stream release 8</osver>
     * → etcSVOs
     */
    private String etcSVIp;
    /**
     * <ipaddr>10.75.1.60</ipaddr>
     * → etcSVIp
     */
    private String etcSVCpuUsage;
    /**
     * <cpu_usage>7</cpu_usage>
     * → etcSVCpuUsage
     */
    private String etcSVMemUsage;
    /**
     * <mem_usage>4</mem_usage>
     * → etcSVMemUsage
     */
    private String etcSVSwapUsage;
    /**
     * <swap_usage>0</swap_usage>
     * → etcSVSwapUsage
     */
    private String etcSVLoadNum;
    /**
     * <load_num>0</load_num>
     * → etcSVLoadNum
     */
    private LocalDateTime etcSVDateTime;

}

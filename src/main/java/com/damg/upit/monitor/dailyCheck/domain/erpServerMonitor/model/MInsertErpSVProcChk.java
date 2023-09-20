package com.damg.upit.monitor.dailyCheck.domain.erpServerMonitor.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MInsertErpSVProcChk {
    /**
     *      * <proc_chk>http,7</proc_chk>
     *      * <proc_chk>java,6</proc_chk>
     *      * <proc_chk>mysql,2</proc_chk>
     */

    private Long erpSVProcId;
    private Long erpSVId;
    private String erpSVProcCd;
    private String erpSVProcData;
}

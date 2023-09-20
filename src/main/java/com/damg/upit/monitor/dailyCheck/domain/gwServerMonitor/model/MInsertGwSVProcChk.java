package com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MInsertGwSVProcChk {
    /**
     * <proc_chk>mySql,2</proc_chk>
     * <proc_chk>NameSpace(CD), Usage</proc_chk>
     *
     */

    private Long gwSVProcId;
    private Long gwSVId;
    private String gwSVProcCd;
    private String gwSVProcData;
}

package com.damg.upit.monitor.dailyCheck.domain.infraServerMonitor.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MInsertInfraSVProcChk {
    /**
     *  <proc_chk>ftp,2</proc_chk>
     *  <proc_chk>httpd,10</proc_chk>
     *  <proc_chk>mysql,1</proc_chk>
     */

    private Long infraSVProcId;
    private Long infraSVId;
    private String infraSVProcCd;
    private String infraSVProcData;
}

package com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MInsertEtcSVProcChk {

    /**
     * <proc_chk>webtob,3</proc_chk>
     */

    private Long etcSVProcId;

    private Long etcErpSVId;
    private Long etcEhrSVId;

    private String etcSVProcCd;
    private String etcSVProcData;
}

package com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MInsertGwSVClustChk {
    /**
     * <cluster-chk>diamanti-system, collectd-v0.8-6xxjc, Terminating</cluster-chk>
     *
     * <cluster-chk>NameSpace, PodName, Status</cluster-chk>
     * <cluster-chk>gwSVClustCd, gwSVClustPod, gwSVClustStatus</cluster-chk>
     *
     * ** Status - Running or Completed 에서는 생성안되고, 다른경우에만 생성
     */

    private Long gwSVClustId;
    private Long gwSVId;
    private String gwSVClustCd;
    private String gwSVClustPod;
    private String gwSVClustStatus;
}

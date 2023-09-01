package com.damg.upit.monitor.dailyCheck.domain.gwDaily.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MInsertGwDailyStorageMain {


    private Long gwStorageId;
    private Long gwMainId;

    /**
     *         <td>GW-NAS-Main</td>
     *         <td>-</td>
     *         <td>
     *           <p>클러스터</p>
     */
    private String gwNasMainClustChk;
    private String gwNasMainClustBigo;

    /**
     *         <td>GW-NAS-Backup</td>
     *         <td>-</td>
     *         <td>
     *           <p>클러스터</p>
     */
    private String gwNasBackClustChk;
    private String gwNasBackClustBigo;

    /**
     *         <td>Arch-NAS-Main</td>
     *         <td>-</td>
     *         <td>
     *           <p>클러스터</p>
     */
    private String archNasMainClustChk;
    private String archNasMainClustBigo;

    /**
     *         <td>Arch-NAS-Backup</td>
     *         <td>-</td>
     *         <td>
     *           <p>클러스터</p>
     */
    private String archNasBackClustChk;
    private String archNasBackClustBigo;

}

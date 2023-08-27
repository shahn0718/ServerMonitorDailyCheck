package com.damg.upit.monitor.dailyCheck.domain.gwDaily.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MInsertGwDailyStorageMain {

    //GW-NAS-MAIN
    private String gwNasMainClustChk;
    private String gwNasMainClustBigo;

    //GW-NAS-Backup
    private String gwNasBackClustChk;
    private String gwNasBackClustBigo;

    //Arch-NAS-Main
    private String archNasMainClustChk;
    private String archNasMainClustBigo;

    //Arch-NAS-Backup
    private String archNasBackClustChk;
    private String archNasBackClustBigo;

}

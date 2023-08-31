package com.damg.upit.monitor.dailyCheck.domain.etcDaily.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MInsertErpDailyStroageMain {

    private Long erpStorageId;
    private Long erpMainId;

    private String erpNasSanClustChk;
    private String erpNasSanClustBigo;



}

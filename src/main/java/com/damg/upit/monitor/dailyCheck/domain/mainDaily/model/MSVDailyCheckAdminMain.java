package com.damg.upit.monitor.dailyCheck.domain.mainDaily.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@ToString
public class MSVDailyCheckAdminMain {

    private long admin_id;
    private String admin_nm;
    private String admin_no;
    private String admin_cellno;
    private String admin_mail;
}

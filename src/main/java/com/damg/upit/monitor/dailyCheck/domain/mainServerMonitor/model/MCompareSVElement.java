package com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public enum MCompareSVElement {

    GW_SERVER_STD("GW","8","33","2","","",""),
    ERP_SERVER_STD("ERP","","","","","",""),
    ETC_ERP_SERVER_STD("ETC_ERP","","","","","",""),
    ETC_HR_SERVER_STD("ETC_HR","","","","","",""),
    INFRA_SERVER_STD("INFRA","","","","","","");


    private String svCd;
    private String cpuUsageStd;
    private String memUsageStd;
    private String loadNumStd;
    private String diskUsageStd;
    private String procChkStd;
    private String clustChkStd;

    MCompareSVElement(String svCd, String cpuUsageStd, String memUsageStd, String loadNumStd,
                      String diskUsageStd, String clustChkStd, String procChkStd ){
        this.svCd = svCd;
        this.cpuUsageStd = cpuUsageStd;
        this.memUsageStd = memUsageStd;
        this.loadNumStd = loadNumStd;
        this.diskUsageStd = diskUsageStd;
        this.clustChkStd = clustChkStd;
        this.procChkStd = procChkStd;
    }

    public String getSvCd() {
        return svCd;
    }
    public String getCpuUsageStd(){
        return cpuUsageStd;
    }
    public String getMemUsageStd(){
        return memUsageStd;
    }
    public String getLoadNumStd(){
        return loadNumStd;
    }
    public String getDiskUsageStd(){
        return diskUsageStd;
    }
    public String getClustChkStd(){
        return clustChkStd;
    }
    public String getProcChkStd(){
        return procChkStd;
    }






}

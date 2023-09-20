package com.damg.upit.monitor.dailyCheck.domain.erpServerMonitor.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MInsertErpSVDiskUsage {
    /**
     *      * <disk_usage>/,35</disk_usage>
     *      * <disk_usage>/boot,79</disk_usage>
     *      * <disk_usage>/boot/efi,2</disk_usage>
     *      * <disk_usage>/home,36</disk_usage>
     */

    private Long erpSVDiskId;
    private Long erpSVId;
    private String erpSVDiskCd;
    private String erpSVDiskData;
}

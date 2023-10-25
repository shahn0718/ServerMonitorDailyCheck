package com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MInsertEtcSVDiskUsage {

    /**
     * <disk_usage>/,16</disk_usage>
     * <disk_usage>/home,2</disk_usage>
     * <disk_usage>/boot,79</disk_usage>
     * <disk_usage>/boot/efi,2</disk_usage>
     */

    private Long etcSVDiskId;
    private Long etcSVId;
    private String etcSVDiskCd;
    private String etcSVDiskData;
}

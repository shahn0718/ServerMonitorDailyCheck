package com.damg.upit.monitor.dailyCheck.domain.infraServerMonitor.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MInsertInfraSVDiskUsage {

    /**
     * <disk_usage>/data,1</disk_usage>
     * <disk_usage>NameSpace(CD), Usage</disk_usage>
     *
     */

    private Long infraSVDiskId;
    private Long infraSVId;
    private String infraSVDiskCd;
    private String infraSVDiskData;
}

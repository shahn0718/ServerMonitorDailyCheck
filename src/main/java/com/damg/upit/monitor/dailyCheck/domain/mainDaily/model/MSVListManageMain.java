package com.damg.upit.monitor.dailyCheck.domain.mainDaily.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MSVListManageMain {
/**
 *  서버관리 목적 : 서버 등록 및 관리
 *  서버 ip 등등
 *  관리자 및 담당: 서버 담당
 *  향후, 추가 스펙
 */
    private Long manageSV_Id;
    private String manageSV_Cd;
    private String manageSV_Ip;
    private String adminSV_No;

}

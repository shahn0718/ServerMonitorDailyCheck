package com.damg.upit.monitor.dailyCheck.domain.erpDaily.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MInsertErpDailyStorageMain {


    private Long erpStorageId;
    private Long erpMainId;
    /**
     *    <tr align="center">
     *         <td>스토리지</td>
     *         <td>
     *           <p>NAS(SAN)</p>
     *         </td>
     *         <td>
     *           <p>-</p>
     *         </td>
     *         <td>
     *           클러스터
     *         </td>
     */

    private String erpNasSanClustChk;
    private String erpNasSanClustBigo;



}

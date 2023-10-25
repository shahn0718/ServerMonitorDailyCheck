package com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.param;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter
@ToString
public class PInsertSms extends PInsertSmsElement {

    List<PInsertSmsElement> detailList;

}

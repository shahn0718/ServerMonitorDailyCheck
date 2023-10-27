package com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.repository;

import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.param.PInsertSmsElement;

public interface smsSVRepository {

    void insertSmsData(PInsertSmsElement pInsertSmsList);
}

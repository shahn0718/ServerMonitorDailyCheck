package com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.mapper;

import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.param.PInsertSmsElement;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface smsSVMapper {

    void insertSmsData(PInsertSmsElement pInsertSmsElement);
}

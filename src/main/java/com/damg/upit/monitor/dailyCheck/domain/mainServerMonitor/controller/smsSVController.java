package com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.controller;


import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.param.PInsertSmsElement;
import com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.service.smsSVService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class smsSVController {

    private final smsSVService smsService;

    public smsSVController(smsSVService smsService){
        this.smsService = smsService;
    }

    @GetMapping("/testData")
    @Transactional(rollbackFor = Exception.class)
    public void getSmsList() throws Exception {

        log.info("kkkkk");

        PInsertSmsElement pInsertSmsElement = new PInsertSmsElement();
        pInsertSmsElement.setTrSendDate("20231025");
        pInsertSmsElement.setTrPhone("01037690830");
        pInsertSmsElement.setTrCallBack("01031984329");
        pInsertSmsElement.setTrMsg("개발 테스트 메세지입니다.");
        pInsertSmsElement.setTrEtc3("TEST");
        smsService.insertSmsData(pInsertSmsElement);
    }
}

package com.damg.upit.monitor.dailyCheck;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableScheduling
@SpringBootApplication
public class DailyCheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyCheckApplication.class, args);
	}

}

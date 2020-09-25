package com.amarsoft.ysshao.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


//开启定时任务注解。
@EnableScheduling
@SpringBootApplication(scanBasePackages = "com.amarsoft")
public class SpringbootScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootScheduleApplication.class, args);
    }

}

package com.amarsoft.ysshao;

import com.amarsoft.ysshao.entities.CustomerInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@ComponentScan(basePackages={"com.amarsoft"})
@SpringBootApplication
@EnableScheduling//开启注解定时任务
@EnableCaching
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        System.out.println("项目启动开始...");
        SpringApplication.run(SpringbootDemoApplication.class, args);
        System.out.println("项目启动完成...");


    }

}

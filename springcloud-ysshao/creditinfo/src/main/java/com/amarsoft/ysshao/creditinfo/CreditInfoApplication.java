package com.amarsoft.ysshao.creditinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CreditInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditInfoApplication.class, args);
    }

}

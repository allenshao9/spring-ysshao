package com.amarsoft.ysshao.customer;

import com.amarsoft.ysshao.RibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
//自定义ribbon的规则
@RibbonClient(name = "creditinfo",configuration = RibbonRule.class)
//开启openfeign调用
@EnableFeignClients(basePackages = "com.amarsoft.ysshao.customer.service")
@EnableCircuitBreaker
@EnableHystrix
public class CustomerinfoApplication {

    public static void main(String[] args) {
        System.out.println();
        SpringApplication.run(CustomerinfoApplication.class, args);
    }

}

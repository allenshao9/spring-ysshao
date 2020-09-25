package com.amarsoft.ysshao.controller;

import com.amarsoft.ysshao.domain.UserInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ysshao
 * @create 2020-05-03 15:41
 */
@PropertySource(value = {"classpath:userinfo.properties"})
@RestController
public class PropertiesController {

    //获取application.yml配置文件的全局参数
    @Value("${server.port}")
    private String serverPort ;
    @Value("${userinfo.name}")
    private String name;
    @Value("${userinfo.address}")
    private String address;
    @Value("${userinfo.email}")
    private String email;


    //测试配置文件随机数
    @Value("${customer.customerid}")
    private String customerid;


    @GetMapping("/ymlprop")
    public String queryUserInfo(){
        System.out.println("==========================");
        System.out.println("全局端口号"+serverPort);

        System.out.println(name+"。"+address+"  "+email+"  ");

        System.out.println("customerid==="+customerid);
        return "Spring-boot-yml 参数配置";
    }

}

package com.amarsoft.ysshao.client.controller;/**
 * @author ysshao
 * @create 2020-10-02 21:45
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/10/2 21:45
 * @Version 1.0
 **/
@RestController
@RefreshScope
public class ConfigController {

    @Value("${config.info}")
    private String config;

    @GetMapping("/configtest")
    public String getConfig(){
        System.out.println("-------------");
        return config;
    }
}

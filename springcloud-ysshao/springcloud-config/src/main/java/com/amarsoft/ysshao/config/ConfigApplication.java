package com.amarsoft.ysshao.config;/**
 * @author ysshao
 * @create 2020-10-02 21:03
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/10/2 21:03
 * @Version 1.0
 **/
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }
}

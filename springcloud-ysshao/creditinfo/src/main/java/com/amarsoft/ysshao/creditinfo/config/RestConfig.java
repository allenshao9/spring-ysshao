package com.amarsoft.ysshao.creditinfo.config;/**
 * @author ysshao
 * @create 2020-09-28 17:52
 */

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/9/28 17:52
 * @Version 1.0
 **/

@Configuration
public class RestConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

}

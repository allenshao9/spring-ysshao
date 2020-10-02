package com.amarsoft.ysshao.customer.config;/**
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

/*
* 在springboot1.3版本中会默认提供一个RestTemplate的实例Bean，
* 当在springboot1.4以及以后的版本中，需要手动创建一个RestTemplate的配置：


 * */
@Configuration
public class RestConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

}

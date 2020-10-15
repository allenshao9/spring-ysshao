package com.amarsoft.ysshao.customer.config;/**
 * @author ysshao
 * @create 2020-10-14 17:21
 */

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/10/14 17:21
 * @Version 1.0
 **/
@Configuration
public class FeignConfig {

    //配置feign的调用日志级别 有4个级别
    @Bean
    Logger.Level feignLoggerLevel() {
        return  Logger.Level.FULL;
    }
}

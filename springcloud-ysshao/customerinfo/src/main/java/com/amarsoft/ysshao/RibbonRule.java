package com.amarsoft.ysshao;/**
 * @author ysshao
 * @create 2020-09-28 22:31
 */

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/9/28 22:31
 * @Version 1.0
 **/
@Configuration
public class RibbonRule {

    @Bean
    public IRule myRule() {
        return new RandomRule(); // 定义为随机
    }

}



package com.amarsoft.ysshao.controller;

import com.amarsoft.ysshao.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ysshao
 * @create 2020-05-03 17:00
 *
 * 测试@Bean 和 类的注解是一样的效果。
 *
 */
@RestController
public class SpringApplication {

    @Autowired
    ApplicationContext context = null;

  /*  @Bean
    public Customer customer(){
        return new Customer();
    }*/

    @GetMapping("/testbean")
    public String testBean(){
        Customer customer = (Customer) context.getBean("ccc");
        System.out.println(customer);

    return  "test Bean....";
    }

}

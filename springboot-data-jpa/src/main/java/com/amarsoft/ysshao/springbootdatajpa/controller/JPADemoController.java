package com.amarsoft.ysshao.springbootdatajpa.controller;/**
 * @author ysshao
 * @create 2020-09-24 17:21
 */

import com.amarsoft.ysshao.springbootdatajpa.entities.CustomerInfo;
import com.amarsoft.ysshao.springbootdatajpa.repository.CustomerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @Author AllenShao
 * @Description springboot jpa
 * @Date 2020/9/24 17:21
 * @Version 1.0
 **/
@RestController
public class JPADemoController {
    @Autowired
    private CustomerInfoRepository cir;

    @GetMapping("/jpatest")
    public CustomerInfo jpatest() {

        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setCustomername("张三");
        customerInfo.setCerttype("111");
        customerInfo.setCertid("4444");
        System.out.println(cir.save(customerInfo));
        CustomerInfo customerInfoByCertidIs = cir.findCustomerInfoByCertid("1111111111111111111");
        System.out.println(customerInfoByCertidIs.toString());
        System.out.println(cir.queryCustomerNameJPQL("王五"));
        List<CustomerInfo> customerInfos = cir.findCustomerByCerttypeContaining("32");
        System.out.println("============");
        System.out.println(Arrays.asList(customerInfos));

        System.out.println("---------------------");
        System.out.println(cir.queryCustomerInfo("王五"));
        return customerInfo;
    }

}

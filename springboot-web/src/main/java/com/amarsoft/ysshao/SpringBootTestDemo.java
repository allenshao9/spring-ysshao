package com.amarsoft.ysshao;/**
 * @author ysshao
 * @create 2020-09-12 14:38
 */

import com.amarsoft.ysshao.entities.CustomerInfo;
import com.amarsoft.ysshao.repository.CustomerInfoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/9/12 14:38
 * @Version 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTestDemo {

    @Autowired
    private CustomerInfoRepository cir;

    //SpringData JPA 测试代码
    @Test
    public  void test(){

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
    }
}

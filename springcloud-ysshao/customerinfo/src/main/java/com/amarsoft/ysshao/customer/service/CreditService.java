package com.amarsoft.ysshao.customer.service;/**
 * @author ysshao
 * @create 2020-09-28 23:21
 */

import com.amarsoft.ysshao.customer.common.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/9/28 23:21
 * @Version 1.0
 **/
@Component
/*@FeignClient(name="springcloud-product-provider", fallback = ProductFallbackServieImpl.class)
  feingclietn 本身也集成了Hystrix的功能。
  当请求异常是。自动请求对应的类。 需要实现同样的服务。 当请求服务异常宕机时。 自动调用指定的fallback的方法。 而不会在这边无尽的等待。
 */
@FeignClient(value = "CREDITINFO",fallback = CreditServiceImpl.class )
public interface CreditService {

    @GetMapping("/creditinfo/query/{customerid}")
     CommonResult queryCustomer(@PathVariable("customerid") String cusid);

    @GetMapping("/creditinfo/queryException/{customerid}")
    CommonResult queryCusException(@PathVariable("customerid") String cusid);

}

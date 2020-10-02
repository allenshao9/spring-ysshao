package com.amarsoft.ysshao.customer.controller;/**
 * @author ysshao
 * @create 2020-09-28 9:45
 */

import com.amarsoft.ysshao.customer.common.CommonResult;
import com.amarsoft.ysshao.customer.entity.CustomerInfo;
import com.amarsoft.ysshao.customer.service.CreditService;
import com.amarsoft.ysshao.customer.service.CustoemrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/9/28 9:45
 * @Version 1.0
 **/

@RestController()
@RequestMapping("/customerinfo")
@Slf4j
public class CustomerController {

    @Autowired
    private CustoemrService custoemrService;

   /* 如果使用Autowired注入
    idea的纠错机制在解析spring通过命名约定的方式进行配置时,
    支持的并不是太好，而用Autowired或Resource注入bean时，会报错。
    采用Resource
    */
    @Resource
    private RestTemplate restTemplate;

    @Autowired
    private CreditService creditService;

    //注意 PathParam是从get请求 也就是?后面的k=v中取值
    //PathVariable 是从路径中进行取值获取
    // GET 请求  http://localhost:8081/customerinfo/query/202000000002
    @GetMapping("/query/{customerid}")
    public CommonResult queryCustomer(@PathVariable("customerid") long cusid){
        CustomerInfo cInfo = custoemrService.queryCustomer(cusid);
        if (cInfo == null) {
            return CommonResult.error(cusid+"该客户信息不存在");
        }
        return CommonResult.ok(cInfo);
    }
    // POST请求  http://localhost:8081/customerinfo/save
    // Content-Type application/x-www-form-urlencoded  普通form表单发送
    @PostMapping("/save")
    public CommonResult saveCustomer(CustomerInfo cInfo){
       custoemrService.saveCustomer(cInfo);
        return CommonResult.okMsg("保存客户信息成功",cInfo);
    }

    // PUT请求  http://localhost:8081/customerinfo/update
    // Content-Type application/x-www-form-urlencoded  普通form表单发送
    @PutMapping("/update")
    public CommonResult updateCustomer(CustomerInfo cInfo){
        //保存客户信息
        CustomerInfo customerInfo = custoemrService.updateCustomer(cInfo);
        return CommonResult.okMsg("更新客户信息成功",customerInfo);
    }


    //PUT请求 http://localhost:8081/customerinfo/update/customername
    @PutMapping("/update/customername")
    public CommonResult updateCustomer( long customerid,String customername ){
        //保存客户信息
        custoemrService.updateCustomerName(customerid, customername);
        log.info("更新客户信息成功");
        return CommonResult.okMsg("更新客户信息名称成功",customername);
    }

    //Delete 请求
    @DeleteMapping("/delete/{customerid}")
    public CommonResult delteCustomer(@PathVariable("customerid") Long customerid){
        //保存客户信息
        custoemrService.deleteCustomer(customerid);
        log.info("更新客户信息成功");
        return CommonResult.okMsg("删除客户信息名称成功",null);
    }

    //查询客户的授信信息
    @GetMapping("/queryCreditInfo/{customerid}")
    public CommonResult queryCreditInfo(@PathVariable("customerid") long cusid){
        log.info("RestTemplate调用授信服务模块");
//        RestTemplate restTemplate = new RestTemplate();
        CommonResult forObject = restTemplate.getForObject("http://creditinfo/creditinfo/query/"+cusid, CommonResult.class);
        return forObject;
    }

    @GetMapping("/queryCreditInfoFeign/{customerid}")
    public CommonResult queryCreditInfo2(@PathVariable("customerid") String cusid){
        log.info("OpenFeign调用授信服务模块");
        return creditService.queryCustomer(cusid);
    }

    @GetMapping("/queryCreditInfoFeign1/{customerid}")
    public CommonResult queryCreditInfo3(@PathVariable("customerid") String cusid){
        log.info("queryCreditInfo3调用授信服务模块");
        return creditService.queryCusException(cusid);
    }

}

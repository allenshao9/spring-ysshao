package com.amarsoft.ysshao.creditinfo.controller;/**
 * @author ysshao
 * @create 2020-09-28 9:45
 */

import com.amarsoft.ysshao.creditinfo.common.CommonResult;
import com.amarsoft.ysshao.creditinfo.entity.CreditInfo;
import com.amarsoft.ysshao.creditinfo.service.CreditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/9/28 9:45
 * @Version 1.0
 **/

@RestController()
@RequestMapping("/creditinfo")
@Slf4j
public class CreditController {

    @Autowired
    private CreditService creditService;

    //注意 PathParam是从get请求 也就是?后面的k=v中取值
    //PathVariable 是从路径中进行取值获取
    @GetMapping("/query/{customerid}")
    public CommonResult queryCustomer(@PathVariable("customerid") String cusid){
        log.info("queryCustomer========"+cusid);
        List<CreditInfo> creditInfos = creditService.queryCreditInfo(cusid);
        if (creditInfos == null) {
            return CommonResult.error(cusid+"该客户授信信息不存在");
        }
        return CommonResult.ok(creditInfos);
    }
    // Content-Type application/x-www-form-urlencoded  普通form表单发送
    @PostMapping("/save")
    public CommonResult saveCustomer(CreditInfo cInfo){
        creditService.saveCreditInfo(cInfo);
        return CommonResult.okMsg("保存授信信息成功",cInfo);
    }


    @GetMapping("/queryException/{customerid}")
    public CommonResult queryCusException(@PathVariable("customerid") String cusid) throws Exception {
        log.info("queryCusException========"+cusid);
        if(Integer.valueOf(cusid) >10000000){
            throw new Exception("客户号不符合要求。返回异常");
        }
        return  CommonResult.okMsg("保存授信信息成功","成功！！！");
    }

}

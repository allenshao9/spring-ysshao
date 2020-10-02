package com.amarsoft.ysshao.customer.service;/**
 * @author ysshao
 * @create 2020-09-29 15:04
 */

import com.amarsoft.ysshao.customer.common.CommonResult;
import org.springframework.stereotype.Component;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/9/29 15:04
 * @Version 1.0
 **/
@Component
public class CreditServiceImpl implements CreditService{
    @Override
    public CommonResult queryCustomer(String cusid) {
        return CommonResult.error("queryCustomer查询客户异常");
    }

    @Override
    public CommonResult queryCusException(String cusid) {
        return CommonResult.error("queryCusException查询客户异常");
    }
}

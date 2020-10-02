package com.amarsoft.ysshao.customer.service;/**
 * @author ysshao
 * @create 2020-09-28 11:41
 */

import com.amarsoft.ysshao.customer.entity.CustomerInfo;
import com.amarsoft.ysshao.customer.repository.CustomerInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/9/28 11:41
 * @Version 1.0
 **/

@Service
@Slf4j
public class CustoemrService {

    @Autowired
    private CustomerInfoRepository customerInfoRepository;

    public CustomerInfo queryCustomer(long cusid){
        //查询该客户的信息
        CustomerInfo cInfo = customerInfoRepository.findCustomerInfoByCustomerid(cusid);
        log.info("查询用户信息:"+cusid);
        return  cInfo;
    }

    public CustomerInfo saveCustomer(CustomerInfo cInfo){
        //保存客户信息
        CustomerInfo customerInfo = customerInfoRepository.save(cInfo);
        log.info("保存用户信息成功");
        return customerInfo;
    }

    public CustomerInfo updateCustomer(CustomerInfo cInfo){
        //保存客户信息
        log.info(cInfo.toString());
        CustomerInfo customerInfo = customerInfoRepository.save(cInfo);
        log.info("更新用户信息成功");
        return customerInfo;
    }
    /**
    指定字段更新信息
    //  @Transactional  不加事务会 Executing an update/delete query] with root cause
    * */
    @Transactional
    public int updateCustomerName(long customerid,String customername){
        //保存客户信息
        int cnt = customerInfoRepository.updateCustoemrInfoBycustomerid(customername, customerid);
        log.info("更新用户信息名称成功");
        return cnt;
    }

    @Transactional // 不加事务会 Executing an update/delete query] with root cause
    public void deleteCustomer(Long customerid){
        //删除客户信息
        log.info(String.valueOf(customerid));
        customerInfoRepository.deleteById(customerid);
        log.info("删除用户信息成功");
    }

}

package com.amarsoft.ysshao.creditinfo.service;/**
 * @author ysshao
 * @create 2020-09-28 11:41
 */

import com.amarsoft.ysshao.creditinfo.entity.CreditInfo;
import com.amarsoft.ysshao.creditinfo.repository.CreditInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/9/28 11:41
 * @Version 1.0
 **/

@Service
@Slf4j
public class CreditService {

    @Autowired
    private CreditInfoRepository  creditInfoRepository;

    public  List<CreditInfo>  queryCreditInfo(String  customerid){
        //查询该客户授信信息
        List<CreditInfo>  cInfoList = creditInfoRepository.queryCreditInfo(customerid);
        return  cInfoList;
    }

    public  void  saveCreditInfo(CreditInfo  creditInfo){
        creditInfoRepository.save(creditInfo);
        log.info("保存授信信息成功！");
    }

}

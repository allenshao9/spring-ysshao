package com.amarsoft.ysshao.domain;

import org.springframework.stereotype.Component;

/**
 * @author ysshao
 * @create 2020-05-03 17:07
 */

@Component("ccc")
public class Customer {

    private String customerid;
    private String customername;

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }
}

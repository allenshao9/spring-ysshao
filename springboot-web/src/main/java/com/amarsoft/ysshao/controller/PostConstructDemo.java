package com.amarsoft.ysshao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author ysshao
 * @create 2020-05-03 21:44
 */

@Controller
public class PostConstructDemo {

    Logger logger = LoggerFactory.getLogger(PostConstructDemo.class);
    @PostConstruct
    public void init(){
        logger.info("系统启动初始化方法 相当于servlet 。init方法");
        logger.debug("日志测试。。。");
    }



    @PreDestroy
    public void destory(){

       logger.info("系统销毁方法。。  相当于servlet中的destory");
       logger.debug("日志测试。。。");

    }


    public String  test(String userid,int i){
       return "";
    }
}

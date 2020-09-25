package com.amarsoft.ysshao.controller;

import com.amarsoft.ysshao.domain.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Map;

/**
 * @author ysshao
 * @create 2020-05-02 23:02
 */


@Controller
public class ThymeleafController {

    private UserInfo userInfo;

    @GetMapping("thymeleaf")
    public String test(Model model){
        //ModelAndView modelAndView = new ModelAndView();
        System.out.println("thymeleaf模板测试....");
        model.addAttribute("userInfo","allen");
        //modelAndView.setViewName("thymeleaf.html");
        Logger logger = LoggerFactory.getLogger(ThymeleafController.class);
        logger.info("Hello World");

        return  "thymeleaf";
    }

    @GetMapping("thymeleafArr")
    public String testArr(Map<String,Object> map){
        //ModelAndView modelAndView = new ModelAndView();
        System.out.println("thymeleaf模板测试....");
        UserInfo userInfo = new UserInfo();
        userInfo.setAddress("绿地");
        userInfo.setUsername("张三");
        userInfo.setEmail("ysshao@amarsoft.com");
        map.put("users", Arrays.asList("张三","李四","王五"));
        //modelAndView.setViewName("thymeleaf.html");
        Logger logger = LoggerFactory.getLogger(ThymeleafController.class);
        logger.info("Hello World");
        return  "thymeleafObj";
    }
    
}

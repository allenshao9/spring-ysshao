package com.amarsoft.ysshao.controller;

import com.amarsoft.ysshao.demo.UserNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author ysshao
 * @create 2020-05-05 9:11
 *
 *  请求登陆的控制器
 */

@Slf4j
@Controller
public class UserLoginController {

    Logger logger = LoggerFactory.getLogger(UserLoginController.class);
    //验证登陆用户名 和 密码。 并对其进行校验 默认增加校验
    @PostMapping("/user/action")
    public String login(@RequestParam(value = "Username") String username,
                        @RequestParam(value = "Password",required = true) String password,
                        Map<String,Object> map, HttpSession session){
        logger.info("用户名:"+username);
        logger.info("密码:"+password);
        log.info("日志测试................");
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("loginuser",username);
            logger.info(username+" 登陆成功！");
            return "redirect:/main.html";
        }else{
            map.put("errmsg","用户名和密码错误！");
            return "login";
        }

    }
    //异常测试。。
    @GetMapping("/exception")
    public String testexception(){
        System.out.println(1);
        throw new UserNotExistException();
    }

}

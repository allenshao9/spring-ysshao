package com.amarsoft.ysshao.gateway.controller;/**
 * @author ysshao
 * @create 2020-10-08 21:28
 */

import com.amarsoft.ysshao.gateway.entity.LoginRequest;
import com.amarsoft.ysshao.gateway.entity.LoginResponse;
import com.amarsoft.ysshao.gateway.service.LoginService;
import com.amarsoft.ysshao.gateway.util.CommonResult;
import com.amarsoft.ysshao.gateway.util.RetCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/10/8 21:28
 * @Version 1.0
 **/
@RestController
@Slf4j
public class LoginController {

    @Autowired
    LoginService loginService;
    @Autowired
    LoginResponse loginResponse;
    //验证登陆用户名 和 密码。 并对其进行校验 默认增加校验
    @PostMapping("/login")
    public CommonResult login( LoginRequest loginRequest, BindingResult bindingResult){

        //判断参数是否合理。
        if (bindingResult.hasErrors()) {
            return new CommonResult(
                    RetCodeEnum.PARAMETER_ILLEGAL.getCode(),
                    RetCodeEnum.PARAMETER_ILLEGAL.getMessage());
        }

        String userid = loginRequest.getUserid();
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        String jwt ="";
        boolean flag = loginService.checkUser(userid, password);

        //用户不存在或密码错误
        if(!flag){
           return new CommonResult(
                    RetCodeEnum.LOGIN_ERROR.getCode(),
                    RetCodeEnum.LOGIN_ERROR.getMessage());
        }else{
            //生产token
            jwt = loginService.createJwt(userid, username);
        }
        System.out.println("----"+loginResponse.hashCode());
        loginResponse.setJwtmsg(jwt);
        loginResponse.setUserid(userid);
        return CommonResult.ok(loginResponse);
    }

}

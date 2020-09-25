package com.amarsoft.ysshao.controller;

import com.amarsoft.ysshao.domain.UserInfo;
import com.amarsoft.ysshao.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author ysshao
 * @create 2020-05-02 21:29
 */

@RestController
public class UserInfoController {
    @Autowired
    private UserInfoRepository uir;


    /*public UserInfoController(UserInfoRepository uir) {
        this.uir = uir;
    }*/

    @PostMapping("/user/save")
    public UserInfo saveUserInfo(@RequestParam(required = true) String name, String address, @RequestParam(value = "myemail",required = false) String email){
        System.out.println("==========================");
        UserInfo userInfo = uir.saveUserInfo(name, address, email);

        return userInfo;
    }

    @GetMapping("/user/query")
    public UserInfo queryUserInfo(@RequestParam(required = true) String name){

        System.out.println("==========================");
        UserInfo userInfo = uir.queryInfo(name);

        return userInfo;
    }
    @GetMapping("/user/queryall")
    public Collection<UserInfo> queryall(){

        System.out.println("==========================");
        Collection<UserInfo> userInfos = uir.queryAll();

        return userInfos;
    }

    @PutMapping("/user/update")
    public UserInfo updateUserInfo(@RequestParam(required = true) String name, String address){

        UserInfo info = uir.updateUserData(name, address);
        return  info;

    }

}

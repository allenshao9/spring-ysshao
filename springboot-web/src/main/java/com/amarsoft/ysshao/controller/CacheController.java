package com.amarsoft.ysshao.controller;/**
 * @author ysshao
 * @create 2020-09-15 18:52
 */

import com.amarsoft.ysshao.cache.CacheDemo;
import com.amarsoft.ysshao.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/9/15 18:52
 * @Version 1.0
 **/
@RestController
public class CacheController {

    @Autowired
    private CacheDemo cacheDemo;

    @PostMapping("/cacheDemo")
    public UserInfo getuinfo(String username){
        System.out.println("------");
        return cacheDemo.getUserInfo(username);
    }

}

package com.amarsoft.ysshao.cache.controller;/**
 * @author ysshao
 * @create 2020-09-24 23:32
 */

import com.amarsoft.ysshao.redis.RedisDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/9/24 23:32
 * @Version 1.0
 **/
@RestController
public class RedisController {

    @Autowired
    RedisDemo redisDemo;

    @GetMapping(value = "/redistest")
    public String redistest(){
        redisDemo.redisTest();
        redisDemo.redisTestOBj();
        redisDemo.redisTest1();
        redisDemo.redisTest2();
        return "Redis test";
    }
}

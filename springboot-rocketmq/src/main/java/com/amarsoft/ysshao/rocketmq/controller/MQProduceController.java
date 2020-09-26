package com.amarsoft.ysshao.rocketmq.controller;/**
 * @author ysshao
 * @create 2020-09-25 15:26
 */

import com.amarsoft.ysshao.rocketmq.constant.MQConstant;
import com.amarsoft.ysshao.rocketmq.entity.CommonResult;
import com.amarsoft.ysshao.rocketmq.entity.UserInfo;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @Author AllenShao
 * @Description //TODO
 * @Date 2020/9/25 15:26
 * @Version 1.0
 **/
@RestController
public class MQProduceController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Autowired
    private UserInfo userInfo;

    @Autowired
    private CommonResult commonResult;

    @GetMapping(value = "/mqtest")
    public String testRocketMq() {

        String name = "Hello RocketMQ" + new Random().nextInt(20);
        //convertAndSend
        //同步消息
        rocketMQTemplate.getProducer().setProducerGroup("ysshao-");
        rocketMQTemplate.syncSend(MQConstant.TOPIC, name);
        rocketMQTemplate.syncSend(MQConstant.TOPIC, name+"gg");

        System.err.println("发送成功...");
        return "RocketMQ Rroducer Success";
    }

    @GetMapping(value = "/mqtestObj")
    public CommonResult testRocketObj() {

        userInfo.setEmail(new Random().nextInt(20) + "111@163.com");
        userInfo.setUsername("科比");
        userInfo.setUserid("kobe");
        commonResult.setCode(200);
        commonResult.setMessage("插入成功");
        commonResult.setData(userInfo);
        rocketMQTemplate.syncSend(MQConstant.TOPICOBJ, MessageBuilder.withPayload(commonResult).build());
        System.err.println("发送成功...");
        return commonResult;
    }

}

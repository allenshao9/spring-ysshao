package com.amarsoft.ysshao.activemq.producer;/**
 * @author ysshao
 * @create 2021-01-21 10:11
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2021/1/21 10:11
 * @Version 1.0
 **/

@RestController
public class ProviderController {

    @Value("${queueName}")
    private String queuename;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;



    @GetMapping("/sendMsg")
    public String sendMsg(String username){
//        System.out.println(username);
        if(new Random().nextInt(10)>5){
            jmsMessagingTemplate.convertAndSend(queuename, username);
        }else{
            jmsMessagingTemplate.convertAndSend("ysshao.A", username);
        }

        return  "发送MQ消息成功"+username;
    }

    @GetMapping("/sendObj")
    public String sendObj(String username){
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setUserid("111");
        jmsMessagingTemplate.convertAndSend("ysshao.Obj", userInfo);

        return  "发送MQ消息成功"+username;
    }


}

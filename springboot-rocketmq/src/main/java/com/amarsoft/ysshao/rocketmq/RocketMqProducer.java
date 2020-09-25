package com.amarsoft.ysshao.rocketmq;/**
 * @author ysshao
 * @create 2020-09-25 14:51
 */

import com.amarsoft.ysshao.rocketmq.entity.UserInfo;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/9/25 14:51
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RocketMqProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public  void testRocketMq(){

        String name = "Hello RocketMQ";
        rocketMQTemplate.convertAndSend("test-topic-1", name);
        UserInfo userInfo = new UserInfo("test11", "王五", "haha@163.com");

        rocketMQTemplate.send("test-topic-2", MessageBuilder.withPayload(userInfo).build());
        System.err.println("发送成功...");
    }

}

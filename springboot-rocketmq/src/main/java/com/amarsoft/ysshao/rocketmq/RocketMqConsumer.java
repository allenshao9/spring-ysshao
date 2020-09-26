package com.amarsoft.ysshao.rocketmq;/**
 * @author ysshao
 * @create 2020-09-25 14:51
 */

import com.amarsoft.ysshao.rocketmq.constan.MQConstan;
import com.amarsoft.ysshao.rocketmq.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author AllenShao
 * @Description //TODO
 * @Date 2020/9/25 14:51
 * @Version 1.0
 **/

/*RocketMQMessageListener 注解
    consumeMode 消费模式
        默认值 ConsumeMode.CONCURRENTLY 并行处理
        ConsumeMode.ORDERLY 按顺序处理
    messageModel 消息模型
        默认值 MessageModel.CLUSTERING 集群   多个消费者不会被重复消费同一个信息。
        MessageModel.BROADCASTING 广播
 */

@Component
@RocketMQMessageListener(topic = MQConstan.TOPIC,messageModel=MessageModel.CLUSTERING, consumerGroup = MQConstan.CONSUMER_GROUP)
@Slf4j
public class RocketMqConsumer implements RocketMQListener<String> {


    @Override
    public void onMessage(String s) {
        log.info("消费消息:" + s);
    }
}

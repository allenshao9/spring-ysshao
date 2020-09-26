package com.amarsoft.ysshao.rocketmq;/**
 * @author ysshao
 * @create 2020-09-25 14:51
 */

import com.amarsoft.ysshao.rocketmq.constant.MQConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

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
@RocketMQMessageListener(topic = MQConstant.TOPIC,messageModel=MessageModel.CLUSTERING, consumerGroup = MQConstant.CONSUMER_GROUP)
@Slf4j
public class RocketMqConsumer implements RocketMQListener<String> {


    @Override
    public void onMessage(String s) {
        log.info("消费消息:" + s);
        log.info(".....");
        log.info("1111");
    }
}

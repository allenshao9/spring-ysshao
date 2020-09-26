package com.amarsoft.ysshao.rocketmq;/**
 * @author ysshao
 * @create 2020-09-25 14:51
 */

import com.amarsoft.ysshao.rocketmq.constan.MQConstant;
import com.amarsoft.ysshao.rocketmq.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @Author AllenShao
 * @Description 消费对象
 * @Date 2020/9/25 14:51
 * @Version 1.0
 **/
@Component
@RocketMQMessageListener(topic = MQConstant.TOPICOBJ, consumerGroup = MQConstant.CONSUMER_GROUP_OBJ)
@Slf4j
public class RocketMqConsumerObj implements RocketMQListener<CommonResult> {


    @Override
    public void onMessage(CommonResult s) {
        log.info("消费消息:" + s.toString());
    }
}

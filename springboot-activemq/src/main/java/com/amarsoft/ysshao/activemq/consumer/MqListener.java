package com.amarsoft.ysshao.activemq.consumer;/**
 * @author ysshao
 * @create 2021-01-21 10:42
 */

import com.amarsoft.ysshao.activemq.producer.UserInfo;
import lombok.extern.java.Log;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2021/1/21 10:42
 * @Version 1.0
 **/

@Component
@Log
public class MqListener {

    @JmsListener(destination = "ysshao.queue")
    public void receiveQueue(String text) {
        log.info("Message Received: " + text);
    }


    @JmsListener(destination = "ysshao.A")
    public void receiveQueueA(String text) {
        log.info("======A====Message Received: " + text);
    }

    @JmsListener(destination = "ysshao.Obj")
    public void receiveQueue(UserInfo userInfo) {
        log.info("Message Received: " + userInfo.toString());
    }
}

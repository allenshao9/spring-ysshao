package com.amarsoft.ysshao.activemq.producer;/**
 * @author ysshao
 * @create 2021-01-21 10:53
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2021/1/21 10:53
 * @Version 1.0
 **/
@Data
@Component
public class UserInfo implements Serializable {

    public String username;
    public String userid;
}

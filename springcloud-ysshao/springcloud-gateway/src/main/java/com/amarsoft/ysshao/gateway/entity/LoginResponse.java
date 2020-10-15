package com.amarsoft.ysshao.gateway.entity;/**
 * @author ysshao
 * @create 2020-10-08 21:29
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/10/8 21:29
 * @Version 1.0
 **/
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

    private String userid;
    private String jwtmsg;

}

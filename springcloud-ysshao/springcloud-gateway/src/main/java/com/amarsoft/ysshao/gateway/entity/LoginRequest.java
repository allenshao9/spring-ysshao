package com.amarsoft.ysshao.gateway.entity;/**
 * @author ysshao
 * @create 2020-10-08 21:29
 */

import org.springframework.stereotype.Component;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/10/8 21:29
 * @Version 1.0
 **/
@Component
public class LoginRequest {

    private String userid;
    private String username;
    private String password;


    public LoginRequest(String userid, String username, String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    public LoginRequest() {
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

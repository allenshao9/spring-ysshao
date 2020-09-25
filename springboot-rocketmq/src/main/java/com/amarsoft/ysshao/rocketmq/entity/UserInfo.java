package com.amarsoft.ysshao.rocketmq.entity;/**
 * @author ysshao
 * @create 2020-09-24 21:28
 */

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/9/24 21:28
 * @Version 1.0
 **/

@Component
public class UserInfo implements  Serializable {


    private static final long serialVersionUID = 5730461211833452057L;
    private String userid;
    private String username;
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public UserInfo(String userid, String username, String email) {
        this.userid = userid;
        this.username = username;
        this.email = email;
    }

    public UserInfo() {
    }
}

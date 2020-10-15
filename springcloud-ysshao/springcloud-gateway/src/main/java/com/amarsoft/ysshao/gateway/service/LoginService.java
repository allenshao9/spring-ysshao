package com.amarsoft.ysshao.gateway.service;/**
 * @author ysshao
 * @create 2020-10-08 22:03
 */

import com.amarsoft.ysshao.gateway.util.JWTUtils;
import com.amarsoft.ysshao.gateway.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/10/8 22:03
 * @Version 1.0
 **/
@Service
public class LoginService {

    @Autowired
    private MD5Utils md5Utils;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    JWTUtils jwtUtils;

    public boolean checkUser(String userid,String password){

        System.out.println("jwtUtils---"+jwtUtils.hashCode());
        String passwd = null;
        try {
            passwd = jdbcTemplate.queryForObject("select password from USER_INFO where userid=?", String.class, userid);
        } catch (EmptyResultDataAccessException e) {
            //不存在结果，则直接返回，证明没有该用户
            return false;
        }
        //用户不存在
        if(StringUtils.isEmpty(passwd)){
            return false;
        }
        //判断密码是否正确
        if(!passwd.equals(md5Utils.stringToMD5(password))){
            return false;
        }
        return true;
    }

    public boolean verityToken(String token){

        return  jwtUtils.verity(token);
    }


    public String createJwt(String userid,String username){
        String sign = jwtUtils.sign(userid, username);
        return sign;
    }


}

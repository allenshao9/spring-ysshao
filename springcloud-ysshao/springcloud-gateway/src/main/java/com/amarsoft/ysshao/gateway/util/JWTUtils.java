package com.amarsoft.ysshao.gateway.util;/**
 * @author ysshao
 * @create 2020-10-08 20:38
 */

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/10/8 20:38
 * @Version 1.0
 **/
@Component
public class JWTUtils {

    /**
     * 过期时间为一天
     * TODO 正式上线更换为15分钟
     */
    private static final long EXPIRE_TIME = 15*60*1000;

    /**
     * token私钥
     */
    private static final String TOKEN_SECRET = "123456";


    public static void main(String[] args) {

        int code = RetCodeEnum.SUCCESS.getCode();
        String message = RetCodeEnum.SUCCESS.getMessage();

        //1746572565
//        base64test();

        System.out.println(sign("张三","test11"));

        System.out.println("验证token是否真实");
        System.out.println(verity("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJsb2dpbk5hbWUiOiLlvKDkuIkiLCJleHAiOjE2MDIxNjE3MTIsInVzZXJJZCI6InRlc3QxMSIsImlhdCI6MTYwMjE2MDgxMn0.7tmrjcXzGx8o8-Cu_7JNFey-vJEp4ljPMpjMST7pZYE"));
    }

    private static void base64test() {
        try {
            // 使用基本编码
            String base64encodedString = Base64.getEncoder().encodeToString("2342342342423423423".getBytes("utf-8"));
            System.out.println("Base64 编码字符串 (基本) :" + base64encodedString);
            // 解码
            byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);

            System.out.println("原始字符串: " + new String(base64decodedBytes, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成签名,15分钟后过期
     * @param userId
     * @param username
     * @return
     */
    public static String sign(String userId,String username){
        //过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        //私钥及加密算法
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        //设置头信息
        HashMap<String, Object> header = new HashMap<>(2);
        header.put("typ", "JWT");
        header.put("alg", "HS256");

        //附带username和userID生成签名
        return JWT.create().withHeader(header)//head信息
                .withClaim("loginName",username)//payload 私有声明 一般存放用户信息
                .withClaim("userId",userId)
                .withIssuer("ysshao")
                //设置过期时间
                .withIssuedAt(new Date()).withExpiresAt(date)
                .sign(algorithm);//签名
    }

    public static boolean verity(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);//可以获取相关信息
            try {
                String header = jwt.getHeader();
                System.out.println(jwt.getId());
                System.out.println(header);
                System.out.println(jwt.getAlgorithm());
                System.out.println(jwt.getContentType());
                System.out.println(jwt.getClaim("loginName").asString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        } catch (JWTVerificationException e) {
            return false;
        }
    }
}

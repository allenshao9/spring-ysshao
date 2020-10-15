package com.amarsoft.ysshao.gateway.util;/**
 * @author ysshao
 * @create 2020-10-08 22:00
 */

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/10/8 22:00
 * @Version 1.0
 **/
@Component
public class MD5Utils {

    public static void main(String[] args) {
        System.out.println(stringToMD5("000000als"));
    }

    public static String stringToMD5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code.toUpperCase();
    }
}

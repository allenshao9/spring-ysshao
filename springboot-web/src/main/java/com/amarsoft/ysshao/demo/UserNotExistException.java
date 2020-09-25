package com.amarsoft.ysshao.demo;/**
 * @author ysshao
 * @create 2020-09-11 22:34
 */

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/9/11 22:34
 * @Version 1.0
 **/
public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super("用户不存在");
    }
}


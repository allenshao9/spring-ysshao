package com.amarsoft.ysshao.cache;/**
 * @author ysshao
 * @create 2020-09-15 18:45
 */

import com.amarsoft.ysshao.domain.UserInfo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/9/15 18:45
 * @Version 1.0
 **/

@Component
public class CacheDemo {

    @Cacheable(cacheNames = "uinfo")
    public UserInfo getUserInfo(String username){
        System.out.println("测试缓存"+username);
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("张三");
        userInfo.setEmail("112@163.com");
        return  userInfo;
    }

}

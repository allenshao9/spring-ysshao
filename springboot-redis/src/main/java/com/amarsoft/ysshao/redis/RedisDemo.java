package com.amarsoft.ysshao.redis;/**
 * @author ysshao
 * @create 2020-09-24 23:25
 */

import com.amarsoft.ysshao.cache.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/9/24 23:25
 * @Version 1.0
 **/

@Component
public class RedisDemo {

    @Autowired
    // 操作字符串的Redis
    private StringRedisTemplate redisTemplate;

    //操作Redis 对象
    @Autowired
    private RedisTemplate<Object,Object> redisTemplateObj;

    //直接使用redis工具类操作
    @Autowired
    private RedisUtil redisUtil;

    public void redisTest(){
        System.out.println(redisTemplate.opsForValue());
        redisTemplate.opsForValue().set("redis", "Hello Redis");
        System.out.println(redisTemplate.opsForValue().get("A"));
    }

    public void redisTestOBj(){

        redisTemplateObj.opsForValue().set("AAAA", "gggggggg");
        System.out.println(redisTemplateObj.opsForValue().get("AAAA").equals("gggggggg"));

        //序列化字符串。增加可读性  否则redis后台去查看时 并不是userinfo字符串
        redisTemplateObj.setKeySerializer(new StringRedisSerializer());
        UserInfo userInfo = new UserInfo();
        userInfo.setUserid("111");
        userInfo.setUsername("张三");
        userInfo.setEmail("123@163.com");
        redisTemplateObj.opsForValue().set("userinfoObj", userInfo);
        Object userinfo = redisTemplateObj.opsForValue().get("userinfoObj");
        System.out.println(userInfo.toString());

    }

    public void redisTest1(){

        redisUtil.set("redistest", "vvvv".toString(),10);

    }

    //redis中的事务操作
    /*
    * 更常见的写法仍是采用 RedisTemplate 的默认配置，即不开启事务支持。
    * 但是，我们可以通过使用 SessionCallback，该接口保证其内部所有操作都是在同一个Session中。测试代码如下：
    *
    *  SessionCallback<Object> callback = new SessionCallback<Object>() {
        @Override
        public Object execute(RedisOperations operations) throws DataAccessException {
            operations.multi();
            operations.opsForValue().set("name", "qinyi");
            operations.opsForValue().set("gender", "male");
            operations.opsForValue().set("age", "19");
            return operations.exec();
        }
    };

    // [true, true, true]
    System.out.println(stringRedisTemplate.execute(callback));

    * */
    public void redisTest2(){
        //redis 中开启事务的支持。 注意并不是开启事务
        redisTemplateObj.setEnableTransactionSupport(true);
        redisTemplateObj.multi();//开启事务。 需要和上面先开启。否则报错
        redisTemplateObj.opsForValue().set("tran1", "ggg");
        redisTemplateObj.opsForValue().set("tran2", "55555");
        redisTemplateObj.exec();

    }
}

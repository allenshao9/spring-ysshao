package com.amarsoft.ysshao.cache.controller;/**
 * @author ysshao
 * @create 2020-09-24 21:24
 */

import com.amarsoft.ysshao.cache.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 *
 * @Author AllenShao
 * @Description
 * @Date 2020/9/24 21:24
 * @Version 1.0
     * Cache	缓存接口，定义缓存操作。实现有：RedisCache、EhCacheCache、ConcurrentMapCache等
     * CacheManager	缓存管理器，管理各种缓存（cache）组件
     * @Cacheable 主要针对方法配置，能够根据方法的请求参数对其进行缓存
     * @CacheEvict 清空缓存
     * @CachePut 保证方法被调用，又希望结果被缓存。
     * 与@Cacheable区别在于是否每次都调用方法，常用于更新
     * @EnableCaching 开启基于注解的缓存
     * keyGenerator	缓存数据时key生成策略
     * serialize	缓存数据时value序列化策略
     * @CacheConfig 统一配置本类的缓存注解的属性
 *
 * ConcurrentMapCacheManager	使用ConcurrentMap作为缓存技术（默认），需要显式的删除缓存，无过期机制
 **/
@RestController
@Slf4j
public class CacheDemoController {

    @Autowired
    private UserInfo userInfo;


    /*
    * value、cacheNames：两个等同的参数（cacheNames为Spring 4新增，作为value的别名），用于指定缓存存储的集合名。由于Spring 4中新增了@CacheConfig，因此在Spring 3中原本必须有的value属性，也成为非必需项了
        key：缓存对象存储在Map集合中的key值，非必需，缺省按照函数的所有参数组合作为key值，若自己配置需使用SpEL表达式，比如：@Cacheable(key = “#p0”)：使用函数第一个参数作为缓存的key值
        condition：缓存对象的条件，非必需，也需使用SpEL表达式，只有满足表达式条件的内容才会被缓存，比如：@Cacheable(key = “#p0”, condition = “#p0.length() < 3”)，表示只有当第一个参数的长度小于3的时候才会被缓存
        unless：另外一个缓存条件参数，非必需，需使用SpEL表达式。它不同于condition参数的地方在于它的判断时机，该条件是在函数被调用之后才做判断的，所以它可以通过对result进行判断。
        keyGenerator：用于指定key生成器，非必需。若需要指定一个自定义的key生成器，我们需要去实现org.springframework.cache.interceptor.KeyGenerator接口，并使用该参数来指定。需要注意的是：该参数与key是互斥的
        cacheManager：用于指定使用哪个缓存管理器，非必需。只有当有多个时才需要使用
        cacheResolver：用于指定使用那个缓存解析器，非必需。需通过org.springframework.cache.interceptor.CacheResolver接口来实现自己的缓存解析器，并用该参数指定。
    * */

    //userinfo会作为缓存名。  userid则会作为key值。返回结果作为Value  第一次查询没有在缓存中 会存放到缓存中。
    //后续在查询 则不会进入改方法。 用于存放热点数据。
    @Cacheable(cacheNames = "userinfo",key = "#p0")
    @GetMapping(value = "/queryUserinfo")
    public UserInfo queryUserinfo(@RequestParam  String userid){
        log.info("查询用户信息..."+userid);
        //缓存失效后 userinfo为null
        if (userInfo == null) {
            return userInfo;
        }

        userInfo.setEmail("111@163.com");
        userInfo.setUserid(userid);
        userInfo.setUsername("周杰伦");
        return userInfo;
    }

    //用于改变了数据后。 更新缓存。
    @CachePut(cacheNames = "userinfo",key = "#p0")
    @GetMapping(value = "/updateUserinfo")
    public UserInfo updateUserinfo(@RequestParam  String userid){
        log.info("更新用户信息..."+userid);
        userInfo.setEmail("111@163.com");
        userInfo.setUserid(userid);
        userInfo.setUsername("周杰伦"+ new Random().nextInt(20));
        return userInfo;
    }
    //用于删除数据后。 把缓存失效。 allEntries=true 这个属性是清空改cache下的所有缓存
    @CacheEvict(cacheNames = "userinfo",key = "#p0")
    @GetMapping(value = "/deleteUserinfo")
    public UserInfo deleteUserinfo(@RequestParam  String userid){
        log.info("删除用户信息..."+userid);
        userInfo=null;
        return userInfo;
    }


}

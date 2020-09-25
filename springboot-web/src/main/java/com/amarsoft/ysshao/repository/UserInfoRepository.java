package com.amarsoft.ysshao.repository;

import com.amarsoft.ysshao.domain.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ysshao
 * @create 2020-05-02 21:15
 */
@Repository
public class UserInfoRepository {

    private  ConcurrentHashMap<Integer,UserInfo> uimap = new ConcurrentHashMap<Integer,UserInfo>();
    private AtomicInteger ai = new  AtomicInteger();

    //保存数据
    public UserInfo saveUserInfo(String name,String address ,String email){

        int i = ai.decrementAndGet();
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(name);
        userInfo.setAddress(address);
        userInfo.setEmail(email);
        uimap.put(i,userInfo);
        System.out.println(userInfo);
        return  userInfo;
    }
    //提供name参数 查询方法
    public UserInfo queryInfo(String name){
        UserInfo userInfo = null;
        Collection<UserInfo> values = uimap.values();
        for(UserInfo ui:values){
            if(name.equals(ui.getUsername())){
                return ui;
            }
        }
        return userInfo;
    }

    //查询全部数据。已集合形式放回
    public Collection<UserInfo> queryAll(){
        Collection<UserInfo> values = uimap.values();
        return values;
    }

    //根据name更新地址信息
    public UserInfo updateUserData(String name,String address){
        for(Map.Entry<Integer,UserInfo> entry:uimap.entrySet() ){

            System.out.println(entry.getKey());
            UserInfo value = entry.getValue();
            if(name.equals(value.getUsername())){
                value.setAddress(address);
                return value;
            }
        }
        return null;
    }

}

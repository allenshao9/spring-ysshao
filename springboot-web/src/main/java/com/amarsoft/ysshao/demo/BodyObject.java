package com.amarsoft.ysshao.demo;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BodyObject {

    private Map<String, Object> icr = null;

    public BodyObject(){
        icr = new HashMap<String, Object>();
    }

    public BodyObject(Map<String, Object> map){
        icr = map;
    }

    public Map<String, Object> getAo() {
        return icr;
    }

    public void setAmAttribute(String key,Object value){
        icr.put(key.toUpperCase(), value);
    }

    public Object getAmAttribute(String key){

        Object object = icr.get(key.toUpperCase());
        if(object instanceof String){
            return (String) icr.get(key.toUpperCase());
        }else{
            return icr.get(key.toUpperCase());
        }

    }

    public int size() {
        return icr.size();
    }

    public String[] getKeys() {
        Object[] okeys = icr.keySet().toArray();
        String[] keys = new String[okeys.length];
        for (int i = 0; i < okeys.length; i++) {
            keys[i] = (String)okeys[i];
        }
        return keys;
    }

    public String toString(){
        return icr.toString();
    }

}

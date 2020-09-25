package com.amarsoft.ysshao.demo;/**
 * @author ysshao
 * @create 2020-09-11 22:43
 */

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/9/11 22:43
 * @Version 1.0
 **/
//给容器中加入我们自己定义的ErrorAttributes
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company","ysshao");
        return map;

    }
}
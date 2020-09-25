package com.amarsoft.ysshao.webcfg;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ysshao
 * @create 2020-05-04 21:58
 *
 * spring boot 2.0则对静态资源也进行了拦截 解决办法就是，在拦截器那里排除静态资源的请求路径
 */
@Configuration
public class WebStaticInterceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("请求已经被拦截");
        return true;
    }
}

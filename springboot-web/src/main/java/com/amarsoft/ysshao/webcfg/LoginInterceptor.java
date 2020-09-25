package com.amarsoft.ysshao.webcfg;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author ysshao
 * @create 2020-05-04 21:58
 *
 *   登陆请求拦截器。 必须要求登陆后。才可以访问后续的资源
 */
@Configuration
public class LoginInterceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String queryString = request.getQueryString();
        if(!StringUtils.isEmpty(queryString) && queryString.startsWith("lange=")){
            return true;
        }
        Object logiguser = request.getSession().getAttribute("loginuser");
        //判断session中是否存在改对象。如果存在则证明已经登陆
        if(Objects.isNull(logiguser)){
            request.setAttribute("errmsg","无权限,请登陆后进行访问");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else{
            return true;
        }
    }
}

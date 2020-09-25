package com.amarsoft.ysshao.webcfg;/**
 * @author ysshao
 * @create 2020-09-09 23:05
 */

import com.amarsoft.ysshao.controller.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/9/9 23:05
 * @Version 1.0
 **/

@Configuration
public class ServletLoadDemo {

    //注册三大组件
    @Bean
    public ServletRegistrationBean myServlet(){
        System.out.println("Bean------------------------");
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(),"/myServlet");
        return registrationBean;
    }
    //可注册Filter
    /*@Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return registrationBean;
    }*/


    //可注册listener
  /*  @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return registrationBean;
    }*/

}

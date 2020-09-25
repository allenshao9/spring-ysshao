package com.amarsoft.ysshao.webcfg;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author ysshao
 * @create 2020-05-04 20:51
 */
@Configuration
public class WebConfigurEextend implements  WebMvcConfigurer {

    @Autowired
    WebStaticInterceptor webStaticInterceptor;//拦截器
    @Autowired
    LoginInterceptor loginInterceptor;

    //配置欢迎页。 springboot 2.0版本
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main.html").setViewName("homepage");
    }

    /**
    * spring boot 2.x  则对静态资源也进行了拦截 解决办法就是，在拦截器那里排除静态资源的请求路径
     *  目前加入assets.后续可以继续加入
     *  2020.5.4 先暂时隐藏。  2.26版本 。默认好像可以直接访问
     *
     *  2020.5.5
     *  注册登陆的拦截器。 但是不拦截登陆相关的
     *
    */

    @Override
   public void addInterceptors(InterceptorRegistry registry) {

        //第一种做法 拦截所有请求。 但是排除登陆相关的 和 静态资源
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/", "/login.html", "/index"
                        ,"/index.html", "/assets/**", "/user/action"
                        , "/login", "/webjars/**", "/assets/img/**"
                    ,"/json/*");

        //第二种方式  只拦截登陆里面的内容。 防止不登录进入。  目前先采用这种。 由于很多其他请求用来测试
       /* registry.addInterceptor(loginInterceptor).addPathPatterns("/main.html");*/

    }

  /*  @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //第一个方法设置访问路径前缀，第二个方法设置资源路径
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }*/

    //Springboot2.X  报错。。 Note: further occurrences of this error will be logged at DEBUG level.
    //请求中含有无效字符，有效的字符在RFC 7230和RFC 3986中定义
//    @Bean
//    public TomcatServletWebServerFactory webServerFactory() {
//        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
//        factory.addConnectorCustomizers((Connector connector) -> {
//            connector.setProperty("relaxedPathChars", "\"<>[\\]^`{|}");
//            connector.setProperty("relaxedQueryChars", "\"<>[\\]^`{|}");
//        });
//        return factory;
//    }

}

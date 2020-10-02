package com.amarsoft.ysshao.creditinfo.config;/**
 * @author ysshao
 * @create 2020-09-29 17:46
 */

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/9/29 17:46
 * @Version 1.0
 **/
//@Configuration
public class HystrixConfig {


    /**
     * 此配置是为了服务监控而配置，与服务容错本身无关，springcloud升级后的坑
     * ServletRegistrationBean因为SpringBoot的默认路径不是 “/hystrix.stream"
     * 只要在自己的项目里配置上下的servlet就可以了
     */
//    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet() ;
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return  registrationBean;
    }
}

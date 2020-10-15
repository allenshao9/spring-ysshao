package com.amarsoft.ysshao.gateway.filter;/**
 * @author ysshao
 * @create 2020-09-30 22:24
 */

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 *
 * @Author AllenShao
 * @Description  自定义过滤器。可以实现 日志记录。或者是 权限鉴定等操作。
 * @Date 2020/9/30 22:24
 * @Version 1.0
 **/

@Component
public class MyLogGatewayFilter  implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //exchange 可以获取repuest对象
        System.out.println("请求进入："+exchange.getRequest().getURI());

        //可以通过请求的内容，进行修改。判断。提前做出响应。
        /*String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if(uname == null) {
            System.out.println("*****用户名为null，非法用户，o(╥﹏╥)o");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }*/
        return chain.filter(exchange);


    }

    //用于控制过滤器的加载级别。 越小越先加载。
    @Override
    public int getOrder() {
        return 0;
    }
}

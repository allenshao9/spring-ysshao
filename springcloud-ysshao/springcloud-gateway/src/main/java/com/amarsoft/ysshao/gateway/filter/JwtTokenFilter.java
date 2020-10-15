package com.amarsoft.ysshao.gateway.filter;/**
 * @author ysshao
 * @create 2020-10-08 20:47
 */

import com.alibaba.fastjson.JSON;
import com.amarsoft.ysshao.gateway.service.LoginService;
import com.amarsoft.ysshao.gateway.util.CommonResult;
import com.amarsoft.ysshao.gateway.util.RetCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/10/8 20:47
 * @Version 1.0
 **/
@Slf4j
@Component
public class JwtTokenFilter implements GlobalFilter, Ordered {

    @Autowired
    LoginService loginService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        System.out.println(response);
        System.out.println(response.getStatusCode());
        String uri = request.getURI().getPath();
        log.info("======================"+uri);
        //  检查白名单（配置） 登陆页面不拦截
        if (uri.indexOf("/login") >= 0) {
            return chain.filter(exchange);
        }
        String token = request.getHeaders().getFirst("token");
        String Accept = request.getHeaders().getFirst("Accept");
        System.out.println(Accept);
        if(StringUtils.isEmpty(token)){
            CommonResult result = new CommonResult();
            result.setCode(RetCodeEnum.TOKEN_MISSION.getCode());
            result.setMessage(RetCodeEnum.TOKEN_MISSION.getMessage());
           return getVoidMono(response,result);
        }
        boolean flag = loginService.verityToken(token);
        //验证成功，继续执行
        if(flag){
            //给当前请求 添加头部信息。 用于标识
            ServerHttpRequest host = exchange.getRequest().mutate().header("userid", "000000").build();
            //将现在的request 变成 change对象
            ServerWebExchange build = exchange.mutate().request(host).build();
            return chain.filter(build);
        }else{
            CommonResult result = new CommonResult();
            result.setCode(RetCodeEnum.TOKEN_INVALID.getCode());
            result.setMessage(RetCodeEnum.TOKEN_INVALID.getMessage());
            return getVoidMono(response,result);
        }


    }

    @Override
    public int getOrder() {
        return 0;
    }

    private Mono<Void> getVoidMono(ServerHttpResponse serverHttpResponse, CommonResult result) {
        serverHttpResponse.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        DataBuffer dataBuffer = serverHttpResponse.bufferFactory().wrap(JSON.toJSONString(result).getBytes());
        return serverHttpResponse.writeWith(Flux.just(dataBuffer));
    }
}

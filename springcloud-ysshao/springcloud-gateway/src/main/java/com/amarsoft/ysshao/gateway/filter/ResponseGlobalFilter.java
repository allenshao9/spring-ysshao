package com.amarsoft.ysshao.gateway.filter;/**
 * @author ysshao
 * @create 2020-10-09 9:20
 */

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.nio.charset.Charset;

/**
 *
 * @Author AllenShao
 * @Description  修改响应内容，可用于对外部交互时的 返回报文填充
 * @Date 2020/10/9 9:20
 * @Version 1.0
 **/
@Slf4j
@Component
public class ResponseGlobalFilter implements GlobalFilter, Ordered {

    private static final String SUCCESS_PREFIX = "{\"code\":20000,\"msg\":\"success\",\"data\":";
    private static final String SUCCESS_SUFFIX = "}";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("=========filter=============");
        ServerHttpResponse originalResponse = exchange.getResponse();
        DataBufferFactory bufferFactory = originalResponse.bufferFactory();
        ServerHttpResponseDecorator decoratedResponse = new ServerHttpResponseDecorator(originalResponse) {
            @Override
            public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
                if (body instanceof Flux) {
                    Flux<? extends DataBuffer> fluxBody = (Flux<? extends DataBuffer>) body;

                    return super.writeWith(fluxBody.buffer().map(dataBuffers -> {

                        DataBufferFactory dataBufferFactory = new DefaultDataBufferFactory();
                        DataBuffer join = dataBufferFactory.join(dataBuffers);

                        byte[] content = new byte[join.readableByteCount()];

                        join.read(content);
                        // 释放掉内存
                        DataBufferUtils.release(join);
                        String str = new String(content, Charset.forName("UTF-8"));
                        //todo 拦截到的返回体内容，可以随意去操作了
                        log.info("返回体：{}", str);
                        // 直接修改str即可。 可以随意完成打包或解包
                        originalResponse.getHeaders().setContentLength(("ccccc"+str).getBytes().length);
                        return bufferFactory.wrap(("ccccc"+str).getBytes());
                    }));

                }
                // if body is not a flux. never got there.
                return super.writeWith(body);
            }
        };
        // replace response with decorator
        return chain.filter(exchange.mutate().response(decoratedResponse).build());

    }

    @Override
    public int getOrder() {
        return -1;
    }
}

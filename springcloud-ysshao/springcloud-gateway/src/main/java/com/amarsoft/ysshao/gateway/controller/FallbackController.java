package com.amarsoft.ysshao.gateway.controller;/**
 * @author ysshao
 * @create 2020-09-30 22:37
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Author AllenShao
 * @Description 用于处理网关熔断的异常响应机制。
 * @Date 2020/9/30 22:37
 * @Version 1.0
 **/
@RestController
public class FallbackController {

    @GetMapping("/fallback")
    public String fallbackA() {
        System.out.println("服务器不可用了。");
        return "网关服务暂时不可用,请稍后访问";
    }
}

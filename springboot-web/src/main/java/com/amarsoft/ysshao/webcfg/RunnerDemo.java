package com.amarsoft.ysshao.webcfg;/**
 * @author ysshao
 * @create 2020-09-24 21:17
 */

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * @Author AllenShao
 * @Description 启动前初始化资源
 * @Date 2020/9/24 21:17
 * @Version 1.0
 **/
@Component
@Order(1)//用于标注顺序  按照 1 2 的顺序执行
public class RunnerDemo implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        System.out.println("-----启动初始化资源使用----");

    }
}

package com.amarsoft.ysshao.customer.controller;/**
 * @author ysshao
 * @create 2020-09-28 17:23
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/9/28 17:23
 * @Version 1.0
 **/
@RestController
@Slf4j
public class DiscoveryController {
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/customerinfo/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();

        for (String service : services) {
            log.info("**服务***:" + service);

            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                log.info("服务信息:"+instance.getServiceId()+"\t" + instance.getHost() +
                        "\t" + instance.getPort() +"\t" + instance.getUri());
            }
        }



        return  this.discoveryClient;
    }


}

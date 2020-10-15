package com.amarsoft.ysshao.creditinfo.controller;/**
 * @author ysshao
 * @create 2020-09-29 11:37
 */

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @Author AllenShao
 * @Description 降级是指，当请求超时、资源不足等情况发生时进行服务降级处理，不调用真实服务逻辑，
 *              而是使用快速失败（fallback）方式直接返回一个托底数据，保证服务链条的完整，避免服务雪崩。
 * @Date 2020/9/29 11:37
 * @Version 1.0
 **/
@RestController
@RequestMapping("/credit")
@Slf4j
//全局异常的调用方法。
@DefaultProperties(defaultFallback = "global_FallbackMethod")
public class CreditInfoController {

    private static  int kk;
    private static  int zz;
    @GetMapping("/hystrix/ok/{id}")
    public String hystrixOK(@PathVariable("id")  Integer id) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        kk++;
        System.out.println(kk+"线程池kk：" + Thread.currentThread().getName()+df.format(new Date()));// new Date()为获取当前系统时间

        return "线程池：" + Thread.currentThread().getName()
                + "   访问OK,id:" + id + " 正常访问！"+df.format(new Date()) ;
    }


    //请求降级。 默认是指程序抛出异常调用的方法。 即可用于异常的处理类。fallbackMethod为降级需要处理的函数。
    @HystrixCommand(fallbackMethod = "hystrix_errorHandler")
    @GetMapping("/hystrix/test/{id}")
    public String hystrixtest1(@PathVariable("id")  Integer id) throws Exception {

        if(id>100){
            throw new  Exception("数据查询异常");
        }
        return "线程池： " + Thread.currentThread().getName();
    }


    //整体响应时间如果超过3秒。 则调用 超时方法。
    @HystrixCommand(fallbackMethod = "hystrix_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    @GetMapping("/hystrix/timeout/{id}")
    public String hystrixOKTimeout(@PathVariable("id")  Integer id) {
        int timeNumber = 1;
        if(id>100){
            timeNumber =4;
        }

        try {
            System.out.println(zz+"线程池zz：" + "--------------------");// new Date()为获取当前系统时间
            // 每次服务睡眠3s
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e){
            e.printStackTrace();
        }
        zz++;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(zz+"线程池zz：" + Thread.currentThread().getName()+df.format(new Date()));// new Date()为获取当前系统时间

        return "线程池： " + Thread.currentThread().getName()
                + "   服务OK,id:" + id + " 耗时(秒):" + timeNumber +" .时间:"+df.format(new Date());
    }


    /* 多次异常请求。触发熔断机制触发发， 则请求正常的内容也是返回异常。
       熔断相当于保险丝 ，触发后。这段时间均不可访问。
       Hystrix的断路器就像我们家庭电路中的保险丝, 一旦后端服务不可用, 断路器会直接切断请求链,
        避免发送大量无效请求影响系统吞吐量, 并且断路器有自我检测并恢复的能力。
     */
    @HystrixCommand(fallbackMethod = "hystrix_errorHandler",commandProperties = {
            //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            //为时间窗口内的请求阈值，只有达到这个阈值，才会判断是否打开断路器。比如配置为10次， 根据下面配置的10秒 那么在时间窗口10秒内请求9次，9次都失败了也不会打开断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),    //请求数达到后才计算
            //为时间窗口，当断路器打开后，会根据这个时间继续尝试接受请求，如果请求成功则关闭断路器。
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗
            //为配置的失败比率，在时间窗口内请求次数达到请求阈值，并且失败比率达到配置的50%，才会打开断路器。
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")  //错误率达到多少跳闸
    })
    @GetMapping("/hystrix/RD/{id}")
    public String hystrixtestRD(@PathVariable("id")  Integer id) throws Exception {
     /*   //模拟业务场景。 不同的参数。响应时间不同。
        try {
            if(id>1000){
                TimeUnit.SECONDS.sleep(1);
            }else {
                TimeUnit.SECONDS.sleep(3);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        if(id<100){
            throw new  Exception("数据查询异常");
        }
        return "线程池： " + Thread.currentThread().getName()+id;
    }


    @HystrixCommand(fallbackMethod = "threadPoolmsg",
            commandKey = "createOrder",
            commandProperties = {
                @HystrixProperty(name="execution.isolation.strategy", value = "THREAD"),
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
            },
            threadPoolKey = "createOrderThreadPool",
            groupKey = "Group1",
            // 本方法中设置了，优先级高于yml的配置。
            //目前配置， 请求最高并发是5个， 5个排队。  如果直接请求10个 全部成功，但是同时只有5个在执行。 请求11个，10个成功，1个拒绝
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "5"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "5"),
                    @HystrixProperty(name = "maxQueueSize", value = "100")
            }
    )
    @GetMapping("/hystrix/thread")
    public String threadHystrix(){

        log.info("线程名："+Thread.currentThread().getName()+"========threadHystrix========");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("线程名："+Thread.currentThread().getName()+"========end========");
        return "线程池隔离控制";
    }


    public String hystrix_TimeoutHandler(Integer id) {
        log.info("Hystrix接口调用超时。系统繁忙"+"线程池zz：" + Thread.currentThread().getName());
        return "调用接口超时或异常、\t" + "\t当前线程池名字" + Thread.currentThread().getName();
    }

    public String hystrix_errorHandler(Integer id) {
        log.info("Hystrix接口调用异常。" + Thread.currentThread().getName());
        return "Hystrix接口调用异常。";

    }

    // 下面是全局fallback方法
    public String global_FallbackMethod()
    {
        return "全局异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }

    // 下面是全局fallback方法
    public String threadPoolmsg()
    {
        return "线程池超出最大队列,服务器繁忙,请稍后再试";
    }

}

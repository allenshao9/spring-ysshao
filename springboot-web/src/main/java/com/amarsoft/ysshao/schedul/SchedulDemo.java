package com.amarsoft.ysshao.schedul;/**
 * @author ysshao
 * @create 2020-09-12 16:08
 */

import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalTime;

/**
 *
 * @Author AllenShao
 * @Description 定时任务类
 * @Date 2020/9/12 16:08
 * @Version 1.0
 *
 * initialDelay：启动后多久开始执行，单位时毫秒
 * fixedRate：下次执行时间，任务开始运行的时候就计时。
 * fixedDelay：下次执行时间，fixedDelay等任务进行完了才开始计时
 * 关于fixedRate和fixedDelay的运行效果接下来详述,下面时运行一段时间的效果：
 *
 **/

//@Component
public class SchedulDemo {

    //10秒开始启动。 每5秒执行一次
    @Scheduled(initialDelay =  1000 * 10,fixedDelay = 1000 * 5)
    public void scheduledTask(){
        System.out.println("Thread=="+Thread.currentThread().getName()+""+ LocalTime.now());

    }

    //可参考cron表达式。   此配置表示 每分钟的19秒都执行一次。
    @Scheduled(cron = "19 * * * * ?")
    public void scheduledTask1(){
        System.out.println("定时任务1");
    }
}

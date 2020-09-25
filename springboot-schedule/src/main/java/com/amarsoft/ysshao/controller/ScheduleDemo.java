package com.amarsoft.ysshao.controller;/**
 * @author ysshao
 * @create 2020-09-24 17:47
 */

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


/**
 *
 * @Author AllenShao
 * @Description  定时任务演示
 * @Date 2020/9/24 17:47
 * @Version 1.0
 **/

@Configuration
@Slf4j
public class ScheduleDemo {

    /**
    * @Scheduled(fixedRate = 6000) ：上一次开始执行时间点之后6秒再执行
      @Scheduled(fixedDelay = 6000) ：上一次执行完毕时间点之后6秒再执行
      @Scheduled(initialDelay=1000, fixedRate=6000) ：第一次延迟1秒后执行，之后按 fixedRate 的规则每6秒执行一次

      cron表达式:
      Java(Spring)
       *    *    *    *    *    *
      -    -    -    -    -    -
      |    |    |    |    |    |
      |    |    |    |    |    +----- day of week (0 - 7) (Sunday=0 or 7) OR sun,mon,tue,wed,thu,fri,sat
      |    |    |    |    +---------- month (1 - 12) OR jan,feb,mar,apr ...
      |    |    |    +--------------- day of month (1 - 31)
      |    |    +-------------------- hour (0 - 23)
      |    +------------------------- min (0 - 59)
      +------------------------------ second (0 - 59)

    * */

    @Scheduled(fixedRate = 5000)
    public void schedule1(){
        LocalDateTime nowTime= LocalDateTime.now();

        log.info("定时任务演示1....");
        log.info("任务1[每5秒循环一次]:"+nowTime.toString());
    }


    @Scheduled(initialDelay = 3000,fixedRate = 10000)
    public void schedule2(){
        LocalDateTime nowTime= LocalDateTime.now();

        log.info("定时任务演示2....");
        log.info(Thread.currentThread().getName()+"任务2 启动3秒后 [每10秒循环一次]:"+nowTime.toString());
    }


    @Scheduled(cron = " 10,30 * * * *  * " )
    public void schedule3(){
        LocalDateTime nowTime= LocalDateTime.now();

        log.info("定时任务cron 演示....");
        log.info(Thread.currentThread().getName()+"任务3[每分钟的10秒 、30秒执行一次]:"+nowTime.toString());
    }

}

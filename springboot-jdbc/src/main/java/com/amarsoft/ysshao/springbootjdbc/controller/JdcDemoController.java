package com.amarsoft.ysshao.springbootjdbc.controller;/**
 * @author ysshao
 * @create 2020-09-24 16:32
 */


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @Author AllenShao
 * @Description  JdbcTemplate 本身使用非常便捷 很简单
 * @Date 2020/6/24 16:32
 * @Version 1.0
 **/
@RestController
@Slf4j
public class JdcDemoController {

    @Autowired
    JdbcTemplate  jdbcTemplate;

    @GetMapping("/jdcbquery")
    public String jdcbquery(){

        try {
            log.info(String.valueOf(jdbcTemplate.getDataSource().getConnection()));
            log.info("查询数据库 单笔 ");
            Map<String, Object> map = jdbcTemplate.queryForMap("select * from user_info where rownum=1 ");
            for(Map.Entry<String,Object> aa:map.entrySet()){
                System.out.println(aa.getKey());
                System.out.print(aa.getValue());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
        }

        return "JDBC Demo1";
    }

    /*
    * 单个值 qureyForObject(sql, Class class, Objec... args)
       如：   String s = jt.queryForObject("select uname from user2 where id=?", String.class, 3);
       *     Integer s2 = jt.queryForObject("select upass from user2 where id=?", Integer.class, 4);


     * */
    @GetMapping("/jdcbquery1")
    public String jdcbquery1(){

        try {
            log.info(String.valueOf(jdbcTemplate.getDataSource().getConnection()));
            log.info("查询数据库 多条 ");
            List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from user_info where rownum < =2");
            for(Map<String, Object> ma :maps){

                ma.forEach(( k, v) ->{
                    System.out.println("key:value = " + k + ":" + v);
                });
            }
            log.info("查询数据库 多条 1111 ");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
        }

        return "JDBC Demo1";
    }

    /**
     * int update(sql, Object... args);  也可以使用update方法 。有返回值的
     * @return
     */

    @GetMapping("/jdcbupdate")
    public String jdcbupdate(){

        try {
            log.info(String.valueOf(jdbcTemplate.getDataSource().getConnection()));
            log.info(" 更新数据库 ");
            jdbcTemplate.execute("update user_info set attribute1='AA' where userid='271715'");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
        }

        return "JDBC Demo1";
    }

}

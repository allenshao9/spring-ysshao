package com.amarsoft.ysshao.customer.controller;/**
 * @author ysshao
 * @create 2020-09-28 14:51
 */

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/9/28 14:51
 * @Version 1.0
 **/

/* 类注解 */
//@Api(value = "desc of class")
//@RestController
public class SwaggerController {


    /* 方法注解 */
    @ApiOperation(value = "desc of method", notes = "")
    @GetMapping(value="/swagger")
    public Object hello( /* 参数注解 */ @ApiParam(value = "desc of param" , required=true ) @RequestParam String name) {
        return "Hello " + name + "!";
    }
}

package com.amarsoft.ysshao.gateway.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ysshao
 * @create 2020-05-19 22:19
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    // 404 not found
    private Integer code;
    private String message;
    private T  data;

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }

    //默认OK的状态信息
    public static CommonResult ok(Object okdata){
        CommonResult result = new CommonResult();
        result.setCode(RetCodeEnum.SUCCESS.getCode());
        result.setMessage(RetCodeEnum.SUCCESS.getMessage());
        result.setData(okdata);
        return result;
    }

    //默认OK的状态信息 自定义信息 +Okdata
    public static CommonResult okMsg(String msg,Object okdata){
        CommonResult result = new CommonResult();
        result.setCode(RetCodeEnum.SUCCESS.getCode());
        result.setMessage(msg);
        result.setData(okdata);
        return result;
    }

    //默认error的状态信息
    public static CommonResult error(Object okdata){
        CommonResult result = new CommonResult();
        result.setCode(RetCodeEnum.FAIL.getCode());
        result.setMessage(RetCodeEnum.FAIL.getMessage());
        result.setData(okdata);
        return result;
    }
}

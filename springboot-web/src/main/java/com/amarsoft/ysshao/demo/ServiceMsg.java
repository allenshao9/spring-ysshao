package com.amarsoft.ysshao.demo;/**
 * @author ysshao
 * @create 2020-09-24 20:25
 */

import org.springframework.stereotype.Component;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/9/24 20:25
 * @Version 1.0
 **/

@Component
public class ServiceMsg {

    private SysHead sysHead;
    private BodyObject bodyObject;

    public SysHead getSysHead() {
        return sysHead;
    }

    public void setSysHead(SysHead sysHead) {
        this.sysHead = sysHead;
    }

    public BodyObject getBodyObject() {
        return bodyObject;
    }

    public void setBodyObject(BodyObject bodyObject) {
        this.bodyObject = bodyObject;
    }
}

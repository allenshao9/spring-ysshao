package com.amarsoft.ysshao.demo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author ysshao
 * @create 2020-05-02 16:17
 */

@RestController
public class HelloController {

    @Autowired
    private ServiceMsg smsg;

    @GetMapping("/hello")
    public  String hello(){

        return "Hello  Srping Boot!  ...";
    }

    @PostMapping("/hellopost")
    public  String hellopost(){

        return "Hello  Srping Boot!  ...";
    }


    //接受外部传入的JSON字符串。
    @PostMapping(value = "/json/test1" , produces = "application/json;charset=UTF-8")
    public  ServiceMsg helloMsg(@RequestBody JSONObject json ){
        System.out.println(json.toJSONString());

        SysHead sysHead = new SysHead();
        sysHead.setOrgId("11");
        sysHead.setUserId("test11");
        BodyObject bodyObject = new BodyObject();
        bodyObject.setAmAttribute("cus", "200");
        bodyObject.setAmAttribute("idddd", "2222");
        smsg.setBodyObject(bodyObject);
        smsg.setSysHead(sysHead);

        return smsg;
    }

    //接受外部传入的JSON字符串。
    @PostMapping(value = "/json/test2" , produces = "application/json;charset=UTF-8")
    public  JSONObject helloMsg(HttpServletRequest request ){
        //获取到JSONObject
        JSONObject jsonParam = this.getJSONParam(request);

        // 将获取的json数据封装一层，然后在给返回
        JSONObject result = new JSONObject();
        result.put("msg", "ok");
        result.put("method", "request");
        result.put("data", jsonParam);

        return result;
    }

    /**
     * @param request
     * @return
     */
    public JSONObject getJSONParam(HttpServletRequest request){
        JSONObject jsonParam = null;
        try {
            // 获取输入流
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

            // 写入数据到Stringbuilder
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = streamReader.readLine()) != null) {
                sb.append(line);
            }
            jsonParam = JSONObject.parseObject(sb.toString());
            // 直接将json信息打印出来
            System.out.println(jsonParam.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonParam;
    }

}

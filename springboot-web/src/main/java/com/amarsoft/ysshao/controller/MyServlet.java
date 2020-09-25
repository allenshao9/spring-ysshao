package com.amarsoft.ysshao.controller;/**
 * @author ysshao
 * @create 2020-09-09 18:25
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/9/9 18:25
 * @Version 1.0
 **/
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            System.out.println("------------1-----------------");
            Map<String, String[]> parameterMap = req.getParameterMap();
            for(Map.Entry<String, String[]>   ee:parameterMap.entrySet()){
                System.out.println("===1");
                System.out.print(ee.getKey());
                System.out.print("=");
                String[] value = ee.getValue();
                for(String str :value){
                    System.out.println(str);
                }
                System.out.println("===2");
            }
            parameterMap.forEach(( k, v) ->{
                System.out.println(k);
                System.out.println(v);
            });

            System.out.println("-----------2------------------");
            System.out.println(parameterMap);
            System.out.println(req.getParameterNames());
//            String userid = req.getParameter("userid");
//            System.out.println(req.getContentType());
//            System.out.println(userid);
            System.out.println(req.getQueryString());
//            ServletInputStream inputStream = req.getInputStream();
//            String s = IOUtils.toString(inputStream, "UTF-8");
            System.out.println("1111111111111111111111");
            System.out.println(ReadAsChars(req));
            System.out.println("1111111111111111111111");
            PrintWriter writer = resp.getWriter();
            writer.write("Hello SpringBoot");
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String ReadAsChars(HttpServletRequest request)
    {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder("");
        try
        {
            br = request.getReader();
            String str;
            while ((str = br.readLine()) != null)
            {
                sb.append(str);
            }
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (null != br)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

}

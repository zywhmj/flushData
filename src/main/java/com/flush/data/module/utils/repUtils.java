package com.flush.data.module.utils;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

public class repUtils {

    public static void render(HttpServletResponse response, Object obj) {
        try{
            response.setContentType("application/json;charset=UTF-8");
            OutputStream out = response.getOutputStream();
            String str  = JSON.toJSONString(obj);
            out.write(str.getBytes("UTF-8"));
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

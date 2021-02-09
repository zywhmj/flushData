package com.flush.data.module.controller;


import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @ResponseBody
    @RequestMapping("/admin/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
/*

        Result result = new Result("00000", "", "请求成功", "");
        repUtils.render(response, result); //TODO 方法2
*/

        Map<String, String> obj = new HashMap<>();
        obj.put("code", "200");
        obj.put("message", "登录成功");
         response.setContentType("application/json;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        String str  = JSON.toJSONString(obj);
        out.write(str.getBytes("UTF-8"));
        out.flush();
        out.close();

    }
}

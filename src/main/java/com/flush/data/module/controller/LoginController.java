package com.flush.data.module.controller;


import com.alibaba.fastjson.JSON;
import com.flush.data.module.entity.P2pMember;
import com.flush.data.module.service.P2pMemberService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private P2pMemberService p2pMemberService;


    @ResponseBody
    @RequestMapping("/admin/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String reqData = getReqData(request);
        Gson gson = new Gson();
        Map<String, String> map = new HashMap<String, String>();
        map = gson.fromJson(reqData, map.getClass());
        String user = map.get("username");
        String pass = map.get("password");
        System.out.println("=============请求参数reqData："+reqData);
        System.out.println("=============请求参数："+user+" "+pass);

        String msg = "登录失败";
        String code = "500";
        P2pMember p2pMember = p2pMemberService.login(user, pass);
        if(p2pMember != null){
            System.out.print("用户存在");
            msg = "登录成功";
            code = "200";
        }

        Map<String, String> obj = new HashMap<>();
        obj.put("code", code);
        obj.put("message", msg);
         response.setContentType("application/json;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        String str  = JSON.toJSONString(obj);
        out.write(str.getBytes("UTF-8"));
        out.flush();
        out.close();

    }

    private String getReqData(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader reader = request.getReader()) {
            char[]buff = new char[1024];
            int len;
            while((len = reader.read(buff)) != -1) {
                sb.append(buff,0, len);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}

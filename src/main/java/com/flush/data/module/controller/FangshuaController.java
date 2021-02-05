package com.flush.data.module.controller;

import com.alibaba.fastjson.JSON;
import com.flush.data.module.core.AccessLimit;
import com.flush.data.module.utils.CodeMsg;
import com.flush.data.module.utils.Result;
import com.flush.data.module.utils.repUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;


/**
 * @author yhq
 * @date 2018/9/10 15:49
 */

@Controller
public class FangshuaController {



    @AccessLimit(seconds = 1, maxCount = 5, needLogin = false)
    @RequestMapping("/fangshua")
    @ResponseBody
    public void fangshua(HttpServletRequest request, HttpServletResponse response) {

        Result result = new Result("00000", "", "请求成功", "");

//        return JSON.toJSONString(result); //TODO 方法1，返回值需要设置为String
        repUtils.render(response, result); //TODO 方法2
    }

}
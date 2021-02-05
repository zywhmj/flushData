package com.flush.data.module.filter;

import com.alibaba.fastjson.JSON;
import com.flush.data.module.core.AccessLimit;
import com.flush.data.module.service.RedisService;
import com.flush.data.module.utils.CodeMsg;
import com.flush.data.module.utils.repUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * @author yhq
 * @date 2018/9/10 16:05
 */
@Component
public class FangshuaInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  {

        //判断请求是否属于方法的请求
        if(handler instanceof HandlerMethod){

            HandlerMethod hm = (HandlerMethod) handler;

            //获取方法中的注解,看是否有该注解
            AccessLimit accessLimit = hm.getMethodAnnotation(AccessLimit.class);
            if(accessLimit == null){
                return true;
            }
            int seconds = accessLimit.seconds();
            int maxCount = accessLimit.maxCount();
            boolean login = accessLimit.needLogin();
            String key = request.getRemoteHost()+"_"+request.getRequestURI(); //TODO request.getHeader("Host")
            //如果需要登录
            if(login){
                //获取登录的session进行判断
                key+=""+"_session168168";  //这里假设用户是1,项目中是动态获取的userId
            }

            Integer count = (Integer) redisService.get(key);
            System.out.println("=======================》"+key+":"+count);
            if(count == null){
                //第一次访问
//                redisService.set(key,1);
                redisService.set(key, seconds, 10000L); //TODO redis超时时间：10秒
            }else if(count < maxCount){
                //加1
                redisService.incr(key, 10000L);
//                redisService.set(key, ++count, 10000L);
            }else{
                //超出访问次数
                CodeMsg codeMsg = new CodeMsg("10001", "访问受限制，请稍后重试！");
                repUtils.render(response, codeMsg); //这里的CodeMsg是一个返回参数
                return false;
            }
        }

        return true;
    }


}
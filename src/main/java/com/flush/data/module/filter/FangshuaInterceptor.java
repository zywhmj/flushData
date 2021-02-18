package com.flush.data.module.filter;

import com.flush.data.module.core.AccessLimit;
import com.flush.data.module.service.RedisService;
import com.flush.data.module.utils.CodeMsg;
import com.flush.data.module.utils.repUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 * 方式：
 * ① 继承HandlerInterceptorAdapter类（已过时）
 * ② 实现HandlerInterceptor接口（常用）
 * 说明:
 * preHandle：在业务处理器处理请求之前被调用。预处理，可以进行编码、安全控制、权限校验等处理；
 * postHandle：在业务处理器处理请求执行完成后，生成视图之前执行。后处理（调用了Service并返回ModelAndView，但未进行页面渲染），有机会修改ModelAndView （这个博主就基本不怎么用了）；
 * afterCompletion：在DispatcherServlet完全处理完请求后被调用，可用于清理资源等。返回处理（已经渲染了页面）；
 */
@Component
public class FangshuaInterceptor implements HandlerInterceptor {

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


    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println();
        System.out.println("======================postHandle====================");
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("======================afterCompletion====================");
    }
}
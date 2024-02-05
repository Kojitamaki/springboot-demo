package com.koji.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.koji.pojo.Result;
import com.koji.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author koji
 * @create 2024-02-02 0:18
 **/
@Component
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override  // 目标资源方法运行前运行，返回true：放行， 返回false：不放行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求的令牌
        String token = request.getHeader("token");
        // 判断令牌是否存在，不存在返回错误结果
        if(!StringUtils.hasLength(token)){
            log.info("请求头token为空，返回未登录的信息");
            Result not_login = Result.error("NOT_LOGIN");
            // 手动转换 把对象转为json ------->阿里巴巴 fastjson
            String s = JSONObject.toJSONString(not_login);
            response.getWriter().write(s);
            return false;
        }
        // 如果令牌存在，解析令牌
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {  // 解析出错，说明令牌被篡改或失效
            e.printStackTrace();
            log.info("令牌解析失败，返回未登录错误信息");
            Result not_login = Result.error("NOT_LOGIN");
            // 手动转换 把对象转为json ------->阿里巴巴 fastjson
            String s = JSONObject.toJSONString(not_login);
            response.getWriter().write(s);
            return false;
        }
        // 令牌解析通过，放行
        log.info("令牌合法，放行");
        return true;
    }

    @Override  // 目标资源方法运行后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle....");
    }

    @Override  // 视图渲染完毕后执行，最后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion......");
    }
}

package com.koji.filter;

import com.alibaba.fastjson.JSONObject;
import com.koji.pojo.Result;
import com.koji.utils.JwtUtils;
import com.sun.media.sound.UlawCodec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author koji
 * @create 2024-02-01 22:58
 **/

@Slf4j
//@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // 1. 获取请求url
        String url = req.getRequestURI();
        log.info("请求的url：{}", url);

        // 2.判断是否为登录请求
        if(url.contains("login")){
            // 登录操作直接放行
            chain.doFilter(request, response);
            return;
        }
        // 3. 获取请求的令牌
        String token = req.getHeader("token");

        // 4.判断令牌是否存在，不存在返回错误结果
        if(!StringUtils.hasLength(token)){
            log.info("请求头token为空，返回未登录的信息");
            Result not_login = Result.error("NOT_LOGIN");
            // 手动转换 把对象转为json ------->阿里巴巴 fastjson
            String s = JSONObject.toJSONString(not_login);
            resp.getWriter().write(s);
            return;
        }
        // 5. 如果令牌存在，解析令牌
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {  // 解析出错，说明令牌被篡改或失效
            e.printStackTrace();
            log.info("令牌解析失败，返回未登录错误信息");
            Result not_login = Result.error("NOT_LOGIN");
            // 手动转换 把对象转为json ------->阿里巴巴 fastjson
            String s = JSONObject.toJSONString(not_login);
            resp.getWriter().write(s);
            return;
        }
        // 6. 放行
        log.info("令牌合法，放行");
        chain.doFilter(request, response);
    }
}

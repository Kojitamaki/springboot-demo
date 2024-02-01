package com.koji.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author koji
 * @create 2024-02-01 20:40
 **/

// @WebFilter(urlPatterns = {"/depts/*", "/emps/*", "/upload"})  // 可以把向这些接口发送的请求都拦截了
public class DemoFilter implements Filter {
    @Override  // 初始化方法，只在服务启动时调用一次
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init 初始化方法执行了");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 放行前逻辑
        System.out.println("请求被拦截了---- 放行前");
        // 放行，允许请求去访问资源
        filterChain.doFilter(servletRequest, servletResponse);
        // 访问资源完成后会会回到过滤器，执行放行后逻辑
        System.out.println("请求被拦截了---- 放行后");
    }

    @Override  // 销毁方法，只在服务关闭时调用一次
    public void destroy() {
        System.out.println("destroy 方法执行了");
    }
}

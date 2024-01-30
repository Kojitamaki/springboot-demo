package com.koji.controller;

import com.koji.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1. @ClassName SessionController
 * 2. @Description TODO
 * 3. @Author ww103
 * 4. @Date 2024/1/31 0:00
 * 5. @Version 1.0
 */

@Slf4j
@RestController
public class SessionController {

    // 设置Cookie
    @GetMapping("/c1")
    public Result cookie1(HttpServletResponse response){
        Cookie cookie = new Cookie("login_username", "koji");
        // 设置cookie生命周期，为正数，则存活n秒，为负数则为会话cookie
        cookie.setMaxAge(10);
        response.addCookie(cookie);
        return Result.success();
    }

    // 获取Cookie
    @GetMapping("/c2")
    public Result cookie2(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();  // 获取所有的cookie
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("login_username")){  // 输出名为login_username的cookie
                System.out.println("login_username : " + cookie.getValue() );
            }
            else System.out.println("无了");
        }
        return Result.success();
    }
}

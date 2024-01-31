package com.koji.controller;

import com.koji.pojo.Emp;
import com.koji.pojo.Result;
import com.koji.service.EmpService;
import com.koji.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. @ClassName LoginController
 * 2. @Description TODO
 * 3. @Author ww103
 * 4. @Date 2024/1/30 22:42
 * 5. @Version 1.0
 */


@RestController
@Slf4j
public class LoginController {
    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("登录请求,username：{}， password:{}", emp.getUsername(), emp.getPassword());
        Emp e = empService.login(emp);
        if(e!=null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("username", e.getUsername());
            claims.put("name", e.getName());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return e!=null? Result.success():Result.error("用户名或密码错误");
    }
}

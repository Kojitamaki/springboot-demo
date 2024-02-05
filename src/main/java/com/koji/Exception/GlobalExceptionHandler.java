package com.koji.Exception;

import com.koji.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 1. @ClassName GlobalExceptionHandler
 * 2. @Description TODO
 * 3. @Author ww103
 * 4. @Date 2024/2/5 23:19
 * 5. @Version 1.0
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)  // 捕获所有异常
    public Result ex(Exception ex){
        ex.printStackTrace();
        return Result.error("对不起，操作失败，请联系管理员");
    }
}

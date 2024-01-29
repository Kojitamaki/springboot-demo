package com.koji.controller;

import com.koji.pojo.Result;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 1. @ClassName UploadController
 * 2. @Description TODO
 * 3. @Author ww103
 * 4. @Date 2024/1/29 20:33
 * 5. @Version 1.0
 */


@RestController
@Slf4j
public class UploadController {
    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws Exception {
        log.info("文件上传：{}，{}，{}" ,username, age, image);
        // 获取原始文件名
        String originalFilename = image.getOriginalFilename();
        // 使用UUID构建新文件名
        String fileName = "E:\\itheima_java\\file\\" + UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        // 将文件保存至服务端本地
        image.transferTo(new File(fileName));
        return Result.success(fileName);
    }
}

package com.koji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan  // 开启对javaweb组件的支持
public class TliasWebManagementApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TliasWebManagementApplication.class);
        springApplication.run(args);
    }

}

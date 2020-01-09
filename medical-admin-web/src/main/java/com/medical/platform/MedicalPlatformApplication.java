package com.medical.platform;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @program: medical-platform-solution
 * @description:  启动类
 * @author: heyu
 * @create: 2020-01-08 19:06
 **/
@MapperScan(basePackages ="com.medical.platform.mapper")
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class MedicalPlatformApplication {
    public static void main(String[] args) {
        SpringApplication.run(MedicalPlatformApplication.class,args);
    }
}

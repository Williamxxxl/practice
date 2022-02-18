package com.fchsoft.auth.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author qw
 * @version 1.0.0
 * @ClassName SecurityMain.java
 * @Description
 * @createTime 2022-01-08 21:40
 */
@EnableAsync
@SpringBootApplication
@EnableRedisHttpSession
@MapperScan({"com.fchsoft.auth.test.module.*.mapper"})
public class SecurityMain {
    public static void main(String[] args) {
        SpringApplication.run(SecurityMain.class, args);
    }
}

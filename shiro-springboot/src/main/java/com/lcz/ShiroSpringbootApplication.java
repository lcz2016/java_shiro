package com.lcz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lcz.mapper")
public class ShiroSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroSpringbootApplication.class, args);
    }

}

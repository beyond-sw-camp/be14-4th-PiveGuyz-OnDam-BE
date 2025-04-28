package com.piveguyz.ondambackend;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = "com.piveguyz.ondambackend", annotationClass = Mapper.class)
public class OndamBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(OndamBackendApplication.class, args);
    }

}

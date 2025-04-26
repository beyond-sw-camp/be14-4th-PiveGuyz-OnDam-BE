package com.piveguyz.ondambackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({
        "com.piveguyz.ondambackend.diary.query.mapper",
        "com.piveguyz.ondambackend.diaryRecord.query.mapper",
        "com.piveguyz.ondambackend.member.query.mapper"
})
public class OndamBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(OndamBackendApplication.class, args);
    }

}

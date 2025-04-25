package com.piveguyz.ondambackend.diary.query.mapper;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
public class DiaryDAO {
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime deletedAt;
    private String isBlinded = "N";
    private Integer memberId;
}

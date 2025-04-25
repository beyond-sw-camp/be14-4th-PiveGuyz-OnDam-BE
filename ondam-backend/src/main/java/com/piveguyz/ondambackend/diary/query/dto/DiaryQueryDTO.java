package com.piveguyz.ondambackend.diary.query.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DiaryQueryDTO {
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
    private String isBlinded;
    private Integer memberId;
}

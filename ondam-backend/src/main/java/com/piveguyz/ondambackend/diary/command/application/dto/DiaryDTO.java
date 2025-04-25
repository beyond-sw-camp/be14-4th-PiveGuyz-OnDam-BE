package com.piveguyz.ondambackend.diary.command.application.dto;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
public class DiaryDTO {
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
    private String isBlinded;
    private Integer memberId;
}

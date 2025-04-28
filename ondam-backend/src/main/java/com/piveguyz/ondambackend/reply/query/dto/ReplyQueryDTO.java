package com.piveguyz.ondambackend.reply.query.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReplyQueryDTO {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
    private String isBlinded;
    private Long diaryRecordId;
    private Long senderId;
    private Long receiverId;
}

package com.piveguyz.ondambackend.reply.command.application.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReplyDTO {
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
    private String isBlinded;
    private Integer diaryRecordId;
    private Integer senderId;
    private Integer receiverId;
}

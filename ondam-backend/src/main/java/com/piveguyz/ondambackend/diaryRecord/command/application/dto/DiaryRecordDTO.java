package com.piveguyz.ondambackend.diaryRecord.command.application.dto;

import lombok.Data;

@Data
public class DiaryRecordDTO {
    private Long id;
    private Long diaryId;
    private Long senderId;
    private Long receiverId;
    private String isExpired;
}

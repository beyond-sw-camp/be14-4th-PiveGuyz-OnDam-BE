package com.piveguyz.ondambackend.diaryRecord.command.application.dto;

import lombok.Data;

@Data
public class DiaryRecordDTO {
    private Integer id;
    private Integer diaryId;
    private Integer senderId;
    private Integer receiverId;
    private String isExpired;
}

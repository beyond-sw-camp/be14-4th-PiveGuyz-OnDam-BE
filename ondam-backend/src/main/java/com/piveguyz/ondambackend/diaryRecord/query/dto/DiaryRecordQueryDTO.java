package com.piveguyz.ondambackend.diaryRecord.query.dto;

import lombok.Data;

@Data
public class DiaryRecordQueryDTO {
    private Long id;
    private Long diaryId;
    private Long senderId;
    private Long receiverId;
    private String isExpired;
}

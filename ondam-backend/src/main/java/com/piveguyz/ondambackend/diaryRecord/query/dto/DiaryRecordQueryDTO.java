package com.piveguyz.ondambackend.diaryRecord.query.dto;

import lombok.Data;

@Data
public class DiaryRecordQueryDTO {
    private Integer id;
    private Integer diaryId;
    private Integer senderId;
    private Integer receiverId;
    private String isExpired;
}

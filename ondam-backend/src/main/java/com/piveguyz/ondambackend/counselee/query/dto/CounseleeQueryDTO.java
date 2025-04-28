package com.piveguyz.ondambackend.counselee.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CounseleeQueryDTO {
    private Long id;
    private String name;
    private String birthday;
    private String gender;
    private String phone;
    private String emePhone;
    private String address;
    private Integer severityLevel;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
    private LocalDateTime updatedAt;
    private LocalDateTime endDate;
    private String endReason;
    private Long memberId;
}
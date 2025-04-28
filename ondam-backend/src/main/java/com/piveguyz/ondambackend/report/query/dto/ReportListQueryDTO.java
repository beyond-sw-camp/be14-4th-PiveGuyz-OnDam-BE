package com.piveguyz.ondambackend.report.query.dto;

import java.time.LocalDateTime;

import com.piveguyz.ondambackend.report.query.dto.enums.ReportStatus;

import lombok.Data;

@Data
public class ReportListQueryDTO {        // 신고 목록 전체 조회
	private Long id;
	private LocalDateTime createdAt;
	private ReportStatus status;
	private Long memberId;
	private String reporterName;         // 신고자 이름
	private Long reportedMemberId;
	private String reportedMemberName;   // 신고당한 사람 이름
	private Long diaryId;
	private Long replyId;
	private Long reportCategoryId;
	private String reportCategoryName;   // 신고 사유명
}

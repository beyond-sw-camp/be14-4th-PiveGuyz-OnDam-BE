package com.piveguyz.ondambackend.report.command.application.dto;

import lombok.Data;

@Data
public class ReportDiaryCommandDTO {
	private Long memberId;
	private Long reportedMemberId;
	private Long diaryId;
	private Long reportCategoryId;
	private String reason;
}

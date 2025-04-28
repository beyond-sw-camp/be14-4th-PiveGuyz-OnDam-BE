package com.piveguyz.ondambackend.report.command.application.dto;

import lombok.Data;

@Data
public class ReportReplyCommandDTO {
	private Long memberId;
	private Long reportedMemberId;
	private Long replyId;
	private Long reportCategoryId;
	private String reason;
}

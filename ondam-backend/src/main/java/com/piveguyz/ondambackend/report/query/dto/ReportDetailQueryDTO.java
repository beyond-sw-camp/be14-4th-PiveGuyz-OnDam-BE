package com.piveguyz.ondambackend.report.query.dto;

import lombok.Data;

@Data
public class ReportDetailQueryDTO {
	private Long reportId;
	private String reportedMemberName;
	private String reportCategoryName;
	private String reason;
}

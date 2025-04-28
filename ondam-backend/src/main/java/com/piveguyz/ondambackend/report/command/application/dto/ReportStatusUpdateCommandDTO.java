package com.piveguyz.ondambackend.report.command.application.dto;

import lombok.Data;

@Data
public class ReportStatusUpdateCommandDTO {
	private Long reportId;
	private Integer status;
}

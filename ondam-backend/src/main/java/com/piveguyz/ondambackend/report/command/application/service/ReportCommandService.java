package com.piveguyz.ondambackend.report.command.application.service;

import com.piveguyz.ondambackend.report.command.application.dto.ReportDiaryCommandDTO;
import com.piveguyz.ondambackend.report.command.application.dto.ReportReplyCommandDTO;
import com.piveguyz.ondambackend.report.command.application.dto.ReportStatusUpdateCommandDTO;

public interface ReportCommandService {
	void reportDiary(ReportDiaryCommandDTO dto);

	void reportReply(ReportReplyCommandDTO dto);

	void updateReportStatus(ReportStatusUpdateCommandDTO dto);

	void approveReport(Long reportId);

	void deleteReport(Long reportId);
}

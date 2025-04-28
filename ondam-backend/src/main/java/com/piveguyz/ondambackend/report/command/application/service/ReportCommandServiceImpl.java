package com.piveguyz.ondambackend.report.command.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.piveguyz.ondambackend.report.command.application.dto.ReportDiaryCommandDTO;
import com.piveguyz.ondambackend.report.command.application.dto.ReportReplyCommandDTO;
import com.piveguyz.ondambackend.report.command.application.dto.ReportStatusUpdateCommandDTO;
import com.piveguyz.ondambackend.report.command.domain.aggregate.Report;
import com.piveguyz.ondambackend.report.command.domain.repository.ReportRepository;
import com.piveguyz.ondambackend.report.command.domain.service.ReportDomainService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ReportCommandServiceImpl implements ReportCommandService{

	private final ReportRepository reportRepository;

	private final ReportDomainService reportDomainService;

	// 일기 신고 등록
	@Override
	public void reportDiary(ReportDiaryCommandDTO dto) {
		Report report = new Report(
			dto.getMemberId(),
			dto.getReportedMemberId(),
			dto.getDiaryId(),
			null,    // 답장id null
			dto.getReportCategoryId(),
			dto.getReason()
		);
		reportRepository.save(report);
	}

	// 답장 신고 등록
	@Override
	public void reportReply(ReportReplyCommandDTO dto) {
		Report report = new Report(
			dto.getMemberId(),
			dto.getReportedMemberId(),
			null,   // 일기id null
			dto.getReplyId(),
			dto.getReportCategoryId(),
			dto.getReason()
		);
		reportRepository.save(report);
	}

	// 신고 처리상태 변경
	@Override
	public void updateReportStatus(ReportStatusUpdateCommandDTO dto) {
		Report report = reportRepository.findById(dto.getReportId())
			.orElseThrow(() -> new IllegalArgumentException("해당 신고가 존재하지 않습니다."));
		report.changeStatus(dto.getStatus());
	}

	// 신고 승인된 일기/답장 블라인드 처리
	@Override
	public void approveReport(Long reportId) {
		reportDomainService.approveReportAndBlindContent(reportId);
	}

	// 신고 삭제
	@Override
	public void deleteReport(Long reportId) {
		Report report = reportRepository.findById(reportId)
			.orElseThrow(() -> new IllegalArgumentException("해당 신고가 존재하지 않습니다."));

		report.delete();
	}
}

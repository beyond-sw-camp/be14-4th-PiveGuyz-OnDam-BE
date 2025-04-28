package com.piveguyz.ondambackend.report.command.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.piveguyz.ondambackend.diary.command.application.service.DiaryService;
import com.piveguyz.ondambackend.reply.command.application.service.ReplyService;
import com.piveguyz.ondambackend.report.command.domain.aggregate.Report;
import com.piveguyz.ondambackend.report.command.domain.aggregate.ReportStatus;
import com.piveguyz.ondambackend.report.command.domain.repository.ReportRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportDomainService {

	private final ReportRepository reportRepository;
	private final DiaryService diaryService;
	private final ReplyService replyService;

	@Transactional
	public void approveReportAndBlindContent(Long reportId) {
		// 신고 조회
		Report report = reportRepository.findById(reportId)
			.orElseThrow(() -> new IllegalArgumentException("해당 신고가 존재하지 않습니다."));

		// 신고 상태 승인으로 변경
		report.changeStatus(ReportStatus.APPROVED.getValue());

		// 신고된 콘텐츠 블라인드 처리
		if (report.getDiaryId() != null) {
			// 일기
			diaryService.blindDiary(report.getDiaryId());
		} else if (report.getReplyId() != null) {
			// 답장
			replyService.blindReply(report.getReplyId());
		}
	}
}

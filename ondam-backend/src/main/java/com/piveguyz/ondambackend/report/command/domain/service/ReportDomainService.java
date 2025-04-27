package com.piveguyz.ondambackend.report.command.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.piveguyz.ondambackend.report.command.domain.aggregate.Report;
import com.piveguyz.ondambackend.report.command.domain.aggregate.ReportStatus;
import com.piveguyz.ondambackend.report.command.domain.repository.ReportRepository;
import com.piveguyz.ondambackend.report.temp.aggregate.Diary;
import com.piveguyz.ondambackend.report.temp.aggregate.Reply;
import com.piveguyz.ondambackend.report.temp.repository.DiaryRepository;
import com.piveguyz.ondambackend.report.temp.repository.ReplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportDomainService {

	private final ReportRepository reportRepository;
	private final DiaryRepository diaryRepository;
	private final ReplyRepository replyRepository;

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
			Diary diary = diaryRepository.findById(report.getDiaryId())
				.orElseThrow(() -> new IllegalArgumentException("해당 일기가 존재하지 않습니다."));
			diary.blind();
		} else if (report.getReplyId() != null) {
			// 답장
			Reply reply = replyRepository.findById(report.getReplyId())
				.orElseThrow(() -> new IllegalArgumentException("해당 답장이 존재하지 않습니다."));
			reply.blind();
		}
	}
}

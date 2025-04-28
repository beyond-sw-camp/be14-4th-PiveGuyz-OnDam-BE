package com.piveguyz.ondambackend.report.command.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piveguyz.ondambackend.report.command.application.dto.ReportDiaryCommandDTO;
import com.piveguyz.ondambackend.report.command.application.dto.ReportReplyCommandDTO;
import com.piveguyz.ondambackend.report.command.application.dto.ReportStatusUpdateCommandDTO;
import com.piveguyz.ondambackend.report.command.application.service.ReportCommandService;

import lombok.RequiredArgsConstructor;

@RestController("CommandReportController")
@RequestMapping("/api/v1/report")
@RequiredArgsConstructor
public class ReportCommandController {

	private final ReportCommandService reportCommandService;

	// 일기 신고 등록
	@PostMapping("/diary")
	public ResponseEntity<String> reportDiary(@RequestBody ReportDiaryCommandDTO dto) {
		reportCommandService.reportDiary(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body("일기 신고가 완료되었습니다.");
	}

	// 답장 신고 등록
	@PostMapping("/reply")
	public ResponseEntity<String> reportReply(@RequestBody ReportReplyCommandDTO dto) {
		reportCommandService.reportReply(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body("답장 신고가 완료되었습니다.");
	}

	// 신고 처리상태 변경
	@PutMapping("/status")
	public ResponseEntity<String> updateReportStatus(@RequestBody ReportStatusUpdateCommandDTO dto) {
		reportCommandService.updateReportStatus(dto);
		return ResponseEntity.ok("신고 처리 상태가 수정되었습니다.");
	}

	// 신고 승인된 일기/답장 블라인드 처리
	@PutMapping("/approve/{reportId}")
	public ResponseEntity<String> approveReport(@PathVariable Long reportId) {
		reportCommandService.approveReport(reportId);
		return ResponseEntity.ok("신고가 승인되고, 콘텐츠가 블라인드 처리되었습니다.");
	}

	// 신고 삭제
	@PutMapping("/delete/{reportId}")
	public ResponseEntity<String> deleteReport(@PathVariable Long reportId) {
		reportCommandService.deleteReport(reportId);
		return ResponseEntity.ok("신고가 삭제되었습니다.");
	}

}
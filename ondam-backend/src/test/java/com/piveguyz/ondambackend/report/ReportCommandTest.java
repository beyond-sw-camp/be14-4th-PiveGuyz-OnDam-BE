package com.piveguyz.ondambackend.report;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.piveguyz.ondambackend.report.command.application.dto.ReportDiaryCommandDTO;
import com.piveguyz.ondambackend.report.command.application.dto.ReportReplyCommandDTO;
import com.piveguyz.ondambackend.report.command.application.dto.ReportStatusUpdateCommandDTO;
import com.piveguyz.ondambackend.report.command.application.service.ReportCommandService;
import com.piveguyz.ondambackend.report.command.domain.aggregate.Report;
import com.piveguyz.ondambackend.report.command.domain.aggregate.ReportStatus;
import com.piveguyz.ondambackend.report.command.domain.repository.ReportRepository;
import com.piveguyz.ondambackend.report.temp.aggregate.Diary;
import com.piveguyz.ondambackend.report.temp.aggregate.Reply;
import com.piveguyz.ondambackend.report.temp.repository.DiaryRepository;
import com.piveguyz.ondambackend.report.temp.repository.ReplyRepository;

@SpringBootTest
@Transactional
public class ReportCommandTest {

	@Autowired
	private ReportCommandService reportCommandService;

	@Autowired
	private ReportRepository reportRepository;

	// 추후 import 수정 필요
	@Autowired
	private DiaryRepository diaryRepository;

	// 추후 import 수정 필요
	@Autowired
	private ReplyRepository replyRepository;

	@Test
	@DisplayName("일기 신고 등록")
	void reportDiaryTest() {
		ReportDiaryCommandDTO dto = new ReportDiaryCommandDTO();
		dto.setMemberId(1L);
		dto.setReportedMemberId(2L);
		dto.setDiaryId(3L);
		dto.setReportCategoryId(3L);
		dto.setReason("욕설이 포함되어 있습니다.");

		reportCommandService.reportDiary(dto);

		Report savedReport = reportRepository.findAll().get(reportRepository.findAll().size() - 1);

		assertThat(savedReport).isNotNull();
		assertThat(savedReport.getMemberId()).isEqualTo(dto.getMemberId());
		assertThat(savedReport.getReportedMemberId()).isEqualTo(dto.getReportedMemberId());
		assertThat(savedReport.getDiaryId()).isEqualTo(dto.getDiaryId());
		assertThat(savedReport.getReportCategoryId()).isEqualTo(dto.getReportCategoryId());
		assertThat(savedReport.getReason()).isEqualTo(dto.getReason());
		assertThat(savedReport.getStatus()).isEqualTo(ReportStatus.PENDING);

		System.out.println("=== 등록된 신고 정보 ===");
		System.out.println("신고자 ID: " + savedReport.getMemberId());
		System.out.println("신고당한 사람 ID: " + savedReport.getReportedMemberId());
		System.out.println("일기 ID: " + savedReport.getDiaryId());
		System.out.println("신고 사유 ID: " + savedReport.getReportCategoryId());
		System.out.println("상세 내용: " + savedReport.getReason());
		System.out.println("상태: " + savedReport.getStatus());
		System.out.println("작성 시각: " + savedReport.getCreatedAt());
	}

	@Test
	@DisplayName("답장 신고 등록")
	void reportReplyTest() {
		ReportReplyCommandDTO dto = new ReportReplyCommandDTO();
		dto.setMemberId(1L);
		dto.setReportedMemberId(2L);
		dto.setReplyId(1L);
		dto.setReportCategoryId(3L);
		dto.setReason("답장에 부적절한 내용이 포함되어 있습니다.");

		reportCommandService.reportReply(dto);

		Report savedReport = reportRepository.findAll().get(reportRepository.findAll().size() - 1);

		assertThat(savedReport).isNotNull();
		assertThat(savedReport.getMemberId()).isEqualTo(dto.getMemberId());
		assertThat(savedReport.getReportedMemberId()).isEqualTo(dto.getReportedMemberId());
		assertThat(savedReport.getReplyId()).isEqualTo(dto.getReplyId());
		assertThat(savedReport.getReportCategoryId()).isEqualTo(dto.getReportCategoryId());
		assertThat(savedReport.getReason()).isEqualTo(dto.getReason());
		assertThat(savedReport.getStatus()).isEqualTo(ReportStatus.PENDING);

		System.out.println("=== 등록된 답장 신고 정보 ===");
		System.out.println("신고자 ID: " + savedReport.getMemberId());
		System.out.println("신고당한 사람 ID: " + savedReport.getReportedMemberId());
		System.out.println("답장 ID: " + savedReport.getReplyId());
		System.out.println("신고 사유 ID: " + savedReport.getReportCategoryId());
		System.out.println("상세 내용: " + savedReport.getReason());
		System.out.println("상태: " + savedReport.getStatus());
		System.out.println("작성 시각: " + savedReport.getCreatedAt());
	}

	@Test
	@DisplayName("신고 상태 수정")
	void updateReportStatusTest() {
		Report existingReport = reportRepository.findAll().get(0);

		ReportStatusUpdateCommandDTO dto = new ReportStatusUpdateCommandDTO();
		dto.setReportId(existingReport.getId());
		dto.setStatus(1); // 거절

		reportCommandService.updateReportStatus(dto);

		Report updatedReport = reportRepository.findById(existingReport.getId())
			.orElseThrow(() -> new IllegalArgumentException("수정된 신고를 찾을 수 없습니다."));

		assertThat(updatedReport.getStatus()).isEqualTo(ReportStatus.APPROVED);

		System.out.println("=== 수정된 신고 상태 ===");
		System.out.println("신고 ID: " + updatedReport.getId());
		System.out.println("수정된 상태: " + updatedReport.getStatus());
	}

	@Test
	@DisplayName("신고 승인 후 일기 블라인드 처리")
	void approveDiaryReportAndBlindTest() {

		Diary diary = Diary.builder()
			.title("테스트 일기 제목")
			.content("테스트 일기 내용")
			.isBlinded("N")
			.memberId(1L)
			.createdAt(LocalDateTime.now())
			.build();
		diaryRepository.save(diary);

		Report report = new Report(1L, 2L, diary.getId(), null, 1L, "일기 신고 테스트");
		reportRepository.save(report);

		reportCommandService.approveReport(report.getId());

		Report approvedReport = reportRepository.findById(report.getId())
			.orElseThrow(() -> new IllegalArgumentException("신고 없음"));
		Diary blindedDiary = diaryRepository.findById(diary.getId())
			.orElseThrow(() -> new IllegalArgumentException("일기 없음"));

		assertThat(approvedReport.getStatus()).isEqualTo(ReportStatus.APPROVED);
		assertThat(blindedDiary.getIsBlinded()).isEqualTo("Y");

		System.out.println("=== 일기 블라인드 처리 결과 ===");
		System.out.println("신고 ID: " + approvedReport.getId());
		System.out.println("상태: " + approvedReport.getStatus());
		System.out.println("블라인드 여부 (일기): " + blindedDiary.getIsBlinded());
	}

	@Test
	@DisplayName("신고 승인 후 답장 블라인드 처리")
	void approveReplyReportAndBlindTest() {

		Reply reply = Reply.builder()
			.title("테스트 답장 제목")
			.content("테스트 답장 내용")
			.createdAt(LocalDateTime.now())
			.isBlinded("N")
			.diaryRecordId(1)
			.senderId(1L)
			.receiverId(2L)
			.build();
		replyRepository.save(reply);

		Report report = new Report(1L, 2L, null, reply.getId(), 1L, "답장 신고 테스트");
		reportRepository.save(report);

		reportCommandService.approveReport(report.getId());

		Report approvedReport = reportRepository.findById(report.getId())
			.orElseThrow(() -> new IllegalArgumentException("신고 없음"));
		Reply blindedReply = replyRepository.findById(reply.getId())
			.orElseThrow(() -> new IllegalArgumentException("답장 없음"));

		assertThat(approvedReport.getStatus()).isEqualTo(ReportStatus.APPROVED);
		assertThat(blindedReply.getIsBlinded()).isEqualTo("Y");

		System.out.println("=== 답장 블라인드 처리 결과 ===");
		System.out.println("신고 ID: " + approvedReport.getId());
		System.out.println("상태: " + approvedReport.getStatus());
		System.out.println("블라인드 여부 (답장): " + blindedReply.getIsBlinded());
	}

	@Test
	@DisplayName("신고 삭제")
	void deleteReportTest() {

		Report report = new Report(1L, 2L, 1L, null, 1L, "삭제 테스트용 신고");
		reportRepository.save(report);

		reportCommandService.deleteReport(report.getId());

		Report deletedReport = reportRepository.findById(report.getId())
			.orElseThrow(() -> new IllegalArgumentException("신고 없음"));

		assertThat(deletedReport.getDeletedAt()).isNotNull();
		assertThat(deletedReport.getDeletedAt()).isBeforeOrEqualTo(LocalDateTime.now());

		System.out.println("=== 신고 삭제 결과 ===");
		System.out.println("신고 ID: " + deletedReport.getId());
		System.out.println("삭제된 시간: " + deletedReport.getDeletedAt());
	}
}

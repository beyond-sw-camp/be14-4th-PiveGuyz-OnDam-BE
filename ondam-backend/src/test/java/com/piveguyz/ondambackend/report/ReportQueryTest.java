package com.piveguyz.ondambackend.report;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.piveguyz.ondambackend.report.query.dto.ReportCategoryQueryDTO;
import com.piveguyz.ondambackend.report.query.dto.ReportContentQueryDTO;
import com.piveguyz.ondambackend.report.query.dto.ReportDetailQueryDTO;
import com.piveguyz.ondambackend.report.query.dto.ReportListQueryDTO;
import com.piveguyz.ondambackend.report.query.dto.enums.ReportStatus;
import com.piveguyz.ondambackend.report.query.service.ReportQueryService;

@SpringBootTest
@AutoConfigureMockMvc
public class ReportQueryTest {

	@Autowired
	private ReportQueryService reportQueryService;

	@Test
	@DisplayName("신고 목록 전체 조회(최신순)")
	void getAllReportsDesc() {
		List<ReportListQueryDTO> reports = reportQueryService.getReportList(null, "desc");
		assertThat(reports).isNotNull();
		assertThat(reports.size()).isGreaterThan(0);

		System.out.println("=== 전체 최신순 조회 ===");
		for (ReportListQueryDTO report : reports) {
			System.out.println("신고 ID: " + report.getId());
			System.out.println("작성일: " + report.getCreatedAt());
			System.out.println("상태: " + report.getStatus());
			System.out.println("신고자 이름: " + report.getReporterName());
			System.out.println("신고당한 사람 이름: " + report.getReportedMemberName());
			System.out.println("신고 카테고리명: " + report.getReportCategoryName());
			System.out.println("----------------------------------------");
		}
	}

	@Test
	@DisplayName("신고 목록 전체 조회(오래된순)")
	void getAllReportsAsc() {
		List<ReportListQueryDTO> reports = reportQueryService.getReportList(null, "asc");
		assertThat(reports).isNotNull();
		assertThat(reports.size()).isGreaterThan(0);

		System.out.println("=== 전체 오래된순 조회 ===");
		for (ReportListQueryDTO report : reports) {
			System.out.println("신고 ID: " + report.getId());
			System.out.println("작성일: " + report.getCreatedAt());
			System.out.println("상태: " + report.getStatus());
			System.out.println("신고자 이름: " + report.getReporterName());
			System.out.println("신고당한 사람 이름: " + report.getReportedMemberName());
			System.out.println("신고 카테고리명: " + report.getReportCategoryName());
			System.out.println("----------------------------------------");
		}
	}

	@Test
	@DisplayName("처리중인 신고만 조회")
	void getPendingReports() {
		List<ReportListQueryDTO> reports = reportQueryService.getReportList(0, "desc");
		assertThat(reports).isNotNull();

		System.out.println("=== 처리중 ===");
		for (ReportListQueryDTO report : reports) {
			assertThat(report.getStatus()).isEqualTo(ReportStatus.PENDING);
			System.out.println("신고 ID: " + report.getId());
			System.out.println("작성일: " + report.getCreatedAt());
			System.out.println("상태: " + report.getStatus());
			System.out.println("신고자 이름: " + report.getReporterName());
			System.out.println("신고당한 사람 이름: " + report.getReportedMemberName());
			System.out.println("신고 카테고리명: " + report.getReportCategoryName());
			System.out.println("----------------------------------------");
		}
	}

	@Test
	@DisplayName("승인 처리된 신고만 조회")
	void getApprovedReports() {
		List<ReportListQueryDTO> reports = reportQueryService.getReportList(1, "desc");
		assertThat(reports).isNotNull();

		System.out.println("=== 승인 ===");
		for (ReportListQueryDTO report : reports) {
			assertThat(report.getStatus()).isEqualTo(ReportStatus.APPROVED);
			System.out.println("신고 ID: " + report.getId());
			System.out.println("작성일: " + report.getCreatedAt());
			System.out.println("상태: " + report.getStatus());
			System.out.println("신고자 이름: " + report.getReporterName());
			System.out.println("신고당한 사람 이름: " + report.getReportedMemberName());
			System.out.println("신고 카테고리명: " + report.getReportCategoryName());
			System.out.println("----------------------------------------");
		}
	}

	@Test
	@DisplayName("거절 처리된 신고만 조회")
	void getRejectedReports() {
		List<ReportListQueryDTO> reports = reportQueryService.getReportList(2, "desc");
		assertThat(reports).isNotNull();

		System.out.println("=== 거절 ===");
		for (ReportListQueryDTO report : reports) {
			assertThat(report.getStatus()).isEqualTo(ReportStatus.REJECTED);
			System.out.println("신고 ID: " + report.getId());
			System.out.println("작성일: " + report.getCreatedAt());
			System.out.println("상태: " + report.getStatus());
			System.out.println("신고자 이름: " + report.getReporterName());
			System.out.println("신고당한 사람 이름: " + report.getReportedMemberName());
			System.out.println("신고 카테고리명: " + report.getReportCategoryName());
			System.out.println("----------------------------------------");
		}
	}

	@Test
	@DisplayName("신고 상세 조회")
	void getReportDetail() {
		Long reportId = 1L;

		ReportDetailQueryDTO reportDetail = reportQueryService.getReportDetail(reportId);

		assertThat(reportDetail).isNotNull();

		System.out.println("=== 신고 상세 조회 ===");
		System.out.println("신고 ID: " + reportDetail.getReportId());
		System.out.println("신고 당한 회원 이름: " + reportDetail.getReportedMemberName());
		System.out.println("신고 사유명: " + reportDetail.getReportCategoryName());
		System.out.println("신고 상세 내용: " + reportDetail.getReason());
	}

	@Test
	@DisplayName("신고된 일기/답장 컨텐츠 조회")
	void getReportedContent() {
		Long reportId = 1L;

		ReportContentQueryDTO content = reportQueryService.getReportedContent(reportId);

		assertThat(content).isNotNull();
		assertThat(content.getTitle()).isNotEmpty();
		assertThat(content.getContent()).isNotEmpty();
		assertThat(content.getCreatedAt()).isNotEmpty();

		System.out.println("=== 신고된 컨텐츠 조회 ===");
		System.out.println("제목: " + content.getTitle());
		System.out.println("작성일시: " + content.getCreatedAt());
		System.out.println("내용: " + content.getContent());
	}

	@Test
	@DisplayName("신고 카테고리 목록 조회")
	void getReportCategories() {
		List<ReportCategoryQueryDTO> categories = reportQueryService.getReportCategoryList();

		assertThat(categories).isNotNull();
		assertThat(categories.size()).isGreaterThan(0);

		System.out.println("=== 신고 카테고리 목록 ===");
		for (ReportCategoryQueryDTO category : categories) {
			System.out.println("카테고리 ID: " + category.getId());
			System.out.println("카테고리 이름: " + category.getName());
			System.out.println("----------------------------------------");
		}
	}

}

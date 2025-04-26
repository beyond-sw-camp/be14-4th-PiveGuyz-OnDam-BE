package com.piveguyz.ondambackend.report.query.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piveguyz.ondambackend.report.query.dto.ReportCategoryQueryDTO;
import com.piveguyz.ondambackend.report.query.dto.ReportContentQueryDTO;
import com.piveguyz.ondambackend.report.query.dto.ReportDetailQueryDTO;
import com.piveguyz.ondambackend.report.query.dto.ReportListQueryDTO;
import com.piveguyz.ondambackend.report.query.service.ReportQueryService;

import lombok.RequiredArgsConstructor;

@RestController("QueryReportController")
@RequestMapping("api/v1/report")
@RequiredArgsConstructor
public class ReportController {

	private final ReportQueryService reportQueryService;

	// 신고 목록 조회
	@GetMapping
	public List<ReportListQueryDTO> getReports(
		@RequestParam(required = false) Integer status,
		@RequestParam(required = false, defaultValue = "desc") String order
	) {
		return reportQueryService.getReportList(status, order);
	}

	// 신고 상세 조회
	@GetMapping("/{id}")
	public ReportDetailQueryDTO getReportDetail(@PathVariable("id") Long id) {
		return reportQueryService.getReportDetail(id);
	}

	// 신고 컨텐츠 조회
	@GetMapping("/content/{reportId}")
	public ReportContentQueryDTO getReportedContent(@PathVariable("reportId") Long reportId) {
		return reportQueryService.getReportedContent(reportId);
	}

	// 신고 카테고리 조회
	@GetMapping("/report-category")
	public List<ReportCategoryQueryDTO> getReportCategories() {
		return reportQueryService.getReportCategoryList();
	}
}

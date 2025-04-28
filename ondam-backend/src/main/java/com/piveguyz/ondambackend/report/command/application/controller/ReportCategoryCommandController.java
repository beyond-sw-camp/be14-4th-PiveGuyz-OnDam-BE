package com.piveguyz.ondambackend.report.command.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piveguyz.ondambackend.report.command.application.dto.ReportCategoryCommandDTO;
import com.piveguyz.ondambackend.report.command.application.service.ReportCategoryCommandService;

import lombok.RequiredArgsConstructor;

@RestController("CommandReportCategoryController")
@RequestMapping("/api/v1/report-category")
@RequiredArgsConstructor
public class ReportCategoryCommandController {

	private final ReportCategoryCommandService reportCategoryCommandService;

	// 신고 사유 등록
	@PostMapping
	public ResponseEntity<String> createCategory(@RequestBody ReportCategoryCommandDTO dto) {
		reportCategoryCommandService.createCategory(dto);
		return ResponseEntity.ok("신고 사유가 등록되었습니다.");
	}

	// 신고 사유 수정
	@PutMapping("/{categoryId}")
	public ResponseEntity<String> updateCategory(@PathVariable Long categoryId,
		@RequestBody ReportCategoryCommandDTO dto) {
		reportCategoryCommandService.updateCategory(categoryId, dto);
		return ResponseEntity.ok("신고 사유가 수정되었습니다.");
	}

	// 신고 사유 삭제
	@PutMapping("/delete/{categoryId}")
	public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
		reportCategoryCommandService.deleteCategory(categoryId);
		return ResponseEntity.ok("신고 사유가 삭제되었습니다.");
	}
}

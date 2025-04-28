package com.piveguyz.ondambackend.report;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.piveguyz.ondambackend.report.command.application.dto.ReportCategoryCommandDTO;
import com.piveguyz.ondambackend.report.command.application.service.ReportCategoryCommandService;
import com.piveguyz.ondambackend.report.command.domain.aggregate.ReportCategory;
import com.piveguyz.ondambackend.report.command.domain.repository.ReportCategoryRepository;

@SpringBootTest
@Transactional
public class ReportCategoryCommandTest {

	@Autowired
	private ReportCategoryCommandService reportCategoryCommandService;

	@Autowired
	private ReportCategoryRepository reportCategoryRepository;

	@Test
	@DisplayName("신고 사유 등록")
	void createCategoryTest() {

		ReportCategoryCommandDTO dto = new ReportCategoryCommandDTO();
		dto.setName("스팸 신고");

		reportCategoryCommandService.createCategory(dto);

		ReportCategory category = reportCategoryRepository.findTopByOrderByIdDesc()
			.orElseThrow(() -> new IllegalArgumentException("신고 사유 없음"));

		assertThat(category.getName()).isEqualTo("스팸 신고");

		System.out.println("=== 신고사유 등록 결과 ===");
		System.out.println("신고사유 이름: " + category.getName());
	}

	@Test
	@DisplayName("신고 사유 수정")
	void updateCategoryTest() {

		ReportCategory category = ReportCategory.builder()
			.name("욕설 및 비하 발언")
			.build();
		reportCategoryRepository.save(category);

		ReportCategoryCommandDTO dto = new ReportCategoryCommandDTO();
		dto.setName("폭력적인 언행");

		reportCategoryCommandService.updateCategory(category.getId(), dto);

		ReportCategory updatedCategory = reportCategoryRepository.findById(category.getId())
			.orElseThrow(() -> new IllegalArgumentException("카테고리 없음"));

		assertThat(updatedCategory.getName()).isEqualTo("폭력적인 언행");

		System.out.println("=== 신고사유 수정 결과 ===");
		System.out.println("변경된 이름: " + updatedCategory.getName());
	}

	@Test
	@DisplayName("신고 사유 삭제")
	void deleteCategoryTest() {

		ReportCategory category = ReportCategory.builder()
			.name("스팸 또는 광고")
			.build();
		reportCategoryRepository.save(category);

		reportCategoryCommandService.deleteCategory(category.getId());

		ReportCategory deletedCategory = reportCategoryRepository.findById(category.getId())
			.orElseThrow(() -> new IllegalArgumentException("카테고리 없음"));

		assertThat(deletedCategory.getDeletedAt()).isNotNull();

		System.out.println("=== 신고사유 삭제 결과 ===");
		System.out.println("삭제된 시간: " + deletedCategory.getDeletedAt());
	}
}

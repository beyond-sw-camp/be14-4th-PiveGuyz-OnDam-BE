package com.piveguyz.ondambackend.report.command.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.piveguyz.ondambackend.report.command.application.dto.ReportCategoryCommandDTO;
import com.piveguyz.ondambackend.report.command.domain.aggregate.ReportCategory;
import com.piveguyz.ondambackend.report.command.domain.repository.ReportCategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ReportCategoryCommandServiceImpl implements ReportCategoryCommandService {

	private final ReportCategoryRepository reportCategoryRepository;

	@Override
	public void createCategory(ReportCategoryCommandDTO dto) {
		ReportCategory category = ReportCategory.builder()
			.name(dto.getName())
			.build();
		reportCategoryRepository.save(category);
	}

	@Override
	public void updateCategory(Long categoryId, ReportCategoryCommandDTO dto) {
		ReportCategory category = reportCategoryRepository.findById(categoryId)
			.orElseThrow(() -> new IllegalArgumentException("해당 신고 사유가 존재하지 않습니다."));

		category.updateName(dto.getName());
	}

	@Override
	public void deleteCategory(Long categoryId) {
		ReportCategory category = reportCategoryRepository.findById(categoryId)
			.orElseThrow(() -> new IllegalArgumentException("해당 신고 사유가 존재하지 않습니다."));

		category.softDelete();
	}
}

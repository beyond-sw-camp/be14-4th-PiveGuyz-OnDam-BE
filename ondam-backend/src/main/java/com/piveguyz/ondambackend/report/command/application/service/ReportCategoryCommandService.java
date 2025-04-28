package com.piveguyz.ondambackend.report.command.application.service;

import com.piveguyz.ondambackend.report.command.application.dto.ReportCategoryCommandDTO;

public interface ReportCategoryCommandService {
	void createCategory(ReportCategoryCommandDTO dto);

	void updateCategory(Long categoryId, ReportCategoryCommandDTO dto);

	void deleteCategory(Long categoryId);
}

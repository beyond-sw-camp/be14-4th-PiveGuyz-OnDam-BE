package com.piveguyz.ondambackend.report.query.service;

import java.util.List;

import com.piveguyz.ondambackend.report.query.dto.ReportCategoryQueryDTO;
import com.piveguyz.ondambackend.report.query.dto.ReportContentQueryDTO;
import com.piveguyz.ondambackend.report.query.dto.ReportDetailQueryDTO;
import com.piveguyz.ondambackend.report.query.dto.ReportListQueryDTO;

public interface ReportQueryService {
	List<ReportListQueryDTO> getReportList(Integer status, String order);

	ReportDetailQueryDTO getReportDetail(Long id);

	ReportContentQueryDTO getReportedContent(Long reportId);

	List<ReportCategoryQueryDTO> getReportCategoryList();
}

package com.piveguyz.ondambackend.report.query.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.piveguyz.ondambackend.report.command.domain.repository.ReportRepository;
import com.piveguyz.ondambackend.report.query.dto.ReportCategoryQueryDTO;
import com.piveguyz.ondambackend.report.query.dto.ReportContentQueryDTO;
import com.piveguyz.ondambackend.report.query.dto.ReportDetailQueryDTO;
import com.piveguyz.ondambackend.report.query.dto.ReportListQueryDTO;
import com.piveguyz.ondambackend.report.query.mapper.ReportQueryMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportQueryServiceImpl implements ReportQueryService {

	private final ReportQueryMapper reportQueryMapper;

	@Override
	public List<ReportListQueryDTO> getReportList(Integer status, String order) {
		return reportQueryMapper.selectReportList(status, order);
	}

	@Override
	public ReportDetailQueryDTO getReportDetail(Long id) {
		return reportQueryMapper.selectReportDetail(id);
	}

	@Override
	public ReportContentQueryDTO getReportedContent(Long reportId) {
		return reportQueryMapper.selectReportedContent(reportId);
	}

	@Override
	public List<ReportCategoryQueryDTO> getReportCategoryList() {
		return reportQueryMapper.selectReportCategoryList();
	}
}

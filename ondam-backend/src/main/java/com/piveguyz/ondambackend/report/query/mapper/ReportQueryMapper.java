package com.piveguyz.ondambackend.report.query.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.piveguyz.ondambackend.report.query.dto.ReportCategoryQueryDTO;
import com.piveguyz.ondambackend.report.query.dto.ReportContentQueryDTO;
import com.piveguyz.ondambackend.report.query.dto.ReportDetailQueryDTO;
import com.piveguyz.ondambackend.report.query.dto.ReportListQueryDTO;

@Mapper
public interface ReportQueryMapper {
	List<ReportListQueryDTO> selectReportList(@Param("status") Integer status, @Param("order") String order);

	ReportDetailQueryDTO selectReportDetail(@Param("id") Long id);

	ReportContentQueryDTO selectReportedContent(@Param("reportId") Long reportId);

	List<ReportCategoryQueryDTO> selectReportCategoryList();
}

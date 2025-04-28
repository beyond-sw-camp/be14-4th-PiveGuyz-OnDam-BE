package com.piveguyz.ondambackend.analysis.query.mapper;

import com.piveguyz.ondambackend.analysis.query.dto.AnalysisResultDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnalysisResultMapper {
    AnalysisResultDTO selectAnalysisResult(Long counselId);
}

package com.piveguyz.ondambackend.analysis.query.mapper;

import com.piveguyz.ondambackend.analysis.query.dto.AnalysisResultDTO;
import com.piveguyz.ondambackend.analysis.query.dto.EmotionAnalysisDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnalysisResultMapper {
    AnalysisResultDTO selectAnalysisResult(Long counselId);

    List<EmotionAnalysisDTO> selectEmotionAnalysisList(Long id);
}

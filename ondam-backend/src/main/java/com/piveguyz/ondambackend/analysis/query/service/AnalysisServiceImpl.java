package com.piveguyz.ondambackend.analysis.query.service;

import com.piveguyz.ondambackend.analysis.query.dto.AnalysisResultDTO;
import com.piveguyz.ondambackend.analysis.query.mapper.AnalysisResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("QueryAnalysisService")
public class AnalysisServiceImpl implements AnalysisService {
    private final AnalysisResultMapper analysisResultMapper;

    @Autowired
    public AnalysisServiceImpl(AnalysisResultMapper analysisResultMapper) {
        this.analysisResultMapper = analysisResultMapper;
    }

    @Override
    public AnalysisResultDTO getAnalysisResult(Long counselId) {
        return analysisResultMapper.selectAnalysisResult(counselId);
    }

}

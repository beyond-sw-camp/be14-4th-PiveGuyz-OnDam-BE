package com.piveguyz.ondambackend.analysis.query.service;

import com.piveguyz.ondambackend.analysis.query.dto.AnalysisResultDTO;

public interface AnalysisService {
    AnalysisResultDTO getAnalysisResult(Long counselId);
}

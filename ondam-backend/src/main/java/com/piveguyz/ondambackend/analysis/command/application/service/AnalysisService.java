package com.piveguyz.ondambackend.analysis.command.application.service;

import com.piveguyz.ondambackend.analysis.command.application.dto.ChatCompletionDTO;

import java.util.Map;

public interface AnalysisService {

    void askGpt(ChatCompletionDTO chatCompletionDto);

    void saveAnalysis(Map<String, Object> resultMap, Long counselId);

    void testSaveAnalysis(Long counselId);
}

package com.piveguyz.ondambackend.analysis.command.application.service;
import com.piveguyz.ondambackend.analysis.command.application.dto.ChatCompletionDTO;
import java.util.Map;

public interface AnalysisService {

    Map<String, Object> askGpt(ChatCompletionDTO chatCompletionDto);
}

package com.piveguyz.ondambackend.analysis.command.application.controller;

import com.piveguyz.ondambackend.analysis.command.application.dto.ChatCompletionDTO;
import com.piveguyz.ondambackend.analysis.command.application.service.AnalysisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/analysis")
@Slf4j
public class AnalysisCommandController {

    private final AnalysisService analysisService;

    public AnalysisCommandController(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @PostMapping("/gpt/prompt")
    public ResponseEntity<Map<String, Object>> registGPTResponse(@RequestBody ChatCompletionDTO chatCompletionDto) {
        log.info("chatCompletionDto : " + chatCompletionDto.toString());

        if (chatCompletionDto.getMessages() == null || chatCompletionDto.getMessages().isEmpty()) {
            return new ResponseEntity<>(Map.of("error", "User message is required"), HttpStatus.BAD_REQUEST);
        }

        analysisService.askGpt(chatCompletionDto);
//        analysisService.testSaveAnalysis(4L);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("success", "true"));
    }


}
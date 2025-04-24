package com.piveguyz.ondambackend.analysis.command.application.controller;

import com.piveguyz.ondambackend.analysis.command.application.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/analysis")
public class AnalysisController {

    private final AnalysisService analysisService;

    @Autowired
    public AnalysisController(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @PostMapping("/gpt")
    public ResponseEntity<?> askGpt(@RequestParam("prompt") String prompt, @RequestParam("file") MultipartFile file) {

        try {
            String fileContent = new String(file.getBytes(), StandardCharsets.UTF_8);
            String result = analysisService.askGpt(prompt, fileContent);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("에러 발생: " + e.getMessage());
        }
    }

}
package com.piveguyz.ondambackend.analysis.command.application.service;

public interface AnalysisService {

    String askGpt(String prompt, String fileContent);
}

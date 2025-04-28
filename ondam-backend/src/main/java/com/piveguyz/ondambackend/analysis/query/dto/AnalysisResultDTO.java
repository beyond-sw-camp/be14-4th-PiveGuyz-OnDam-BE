package com.piveguyz.ondambackend.analysis.query.dto;

import lombok.*;

import java.util.List;

@ToString
@Getter
@NoArgsConstructor
public class AnalysisResultDTO {
    private Long id;
    private TroubleSummaryDTO troubleSummary;
    private List<EmotionAnalysisDTO> emotionAnalysisList;
    private EffectiveStatementDTO effectiveStatement;
    private ShortenedCounselDTO shortenedCounsel;

    @Builder
    public AnalysisResultDTO(Long id,
                             TroubleSummaryDTO troubleSummary,
                             List<EmotionAnalysisDTO> emotionAnalysisList,
                             EffectiveStatementDTO effectiveStatement,
                             ShortenedCounselDTO shortenedCounsel) {
        this.id = id;
        this.troubleSummary = troubleSummary;
        this.emotionAnalysisList = emotionAnalysisList;
        this.effectiveStatement = effectiveStatement;
        this.shortenedCounsel = shortenedCounsel;
    }
}
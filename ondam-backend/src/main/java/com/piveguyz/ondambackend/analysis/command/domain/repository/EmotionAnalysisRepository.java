package com.piveguyz.ondambackend.analysis.command.domain.repository;

import com.piveguyz.ondambackend.analysis.command.domain.aggregate.EmotionAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmotionAnalysisRepository extends JpaRepository<EmotionAnalysis, Long> {
    void deleteByAnalysisId(Long analysisId);
}

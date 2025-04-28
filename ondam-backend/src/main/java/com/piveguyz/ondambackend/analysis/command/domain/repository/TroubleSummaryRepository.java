package com.piveguyz.ondambackend.analysis.command.domain.repository;

import com.piveguyz.ondambackend.analysis.command.domain.aggregate.TroubleSummary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TroubleSummaryRepository extends JpaRepository<TroubleSummary, Long> {
    Optional<TroubleSummary> findByAnalysisId(Long analysisId);
}

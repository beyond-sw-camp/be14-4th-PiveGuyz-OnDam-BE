package com.piveguyz.ondambackend.analysis.command.domain.repository;

import com.piveguyz.ondambackend.analysis.command.domain.aggregate.ShortenedCounsel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShortenedCounselRepository extends JpaRepository<ShortenedCounsel, Long> {
    Optional<ShortenedCounsel> findByAnalysisId(Long analysisId);
}

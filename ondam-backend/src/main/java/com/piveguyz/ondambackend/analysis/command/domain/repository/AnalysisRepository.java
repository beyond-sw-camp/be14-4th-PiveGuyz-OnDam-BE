package com.piveguyz.ondambackend.analysis.command.domain.repository;


import com.piveguyz.ondambackend.analysis.command.domain.aggregate.Analysis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnalysisRepository extends JpaRepository<Analysis, Long> {
    Optional<Analysis> findByCounselId(Long counselId);
}

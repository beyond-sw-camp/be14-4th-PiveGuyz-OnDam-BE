package com.piveguyz.ondambackend.analysis.command.domain.repository;

import com.piveguyz.ondambackend.analysis.command.domain.aggregate.TroubleSummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounselSummaryRepository extends JpaRepository<TroubleSummary, Long> {
}

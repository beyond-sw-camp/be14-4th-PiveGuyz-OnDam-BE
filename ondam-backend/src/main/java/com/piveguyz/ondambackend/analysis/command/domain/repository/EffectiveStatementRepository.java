package com.piveguyz.ondambackend.analysis.command.domain.repository;

import com.piveguyz.ondambackend.analysis.command.domain.aggregate.EffectiveStatement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EffectiveStatementRepository extends JpaRepository<EffectiveStatement, Integer> {
}

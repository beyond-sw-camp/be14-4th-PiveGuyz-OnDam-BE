package com.piveguyz.ondambackend.report.command.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piveguyz.ondambackend.report.command.domain.aggregate.ReportCategory;

public interface ReportCategoryRepository extends JpaRepository<ReportCategory, Long> {

	Optional<ReportCategory> findTopByOrderByIdDesc();
}

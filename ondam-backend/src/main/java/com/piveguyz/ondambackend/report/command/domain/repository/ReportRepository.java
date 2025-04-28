package com.piveguyz.ondambackend.report.command.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piveguyz.ondambackend.report.command.domain.aggregate.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {
}

package com.piveguyz.ondambackend.counsel.command.domain.repository;

import com.piveguyz.ondambackend.counsel.command.domain.aggregate.entity.CounselEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounselRepository extends JpaRepository<CounselEntity, Long> {
}
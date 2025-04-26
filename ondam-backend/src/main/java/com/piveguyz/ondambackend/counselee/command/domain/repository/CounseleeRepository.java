package com.piveguyz.ondambackend.counselee.command.domain.repository;

import com.piveguyz.ondambackend.counselee.command.domain.aggregate.entity.CounseleeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounseleeRepository extends JpaRepository<CounseleeEntity, Long> {
    boolean existsByMemberIdAndDeletedAtIsNull(Long memberId);
    CounseleeEntity findByIdAndDeletedAtIsNull(Long id);
    void deleteByIdAndDeletedAtIsNull(Long id);
    boolean existsByMemberId(Long memberId);
}

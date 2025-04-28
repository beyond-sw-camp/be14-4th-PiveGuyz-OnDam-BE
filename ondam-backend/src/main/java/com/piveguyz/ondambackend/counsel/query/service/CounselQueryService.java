package com.piveguyz.ondambackend.counsel.query.service;

import com.piveguyz.ondambackend.counsel.query.dto.CounselQueryDTO;
import java.time.LocalDateTime;
import java.util.List;

public interface CounselQueryService {
    // 상담사 ID로 상담 기록 조회
    List<CounselQueryDTO> findByMemberId(Long memberId);

    // 내담자 ID로 상담 기록 조회
    List<CounselQueryDTO> findByCounseleeId(Long counseleeId);

    // 상담 기록 상세 조회
    CounselQueryDTO findById(Long id);

    // 기간별 상담 기록 조회
    List<CounselQueryDTO> findByDateRange(LocalDateTime startDate, LocalDateTime endDate);

    // 예정된 상담 일정 조회
    List<CounselQueryDTO> findUpcomingCounsels();
}
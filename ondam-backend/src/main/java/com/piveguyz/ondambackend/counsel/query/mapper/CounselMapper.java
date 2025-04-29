package com.piveguyz.ondambackend.counsel.query.mapper;

import com.piveguyz.ondambackend.counsel.query.dto.CounselQueryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface CounselMapper {
    // 상담사 ID로 상담 기록 조회
    List<CounselQueryDTO> findByMemberId(@Param("memberId") Long memberId);

    // 내담자 ID로 상담 기록 조회
    List<CounselQueryDTO> findByCounseleeId(@Param("counseleeId") Long counseleeId);

    // ID로 상담 기록 상세 조회
    CounselQueryDTO findById(@Param("id") Long id);

    // 기간별 상담 기록 조회
    List<CounselQueryDTO> findByDateRange(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );

    // 예정된 상담 일정 조회
    List<CounselQueryDTO> findUpcomingCounsels();
}
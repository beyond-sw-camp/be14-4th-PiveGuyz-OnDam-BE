package com.piveguyz.ondambackend.counselee.query.service;

import com.piveguyz.ondambackend.counselee.query.dto.CounseleeQueryDTO;

import java.util.List;

public interface CounseleeQueryService {
    // 조회 관련
    List<CounseleeQueryDTO> findAllByMemberId(Long memberId);
    CounseleeQueryDTO findById(Long id);
    List<CounseleeQueryDTO> searchByName(Long memberId, String name);
    List<CounseleeQueryDTO> findActiveCounselees(Long memberId);
    int countByMemberId(Long memberId);
}
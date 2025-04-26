package com.piveguyz.ondambackend.counselee.query.service;

import com.piveguyz.ondambackend.counselee.query.dto.CounseleeDTO;

import java.util.List;

public interface CounseleeQueryService {
    // 조회 관련
    List<CounseleeDTO> findAllByMemberId(Long memberId);
    CounseleeDTO findById(Long id);
    List<CounseleeDTO> searchByName(Long memberId, String name);
    List<CounseleeDTO> findActiveCounselees(Long memberId);
    int countByMemberId(Long memberId);
    void deleteCounselee(Long id);
}
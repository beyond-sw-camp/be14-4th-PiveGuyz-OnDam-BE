package com.piveguyz.ondambackend.counselee.query.service;

import com.piveguyz.ondambackend.counselee.query.dto.CounseleeDTO;

import java.util.List;

public interface CounseleeService {
    // 조회 관련
    List<CounseleeDTO> findAllByMemberId(Long memberId);
    CounseleeDTO findById(Long id);
    List<CounseleeDTO> searchByName(Long memberId, String name);
    List<CounseleeDTO> findActiveCounselees(Long memberId);
    int countByMemberId(Long memberId);
    
    // 생성, 수정, 삭제 관련
//    Long createCounselee(CreateCounseleeCommand command);
//    void updateCounselee(Long id, UpdateCounseleeCommand command);
    void deleteCounselee(Long id);
    
    // 상담 종료 관련
//    void endCounseling(Long id, EndCounselingCommand command);
}
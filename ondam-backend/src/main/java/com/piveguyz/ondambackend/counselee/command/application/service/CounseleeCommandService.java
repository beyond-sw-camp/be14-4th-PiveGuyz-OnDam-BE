package com.piveguyz.ondambackend.counselee.command.application.service;

import com.piveguyz.ondambackend.counselee.command.application.dto.CounseleeCreateDTO;

public interface CounseleeCommandService {
    // 생성
    Long createCounselee(CounseleeCreateDTO dto);
    
    // 수정
    void updateCounselee(Long id, CounseleeCreateDTO dto);
    
    // 삭제 (소프트 딜리트)
    void deleteCounselee(Long id);
    
    // 상담 종료
    void endCounseling(Long id, String endReason);
    
    // 존재 여부 확인
    boolean existsCounselee(Long memberId);
}
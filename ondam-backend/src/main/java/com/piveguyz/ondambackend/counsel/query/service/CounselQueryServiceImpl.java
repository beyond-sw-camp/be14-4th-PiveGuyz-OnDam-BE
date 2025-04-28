package com.piveguyz.ondambackend.counsel.query.service;

import com.piveguyz.ondambackend.counsel.query.dto.CounselQueryDTO;
import com.piveguyz.ondambackend.counsel.query.mapper.CounselMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CounselQueryServiceImpl implements CounselQueryService {

    private final CounselMapper counselMapper;

    @Override
    public List<CounselQueryDTO> findByMemberId(Long memberId) {
        log.info("상담사 ID로 상담 기록 조회: {}", memberId);
        List<CounselQueryDTO> counsels = counselMapper.findByMemberId(memberId);
        
        if (counsels.isEmpty()) {
            log.warn("상담사 ID {}에 대한 상담 기록이 없습니다", memberId);
        }
        
        return counsels;
    }

    @Override
    public List<CounselQueryDTO> findByCounseleeId(Long counseleeId) {
        log.info("내담자 ID로 상담 기록 조회: {}", counseleeId);
        List<CounselQueryDTO> counsels = counselMapper.findByCounseleeId(counseleeId);
        
        if (counsels.isEmpty()) {
            log.warn("내담자 ID {}에 대한 상담 기록이 없습니다", counseleeId);
        }
        
        return counsels;
    }

    @Override
    public CounselQueryDTO findById(Long id) {
        log.info("상담 기록 상세 조회: {}", id);
        CounselQueryDTO counsel = counselMapper.findById(id);
        
        if (counsel == null) {
            log.error("상담 기록을 찾을 수 없습니다: {}", id);
            throw new EntityNotFoundException("해당 상담 기록을 찾을 수 없습니다: " + id);
        }
        
        return counsel;
    }

    @Override
    public List<CounselQueryDTO> findByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        log.info("기간별 상담 기록 조회: {} ~ {}", startDate, endDate);
        List<CounselQueryDTO> counsels = counselMapper.findByDateRange(startDate, endDate);
        
        if (counsels.isEmpty()) {
            log.warn("해당 기간에 상담 기록이 없습니다: {} ~ {}", startDate, endDate);
        }
        
        return counsels;
    }

    @Override
    public List<CounselQueryDTO> findUpcomingCounsels() {
        log.info("예정된 상담 일정 조회");
        List<CounselQueryDTO> counsels = counselMapper.findUpcomingCounsels();
        
        if (counsels.isEmpty()) {
            log.warn("예정된 상담 일정이 없습니다");
        }
        
        return counsels;
    }
}
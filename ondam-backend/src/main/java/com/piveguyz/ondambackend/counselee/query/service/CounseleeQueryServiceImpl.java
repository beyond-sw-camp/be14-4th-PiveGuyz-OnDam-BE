package com.piveguyz.ondambackend.counselee.query.service;

import com.piveguyz.ondambackend.counselee.query.dto.CounseleeDTO;
import com.piveguyz.ondambackend.counselee.query.mapper.CounseleeMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CounseleeQueryServiceImpl implements CounseleeQueryService {

    private final CounseleeMapper counseleeMapper;

    @Override
    public List<CounseleeDTO> findAllByMemberId(Long memberId) {
        log.info("Fetching all counselees for member id: {}", memberId);
        return counseleeMapper.findAllByMemberId(memberId);
    }
    
    @Override
    public CounseleeDTO findById(Long id) {
        log.info("Fetching counselee with id: {}", id);
        CounseleeDTO counselee = counseleeMapper.findById(id);
        if (counselee == null) {
            throw new EntityNotFoundException("Counselee not found with id: " + id);
        }
        return counselee;
    }
    
    @Override
    public List<CounseleeDTO> searchByName(Long memberId, String name) {
        log.info("Searching counselees for member id: {} with name containing: {}", memberId, name);
        return counseleeMapper.findByNameContaining(memberId, name);
    }
    
    @Override
    public List<CounseleeDTO> findActiveCounselees(Long memberId) {
        log.info("Fetching active counselees for member id: {}", memberId);
        return counseleeMapper.findActiveCounselees(memberId);
    }
    
    @Override
    public int countByMemberId(Long memberId) {
        return counseleeMapper.countByMemberId(memberId);
    }
    
    @Override
    @Transactional
    public void deleteCounselee(Long id) {
        log.info("Deleting counselee with id: {}", id);
        
        CounseleeDTO existingCounselee = findById(id);
        if (existingCounselee == null) {
            throw new EntityNotFoundException("Counselee not found with id: " + id);
        }
        
        // Soft delete 구현 필요
    }
}
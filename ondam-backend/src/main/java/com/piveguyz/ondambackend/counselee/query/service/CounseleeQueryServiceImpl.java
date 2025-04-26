package com.piveguyz.ondambackend.counselee.query.service;

import com.piveguyz.ondambackend.counselee.query.dto.CounseleeQueryDTO;
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
    public List<CounseleeQueryDTO> findAllByMemberId(Long memberId) {
        log.info("Fetching all counselees for member id: {}", memberId);
        return counseleeMapper.findAllByMemberId(memberId);
    }
    
    @Override
    public CounseleeQueryDTO findById(Long id) {
        log.info("Fetching counselee with id: {}", id);
        CounseleeQueryDTO counselee = counseleeMapper.findById(id);
        if (counselee == null) {
            throw new EntityNotFoundException("Counselee not found with id: " + id);
        }
        return counselee;
    }

    @Override
    public List<CounseleeQueryDTO> searchByName(Long memberId, String name) {
        log.info("Searching counselees for member id: {} with name containing: {}", memberId, name);
        List<CounseleeQueryDTO> results = counseleeMapper.findByNameContaining(memberId, name);

        if (results.isEmpty()) {
            throw new EntityNotFoundException("해당 이름의 내담자를 찾을 수 없습니다: " + name);
        }

        return results;
    }
    
    @Override
    public List<CounseleeQueryDTO> findActiveCounselees(Long memberId) {
        log.info("Fetching active counselees for member id: {}", memberId);
        return counseleeMapper.findActiveCounselees(memberId);
    }
    
    @Override
    public int countByMemberId(Long memberId) {
        return counseleeMapper.countByMemberId(memberId);
    }
}
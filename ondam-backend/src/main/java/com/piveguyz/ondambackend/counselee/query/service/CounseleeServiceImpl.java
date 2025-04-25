package com.piveguyz.ondambackend.counselee.query.service;

//import com.piveguyz.ondambackend.counselee.command.model.Counselee;
//import com.piveguyz.ondambackend.counselee.command.model.CreateCounseleeCommand;
//import com.piveguyz.ondambackend.counselee.command.model.EndCounselingCommand;
//import com.piveguyz.ondambackend.counselee.command.model.UpdateCounseleeCommand;
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
public class CounseleeServiceImpl implements CounseleeService {

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
    
//    @Override
//    @Transactional
//    public Long createCounselee(CreateCounseleeCommand command) {
//        log.info("Creating new counselee for member id: {}", command.getMemberId());
//
//        validateCounseleeData(command);
//
//        // Entity 생성 및 저장 로직
//        Counselee counselee = Counselee.builder()
//                .memberId(command.getMemberId())
//                .name(command.getName())
//                .birthday(command.getBirthday())
//                .gender(command.getGender())
//                .phone(command.getPhone())
//                .emePhone(command.getEmePhone())
//                .address(command.getAddress())
//                .severityLevel(command.getSeverityLevel())
//                .build();
//
//        // 저장 로직 구현 필요
//
//        return counselee.getId();
//    }
    
//    @Override
//    @Transactional
//    public void updateCounselee(Long id, UpdateCounseleeCommand command) {
//        log.info("Updating counselee with id: {}", id);
//
//        CounseleeDTO existingCounselee = findById(id);
//        if (existingCounselee == null) {
//            throw new EntityNotFoundException("Counselee not found with id: " + id);
//        }
//
//        validateCounseleeData(command);
//
//        // 업데이트 로직 구현 필요
//    }
    
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
    
//    @Override
//    @Transactional
//    public void endCounseling(Long id, EndCounselingCommand command) {
//        log.info("Ending counseling for counselee with id: {}", id);
//
//        CounseleeDTO existingCounselee = findById(id);
//        if (existingCounselee == null) {
//            throw new EntityNotFoundException("Counselee not found with id: " + id);
//        }
//
//        // 상담 종료 로직 구현 필요
//    }
    
//    private void validateCounseleeData(CreateCounseleeCommand command) {
//        if (command.getName() == null || command.getName().trim().isEmpty()) {
//            throw new IllegalArgumentException("Name cannot be empty");
//        }
//        if (command.getBirthday() == null || command.getBirthday().trim().isEmpty()) {
//            throw new IllegalArgumentException("Birthday cannot be empty");
//        }
//        if (command.getPhone() == null || command.getPhone().trim().isEmpty()) {
//            throw new IllegalArgumentException("Phone number cannot be empty");
//        }
//        // 추가 유효성 검사...
//    }
}
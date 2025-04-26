package com.piveguyz.ondambackend.counselee.command.application.service;

import com.piveguyz.ondambackend.counselee.command.application.dto.CounseleeCreateDTO;
import com.piveguyz.ondambackend.counselee.command.domain.aggregate.entity.CounseleeEntity;
import com.piveguyz.ondambackend.counselee.command.domain.aggregate.vo.Birthday;
import com.piveguyz.ondambackend.counselee.command.domain.aggregate.vo.Gender;
import com.piveguyz.ondambackend.counselee.command.domain.aggregate.vo.PhoneNumber;
import com.piveguyz.ondambackend.counselee.command.domain.repository.CounseleeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CounseleeCommandServiceImpl implements CounseleeCommandService {

    private final CounseleeRepository counseleeRepository;

    @Override
    @Transactional
    public Long createCounselee(CounseleeCreateDTO dto) {
        log.info("Creating new counselee for member id: {}", dto.getMemberId());

        CounseleeEntity counselee = CounseleeEntity.builder()
                .memberId(dto.getMemberId())
                .name(dto.getName())
                .birthday(new Birthday(dto.getBirthday()))
                .gender(Gender.valueOf(dto.getGender()))
                .phone(new PhoneNumber(dto.getPhone()))
                .emePhone(dto.getEmePhone() != null ? new PhoneNumber(dto.getEmePhone()) : null)
                .address(dto.getAddress())
                .severityLevel(dto.getSeverityLevel())
                .build();

        CounseleeEntity savedCounselee = counseleeRepository.save(counselee);
        return savedCounselee.getId();
    }

    @Override
    @Transactional
    public void updateCounselee(Long id, CounseleeCreateDTO dto) {
        log.info("Updating counselee with id: {}", id);

        CounseleeEntity counselee = counseleeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Counselee not found with id: " + id));

        counselee.update(
                dto.getName(),
                new Birthday(dto.getBirthday()),
                Gender.valueOf(dto.getGender()),
                new PhoneNumber(dto.getPhone()),
                dto.getEmePhone() != null ? new PhoneNumber(dto.getEmePhone()) : null,
                dto.getAddress(),
                dto.getSeverityLevel()
        );
    }

    @Override
    @Transactional
    public void deleteCounselee(Long id) {
        log.info("Deleting counselee with id: {}", id);
        
        CounseleeEntity counselee = counseleeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Counselee not found with id: " + id));
        
        counselee.delete();
    }

    @Override
    @Transactional
    public void endCounseling(Long id, String endReason) {
        log.info("Ending counseling for counselee with id: {}", id);

        CounseleeEntity counselee = counseleeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Counselee not found with id: " + id));

        counselee.endCounseling(endReason);
    }

    @Override
    public boolean existsCounselee(Long memberId) {
        return counseleeRepository.existsByMemberId(memberId);
    }
}
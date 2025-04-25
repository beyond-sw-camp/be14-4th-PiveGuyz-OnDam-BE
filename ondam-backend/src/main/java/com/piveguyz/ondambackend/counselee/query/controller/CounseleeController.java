package com.piveguyz.ondambackend.counselee.query.controller;

import com.piveguyz.ondambackend.common.response.ErrorResponse;
import com.piveguyz.ondambackend.counselee.query.dto.CounseleeDTO;
import com.piveguyz.ondambackend.counselee.query.service.CounseleeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/counselees")
@RequiredArgsConstructor
public class CounseleeController {

    private final CounseleeService counseleeService;

    // 내담자 목록 조회
    @GetMapping
    public ResponseEntity<List<CounseleeDTO>> getCounseleesByMemberId(
            @RequestParam Long memberId) {
        List<CounseleeDTO> counselees = counseleeService.findAllByMemberId(memberId);
        return ResponseEntity.ok(counselees);
    }

    // 내담자 상세 조회
    @GetMapping("/{id}")
    public ResponseEntity<CounseleeDTO> getCounselee(@PathVariable Long id) {
        CounseleeDTO counselee = counseleeService.findById(id);
        return ResponseEntity.ok(counselee);
    }

    // 내담자 이름으로 검색
    @GetMapping("/search")
    public ResponseEntity<List<CounseleeDTO>> searchCounselees(
            @RequestParam Long memberId,
            @RequestParam String name) {
        List<CounseleeDTO> counselees = counseleeService.searchByName(memberId, name);
        return ResponseEntity.ok(counselees);
    }

    // 활성 내담자 목록 조회
    @GetMapping("/active")
    public ResponseEntity<List<CounseleeDTO>> getActiveCounselees(
            @RequestParam Long memberId) {
        List<CounseleeDTO> activeCounselees = counseleeService.findActiveCounselees(memberId);
        return ResponseEntity.ok(activeCounselees);
    }

    // 내담자 수 조회
    @GetMapping("/count")
    public ResponseEntity<Integer> getCounseleeCount(@RequestParam Long memberId) {
        int count = counseleeService.countByMemberId(memberId);
        return ResponseEntity.ok(count);
    }

    // 내담자 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCounselee(@PathVariable Long id) {
        counseleeService.deleteCounselee(id);
        return ResponseEntity.noContent().build();
    }

    // 예외 처리
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException e) {
        ErrorResponse error = new ErrorResponse(
                "NOT_FOUND",
                e.getMessage()
        );
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        ErrorResponse error = new ErrorResponse(
                "BAD_REQUEST",
                e.getMessage()
        );
        return ResponseEntity.badRequest().body(error);
    }
}
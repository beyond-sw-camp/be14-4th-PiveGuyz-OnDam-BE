package com.piveguyz.ondambackend.counsel.query.controller;

import com.piveguyz.ondambackend.common.response.ErrorResponse;
import com.piveguyz.ondambackend.counsel.query.dto.CounselQueryDTO;
import com.piveguyz.ondambackend.counsel.query.service.CounselQueryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/counsels")
@RequiredArgsConstructor
public class CounselQueryController {

    private final CounselQueryService counselQueryService;

    // 상담사별 상담 기록 조회
    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<CounselQueryDTO>> getCounselsByMemberId(
            @PathVariable Long memberId) {
        List<CounselQueryDTO> counsels = counselQueryService.findByMemberId(memberId);
        return ResponseEntity.ok(counsels);
    }

    // 내담자별 상담 기록 조회
    @GetMapping("/counselee/{counseleeId}")
    public ResponseEntity<List<CounselQueryDTO>> getCounselsByCounseleeId(
            @PathVariable Long counseleeId) {
        List<CounselQueryDTO> counsels = counselQueryService.findByCounseleeId(counseleeId);
        return ResponseEntity.ok(counsels);
    }

    // 상담 기록 상세 조회
    @GetMapping("/{id}")
    public ResponseEntity<CounselQueryDTO> getCounsel(
            @PathVariable Long id) {
        CounselQueryDTO counsel = counselQueryService.findById(id);
        return ResponseEntity.ok(counsel);
    }

    // 기간별 상담 기록 조회
    @GetMapping("/date-range")
    public ResponseEntity<List<CounselQueryDTO>> getCounselsByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        List<CounselQueryDTO> counsels = counselQueryService.findByDateRange(startDate, endDate);
        return ResponseEntity.ok(counsels);
    }

    // 예정된 상담 일정 조회
    @GetMapping("/upcoming")
    public ResponseEntity<List<CounselQueryDTO>> getUpcomingCounsels() {
        List<CounselQueryDTO> counsels = counselQueryService.findUpcomingCounsels();
        return ResponseEntity.ok(counsels);
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
package com.piveguyz.ondambackend.counselee.command.application.controller;

import com.piveguyz.ondambackend.common.response.ErrorResponse;
import com.piveguyz.ondambackend.counselee.command.application.dto.CounseleeCreateDTO;
import com.piveguyz.ondambackend.counselee.command.application.service.CounseleeCommandService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/counselees")
@RequiredArgsConstructor
public class CounseleeCommandController {

    private final CounseleeCommandService counseleeService;

    @PostMapping
    public ResponseEntity<Void> createCounselee(@Valid @RequestBody CounseleeCreateDTO dto) {
        Long id = counseleeService.createCounselee(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCounselee(
            @PathVariable Long id,
            @Valid @RequestBody CounseleeCreateDTO dto) {
        counseleeService.updateCounselee(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCounselee(@PathVariable Long id) {
        counseleeService.deleteCounselee(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/end")
    public ResponseEntity<Void> endCounseling(
            @PathVariable Long id,
            @RequestParam String endReason) {
        counseleeService.endCounseling(id, endReason);
        return ResponseEntity.noContent().build();
    }

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
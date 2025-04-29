package com.piveguyz.ondambackend.counsel.command.application.controller;

import com.piveguyz.ondambackend.counsel.command.application.dto.CounselCommandDTO;
import com.piveguyz.ondambackend.counsel.command.application.service.CounselCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/counsels")
@RequiredArgsConstructor
public class CounselCommandController {

    private final CounselCommandService counselCommandService;

    @PostMapping
    public ResponseEntity<CounselCommandDTO.Response> createCounsel(
            @Valid @RequestBody CounselCommandDTO.CreateRequest request) {
        CounselCommandDTO.Response response = counselCommandService.createCounsel(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{counselId}")
    public ResponseEntity<CounselCommandDTO.Response> updateCounsel(
            @PathVariable Long counselId,
            @Valid @RequestBody CounselCommandDTO.UpdateRequest request) {
        CounselCommandDTO.Response response = counselCommandService.updateCounsel(counselId, request);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{counselId}/next-date")
    public ResponseEntity<CounselCommandDTO.Response> updateNextCounselDate(
            @PathVariable Long counselId,
            @Valid @RequestBody CounselCommandDTO.UpdateNextCounselDateRequest request) {
        CounselCommandDTO.Response response = counselCommandService.updateNextCounselDate(counselId, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{counselId}")
    public ResponseEntity<Void> deleteCounsel(@PathVariable Long counselId) {
        counselCommandService.deleteCounsel(counselId);
        return ResponseEntity.noContent().build();
    }
}
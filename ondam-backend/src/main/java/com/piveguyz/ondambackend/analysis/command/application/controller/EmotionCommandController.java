package com.piveguyz.ondambackend.analysis.command.application.controller;

import com.piveguyz.ondambackend.analysis.command.application.dto.EmotionDTO;
import com.piveguyz.ondambackend.analysis.command.application.service.EmotionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/analysis/emotion")
@Slf4j
public class EmotionCommandController {
    private final EmotionService emotionService;

    public EmotionCommandController(EmotionService emotionService) {
        this.emotionService = emotionService;
    }

    // 감정 등록
    @PostMapping
    public ResponseEntity<?> registEmotion(@RequestBody EmotionDTO emotionDTO) {
        emotionService.createEmotion(emotionDTO);
        return ResponseEntity.ok("감정 : " + emotionDTO.getName() + " 등록 완료");
    }

    // 감정 수정
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmotion(
            @PathVariable Long id,
            @RequestBody EmotionDTO emotionDTO) {
        emotionService.updateEmotion(id, emotionDTO);
        return ResponseEntity.ok("감정 : " + emotionDTO.getName() + " 수정 완료");
    }

    // 감정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmotion(@PathVariable Long id) {
        emotionService.deleteEmotion(id);
        return ResponseEntity.ok("감정 : " + id + "번 삭제 완료");
    }

}

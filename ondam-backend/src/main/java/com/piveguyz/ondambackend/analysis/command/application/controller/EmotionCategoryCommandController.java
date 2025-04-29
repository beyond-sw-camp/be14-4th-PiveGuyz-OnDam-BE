package com.piveguyz.ondambackend.analysis.command.application.controller;

import com.piveguyz.ondambackend.analysis.command.application.dto.EmotionCategoryDTO;
import com.piveguyz.ondambackend.analysis.command.application.service.EmotionCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/analysis/emotion_category")
@Slf4j
public class EmotionCategoryCommandController {
    private final EmotionCategoryService emotionCategoryService;

    public EmotionCategoryCommandController(EmotionCategoryService emotionCategoryService) {
        this.emotionCategoryService = emotionCategoryService;
    }

    // 감정 카테고리 등록
    @PostMapping
    public ResponseEntity<?> registEmotionCategory(@RequestBody EmotionCategoryDTO emotionCategoryDTO) {
        emotionCategoryService.createEmotionCategory(emotionCategoryDTO);
        return ResponseEntity.ok("감정 카테고리 : " + emotionCategoryDTO.getName() + " 등록 완료");
    }

    // 감정 카테고리 수정
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmotionCategory(
            @PathVariable Long id,
            @RequestBody EmotionCategoryDTO emotionCategoryDTO) {
        emotionCategoryService.updateEmotionCategory(id, emotionCategoryDTO);
        return ResponseEntity.ok("감정 카테고리 : " + emotionCategoryDTO.getName() + " 수정 완료");
    }

    // 감정 카테고리 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmotionCategory(@PathVariable Long id) {
        emotionCategoryService.deleteEmotionCategory(id);
        return ResponseEntity.ok("감정 카테고리 : " + id + "번 삭제 완료");
    }
}

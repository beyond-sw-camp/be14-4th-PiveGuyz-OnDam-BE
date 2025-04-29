package com.piveguyz.ondambackend.analysis.command.application.service;

import com.piveguyz.ondambackend.analysis.command.application.dto.EmotionCategoryDTO;

public interface EmotionCategoryService {
    void createEmotionCategory(EmotionCategoryDTO emotionCategoryDTO);

    void updateEmotionCategory(Long id, EmotionCategoryDTO emotionCategoryDTO);

    void deleteEmotionCategory(Long id);
}

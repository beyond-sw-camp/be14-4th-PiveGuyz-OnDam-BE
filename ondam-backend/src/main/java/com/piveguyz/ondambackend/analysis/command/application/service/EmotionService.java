package com.piveguyz.ondambackend.analysis.command.application.service;

import com.piveguyz.ondambackend.analysis.command.application.dto.EmotionDTO;

public interface EmotionService {
    void createEmotion(EmotionDTO emotionDTO);

    void updateEmotion(Long id, EmotionDTO emotionDTO);

    void deleteEmotion(Long id);
}

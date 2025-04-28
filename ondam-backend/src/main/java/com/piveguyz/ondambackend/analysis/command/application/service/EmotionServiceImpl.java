package com.piveguyz.ondambackend.analysis.command.application.service;

import com.piveguyz.ondambackend.analysis.command.application.dto.EmotionDTO;
import com.piveguyz.ondambackend.analysis.command.domain.aggregate.Emotion;
import com.piveguyz.ondambackend.analysis.command.domain.repository.EmotionAnalysisRepository;
import com.piveguyz.ondambackend.analysis.command.domain.repository.EmotionCategoryRepository;
import com.piveguyz.ondambackend.analysis.command.domain.repository.EmotionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmotionServiceImpl implements EmotionService {

    private final EmotionRepository emotionRepository;
    private final EmotionCategoryRepository emotionCategoryRepository;
    private final EmotionAnalysisRepository emotionAnalysisRepository;

    public EmotionServiceImpl(EmotionRepository emotionRepository,
                              EmotionCategoryRepository emotionCategoryRepository,
                              EmotionAnalysisRepository emotionAnalysisRepository) {
        this.emotionRepository = emotionRepository;
        this.emotionCategoryRepository = emotionCategoryRepository;
        this.emotionAnalysisRepository = emotionAnalysisRepository;
    }

    // 등록
    @Override
    public void createEmotion(EmotionDTO emotionDTO) {

        if (emotionRepository.existsByName(emotionDTO.getName())) {
            throw new IllegalArgumentException("이미 존재하는 감정입니다: " + emotionDTO.getName());
        }

        Emotion emotion = Emotion.builder()
                .name(emotionDTO.getName())
                .emotionCategoryId(emotionDTO.getEmotionCategoryId())
                .build();
        emotionRepository.save(emotion);
        log.info("감정 등록 완료: " + emotionDTO.getName());
    }

    // 수정
    @Override
    public void updateEmotion(Long id, EmotionDTO emotionDTO) {
        Emotion emotion = emotionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 감정입니다. id = " + id));

        boolean existsCategory = emotionCategoryRepository.existsById(emotionDTO.getEmotionCategoryId());
        if (!existsCategory) {
            throw new IllegalArgumentException("존재하지 않는 감정 카테고리입니다. id=" + emotionDTO.getEmotionCategoryId());
        }

        String emotionName = emotionDTO.getName();
        if (emotionRepository.existsByName(emotionName)) {
            throw new IllegalArgumentException("이미 존재하는 감정입니다: " + emotionName);
        }

        emotion.update(emotionName, emotionDTO.getEmotionCategoryId());
        emotionRepository.save(emotion);

        log.info("감정 수정 완료: id = " + id + ", 새로운 이름 " + emotionName
                + ", 새로운 카테고리 " + emotionDTO.getEmotionCategoryId());
    }

    // 삭제
    @Override
    public void deleteEmotion(Long id) {
        Emotion emotion = emotionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 감정입니다. id = " + id));

        long count = emotionAnalysisRepository.countByEmotionId(id);
        if (count > 0) {
            throw new IllegalStateException("이 감정을 참조하는 데이터가 존재하여 삭제할 수 없습니다. (참조 개수: " + count + ")");
        }

        emotionRepository.delete(emotion);

        log.info("감정 삭제 완료: id = " + id);
    }
}

package com.piveguyz.ondambackend.analysis.command.application.service;

import com.piveguyz.ondambackend.analysis.command.application.dto.EmotionCategoryDTO;
import com.piveguyz.ondambackend.analysis.command.domain.aggregate.EmotionCategory;
import com.piveguyz.ondambackend.analysis.command.domain.repository.EmotionCategoryRepository;
import com.piveguyz.ondambackend.analysis.command.domain.repository.EmotionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmotionCategoryServiceImpl implements EmotionCategoryService {

    private final EmotionCategoryRepository emotionCategoryRepository;
    private final EmotionRepository emotionRepository;

    public EmotionCategoryServiceImpl(EmotionCategoryRepository emotionCategoryRepository,
                                      EmotionRepository emotionRepository) {
        this.emotionCategoryRepository = emotionCategoryRepository;
        this.emotionRepository = emotionRepository;
    }

    // 등록
    @Override
    public void createEmotionCategory(EmotionCategoryDTO emotionCategoryDTO) {
        // 중복 방지
        if (emotionCategoryRepository.existsByName(emotionCategoryDTO.getName())) {
            throw new IllegalArgumentException("이미 존재하는 감정 카테고리입니다: " + emotionCategoryDTO.getName());
        }

        EmotionCategory newCategory = EmotionCategory.builder()
                .name(emotionCategoryDTO.getName())
                .build();

        emotionCategoryRepository.save(newCategory);
        log.info("감정 카테고리 등록 완료: " + emotionCategoryDTO.getName());
    }

    // 수정
    @Override
    public void updateEmotionCategory(Long id, EmotionCategoryDTO emotionCategoryDTO) {
        EmotionCategory category = emotionCategoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 감정 카테고리입니다. id = " + id));

        String categoryName = emotionCategoryDTO.getName();
        if (emotionCategoryRepository.existsByName(categoryName)) {
            throw new IllegalArgumentException("이미 존재하는 감정 카테고리입니다: " + categoryName);
        }

        category.updateName(categoryName);
        emotionCategoryRepository.save(category);

        log.info("감정 카테고리 수정 완료: id = " + id + ", 새로운 이름 " + emotionCategoryDTO.getName());
    }

    // 삭제
    @Override
    public void deleteEmotionCategory(Long id) {
        EmotionCategory category = emotionCategoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 감정 카테고리입니다. id =" + id));

        long count = emotionRepository.countByEmotionCategoryId(id);
        if (count > 0) {
            throw new IllegalStateException("이 감정 카테고리를 참조하는 데이터가 존재하여 삭제할 수 없습니다. (참조 개수: " + count + ")");
        }

        emotionCategoryRepository.delete(category);

        log.info("감정 카테고리 삭제 완료: id = " + id);
    }
}

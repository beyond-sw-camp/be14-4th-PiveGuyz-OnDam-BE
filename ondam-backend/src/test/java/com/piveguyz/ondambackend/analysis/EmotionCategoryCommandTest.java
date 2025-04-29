package com.piveguyz.ondambackend.analysis;

import com.piveguyz.ondambackend.analysis.command.application.dto.EmotionCategoryDTO;
import com.piveguyz.ondambackend.analysis.command.application.service.EmotionCategoryService;
import com.piveguyz.ondambackend.analysis.command.application.service.EmotionService;
import com.piveguyz.ondambackend.analysis.command.domain.aggregate.EmotionCategory;
import com.piveguyz.ondambackend.analysis.command.domain.repository.EmotionCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

@SpringBootTest
@Transactional
public class EmotionCategoryCommandTest {
    @Autowired
    private EmotionCategoryRepository emotionCategoryRepository;

    // 감정 카테고리 등록 테스트
    static Stream<Arguments> createCategoryArgs() {
        return Stream.of(
                Arguments.of("행복"),
                Arguments.of("슬픔")
        );
    }

    @ParameterizedTest
    @DisplayName("감정 카테고리 등록 테스트")
    @MethodSource("createCategoryArgs")
    void createEmotionCategoryTest(String name) {
        if (emotionCategoryRepository.existsByName(name)) {
            throw new IllegalArgumentException("이미 존재하는 감정 카테고리입니다: " + name);
        }

        EmotionCategory newCategory = EmotionCategory.builder()
                .name(name)
                .build();

        emotionCategoryRepository.save(newCategory);
        assertTrue(emotionCategoryRepository.existsByName(name));
    }


    // 감정 카테고리 수정 테스트
    @BeforeEach
    void setup() {
        emotionCategoryRepository.save(EmotionCategory.builder().name("기쁨").build());
        emotionCategoryRepository.save(EmotionCategory.builder().name("희망").build());
    }

    static Stream<Arguments> updateCategoryArgs() {
        return Stream.of(
                Arguments.of("기쁨", "행복"),
                Arguments.of("희망", "즐거움")
        );
    }

    @ParameterizedTest
    @DisplayName("감정 카테고리 수정 테스트")
    @MethodSource("updateCategoryArgs")
    void updateEmotionCategoryTest(String oldName, String newName) {
        EmotionCategory existingCategory = emotionCategoryRepository.findByName(oldName)
                .orElseThrow(() -> new IllegalArgumentException("기존 카테고리를 찾을 수 없습니다: " + oldName));

        existingCategory.updateName(newName);
        emotionCategoryRepository.save(existingCategory);

        assertTrue(emotionCategoryRepository.existsByName(newName));
    }

    static Stream<Arguments> deleteCategoryArgs() {
        return Stream.of(
                Arguments.of("기쁨"),
                Arguments.of("희망")
        );
    }

    @ParameterizedTest
    @DisplayName("감정 카테고리 삭제 테스트")
    @MethodSource("deleteCategoryArgs")
    void testDeleteEmotionCategory(String name) {
        EmotionCategory existingCategory = emotionCategoryRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("삭제할 카테고리를 찾을 수 없습니다: " + name));

        emotionCategoryRepository.delete(existingCategory);

        assertFalse(emotionCategoryRepository.existsByName(name), "카테고리가 정상적으로 삭제되지 않았습니다.");
    }
}

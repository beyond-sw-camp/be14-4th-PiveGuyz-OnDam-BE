package com.piveguyz.ondambackend.analysis.command.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class EmotionDTO {
    private String name;
    private Long emotionCategoryId;
}

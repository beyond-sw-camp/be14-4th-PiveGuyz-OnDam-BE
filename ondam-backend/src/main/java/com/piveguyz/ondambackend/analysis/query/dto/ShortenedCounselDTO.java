package com.piveguyz.ondambackend.analysis.query.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class ShortenedCounselDTO {
    private Long id;
    private String emotionalChange;
    private String cognitive;
    private String behavioral;
    private String response;
    private String recommendedDirection;

    @Builder
    public ShortenedCounselDTO(Long id,
                               String emotionalChange,
                               String cognitive,
                               String behavioral,
                               String response,
                               String recommendedDirection) {
        this.id = id;
        this.emotionalChange = emotionalChange;
        this.cognitive = cognitive;
        this.behavioral = behavioral;
        this.response = response;
        this.recommendedDirection = recommendedDirection;
    }
}

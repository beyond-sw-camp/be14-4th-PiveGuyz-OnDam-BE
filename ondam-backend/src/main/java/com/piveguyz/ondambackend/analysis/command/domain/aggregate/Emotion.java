package com.piveguyz.ondambackend.analysis.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Builder
@Table(name = "emotion")
public class Emotion {
    // 감정

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "emotion_category_id", nullable = false)
    private Long emotionCategoryId;

    public void update(String name, Long emotionCategoryId) {
        this.name = name;
        this.emotionCategoryId = emotionCategoryId;
    }
}

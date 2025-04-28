package com.piveguyz.ondambackend.analysis.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Builder
@Table(name = "shortened_counsel")
public class ShortenedCounsel {
    // 상담 요약

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="emotional_change", nullable = false)
    private String emotionalChange;

    @Column(name="cognitive", nullable = false)
    private String cognitive;

    @Column(name="behavioral", nullable = false)
    private String behavioral;

    @Column(name="response", nullable = false)
    private String response;

    @Column(name="recommended_direction", nullable = false)
    private String recommendedDirection;

    @Column(name="analysis_id", nullable = false)
    private Long analysisId;
}

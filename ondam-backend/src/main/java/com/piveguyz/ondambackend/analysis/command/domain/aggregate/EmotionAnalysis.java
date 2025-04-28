package com.piveguyz.ondambackend.analysis.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Builder
@Table(name="emotion_analysis")
public class EmotionAnalysis {
    // 분석 감정별 정보

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="evidence", nullable = false)
    private String evidence;

    @Column(name="reason", nullable = false)
    private String reason;

    @Column(name="count", nullable = false)
    private int count;

    @Column(name="analysis_id", nullable = false)
    private Long analysisId;

    @Column(name="emotion_id", nullable = false)
    private Long emotionId;
}

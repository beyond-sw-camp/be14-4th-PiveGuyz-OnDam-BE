package com.piveguyz.ondambackend.analysis.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Builder
@Table(name="trouble_summary")
public class TroubleSummary {
    // 고민 요약 테이블

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="period", nullable = false)
    private String period;

    @Column(name="place", nullable = false)
    private String place;

    @Column(name="situation", nullable = false)
    private String situation;

    @Column(name="reason", nullable = false)
    private String reason;

    @Column(name="flow", nullable = false)
    private String flow;

    @Column(name="determination", nullable = false)
    private String determination;

    @Column(name="analysis_id", nullable = false)
    private Long analysisId;
}

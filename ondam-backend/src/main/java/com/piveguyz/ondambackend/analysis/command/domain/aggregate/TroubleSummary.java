package com.piveguyz.ondambackend.analysis.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.*;

import java.util.Map;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Builder
@Table(name = "trouble_summary")
public class TroubleSummary {
    // 고민 요약 테이블

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "period", nullable = false)
    private String period;

    @Column(name = "place", nullable = false)
    private String place;

    @Column(name = "situation", nullable = false)
    private String situation;

    @Column(name = "reason", nullable = false)
    private String reason;

    @Column(name = "flow", nullable = false)
    private String flow;

    @Column(name = "determination", nullable = false)
    private String determination;

    @Column(name = "analysis_id", nullable = false)
    private Long analysisId;

    public static TroubleSummary createFromMap(Map<String, String> map, Long analysisId) {
        return TroubleSummary.builder()
                .period(map.getOrDefault("period", ""))
                .place(map.getOrDefault("place", ""))
                .situation(map.getOrDefault("situation", ""))
                .reason(map.getOrDefault("reason", ""))
                .flow(map.getOrDefault("flow", ""))
                .determination(map.getOrDefault("determination", ""))
                .analysisId(analysisId)
                .build();
    }

    public void updateFromMap(Map<String, String> map) {
        this.period = map.getOrDefault("period", "");
        this.place = map.getOrDefault("place", "");
        this.situation = map.getOrDefault("situation", "");
        this.reason = map.getOrDefault("reason", "");
        this.flow = map.getOrDefault("flow", "");
        this.determination = map.getOrDefault("determination", "");
    }
}

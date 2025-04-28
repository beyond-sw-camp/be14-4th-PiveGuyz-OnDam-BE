package com.piveguyz.ondambackend.analysis.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Builder
@Table(name = "effective_statement")
public class EffectiveStatement {
    // 효과적이었던 발화

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "reason")
    private String reason;

    @Column(name = "response")
    private String response;

    @Column(name = "result")
    private String result;

    @Column(name = "analysis_id", nullable = false)
    private Long analysisId;
}

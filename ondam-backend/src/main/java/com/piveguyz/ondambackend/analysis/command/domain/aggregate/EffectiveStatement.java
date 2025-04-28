package com.piveguyz.ondambackend.analysis.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Map;

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

    public static EffectiveStatement createFromMap(Map<String, Object> map, Long analysisId) {
        return EffectiveStatement.builder()
                .content((String) map.getOrDefault("content", ""))
                .response(parseListOrString(map.get("response")))
                .reason(parseListOrString(map.get("reason")))
                .result((String) map.getOrDefault("result", ""))
                .analysisId(analysisId)
                .build();
    }

    private static String parseListOrString(Object value) {
        if (value instanceof List) {
            return String.join(" / ", (List<String>) value);
        } else if (value instanceof String) {
            return (String) value;
        } else {
            return "";
        }
    }

    public void updateFromMap(Map<String, Object> map) {
        this.content = (String) map.getOrDefault("content", "");
        this.response = parseListOrString(map.get("response"));
        this.reason = parseListOrString(map.get("reason"));
        this.result = (String) map.getOrDefault("result", "");
    }
}

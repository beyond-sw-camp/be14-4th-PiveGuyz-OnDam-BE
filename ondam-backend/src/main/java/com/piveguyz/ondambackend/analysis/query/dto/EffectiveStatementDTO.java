package com.piveguyz.ondambackend.analysis.query.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@NoArgsConstructor
public class EffectiveStatementDTO {
    private Long id;
    private String content;
    private List<String> response;
    private List<String> reason;
    private String result;

    @Builder
    public EffectiveStatementDTO(Long id,
                                 String content,
                                 List<String> response,
                                 List<String> reason,
                                 String result) {
        this.id = id;
        this.content = content;
        this.response = response;
        this.reason = reason;
        this.result = result;
    }
}

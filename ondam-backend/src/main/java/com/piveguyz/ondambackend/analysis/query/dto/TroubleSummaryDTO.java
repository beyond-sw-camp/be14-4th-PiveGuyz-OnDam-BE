package com.piveguyz.ondambackend.analysis.query.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class TroubleSummaryDTO {
    private Long id;
    private String period;
    private String place;
    private String situation;
    private String reason;
    private String flow;
    private String determination;

    @Builder
    public TroubleSummaryDTO(Long id,
                             String period,
                             String place,
                             String situation,
                             String reason,
                             String flow,
                             String determination) {
        this.id = id;
        this.period = period;
        this.place = place;
        this.situation = situation;
        this.reason = reason;
        this.flow = flow;
        this.determination = determination;
    }
}

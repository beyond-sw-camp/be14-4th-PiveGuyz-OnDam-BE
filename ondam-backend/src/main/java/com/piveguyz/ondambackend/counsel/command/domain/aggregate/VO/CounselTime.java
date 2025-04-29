package com.piveguyz.ondambackend.counsel.command.domain.aggregate.VO;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
@Embeddable
public class CounselTime {
    @NotBlank(message = "상담 시간은 필수입니다")
    private String value;

    private CounselTime(String value) {
        this.value = value;
    }

    protected CounselTime() {

    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static CounselTime from(String time) {
        return new CounselTime(time);
    }

    @Override
    public String toString() {
        return value;
    }
}
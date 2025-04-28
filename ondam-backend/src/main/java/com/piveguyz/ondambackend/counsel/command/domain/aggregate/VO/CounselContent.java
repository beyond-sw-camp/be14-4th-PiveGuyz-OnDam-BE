package com.piveguyz.ondambackend.counsel.command.domain.aggregate.VO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
@Embeddable
public class CounselContent {
    @NotBlank(message = "상담 내용은 필수입니다")
    @Size(min = 10, message = "상담 내용은 최소 10자 이상이어야 합니다")
    private String value;

    private CounselContent(String value) {
        this.value = value;
    }

    protected CounselContent() {
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static CounselContent from(String content) {
        return new CounselContent(content);
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
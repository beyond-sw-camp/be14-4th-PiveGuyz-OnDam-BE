package com.piveguyz.ondambackend.counsel.command.domain.aggregate.VO;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
@Embeddable
public class CounselOpinion {
    @NotBlank(message = "상담 소견은 필수입니다")
    private String value;

    private CounselOpinion(String value) {
        validateOpinion(value);
        this.value = value;
    }

    protected CounselOpinion() {

    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static CounselOpinion from(String opinion) {
        return new CounselOpinion(opinion);
    }

    private void validateOpinion(String opinion) {
        if (opinion == null || opinion.trim().isEmpty()) {
            throw new IllegalArgumentException("상담 소견은 필수입니다");
        }
        if (opinion.length() > 1000) {
            throw new IllegalArgumentException("상담 소견은 1000자를 초과할 수 없습니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CounselOpinion that = (CounselOpinion) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value;
    }
}
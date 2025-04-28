package com.piveguyz.ondambackend.counsel.command.domain.aggregate.VO;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
@Embeddable
public class Weather {
    @NotBlank(message = "날씨 정보는 필수입니다")
    private String value;

    private Weather(String value) {
        this.value = value;
    }

    protected Weather() {

    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static Weather from(String weather) {
        return new Weather(weather);
    }

    @Override
    public String toString() {
        return value;
    }
}
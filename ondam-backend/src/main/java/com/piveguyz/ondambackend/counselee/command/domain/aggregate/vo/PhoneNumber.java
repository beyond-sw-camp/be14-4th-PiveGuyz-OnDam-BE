package com.piveguyz.ondambackend.counselee.command.domain.aggregate.vo;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PhoneNumber {
    private String number;

    public PhoneNumber(String number) {
        validate(number);
        this.number = number;
    }

    private void validate(String number) {
        if (number == null || !number.matches("^\\d{2,3}-\\d{3,4}-\\d{4}$")) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
    }
}
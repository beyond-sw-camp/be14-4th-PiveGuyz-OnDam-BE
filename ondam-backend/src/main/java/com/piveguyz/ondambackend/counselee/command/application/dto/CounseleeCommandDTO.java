package com.piveguyz.ondambackend.counselee.command.application.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CounseleeCommandDTO {

    @NotNull(message = "상담사 ID는 필수입니다")
    private Long memberId;

    @NotEmpty(message = "이름은 필수입니다")
    private String name;

    @NotEmpty(message = "생년월일은 필수입니다")
    @Pattern(regexp = "^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$",
            message = "생년월일은 YYYY-MM-DD 형식이어야 합니다")
    private String birthday;

    @NotEmpty(message = "성별은 필수입니다")
    @Pattern(regexp = "^(M|F)$",
            message = "성별은 M 또는 F이어야 합니다")
    private String gender;

    @NotEmpty(message = "연락처는 필수입니다")
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$",
            message = "연락처는 xxx-xxxx-xxxx 형식이어야 합니다")
    private String phone;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$",
            message = "비상연락처는 xxx-xxxx-xxxx 형식이어야 합니다")
    private String emePhone;

    private String address;

    private Integer severityLevel;

    @Builder
    public CounseleeCommandDTO(Long memberId, String name, String birthday, String gender,
                               String phone, String emePhone, String address, Integer severityLevel) {
        this.memberId = memberId;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.emePhone = emePhone;
        this.address = address;
        this.severityLevel = severityLevel;
    }
}
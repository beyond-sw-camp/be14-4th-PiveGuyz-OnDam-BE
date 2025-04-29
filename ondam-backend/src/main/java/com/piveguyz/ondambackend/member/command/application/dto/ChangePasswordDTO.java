package com.piveguyz.ondambackend.member.command.application.dto;

import lombok.Data;

@Data
public class ChangePasswordDTO {
    private String currentPassword;
    private String newPassword;
    private String newPasswordCheck;
}

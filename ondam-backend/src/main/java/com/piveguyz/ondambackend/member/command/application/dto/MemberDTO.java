package com.piveguyz.ondambackend.member.command.application.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MemberDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String birthday;
    private Date createdAt;
    private Date deletedAt;
    private String phone;
    private String profileImageUrl;
    private String address;
    private Integer point;
    private String authority;
    private String isBanned;
    private String isDiaryBlocked;

    // 회원가입 진행하면서 추가

}

package com.piveguyz.ondambackend.member.command.domain.vo;

import lombok.Data;

@Data
public class RequestRegistMembersVO {
    private String name;
    private String email;
    private String password;
    private String birthday;
    private String phone;
    private String address;

}

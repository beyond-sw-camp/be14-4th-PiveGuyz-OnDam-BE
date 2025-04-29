package com.piveguyz.ondambackend.member.query.service;

import com.piveguyz.ondambackend.member.query.dto.MemberDTO;

import java.util.List;

public interface MemberService {
    List<MemberDTO> selectAllMembers();

    boolean loginMember(String email, String password);
}

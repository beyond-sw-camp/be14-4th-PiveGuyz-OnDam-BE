package com.piveguyz.ondambackend.member.query.service;

import com.piveguyz.ondambackend.member.query.dto.MemberQueryDTO;

import java.util.List;

public interface MemberQueryService {
    List<MemberQueryDTO> selectAllMembers();

    boolean loginMember(String email, String password);

    MemberQueryDTO findMemberById(Long id);
}

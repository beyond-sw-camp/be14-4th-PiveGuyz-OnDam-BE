package com.piveguyz.ondambackend.member.query.service;

import com.piveguyz.ondambackend.member.query.dto.MemberDTO;
import com.piveguyz.ondambackend.member.query.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberMapper memberMapper;

    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public List<MemberDTO> selectAllMembers() {
        List<MemberDTO> memberDTOList = memberMapper.findAllMembers();
        return memberDTOList;
    }

    @Override
    public boolean loginMember(String email, String password) {
        List<MemberDTO> memberDTOList = memberMapper.findAllMembers();

        return  memberDTOList.stream()
                .anyMatch(memberDTO ->
                        memberDTO.getEmail().equals(email) &&
                                memberDTO.getPassword().equals(password)
                );
    }
    @Override
    public MemberDTO findMemberById(Long id) { // ★ 추가
        return memberMapper.findMemberById(id);
    }
}

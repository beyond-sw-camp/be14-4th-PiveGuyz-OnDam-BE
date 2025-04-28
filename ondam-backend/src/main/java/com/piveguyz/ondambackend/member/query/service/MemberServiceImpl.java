package com.piveguyz.ondambackend.member.query.service;

import com.piveguyz.ondambackend.member.query.dto.MemberDTO;
import com.piveguyz.ondambackend.member.query.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

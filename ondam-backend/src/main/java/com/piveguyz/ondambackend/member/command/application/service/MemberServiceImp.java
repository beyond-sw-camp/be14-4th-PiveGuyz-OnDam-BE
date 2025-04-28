package com.piveguyz.ondambackend.member.command.application.service;

import com.piveguyz.ondambackend.member.command.application.dto.MemberDTO;
import com.piveguyz.ondambackend.member.command.domain.aggregate.MemberEntity;
import com.piveguyz.ondambackend.member.command.domain.repository.MemberRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class MemberServiceImp implements MemberService {

    MemberRepository memberRepository;
    ModelMapper modelMapper;
//    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public MemberServiceImp(MemberRepository memberRepository,
                            ModelMapper modelMapper
//                            ,BCryptPasswordEncoder bCryptPasswordEncoder
    ) {
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    @Transactional
    public void registMember(MemberDTO memberDTO) {

        // 회원가입 고유 번호 할당
//        memberDTO.setMemberId(UUID.randomUUID().toString());

        MemberEntity registMember = modelMapper.map(memberDTO, MemberEntity.class);
        System.out.println(registMember);
        registMember.setPoint(30);
        registMember.setAuthority("GUEST");
        registMember.setIsBanned("N");
        registMember.setIsDiaryBlocked("N");
//        registMember.setEncryptedPwd(bCryptPasswordEncoder.encode(memberDTO.getPwd()));

    memberRepository.save(registMember);
    }
}

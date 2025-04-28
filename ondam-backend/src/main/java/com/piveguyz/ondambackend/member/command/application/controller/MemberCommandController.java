package com.piveguyz.ondambackend.member.command.application.controller;


import com.piveguyz.ondambackend.member.command.application.dto.MemberDTO;
import com.piveguyz.ondambackend.member.command.application.service.MemberService;
import com.piveguyz.ondambackend.member.command.domain.vo.RequestRegistMembersVO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MemberCommandController {
    private MemberService memberService;
    private ModelMapper modelMapper;

    @Autowired
    public MemberCommandController(MemberService memberService,
                                   ModelMapper modelMapper) {
        this.memberService = memberService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("members")
    public ResponseEntity<String> registMember(@RequestBody RequestRegistMembersVO newMember) {
        MemberDTO memberDTO = modelMapper.map(newMember, MemberDTO.class);


        // call by reference 는 원본을 보내고 값이 바뀌고 돌아오기 때문에 반환 x
        // userId 추가된 값
        memberService.registMember(memberDTO);


        return  ResponseEntity.status(HttpStatus.CREATED).body("회원가입 성공!");
    }
}

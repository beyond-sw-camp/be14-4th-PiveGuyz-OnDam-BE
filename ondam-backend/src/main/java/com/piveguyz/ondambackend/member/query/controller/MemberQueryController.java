package com.piveguyz.ondambackend.member.query.controller;

import com.piveguyz.ondambackend.member.query.dto.MemberDTO;
import com.piveguyz.ondambackend.member.query.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberQueryController {
    private MemberService memberService;

    @Autowired
    public MemberQueryController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/findAllMembers")
    public List<MemberDTO> findAllMembers() {
        List<MemberDTO> memberDTOList = memberService.selectAllMembers();
        return memberDTOList;
    }
}

package com.piveguyz.ondambackend.member.query.controller;

import com.piveguyz.ondambackend.member.query.dto.MemberQueryDTO;
import com.piveguyz.ondambackend.member.query.service.MemberQueryService;
import com.piveguyz.ondambackend.member.query.vo.RequestLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/member")
public class MemberQueryController {
    private MemberQueryService memberService;

    @Autowired
    public MemberQueryController(MemberQueryService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/findAllMembers")
    public List<MemberQueryDTO> findAllMembers() {
        List<MemberQueryDTO> memberDTOList = memberService.selectAllMembers();
        return memberDTOList;
    }

    @PostMapping("login")
    public ResponseEntity<String> loginMember(@RequestBody RequestLoginVO requestLoginVO) {
        boolean loginResult = memberService.loginMember(requestLoginVO.getEmail(), requestLoginVO.getPassword());

        if (loginResult) {
            return ResponseEntity.ok("로그인 성공!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
        }
    }

    @GetMapping("/findMemberById") // ★ 추가
    public ResponseEntity<MemberQueryDTO> findMemberById(@RequestParam("id") Long id) {
        MemberQueryDTO memberDTO = memberService.findMemberById(id);
        if (memberDTO != null) {
            return ResponseEntity.ok(memberDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}


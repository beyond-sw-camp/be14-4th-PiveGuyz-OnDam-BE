package com.piveguyz.ondambackend.member.query.mapper;

import com.piveguyz.ondambackend.member.query.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<MemberDTO> findAllMembers();
}

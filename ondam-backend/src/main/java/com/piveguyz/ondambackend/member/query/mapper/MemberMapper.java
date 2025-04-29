package com.piveguyz.ondambackend.member.query.mapper;

import com.piveguyz.ondambackend.member.query.dto.MemberQueryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<MemberQueryDTO> findAllMembers(); // @Select 제거

    MemberQueryDTO findMemberById(Long id);
}

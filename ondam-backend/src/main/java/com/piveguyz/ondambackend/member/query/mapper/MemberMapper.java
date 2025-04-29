package com.piveguyz.ondambackend.member.query.mapper;

import com.piveguyz.ondambackend.member.query.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Mapper
public interface MemberMapper {
    @Select("SELECT * FROM member")
    List<MemberDTO> findAllMembers();

}

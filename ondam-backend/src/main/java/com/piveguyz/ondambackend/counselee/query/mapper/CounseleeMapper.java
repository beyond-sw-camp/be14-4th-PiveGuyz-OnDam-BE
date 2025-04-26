package com.piveguyz.ondambackend.counselee.query.mapper;

import java.util.List;

import com.piveguyz.ondambackend.counselee.query.dto.CounseleeQueryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CounseleeMapper {
    
    List<CounseleeQueryDTO> findAll();

    CounseleeQueryDTO findById(Long id);
    
    List<CounseleeQueryDTO> findAllByMemberId(Long memberId);

    List<CounseleeQueryDTO> findByNameContaining(@Param("memberId") Long memberId, @Param("name") String name);
    
    List<CounseleeQueryDTO> findActiveCounselees(Long memberId);
    
    int countByMemberId(Long memberId);
}
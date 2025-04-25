package com.piveguyz.ondambackend.counselee.query.mapper;

import java.util.List;

import com.piveguyz.ondambackend.counselee.query.dto.CounseleeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CounseleeMapper {
    
    List<CounseleeDTO> findAll();

    CounseleeDTO findById(Long id);
    
    List<CounseleeDTO> findAllByMemberId(Long memberId);
    
    List<CounseleeDTO> findByNameContaining(@Param("memberId") Long memberId, @Param("name") String name);
    
    List<CounseleeDTO> findActiveCounselees(Long memberId);
    
    int countByMemberId(Long memberId);
}
package com.piveguyz.ondambackend.diary.query.mapper;

import com.piveguyz.ondambackend.diary.query.dto.DiaryQueryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiaryMapper {
    List<DiaryQueryDTO> findAllDiary();

    List<DiaryQueryDTO> findActivatedDiary();

    DiaryQueryDTO findDiaryById(Long id);

    List<DiaryQueryDTO> findDiaryByMemberId(Long memberId);
}

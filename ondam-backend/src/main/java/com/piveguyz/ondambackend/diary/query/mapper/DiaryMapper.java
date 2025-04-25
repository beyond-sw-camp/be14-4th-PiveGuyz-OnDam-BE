package com.piveguyz.ondambackend.diary.query.mapper;

import com.piveguyz.ondambackend.diary.query.dto.DiaryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiaryMapper {
    List<DiaryDTO> findAllDiary();

    List<DiaryDTO> findActivatedDiary();

    List<DiaryDTO> findDiaryByUserId(Integer userId);
}

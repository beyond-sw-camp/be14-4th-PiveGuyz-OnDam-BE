package com.piveguyz.ondambackend.diary.query.service;

import com.piveguyz.ondambackend.diary.query.dto.DiaryDTO;

import java.util.List;

public interface DiaryQueryService {

    List<DiaryDTO> selectAllDiaries();

    List<DiaryDTO> selectActivatedDiaries();

    List<DiaryDTO> selectDiaryByUserId(Integer userId);
}

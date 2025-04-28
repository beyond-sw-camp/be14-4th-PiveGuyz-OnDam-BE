package com.piveguyz.ondambackend.diary.query.service;

import com.piveguyz.ondambackend.diary.query.dto.DiaryQueryDTO;

import java.util.List;

public interface DiaryQueryService {

    List<DiaryQueryDTO> selectAllDiaries();

    List<DiaryQueryDTO> selectActivatedDiaries();

    List<DiaryQueryDTO> selectDiaryByMemberId(Integer memberId);

    DiaryQueryDTO selectDiaryById(Integer id);
}

package com.piveguyz.ondambackend.diaryRecord.query.service;

import com.piveguyz.ondambackend.diaryRecord.query.dto.DiaryRecordQueryDTO;

import java.util.List;

public interface DiaryRecordQueryService {
    List<DiaryRecordQueryDTO> selectAllDiaryRecord();

    DiaryRecordQueryDTO selectDiaryRecordById(Long id);

    List<DiaryRecordQueryDTO> selectDiaryRecordByDiaryId(Long diaryId);

    List<DiaryRecordQueryDTO> selectDiaryRecordByReceiverId(Long receiverId);

    DiaryRecordQueryDTO selectDiaryRecordByDiaryIdAndReceiverId(Long diaryId, Long receiverId);
}

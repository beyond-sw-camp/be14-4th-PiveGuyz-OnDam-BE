package com.piveguyz.ondambackend.diaryRecord.query.service;

import com.piveguyz.ondambackend.diaryRecord.query.dto.DiaryRecordQueryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DiaryRecordQueryService {
    List<DiaryRecordQueryDTO> selectAllDiaryRecord();

    List<DiaryRecordQueryDTO> selectDiaryRecordByDiaryId(Integer diaryId);

    List<DiaryRecordQueryDTO> selectDiaryRecordByReceiverId(Integer receiverId);

    DiaryRecordQueryDTO selectDiaryRecordByDiaryIdAndReceiverId(Integer diaryId, Integer receiverId);
}

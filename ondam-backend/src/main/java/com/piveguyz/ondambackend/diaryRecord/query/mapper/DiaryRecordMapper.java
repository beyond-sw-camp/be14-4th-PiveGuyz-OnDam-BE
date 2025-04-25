package com.piveguyz.ondambackend.diaryRecord.query.mapper;

import com.piveguyz.ondambackend.diaryRecord.query.dto.DiaryRecordQueryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiaryRecordMapper {
    List<DiaryRecordQueryDTO> findAllDiaryRecord();

    List<DiaryRecordQueryDTO> findDiaryRecordByDiaryId(Integer diaryId);

    List<DiaryRecordQueryDTO> findDiaryRecordByReceiverId(Integer receiverId);

    DiaryRecordQueryDTO findDiaryRecordByDiaryIdAndReceiverId(Integer diaryId, Integer receiverId);
}

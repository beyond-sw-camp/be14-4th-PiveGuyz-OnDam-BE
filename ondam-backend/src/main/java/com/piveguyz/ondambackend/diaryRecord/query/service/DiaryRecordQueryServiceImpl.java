package com.piveguyz.ondambackend.diaryRecord.query.service;

import com.piveguyz.ondambackend.diaryRecord.query.dto.DiaryRecordQueryDTO;
import com.piveguyz.ondambackend.diaryRecord.query.mapper.DiaryRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryRecordQueryServiceImpl implements DiaryRecordQueryService {
    private final DiaryRecordMapper diaryRecordMapper;

    @Autowired
    public DiaryRecordQueryServiceImpl(DiaryRecordMapper diaryRecordMapper) {
        this.diaryRecordMapper = diaryRecordMapper;
    }

    @Override
    public List<DiaryRecordQueryDTO> selectAllDiaryRecord() {
        List<DiaryRecordQueryDTO> diaryRecordQueryDTOList = diaryRecordMapper.findAllDiaryRecord();
        return diaryRecordQueryDTOList;
    }

    @Override
    public List<DiaryRecordQueryDTO> selectDiaryRecordByDiaryId(Long diaryId) {
        List<DiaryRecordQueryDTO> diaryRecordQueryDTOList = diaryRecordMapper.findDiaryRecordByDiaryId(diaryId);
        return diaryRecordQueryDTOList;
    }

    @Override
    public List<DiaryRecordQueryDTO> selectDiaryRecordByReceiverId(Long receiverId) {
        List<DiaryRecordQueryDTO> diaryRecordQueryDTOList = diaryRecordMapper.findDiaryRecordByReceiverId(receiverId);
        return diaryRecordQueryDTOList;
    }

    @Override
    public DiaryRecordQueryDTO selectDiaryRecordByDiaryIdAndReceiverId(Long diaryId, Long receiverId) {
        DiaryRecordQueryDTO diaryRecordQueryDTO
                = diaryRecordMapper.findDiaryRecordByDiaryIdAndReceiverId(diaryId, receiverId);
        return diaryRecordQueryDTO;
    }
}

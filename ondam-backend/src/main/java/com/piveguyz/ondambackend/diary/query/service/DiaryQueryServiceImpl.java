package com.piveguyz.ondambackend.diary.query.service;

import com.piveguyz.ondambackend.diary.query.dto.DiaryDTO;
import com.piveguyz.ondambackend.diary.query.mapper.DiaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryQueryServiceImpl implements DiaryQueryService {
    private final DiaryMapper diaryMapper;

    @Autowired
    public DiaryQueryServiceImpl(DiaryMapper diaryMapper) {
        this.diaryMapper = diaryMapper;
    }

    @Override
    public List<DiaryDTO> selectAllDiaries() {
        List<DiaryDTO> diaryDTOList = diaryMapper.findAllDiary();
        return diaryDTOList;
    }

    @Override
    public List<DiaryDTO> selectActivatedDiaries() {
        List<DiaryDTO> diaryDTOList = diaryMapper.findActivatedDiary();
        return diaryDTOList;
    }

    @Override
    public List<DiaryDTO> selectDiaryByUserId(Integer userId) {
        List<DiaryDTO> diaryDTOList = diaryMapper.findDiaryByUserId(userId);
        return diaryDTOList;
    }
}

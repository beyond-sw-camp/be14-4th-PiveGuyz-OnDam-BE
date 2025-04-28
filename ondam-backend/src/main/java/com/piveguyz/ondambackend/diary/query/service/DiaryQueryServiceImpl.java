package com.piveguyz.ondambackend.diary.query.service;

import com.piveguyz.ondambackend.diary.query.dto.DiaryQueryDTO;
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
    public List<DiaryQueryDTO> selectAllDiaries() {
        List<DiaryQueryDTO> diaryQueryDTOList = diaryMapper.findAllDiary();
        return diaryQueryDTOList;
    }

    @Override
    public List<DiaryQueryDTO> selectActivatedDiaries() {
        List<DiaryQueryDTO> diaryQueryDTOList = diaryMapper.findActivatedDiary();
        return diaryQueryDTOList;
    }

    @Override
    public DiaryQueryDTO selectDiaryById(Long id) {
        DiaryQueryDTO diaryQueryDTO = diaryMapper.findDiaryById(id);
        return diaryQueryDTO;
    }

    @Override
    public List<DiaryQueryDTO> selectDiaryByMemberId(Long memberId) {
        List<DiaryQueryDTO> diaryQueryDTOList = diaryMapper.findDiaryByMemberId(memberId);
        return diaryQueryDTOList;
    }
}

package com.piveguyz.ondambackend.diary.command.application.service;


import com.piveguyz.ondambackend.diary.command.application.dto.DiaryDTO;
import com.piveguyz.ondambackend.diary.command.domain.aggregate.Diary;
import com.piveguyz.ondambackend.diary.command.domain.repository.DiaryRepository;
import com.piveguyz.ondambackend.diary.query.dto.DiaryQueryDTO;
import com.piveguyz.ondambackend.diary.query.mapper.DiaryMapper;
import com.piveguyz.ondambackend.diary.query.service.DiaryQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DiaryService {
    private final DiaryRepository diaryRepository;
    private final DiaryMapper diaryMapper;
    private final DiaryQueryService diaryQueryService;

    @Autowired
    public DiaryService(DiaryRepository diaryRepository, DiaryMapper diaryMapper, DiaryQueryService diaryQueryService) {
        this.diaryRepository = diaryRepository;
        this.diaryMapper = diaryMapper;
        this.diaryQueryService = diaryQueryService;
    }

    public boolean writeDiary(DiaryDTO diaryDTO) {
        Diary diary = new Diary();
        diary.setTitle(diaryDTO.getTitle());
        diary.setContent(diaryDTO.getContent());
        diary.setCreatedAt(diaryDTO.getCreatedAt() != null ? diaryDTO.getCreatedAt() : LocalDateTime.now());
        diary.setDeletedAt(diaryDTO.getDeletedAt());
        diary.setIsBlinded(diaryDTO.getIsBlinded() != null ? diaryDTO.getIsBlinded() : "N");
        diary.setMemberId(diaryDTO.getMemberId());

        try {
            diaryRepository.save(diary);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteDiary(Long id) {
        DiaryQueryDTO diaryQueryDTO = diaryQueryService.selectDiaryById(id);
        Diary diary = new Diary();
        diary.setId(diaryQueryDTO.getId());
        diary.setTitle(diaryQueryDTO.getTitle());
        diary.setContent(diaryQueryDTO.getContent());
        diary.setCreatedAt(diaryQueryDTO.getCreatedAt());
        diary.setDeletedAt(LocalDateTime.now());
        diary.setIsBlinded(diaryQueryDTO.getIsBlinded());
        diary.setMemberId(diaryQueryDTO.getMemberId());

        try {
            diaryRepository.save(diary);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean blindDiary(Long id){
        DiaryQueryDTO diaryQueryDTO = diaryQueryService.selectDiaryById(id);
        Diary diary = new Diary();
        diary.setId(diaryQueryDTO.getId());
        diary.setTitle(diaryQueryDTO.getTitle());
        diary.setContent(diaryQueryDTO.getContent());
        diary.setCreatedAt(diaryQueryDTO.getCreatedAt());
        diary.setDeletedAt(diaryQueryDTO.getDeletedAt());
        diary.setIsBlinded("Y");
        diary.setMemberId(diaryQueryDTO.getMemberId());

        try {
            diaryRepository.save(diary);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

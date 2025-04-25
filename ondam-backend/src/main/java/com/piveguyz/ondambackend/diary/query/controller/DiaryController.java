package com.piveguyz.ondambackend.diary.query.controller;

import com.piveguyz.ondambackend.diary.query.dto.DiaryDTO;
import com.piveguyz.ondambackend.diary.query.service.DiaryQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/diary")
public class DiaryController {
    private DiaryQueryService diaryQueryService;

    @Autowired
    public DiaryController(DiaryQueryService diaryQueryService) {
        this.diaryQueryService = diaryQueryService;
    }

    @GetMapping("/findAllDiary")
    public List<DiaryDTO> findAllDiary() {
        List<DiaryDTO> diaryDTOList = diaryQueryService.selectAllDiaries();
        return diaryDTOList;
    }
    @GetMapping("/findActivatedDiary")
    public List<DiaryDTO> findActivatedDiary() {
        List<DiaryDTO> diaryDTOList = diaryQueryService.selectActivatedDiaries();
        return diaryDTOList;
    }

    @GetMapping("/findDiaryByUserId")
    public List<DiaryDTO> findDiaryByUserId(@RequestParam("userId") Integer userId) {
        List<DiaryDTO> diaryDTOList = diaryQueryService.selectDiaryByUserId(userId);
        return diaryDTOList;
    }
}

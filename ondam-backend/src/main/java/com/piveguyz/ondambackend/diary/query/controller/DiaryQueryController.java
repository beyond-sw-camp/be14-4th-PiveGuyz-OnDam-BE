package com.piveguyz.ondambackend.diary.query.controller;

import com.piveguyz.ondambackend.diary.query.dto.DiaryQueryDTO;
import com.piveguyz.ondambackend.diary.query.service.DiaryQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/diary")
public class DiaryQueryController {
    private DiaryQueryService diaryQueryService;

    @Autowired
    public DiaryQueryController(DiaryQueryService diaryQueryService) {
        this.diaryQueryService = diaryQueryService;
    }

    @GetMapping("/findAllDiary")
    public List<DiaryQueryDTO> findAllDiary() {
        List<DiaryQueryDTO> diaryQueryDTOList = diaryQueryService.selectAllDiaries();
        return diaryQueryDTOList;
    }
    @GetMapping("/findActivatedDiary")
    public List<DiaryQueryDTO> findActivatedDiary() {
        List<DiaryQueryDTO> diaryQueryDTOList = diaryQueryService.selectActivatedDiaries();
        return diaryQueryDTOList;
    }

    @GetMapping("findDiaryById")
    public DiaryQueryDTO findDiaryById(@RequestParam("id") Long id) {
        DiaryQueryDTO diaryQueryDTO = diaryQueryService.selectDiaryById(id);
        return diaryQueryDTO;
    }

    @GetMapping("/findDiaryByMemberId")
    public List<DiaryQueryDTO> findDiaryByMemberId(@RequestParam("memberId") Long memberId) {
        List<DiaryQueryDTO> diaryQueryDTOList = diaryQueryService.selectDiaryByMemberId(memberId);
        return diaryQueryDTOList;
    }
}

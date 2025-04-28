package com.piveguyz.ondambackend.diary.command.application.controller;

import com.piveguyz.ondambackend.diary.command.application.dto.DiaryDTO;
import com.piveguyz.ondambackend.diary.command.application.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diary")
public class DiaryController {
    private DiaryService diaryService;

    @Autowired
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @PostMapping("/writeDiary")
    public ResponseEntity<String> writeDiary(@RequestBody DiaryDTO diaryDTO) {
        boolean result = diaryService.writeDiary(diaryDTO);
        if(result){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("일기 작성이 완료되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("일기 작성에 실패하였습니다.");
        }
    }
    @DeleteMapping("/deleteDiary")
    public ResponseEntity<String> deleteDiary(@RequestParam int id){
        boolean result = diaryService.deleteDiary(id);
        if(result) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("일기가 삭제되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("일기 삭제에 실패하였습니다.");
        }
    }
}

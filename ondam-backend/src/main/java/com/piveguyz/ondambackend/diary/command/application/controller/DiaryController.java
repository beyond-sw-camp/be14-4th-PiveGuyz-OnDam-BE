package com.piveguyz.ondambackend.diary.command.application.controller;

import com.piveguyz.ondambackend.diary.command.application.dto.DiaryDTO;
import com.piveguyz.ondambackend.diary.command.application.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/diary")
public class DiaryController {
    private DiaryService diaryService;

    @Autowired
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @PostMapping("/writeDiary")
    public ResponseEntity<String> writeDiary(@RequestBody DiaryDTO diaryDTO) {
        String result = diaryService.writeDiary(diaryDTO);

        if(result.substring(0,2).equals("성공")) {
            Integer point = Integer.parseInt(result.substring(2));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("일기 작성에 성공하였습니다. 남은 포인트는 " + point + "입니다.");
        } else if(result.substring(0,2).equals("실패")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("일기 작성에 실패하였습니다.");
        } else {
            Integer point = Integer.parseInt(result.substring(3));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("포인트가 부족합니다. 남은 포인트는 " + point + "입니다.");
        }
    }
    @DeleteMapping("/deleteDiary")
    public ResponseEntity<String> deleteDiary(@RequestParam Long id){
        boolean result = diaryService.deleteDiary(id);
        if(result) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("일기가 삭제되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("일기 삭제에 실패하였습니다.");
        }
    }
}

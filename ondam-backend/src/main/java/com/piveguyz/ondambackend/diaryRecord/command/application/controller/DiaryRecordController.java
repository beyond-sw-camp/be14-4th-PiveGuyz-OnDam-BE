package com.piveguyz.ondambackend.diaryRecord.command.application.controller;

import com.piveguyz.ondambackend.diaryRecord.command.application.service.DiaryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/diaryRecord")
public class DiaryRecordController {
    private DiaryRecordService diaryRecordService;

    @Autowired
    public DiaryRecordController(DiaryRecordService diaryRecordService) {
        this.diaryRecordService = diaryRecordService;
    }

    @PostMapping("/sendDiary")
    public ResponseEntity<String> sendDiary(@RequestParam("id") Integer id){
        boolean result = diaryRecordService.sendDiary(id);
        if(result) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("일기가 전송되었습니다.");
        } else {
            return ResponseEntity.status((HttpStatus.BAD_REQUEST)).body("일기 전송에 실패하였습니다.");
        }
    }
}

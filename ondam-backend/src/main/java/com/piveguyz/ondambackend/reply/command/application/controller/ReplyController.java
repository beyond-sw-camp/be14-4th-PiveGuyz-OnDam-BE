package com.piveguyz.ondambackend.reply.command.application.controller;

import com.piveguyz.ondambackend.reply.command.application.dto.ReplyDTO;
import com.piveguyz.ondambackend.reply.command.application.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reply")
public class ReplyController {
    private ReplyService replyService;

    @Autowired
    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @PostMapping("/writeReply")
    public ResponseEntity<String> writeReply(@RequestBody ReplyDTO replyDTO) {
        boolean result = replyService.writeReply(replyDTO);
        if(result){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("답장이 작성되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("답장 작성에 실패하였습니다.");
        }
    }

    @DeleteMapping("/deleteReply")
    public ResponseEntity<String> deleteReply(@RequestParam Long replyId) {
        boolean result = replyService.deleteReply(replyId);
        if(result){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("답장 삭제가 완료되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("답장 삭제에 실패하였습니다.");
        }
    }
}

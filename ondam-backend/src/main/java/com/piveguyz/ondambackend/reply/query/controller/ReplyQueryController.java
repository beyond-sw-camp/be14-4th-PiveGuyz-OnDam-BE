package com.piveguyz.ondambackend.reply.query.controller;

import com.piveguyz.ondambackend.reply.query.dto.ReplyQueryDTO;
import com.piveguyz.ondambackend.reply.query.service.ReplyQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reply")
public class ReplyQueryController {
    private final ReplyQueryService replyQueryService;

    @Autowired
    public ReplyQueryController(ReplyQueryService replyQueryService) {
        this.replyQueryService = replyQueryService;
    }

    @GetMapping("/findAllReply")
    public List<ReplyQueryDTO> findAllReply() {
        List<ReplyQueryDTO> replyQueryDTOList = replyQueryService.selectAllReply();
        return replyQueryDTOList;
    }

    @GetMapping("/findReplyById")
    public ReplyQueryDTO findReplyById(@RequestParam("id") Integer id) {
        ReplyQueryDTO replyQueryDTO = replyQueryService.selectReplyById(id);
        return replyQueryDTO;
    }

    @GetMapping("/findReplyByDiaryId")
    public List<ReplyQueryDTO> findReplyByDiaryId(@RequestParam Integer diaryId) {
        List<ReplyQueryDTO> replyQueryDTOList = replyQueryService.selectReplyByDiaryId(diaryId);
        return replyQueryDTOList;
    }

    @GetMapping("/findReplyBySenderId")
    public List<ReplyQueryDTO> findReplyBySenderId(@RequestParam Integer senderId) {
        List<ReplyQueryDTO> replyQueryDTOList = replyQueryService.selectReplyBySenderId(senderId);
        return replyQueryDTOList;
    }

}

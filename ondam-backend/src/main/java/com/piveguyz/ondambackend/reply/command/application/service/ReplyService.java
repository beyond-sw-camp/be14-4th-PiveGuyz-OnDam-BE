package com.piveguyz.ondambackend.reply.command.application.service;



import com.piveguyz.ondambackend.reply.command.application.dto.ReplyDTO;
import com.piveguyz.ondambackend.reply.command.domain.aggregate.Reply;
import com.piveguyz.ondambackend.reply.command.domain.repository.ReplyRepository;
import com.piveguyz.ondambackend.reply.query.dto.ReplyQueryDTO;
import com.piveguyz.ondambackend.reply.query.mapper.ReplyMapper;
import com.piveguyz.ondambackend.reply.query.service.ReplyQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final ReplyMapper replyMapper;
    private final ReplyQueryService replyQueryService;

    @Autowired
    public ReplyService(ReplyRepository replyRepository, ReplyMapper replyMapper, ReplyQueryService replyQueryService) {
        this.replyRepository = replyRepository;
        this.replyMapper = replyMapper;
        this.replyQueryService = replyQueryService;
    }

    public boolean writeReply(ReplyDTO replyDTO) {
        Reply reply = new Reply();
        reply.setId(replyDTO.getId());
        reply.setTitle(replyDTO.getTitle());
        reply.setContent(replyDTO.getContent());
        reply.setCreatedAt(replyDTO.getCreatedAt());
        reply.setDeletedAt(replyDTO.getDeletedAt());
        reply.setIsBlinded(replyDTO.getIsBlinded());
        reply.setDiaryRecordId(replyDTO.getDiaryRecordId());
        reply.setSenderId(replyDTO.getSenderId());
        reply.setReceiverId(replyDTO.getReceiverId());

        try {
            replyRepository.save(reply);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteReply(int replyId) {
        ReplyQueryDTO replyQueryDTO = replyQueryService.selectReplyById(replyId);
        System.out.println(replyQueryDTO);
        Reply reply = new Reply();
        reply.setId(replyQueryDTO.getId());
        reply.setTitle(replyQueryDTO.getTitle());
        reply.setContent(replyQueryDTO.getContent());
        reply.setCreatedAt(replyQueryDTO.getCreatedAt());
        reply.setDeletedAt(LocalDateTime.now());
        reply.setIsBlinded(replyQueryDTO.getIsBlinded());
        reply.setDiaryRecordId(replyQueryDTO.getDiaryRecordId());
        reply.setSenderId(replyQueryDTO.getSenderId());
        reply.setReceiverId(replyQueryDTO.getReceiverId());

        try {
            replyRepository.save(reply);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

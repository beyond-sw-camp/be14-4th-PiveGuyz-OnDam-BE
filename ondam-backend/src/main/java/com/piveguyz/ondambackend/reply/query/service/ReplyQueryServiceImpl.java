package com.piveguyz.ondambackend.reply.query.service;

import com.piveguyz.ondambackend.diary.query.dto.DiaryQueryDTO;
import com.piveguyz.ondambackend.diary.query.mapper.DiaryMapper;
import com.piveguyz.ondambackend.diary.query.service.DiaryQueryService;
import com.piveguyz.ondambackend.reply.query.dto.ReplyQueryDTO;
import com.piveguyz.ondambackend.reply.query.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyQueryServiceImpl implements ReplyQueryService {
    private final ReplyMapper replyMapper;

    @Autowired
    public ReplyQueryServiceImpl(ReplyMapper replyMapper) {
        this.replyMapper = replyMapper;
    }

    @Override
    public List<ReplyQueryDTO> selectAllReply() {
        List<ReplyQueryDTO> replyQueryDTOList = replyMapper.findAllReply();
        return replyQueryDTOList;
    }

    @Override
    public ReplyQueryDTO selectReplyById(Integer id) {
        ReplyQueryDTO replyQueryDTO = replyMapper.findReplyById(id);
        return replyQueryDTO;
    }

    @Override
    public List<ReplyQueryDTO> selectReplyByDiaryId(Integer diaryId) {
        List<ReplyQueryDTO> replyQueryDTOList = replyMapper.findReplyByDiaryId(diaryId);
        return replyQueryDTOList;
    }

    @Override
    public List<ReplyQueryDTO> selectReplyBySenderId(Integer senderId) {
        List<ReplyQueryDTO> replyQueryDTOList = replyMapper.findReplyBySenderId(senderId);
        return replyQueryDTOList;
    }
}

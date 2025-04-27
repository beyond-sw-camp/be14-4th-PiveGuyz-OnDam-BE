package com.piveguyz.ondambackend.reply.query.service;

import com.piveguyz.ondambackend.reply.query.dto.ReplyQueryDTO;

import java.util.List;

public interface ReplyQueryService {

    List<ReplyQueryDTO> selectAllReply();

    ReplyQueryDTO selectReplyById(Integer id);

    List<ReplyQueryDTO> selectReplyByDiaryId(Integer diaryId);

    List<ReplyQueryDTO> selectReplyBySenderId(Integer senderId);
}

package com.piveguyz.ondambackend.reply.query.service;

import com.piveguyz.ondambackend.reply.query.dto.ReplyQueryDTO;

import java.util.List;

public interface ReplyQueryService {

    List<ReplyQueryDTO> selectAllReply();

    ReplyQueryDTO selectReplyById(Long id);

    List<ReplyQueryDTO> selectReplyByDiaryId(Long diaryId);

    List<ReplyQueryDTO> selectReplyBySenderId(Long senderId);
}

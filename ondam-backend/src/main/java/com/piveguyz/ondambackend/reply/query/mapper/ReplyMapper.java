package com.piveguyz.ondambackend.reply.query.mapper;

import com.piveguyz.ondambackend.diary.query.dto.DiaryQueryDTO;
import com.piveguyz.ondambackend.reply.query.dto.ReplyQueryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
    List<ReplyQueryDTO> findAllReply();

    ReplyQueryDTO findReplyById(Long id);

    List<ReplyQueryDTO> findReplyByDiaryId(Long diaryId);

    List<ReplyQueryDTO> findReplyBySenderId(Long senderId);
}

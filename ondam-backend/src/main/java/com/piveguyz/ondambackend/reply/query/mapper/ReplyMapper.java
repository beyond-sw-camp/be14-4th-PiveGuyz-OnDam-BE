package com.piveguyz.ondambackend.reply.query.mapper;

import com.piveguyz.ondambackend.diary.query.dto.DiaryQueryDTO;
import com.piveguyz.ondambackend.reply.query.dto.ReplyQueryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
    List<ReplyQueryDTO> findAllReply();

    ReplyQueryDTO findReplyById(Integer id);

    List<ReplyQueryDTO> findReplyByDiaryId(Integer diaryId);

    List<ReplyQueryDTO> findReplyBySenderId(Integer senderId);
}

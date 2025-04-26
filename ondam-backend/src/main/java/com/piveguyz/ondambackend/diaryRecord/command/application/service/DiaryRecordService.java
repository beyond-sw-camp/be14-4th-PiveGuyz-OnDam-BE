package com.piveguyz.ondambackend.diaryRecord.command.application.service;

import com.piveguyz.ondambackend.diary.command.application.dto.DiaryDTO;
import com.piveguyz.ondambackend.diary.command.domain.aggregate.Diary;
import com.piveguyz.ondambackend.diary.command.domain.repository.DiaryRepository;
import com.piveguyz.ondambackend.diary.query.dto.DiaryQueryDTO;
import com.piveguyz.ondambackend.diary.query.service.DiaryQueryService;
import com.piveguyz.ondambackend.diaryRecord.command.application.dto.DiaryRecordDTO;
import com.piveguyz.ondambackend.diaryRecord.command.domain.aggregate.DiaryRecord;
import com.piveguyz.ondambackend.diaryRecord.command.domain.repository.DiaryRecordRepository;
import com.piveguyz.ondambackend.diaryRecord.query.dto.DiaryRecordQueryDTO;
import com.piveguyz.ondambackend.diaryRecord.query.service.DiaryRecordQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryRecordService {
    private final DiaryQueryService diaryQueryService;
    private final DiaryRecordQueryService diaryRecordQueryService;
    private final DiaryRecordRepository diaryRecordRepository;

    @Autowired
    public DiaryRecordService(DiaryQueryService diaryQueryService, DiaryRecordQueryService diaryRecordQueryService, DiaryRecordRepository diaryRecordRepository) {
        this.diaryQueryService = diaryQueryService;
        this.diaryRecordQueryService = diaryRecordQueryService;
        this.diaryRecordRepository = diaryRecordRepository;
    }

    public boolean sendDiary(int diaryId) {
        int attempt = 0;
        int Maxattempt = 100;
        int[] memberIdArray = {1,2,3,4,5,6,7,8,9,10};
        while(attempt <= Maxattempt) {
            attempt++;
            List<DiaryRecordQueryDTO> diaryRecordQueryDTOList = diaryRecordQueryService.selectAllDiaryRecord();
            List<DiaryQueryDTO> diaryQueryDTOList = diaryQueryService.selectAllDiaries();
            if(diaryRecordQueryDTOList.size() == diaryQueryDTOList.size() * 3){      // 일기를 모두 배분하였다.
                break;
            }
            diaryRecordQueryDTOList = diaryRecordQueryService.selectDiaryRecordByDiaryId(diaryId);
            if(diaryRecordQueryDTOList.size() >= 3){        // 일기는 3명한테만 보낸다.
                break;
            }
            int receiverId = ((int)(memberIdArray.length * Math.random())+1);
            diaryRecordQueryDTOList = diaryRecordQueryService.selectDiaryRecordByReceiverId(receiverId);
            if(diaryRecordQueryDTOList.size() >= 3){        // 일기를 3개 받은 사람은 받지 않는다.
                continue;
            }
            DiaryQueryDTO diaryQueryDTO = diaryQueryService.selectDiaryById(diaryId);
            int senderId = diaryQueryDTO.getMemberId();
            if(senderId == receiverId){     // 본인이 작성한 일기는 본인한테 보내지 않는다.
                continue;
            }
            DiaryRecordQueryDTO diaryRecordQueryDTO = diaryRecordQueryService.selectDiaryRecordByDiaryIdAndReceiverId(diaryId, receiverId);
            if(diaryRecordQueryDTO != null){    // 이미 일기를 받은 사람한테는 보내지 않는다.
                continue;
            }
            DiaryRecord diaryRecord = new DiaryRecord();
            diaryRecord.setDiaryId(diaryId);
            diaryRecord.setSenderId(senderId);
            diaryRecord.setReceiverId(receiverId);
            try {
                diaryRecordRepository.save(diaryRecord);
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
}

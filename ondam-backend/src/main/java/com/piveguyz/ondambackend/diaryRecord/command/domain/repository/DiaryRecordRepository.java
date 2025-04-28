package com.piveguyz.ondambackend.diaryRecord.command.domain.repository;

import com.piveguyz.ondambackend.diaryRecord.command.domain.aggregate.DiaryRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryRecordRepository extends JpaRepository<DiaryRecord, Long> {
}

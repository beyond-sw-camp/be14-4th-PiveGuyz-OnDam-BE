// TODO: 임시 파일입니다. 추후 ReplyRepository 개발 완료 시 교체 예정입니다.
package com.piveguyz.ondambackend.report.temp.repository;

import com.piveguyz.ondambackend.report.temp.aggregate.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}

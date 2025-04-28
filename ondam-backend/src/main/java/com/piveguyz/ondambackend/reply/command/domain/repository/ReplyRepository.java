package com.piveguyz.ondambackend.reply.command.domain.repository;

import com.piveguyz.ondambackend.reply.command.domain.aggregate.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
    // 추가적인 메소드 구현이 필요하다면 여기에 추가

}

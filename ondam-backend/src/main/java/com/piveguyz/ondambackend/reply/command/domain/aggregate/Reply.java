package com.piveguyz.ondambackend.reply.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reply")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "deleted_at", nullable = true)
    private LocalDateTime deletedAt;
    @Column(name = "is_blinded", nullable = false)
    private String isBlinded = "N";
    @Column(name = "diary_record_id", nullable = false)
    private Integer diaryRecordId;
    @Column(name = "sender_id", nullable = false)
    private Integer senderId;
    @Column(name = "receiver_id", nullable = false)
    private Integer receiverId;
}

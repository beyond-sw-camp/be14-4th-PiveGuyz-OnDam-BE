package com.piveguyz.ondambackend.diaryRecord.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "diary_record")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DiaryRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "diary_id", nullable = false)
    private Long diaryId;
    @Column(name = "sender_id", nullable = false)
    private Long senderId;
    @Column(name = "receiver_id", nullable = false)
    private Long receiverId;
    @Column(name = "is_expired", nullable = false)
    private String isExpired = "N";
}

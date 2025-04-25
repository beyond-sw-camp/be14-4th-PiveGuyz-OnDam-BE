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
    private Integer id;
    @Column(name = "diary_id", nullable = false)
    private Integer diaryId;
    @Column(name = "sender_id", nullable = false)
    private Integer senderId;
    @Column(name = "receiver_id", nullable = false)
    private Integer receiverId;
    @Column(name = "is_expired", nullable = false)
    private String isExpired = "N";
}

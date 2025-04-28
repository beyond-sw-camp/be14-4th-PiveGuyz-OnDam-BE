package com.piveguyz.ondambackend.diary.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "diary")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    @Column(name = "member_id", nullable = false)
    private Long memberId;
}

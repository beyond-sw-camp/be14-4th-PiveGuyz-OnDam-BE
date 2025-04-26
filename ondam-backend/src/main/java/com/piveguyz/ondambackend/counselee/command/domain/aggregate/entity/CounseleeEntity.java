package com.piveguyz.ondambackend.counselee.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "counselee")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CounseleeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Long memberId;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String birthday;
    
    @Column(nullable = false)
    private String gender;
    
    @Column(nullable = false)
    private String phone;
    
    private String emePhone;
    
    private String address;
    
    private Integer severityLevel;
    
    @Column(nullable = false)
    private LocalDateTime createdAt;
    
    private LocalDateTime deletedAt;
    
    private LocalDateTime updatedAt;
    
    private LocalDateTime endDate;
    
    private String endReason;

    @Builder
    public CounseleeEntity(Long memberId, String name, String birthday, String gender,
                          String phone, String emePhone, String address, Integer severityLevel) {
        this.memberId = memberId;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.emePhone = emePhone;
        this.address = address;
        this.severityLevel = severityLevel;
        this.createdAt = LocalDateTime.now();
    }

    public void update(String name, String birthday, String gender,
                      String phone, String emePhone, String address, Integer severityLevel) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.emePhone = emePhone;
        this.address = address;
        this.severityLevel = severityLevel;
        this.updatedAt = LocalDateTime.now();
    }

    public void delete() {
        this.deletedAt = LocalDateTime.now();
    }

    public void endCounseling(String endReason) {
        this.endDate = LocalDateTime.now();
        this.endReason = endReason;
    }
}
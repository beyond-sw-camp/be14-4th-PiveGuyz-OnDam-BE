package com.piveguyz.ondambackend.counselee.command.domain.aggregate.entity;

import com.piveguyz.ondambackend.counselee.command.domain.aggregate.vo.Birthday;
import com.piveguyz.ondambackend.counselee.command.domain.aggregate.vo.Gender;
import com.piveguyz.ondambackend.counselee.command.domain.aggregate.vo.PhoneNumber;
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

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "birthday"))
    private Birthday birthday;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Embedded
    @AttributeOverride(name = "number", column = @Column(name = "phone"))
    private PhoneNumber phone;

    @Embedded
    @AttributeOverride(name = "number", column = @Column(name = "eme_phone"))
    private PhoneNumber emePhone;

    private String address;
    
    private Integer severityLevel;
    
    @Column(nullable = false)
    private LocalDateTime createdAt;
    
    private LocalDateTime deletedAt;
    
    private LocalDateTime updatedAt;
    
    private LocalDateTime endDate;
    
    private String endReason;

    @Builder
    public CounseleeEntity(Long memberId, String name, Birthday birthday, Gender gender,
                          PhoneNumber phone, PhoneNumber emePhone, String address, Integer severityLevel) {
        this.memberId = memberId;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.emePhone = emePhone;
        this.address = address;
        this.severityLevel = severityLevel;
        this.updatedAt = null;
        this.deletedAt = null;
        this.endDate = null;
        this.endReason = null;
        this.createdAt = LocalDateTime.now();
    }

    public void update(String name, Birthday birthday, Gender gender,
                       PhoneNumber phone, PhoneNumber emePhone, String address, Integer severityLevel) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.emePhone = emePhone;
        this.address = address;
        this.severityLevel = severityLevel;
        this.deletedAt = null;
        this.endDate = null;
        this.endReason = null;
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
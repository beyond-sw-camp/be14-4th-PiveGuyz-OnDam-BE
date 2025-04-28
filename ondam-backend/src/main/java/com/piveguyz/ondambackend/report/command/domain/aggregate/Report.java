package com.piveguyz.ondambackend.report.command.domain.aggregate;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "report")
@Getter
@NoArgsConstructor
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "member_id", nullable = false)
	private Long memberId;

	@Column(name = "reported_member_id", nullable = false)
	private Long reportedMemberId;

	@Column(name = "diary_id")
	private Long diaryId;

	@Column(name = "reply_id")
	private Long replyId;

	@Column(name = "report_category_id", nullable = false)
	private Long reportCategoryId;

	@Column(name = "reason", columnDefinition = "TEXT")
	private String reason;

	@Column(name = "status", nullable = false)
	@Convert(converter = ReportStatusConverter.class)
	private ReportStatus status;

	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "deleted_at")
	private LocalDateTime deletedAt;

	public Report(Long memberId, Long reportedMemberId, Long diaryId, Long replyId,
		Long reportCategoryId, String reason) {
		this.memberId = memberId;
		this.reportedMemberId = reportedMemberId;
		this.diaryId = diaryId;
		this.replyId = replyId;
		this.reportCategoryId = reportCategoryId;
		this.reason = reason;
		this.status = ReportStatus.PENDING;
		this.createdAt = LocalDateTime.now();
	}

	public void changeStatus(Integer statusValue) {
		this.status = ReportStatus.fromValue(statusValue);
	}

	public void delete() {
		this.deletedAt = LocalDateTime.now();
	}
}

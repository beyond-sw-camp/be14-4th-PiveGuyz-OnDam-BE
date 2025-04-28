package com.piveguyz.ondambackend.report.command.domain.aggregate;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "report_category")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "deleted_at")
	private LocalDateTime deletedAt;

	public void updateName(String newName) {
		this.name = newName;
	}

	public void softDelete() {
		this.deletedAt = LocalDateTime.now();
	}
}

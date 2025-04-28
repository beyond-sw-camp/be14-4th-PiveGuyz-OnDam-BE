package com.piveguyz.ondambackend.report.command.domain.aggregate;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ReportStatusConverter implements AttributeConverter<ReportStatus, Integer> {

	@Override
	public Integer convertToDatabaseColumn(ReportStatus attribute) {
		if (attribute == null) {
			return null;
		}
		return attribute.getValue();
	}

	@Override
	public ReportStatus convertToEntityAttribute(Integer dbData) {
		if (dbData == null) {
			return null;
		}
		return ReportStatus.fromValue(dbData);
	}
}
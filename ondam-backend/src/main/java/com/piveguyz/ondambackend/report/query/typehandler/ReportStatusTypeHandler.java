package com.piveguyz.ondambackend.report.query.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.piveguyz.ondambackend.report.query.dto.enums.ReportStatus;

public class ReportStatusTypeHandler extends BaseTypeHandler<ReportStatus> {
	@Override
	public void setNonNullParameter
		(PreparedStatement ps, int i, ReportStatus parameter, JdbcType jdbcType) throws SQLException {
		ps.setInt(i, parameter.getValue());
	}

	@Override
	public ReportStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
		int value = rs.getInt(columnName);
		return ReportStatus.fromValue(value);
	}

	@Override
	public ReportStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		int value = rs.getInt(columnIndex);
		return ReportStatus.fromValue(value);
	}

	@Override
	public ReportStatus getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		int value = cs.getInt(columnIndex);
		return ReportStatus.fromValue(value);
	}
}

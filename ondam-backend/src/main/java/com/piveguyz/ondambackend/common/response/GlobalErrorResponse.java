package com.piveguyz.ondambackend.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class GlobalErrorResponse {
    private int status;              // HTTP 상태 코드 (예: 400, 404)
    private String code;             // 에러 코드 (예: INVALID_COUNSEL_CONTENT)
    private String message;          // 에러 메시지
    private String path;             // API 경로
    private LocalDateTime timestamp; // 에러 발생 시각
}
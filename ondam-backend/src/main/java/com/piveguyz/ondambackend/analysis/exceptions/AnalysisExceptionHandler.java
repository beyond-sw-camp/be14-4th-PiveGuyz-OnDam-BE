package com.piveguyz.ondambackend.analysis.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.piveguyz.ondambackend.common.response.ErrorResponse;
import com.piveguyz.ondambackend.common.response.GlobalErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

// analysis 패키지에 존재하면 이 handler가 처리
@RestControllerAdvice(basePackages = "com.piveguyz.ondambackend.analysis")
public class AnalysisExceptionHandler {

    // 이상한 상담 내역이 들어와서 gpt가 error json을 보낸 경우
    @ExceptionHandler(InvalidCounselContentException.class)
    public ResponseEntity<GlobalErrorResponse> handleInvalidCounselContentException(InvalidCounselContentException ex,
                                                                                    HttpServletRequest request) {
        return buildErrorResponse(
                HttpStatus.BAD_REQUEST,
                "INVALID_COUNSEL_CONTENT",
                ex.getMessage(),
                request.getRequestURI()
        );
    }

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<GlobalErrorResponse> handleJsonProcessingException(
            JsonProcessingException ex, HttpServletRequest request) {
        return buildErrorResponse(
                HttpStatus.BAD_REQUEST,
                "INVALID_JSON_FORMAT",
                "JSON 파싱 실패: GPT 응답 형식이 올바르지 않습니다.",
                request.getRequestURI()
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<GlobalErrorResponse> handleIllegalArgumentException(
            IllegalArgumentException ex, HttpServletRequest request) {
        return buildErrorResponse(
                HttpStatus.BAD_REQUEST,
                "BAD_REQUEST",
                ex.getMessage(),
                request.getRequestURI()
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GlobalErrorResponse> handleGenericException(
            Exception ex, HttpServletRequest request) {
        return buildErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "INTERNAL_SERVER_ERROR",
                "서버 내부 오류가 발생했습니다.",
                request.getRequestURI()
        );
    }

    private ResponseEntity<GlobalErrorResponse> buildErrorResponse(
            HttpStatus httpStatus, String code, String message, String path) {
        GlobalErrorResponse response = new GlobalErrorResponse(
                httpStatus.value(),
                code,
                message,
                path,
                LocalDateTime.now()
        );
        return ResponseEntity.status(httpStatus).body(response);
    }
}
package com.piveguyz.ondambackend.analysis.exceptions;

public class InvalidCounselContentException extends IllegalArgumentException {
    public InvalidCounselContentException(String message) {
        super("유효하지 않은 상담 내역입니다. gpt 응답 메세지 : " + message);
    }
}

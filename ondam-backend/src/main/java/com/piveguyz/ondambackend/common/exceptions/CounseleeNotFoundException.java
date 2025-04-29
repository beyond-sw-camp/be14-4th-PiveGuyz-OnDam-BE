package com.piveguyz.ondambackend.common.exceptions;

public class CounseleeNotFoundException extends RuntimeException {
    public CounseleeNotFoundException(Long id) {
        super("존재하지 않는 내담자입니다. ID: " + id);
    }
}
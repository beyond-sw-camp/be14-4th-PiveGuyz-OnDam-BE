package com.piveguyz.ondambackend.common.exceptions;

public class CounselNotFoundException extends RuntimeException {
    public CounselNotFoundException(Long id) {
        super("상담 정보를 찾을 수 없습니다. ID: " + id);
    }
}

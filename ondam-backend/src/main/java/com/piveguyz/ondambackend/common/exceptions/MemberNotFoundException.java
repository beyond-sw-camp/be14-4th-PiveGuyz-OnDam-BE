package com.piveguyz.ondambackend.common.exceptions;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(Long id) {
        super("존재하지 않는 상담사입니다. ID: " + id);
    }
}

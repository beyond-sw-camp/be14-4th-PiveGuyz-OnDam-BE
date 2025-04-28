package com.piveguyz.ondambackend.counselee.command.domain.aggregate.vo;

public enum Gender {
    M("M"),
    F("F");

    private final String description;

    Gender(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
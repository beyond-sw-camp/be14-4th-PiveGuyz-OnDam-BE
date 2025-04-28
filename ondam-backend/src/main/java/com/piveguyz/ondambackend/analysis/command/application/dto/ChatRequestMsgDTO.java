package com.piveguyz.ondambackend.analysis.command.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ChatRequestMsgDTO {

    private String role;

    private String content;

    @Builder
    public ChatRequestMsgDTO(String role, String content) {
        this.role = role;
        this.content = content;
    }
}
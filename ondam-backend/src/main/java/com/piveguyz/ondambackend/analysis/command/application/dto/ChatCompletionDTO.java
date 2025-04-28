package com.piveguyz.ondambackend.analysis.command.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@NoArgsConstructor
public class ChatCompletionDTO {
    private String model;
    private List<ChatRequestMsgDTO> messages;

    private Long counselId;

    @Builder
    public ChatCompletionDTO(String model, List<ChatRequestMsgDTO> messages, Long counselId) {
        this.model = model;
        this.messages = messages;
        this.counselId = counselId;
    }
}

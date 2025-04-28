package com.piveguyz.ondambackend.analysis.command.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@NoArgsConstructor
public class GptRequestDTO {
    private String model;
    private List<ChatRequestMsgDTO> messages;

    @Builder
    GptRequestDTO(String model, List<ChatRequestMsgDTO> messages) {
        this.model = model;
        this.messages = messages;
    }
}

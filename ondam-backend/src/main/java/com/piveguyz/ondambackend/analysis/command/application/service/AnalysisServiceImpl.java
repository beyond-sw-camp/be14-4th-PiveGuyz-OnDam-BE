package com.piveguyz.ondambackend.analysis.command.application.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class AnalysisServiceImpl implements AnalysisService {

    private final WebClient webClient;

    public AnalysisServiceImpl(@Value("${openai.api.key}") String apiKey) {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.openai.com/v1/chat/completions")
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .build();
    }

    @Override
    public String askGpt(String prompt, String fileContent) {
        String fullPrompt = prompt + "\n\n[첨부된 파일 내용]\n" + fileContent;

        Map<String, Object> request = Map.of(
                "model", "gpt-3.5-turbo",
                "messages", List.of(
                        Map.of("role", "user", "content", fullPrompt)
                )
        );

        try {
            // 요청 전 딜레이 추가 (1초)
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // 권장되는 예외 처리 방식
            return "스레드 인터럽트 오류 발생";
        }

        Map<?, ?> response = webClient.post()
                .bodyValue(request)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        if (response != null && response.containsKey("choices")) {
            Map<?, ?> choice = ((List<Map<?, ?>>) response.get("choices")).get(0);
            Map<?, ?> message = (Map<?, ?>) choice.get("message");
            return message.get("content").toString();
        }

        return "GPT 응답 없음";
    }
}

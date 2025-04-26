package com.piveguyz.ondambackend.analysis.command.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.piveguyz.ondambackend.analysis.command.application.dto.ChatCompletionDTO;
import com.piveguyz.ondambackend.analysis.command.application.dto.ChatRequestMsgDTO;
import com.piveguyz.ondambackend.analysis.config.ChatGPTConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class AnalysisServiceImpl implements AnalysisService {

    private static final String SYSTEM_PROMPT = """
            당신은 내담자와 상담자의 대화를 분석하는 상담 전문가입니다. 다음 상담 내용을 바탕으로 고민 요약, 감정 분석, 효과적 발화, 상담 요약을 JSON 형식으로 정리해주세요.
            1. 고민 요약 (`client_problem_summary'):
            - 내담자의 말을 고민 시기(period), 고민 장소(place), 고민 상황(situation), 이유(reason), 흐름(flow), 결심(determination)으로 정리해주세요.
            
            2. 감정 분석 (`emotion_analysis`):
            - 내담자의 말에서 감정(e.g. 불안, 무기력, 고립감 등)을 추출하고, 그 감정의 근거가 된 발화(evidence), 감정을 추출한 이유(reason)를 작성해주세요.
            - 동일한 감정이 대화 중 여러 번 표현되었다면, 각 표현을 개별적으로 모두 추출해 주세요. (중복 감정도 각각 별도로 작성합니다.)
            - 감정은 반드시 다음의 감정 목록 중 5개 이상여야 합니다: 기쁨, 안도, 감사, 감동, 기대, 희망, 편안함, 자신감, 활력, 불안, 분노, 짜증, 우울, 슬픔, 외로움, 수치심, 죄책감, 후회, 좌절, 무기력, 혼란, 멍함, 무감각, 갈등, 복잡함, 모호함, 회복, 안정감, 수용, 성장, 용기, 극복, 해소, 고립감, 연결감, 서운함, 이해받음, 부담감
            
            3. 효과적 발화 (`effective_statement`):
            - 상담자의 말 중 정서적 안정 및 동기 부여에 효과적인 발화를 1개 선택해 주세요.
            - 해당 발화의 이유(reason) 3개~5개, 내담자의 반응 예시(response) 1개~3개, 상담 효과(result)를 작성해주세요.
            
            4. 상담 요약 (`shortened_counsel`):
            - 정서 변화(emotional_change), 인지적 특징(cognitive), 행동적 특징(behavioral), 상담 중 반응(response), 추천 상담 방향(recommended_direction)을 포함해 주세요.
            
            JSON으로 아래 형식에 맞춰 결과를 반환해주세요 (...은 내용이 들어간다는 뜻입니다.):
            ```json
            {
            {
              "client_problem_summary": {
                "period": "...",
                "place": "...",
                "situation": "...",
                "reason": "...",
                "flow": "...",
                "determination": "..."
              },
              "emotion_analysis": [
                {
                  "emotion": "...",
                  "evidence": "...",
                  "reason": "..."
                }
                ...
              ],
              "effective_statement": {
                "content": "...",
                "response": [
                  "...",
                  "..."
                ],
                "reason": [
                  "...",
                  "...",
                  ...
                ],
                "result": "..."
              },
              "shortened_counsel": {
                "emotional_change": "...",
                "cognitive": "...",
                "behavioral": "...",
                "response": "...",
                "recommended_direction": "..."
              }
            }
            
            """;
    private final ChatGPTConfig chatGPTConfig;
    @Value("${openai.model}")
    private String openaiModel;
    @Value("${openai.url.prompt}")
    private String promptUrl;

    public AnalysisServiceImpl(ChatGPTConfig chatGPTConfig) {
        this.chatGPTConfig = chatGPTConfig;
    }

    // 프롬프트를 기준으로 ChatGPT 호출 후 응답 생성
    @Override
    public Map<String, Object> askGpt(ChatCompletionDTO chatCompletionDto) {
        log.info("ChatGPT 프롬프트 실행");

        List<ChatRequestMsgDTO> fullMessages = List.of(
                ChatRequestMsgDTO.builder()
                        .role("system")
                        .content(SYSTEM_PROMPT)
                        .build(),
                chatCompletionDto.getMessages().get(0) // 첫 번째 user 메시지만 사용
        );

        ChatCompletionDTO fullRequest = ChatCompletionDTO.builder()
                .model(openaiModel)
                .messages(List.of(
                        ChatRequestMsgDTO.builder().role("system").content(SYSTEM_PROMPT).build(),
                        chatCompletionDto.getMessages().get(0)
                ))
                .build();

        HttpHeaders headers = chatGPTConfig.httpHeaders();
        HttpEntity<ChatCompletionDTO> requestEntity = new HttpEntity<>(fullRequest, headers);
        ResponseEntity<String> response = chatGPTConfig
                .restTemplate()
                .exchange(promptUrl, HttpMethod.POST, requestEntity, String.class);

        Map<String, Object> resultMap = new HashMap<>();
        try {
            ObjectMapper om = new ObjectMapper();

            // GPT 전체 응답 파싱
            Map<String, Object> gptResponse = om.readValue(response.getBody(), new TypeReference<>() {
            });
            Map<String, Object> message = (Map<String, Object>) ((Map<String, Object>) ((List<?>) gptResponse.get("choices")).get(0)).get("message");

            // message.content 내부 JSON 문자열 다시 파싱
            String jsonString = (String) message.get("content");
            resultMap = om.readValue(jsonString, new TypeReference<>() {
            });

        } catch (JsonProcessingException e) {
            log.debug("JsonMappingException :: " + e.getMessage());
        } catch (RuntimeException e) {
            log.debug("RuntimeException :: " + e.getMessage());
        }

        return resultMap;
    }
}

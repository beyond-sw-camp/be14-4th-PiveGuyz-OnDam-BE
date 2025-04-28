package com.piveguyz.ondambackend.analysis.command.application.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.piveguyz.ondambackend.analysis.command.application.dto.ChatCompletionDTO;
import com.piveguyz.ondambackend.analysis.command.application.dto.ChatRequestMsgDTO;
import com.piveguyz.ondambackend.analysis.command.application.dto.GptRequestDTO;
import com.piveguyz.ondambackend.analysis.command.domain.aggregate.*;
import com.piveguyz.ondambackend.analysis.command.domain.repository.*;
import com.piveguyz.ondambackend.analysis.config.ChatGPTConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class AnalysisServiceImpl implements AnalysisService {

    private static final String SYSTEM_PROMPT = """
            당신은 내담자와 상담자의 대화를 분석하는 상담 전문가입니다. 다음 상담 내용을 바탕으로 고민 요약, 감정 분석, 효과적 발화, 상담 요약을 JSON 형식으로 정리해주세요.
                            1. 고민 요약 (`trouble_summary'):
                            - 내담자의 말을 고민 시기(period), 고민 장소(place), 고민 상황(situation), 이유(reason), 흐름(flow), 결심(determination)으로 정리해주세요.
                           \s
                            2. 감정 분석 (`emotion_analysis`):
                            - 내담자의 말에서 감정(e.g. 불안, 무기력, 고립감 등)을 추출하고, 그 감정의 근거가 된 발화(evidence), 감정을 추출한 이유(reason)를 작성해주세요.
                            - 동일한 감정이 대화 중 여러 번 표현되었다면, 각 표현을 개별적으로 모두 추출해 주세요. (중복 감정도 각각 별도로 작성합니다.)
                            - 감정은 반드시 다음의 감정 목록 중 5개 이상여야 합니다: 기쁨, 안도, 감사, 감동, 기대, 희망, 편안함, 자신감, 활력, 불안, 분노, 짜증, 우울, 슬픔, 외로움, 수치심, 죄책감, 후회, 좌절, 무기력, 혼란, 멍함, 무감각, 갈등, 복잡함, 모호함, 회복, 안정감, 수용, 성장, 용기, 극복, 해소, 고립감, 연결감, 서운함, 이해받음, 부담감
                           \s
                            3. 효과적 발화 (`effective_statement`):
                            - 상담자의 말 중 정서적 안정 및 동기 부여에 효과적인 발화를 1개 선택해 주세요.
                            - 해당 발화의 이유(reason) 3개~5개, 내담자의 반응 예시(response) 1개~3개, 상담 효과(result)를 작성해주세요.
                           \s
                            4. 상담 요약 (`shortened_counsel`):
                            - 정서 변화(emotional_change), 인지적 특징(cognitive), 행동적 특징(behavioral), 상담 중 반응(response), 추천 상담 방향(recommended_direction)을 포함해 주세요.
                           \s
                            JSON으로 아래 형식에 맞춰 결과를 반환해주세요 (...은 내용이 들어간다는 뜻입니다.):
                            ```json
                            {
                              "trouble_summary": {
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
           \s""";

    // DB 테스트용 json (API 사용 X)
    private static final String dbTestJson = """
  {
  "trouble_summary": {
    "period": "고민했던 시기",
    "place": "고민이 발생한 장소",
    "situation": "고민 상황에 대한 설명",
    "reason": "고민하게 된 이유",
    "flow": "고민의 흐름/전개",
    "determination": "내린 결심이나 다짐"
  },
  "emotion_analysis": [
    {
      "emotion": "불안",
      "evidence": "시험이 다가와서 불안해요.",
      "reason": "시험 일정이 임박하면서 스트레스를 느낌"
    },
    {
      "emotion": "우울",
      "evidence": "자꾸 떨어져서 우울해요.",
      "reason": "연속된 실패로 인한 자존감 저하"
    }
  ],
  "effective_statement": {
    "content": "그만큼 노력해온 내담자님 자신을 믿어도 괜찮아요.",
    "response": [
      "네... 그렇게 생각해볼게요.",
      "조금 마음이 가벼워진 것 같아요."
    ],
    "reason": [
      "노력 자체를 인정해주는 말",
      "자기 효능감을 북돋워주는 메시지",
      "현재의 불안을 수용해주는 태도"
    ],
    "result": "내담자가 불안을 다루는 자신감을 얻음"
  },
  "shortened_counsel": {
    "emotional_change": "불안 → 수용 → 자신감",
    "cognitive": "노력의 가치를 재인식함",
    "behavioral": "더 이상 회피하지 않고 시도하려는 태도",
    "response": "조금 더 해볼 수 있을 것 같다는 반응을 보임",
    "recommended_direction": "성공과 실패 모두를 경험으로 받아들이는 연습"
  }
}

            """;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final AnalysisRepository analysisRepository;
    private final CounselSummaryRepository counselSummaryRepository;
    private final EffectiveStatementRepository effectiveStatementRepository;
    private final EmotionAnalysisRepository emotionAnalysisRepository;
    private final EmotionRepository emotionRepository;
    private final ChatGPTConfig chatGPTConfig;

    @Value("${openai.model}")
    private String openaiModel;
    @Value("${openai.url.prompt}")
    private String promptUrl;

    public AnalysisServiceImpl(ChatGPTConfig chatGPTConfig,
                               AnalysisRepository analysisRepository,
                               CounselSummaryRepository counselSummaryRepository,
                               EffectiveStatementRepository effectiveStatementRepository,
                               EmotionAnalysisRepository emotionAnalysisRepository,
                               EmotionRepository emotionRepository) {
        this.chatGPTConfig = chatGPTConfig;
        this.analysisRepository = analysisRepository;
        this.counselSummaryRepository = counselSummaryRepository;
        this.effectiveStatementRepository = effectiveStatementRepository;
        this.emotionAnalysisRepository = emotionAnalysisRepository;
        this.emotionRepository = emotionRepository;
    }

    @Override
    public void askGpt(ChatCompletionDTO chatCompletionDto) {
        log.info("ChatGPT 프롬프트 실행");

        List<ChatRequestMsgDTO> fullMessages = List.of(
                ChatRequestMsgDTO.builder()
                        .role("system")
                        .content(SYSTEM_PROMPT)
                        .build(),
                chatCompletionDto.getMessages().get(0)
        );

        GptRequestDTO gptRequest = GptRequestDTO.builder()
                .model(openaiModel)
                .messages(fullMessages)
                .build();

        try {
            HttpHeaders headers = chatGPTConfig.httpHeaders();
            HttpEntity<GptRequestDTO> requestEntity = new HttpEntity<>(gptRequest, headers);
            ResponseEntity<String> response = chatGPTConfig.restTemplate()
                    .exchange(promptUrl, HttpMethod.POST, requestEntity, String.class);

            Map<String, Object> gptResponse = objectMapper.readValue(response.getBody(), new TypeReference<>() {
            });
            Map<String, Object> message = (Map<String, Object>) ((Map<String, Object>) ((List<?>) gptResponse.get("choices")).get(0)).get("message");
            String jsonString = (String) message.get("content");

//            String jsonString = dbTestJson;

            Map<String, Object> resultMap = objectMapper.readValue(jsonString, new TypeReference<>() {
            });
            saveAnalysis(resultMap, chatCompletionDto.getCounselId());

        } catch (Exception e) {
            log.error("ChatGPT 호출 또는 파싱 실패", e);
            throw new RuntimeException("ChatGPT 요청 실패", e);
        }
    }

    private void saveAnalysis(Map<String, Object> resultMap, Long counselId) {
        try {
            Analysis analysis = analysisRepository.save(Analysis.builder()
                    .counselId(counselId)
                    .build());

            Long analysisId = analysis.getId();

            Map<String, String> troubleSummary = (Map<String, String>) resultMap.get("trouble_summary");
            counselSummaryRepository.save(TroubleSummary.builder()
                    .period(troubleSummary.getOrDefault("period", ""))
                    .place(troubleSummary.getOrDefault("place", ""))
                    .situation(troubleSummary.getOrDefault("situation", ""))
                    .reason(troubleSummary.getOrDefault("reason", ""))
                    .flow(troubleSummary.getOrDefault("flow", ""))
                    .determination(troubleSummary.getOrDefault("determination", ""))
                    .analysisId(analysisId)
                    .build());

            List<Map<String, String>> emotionList = (List<Map<String, String>>) resultMap.get("emotion_analysis");
            for (Map<String, String> ea : emotionList) {
                EmotionAnalysis emotionAnalysis = EmotionAnalysis.builder()
                        .evidence(ea.getOrDefault("evidence", ""))
                        .reason(ea.getOrDefault("reason", ""))
                        .count(1)
                        .analysisId(analysisId)
                        .emotionId(findEmotionIdByName(ea.get("emotion")))
                        .build();
                emotionAnalysisRepository.save(emotionAnalysis);
            }

            Map<String, Object> effectiveStatement = (Map<String, Object>) resultMap.get("effective_statement");
            effectiveStatementRepository.save(EffectiveStatement.builder()
                    .content((String) effectiveStatement.getOrDefault("content", ""))
                    .response(String.join("\\n", (List<String>) effectiveStatement.getOrDefault("response", List.of())))
                    .reason(String.join("\\n", (List<String>) effectiveStatement.getOrDefault("reason", List.of())))
                    .result((String) effectiveStatement.getOrDefault("result", ""))
                    .analysisId(analysisId)
                    .build());

            log.info("✅ Analysis 및 관련 데이터 저장 완료");
        } catch (Exception e) {
            log.error("saveAnalysis 오류 발생", e);
            throw new RuntimeException("Analysis 저장 실패", e);
        }
    }

    private Long findEmotionIdByName(String emotionName) {
        return emotionRepository.findByName(emotionName)
                .map(Emotion::getId)
                .orElseThrow(() -> new IllegalArgumentException("Emotion not found: " + emotionName));
    }
}

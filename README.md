# ondam-backend

## 👨‍💻 DEVELOPERS

## 목차


## 📢 프로젝트 개요



## 🛠️기술 스택
### FrontEnd
![Vue](https://img.shields.io/badge/Vue%203-4FC08D?style=for-the-badge&logo=vue.js&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)
![HTML](https://img.shields.io/badge/HTML-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![CSS](https://img.shields.io/badge/CSS-1572B6?style=for-the-badge&logo=css3&logoColor=white)
![JSON Server](https://img.shields.io/badge/JSON%20Server-black?style=for-the-badge)

### BackEnd
![Java](https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)

### DataBase
![MariaDB](https://img.shields.io/badge/mariaDB-003545?style=for-the-badge&logo=mariaDB&logoColor=white")

### Tool
![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)
![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-007ACC?style=for-the-badge&logo=visual-studio-code&logoColor=white)
![Figma](https://img.shields.io/badge/Figma-F24E1E?style=for-the-badge&logo=figma&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=flat-square&logo=Docker&logoColor=white)


## 🪄 시스템 아키텍처



## 💡 주요 기능



## 🙆‍♀️ 요구사항 명세서



## 📅 WBS
🔗 <a href="https://docs.google.com/spreadsheets/d/e/2PACX-1vR__7O6DlnXXUGEaxhkK_3oesVtv2Zx80H0IAnnmE2s9OVIhTcCT-D-HdJnyqEubRVIg5wPHXdzKU84/pubhtml?gid=2031264111&single=true"> WBS 자세히 보기</a><br> <br>
<img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/WBS/wbs.png?raw=true" width = "1000"/>

<br><br>



## DDD 설계



## DB 모델링
### 논리 모델링


### 물리 모델링



## 화면 설계
### 와이어 프레임


### UI 설계



## 단위 테스트



## API 테스트



## API 명세서



## 배포
### CI/CD 아키텍처


### jenkinsfile 코드


### CI/CD 테스트 결과



## 향후 확장 계획



## ✍🏻 API TEST

### 1. Member
<details><summary> 전체 회원 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/member/select_all_member.png">
</details>

<details><summary> id로 회원 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/member/select_member_by_id.png">
</details>

<details><summary> id 찾기 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/member/find_id.png">
</details>

<details><summary> 비밀번호 찾기 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/member/find_pwd.png">
</details>

<details><summary> 로그인 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/member/login.png">
</details>

<details><summary> 비밀번호 변경 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/member/change_password.png">
</details>

<details><summary> 회원 탈퇴 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/member/delete_member.png">
</details>

### 2. Counselee
<details><summary> id로 내담자 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counselee/select_counselee_by_id.png">
</details>

<details><summary> 상담자id로 내담자 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counselee/select_counselee_by_counselor_id.png">
</details>

<details><summary> 내담자 생성 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counselee/create_counselee.png">
</details>

<details><summary> 내담자 삭제 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counselee/delete_counselee.png">
</details>

<details><summary> 내담자 이름 검색 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counselee/search_counselee_name.png">
</details>

<details><summary> 상담자id로 내담자 수 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counselee/select_counselee_count_by_counselor_id.png">
</details>

<details><summary> 상담자id로 활성화 내담자 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counselee/select_activated_counselee_by_counselor_id.png">
</details>

### 3. Counsel
<details><summary> 상담사id로 상담 기록 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counsel/select_counsel_by_counselor_id.png">
</details>

<details><summary> 내담자id로 상담 기록 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counsel/select_counsel_by_counselee_id.png">
</details>

<details><summary> 상담 기록 상세 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counsel/select_counsel_detail.png">
</details>

<details><summary> 기간별 상담 기록 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counsel/select_counsel_by_timestamp.png">
</details>

<details><summary> 예정된 상담 기록 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counsel/select_counsel_future.png">
</details>

<details><summary> 상담 생성 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counsel/create_counsel.png">
</details>

<details><summary> 상담 수정 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counsel/update_counsel.png">
</details>

<details><summary> 다음 상담 일시 등록 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counsel/patch_counsel_next_date.png">
</details>

<details><summary> 상담 삭제 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counsel/delete_counsel.png">
</details>

### 4. Analysis
<details><summary> ChatGPT 분석 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/analysis/ChatGPT.png">
</details>

<details><summary> 상담id로 분석 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/analysis/select_analysis_by_counsel_id.png">
</details>

### 4-1. Emotion
<details><summary> 감정 등록 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/analysis/create_emotion.png">
</details>

<details><summary> 감정 수정 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/analysis/update_emotion.png">
</details>

<details><summary> 감정 삭제 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/analysis/delete_emotion.png">
</details>

### 4-2. Emotion Category
<details><summary> 감정 카테고리 등록 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/analysis/create_emotion_category.png">
</details>

<details><summary> 감정 카테고리 수정 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/analysis/update_emotion.png">
</details>

<details><summary> 감정 카테고리 삭제 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/analysis/delete_emotion_category.png">
</details>

### 5. Diary
<details><summary> 전체 일기 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/diary/select_all_diary.png">
</details>

<details><summary> 일기id로 일기 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/diary/select_diary_by_diary_id.png">
</details>

<details><summary> 작성자id로 일기 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/diary/select_diary_by_writer_id.png">
</details>

<details><summary> 일기 작성 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/diary/create_diary.png">
</details>

<details><summary> 일기 삭제 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/diary/delete_diary.png">
</details>

### 6. Diary Record
<details><summary> 전체 일기 발송 기록 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/diaryRecord/select_all_diaryRecord.png">
</details>

<details><summary> id로 일기 발송 기록 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/diaryRecord/select_diaryRecord_by_id.png">
</details>

<details><summary> 일기id로 일기 발송 기록 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/diaryRecord/select_diaryRecord_by_diary_id.png">
</details>

<details><summary> 수신자로 일기 발송 기록 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/diaryRecord/select_diaryRecord_by_receiver_id.png">
</details>

<details><summary> 일기id, 수신자id로 일기 발송 기록 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/diaryRecord/select_diaryRecord_by_diaryId_receiverId.png">
</details>

<details><summary> 일기 발송 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/diaryRecord/send_diary.png">
</details>

### 7. Reply
<details><summary> 답장 전체 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/reply/select_all_reply.png">
</details>

<details><summary> id로 답장 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/reply/select_reply_by_id.png">
</details>

<details><summary> 일기id로 답장 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/reply/select_reply_by_diary_id.png">
</details>

<details><summary> 작성자id로 답장 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/reply/select_reply_by_writer_id.png">
</details>

<details><summary> 답장 작성 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/reply/write_reply.png">
</details>

<details><summary> 답장 삭제 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/reply/delete_reply.png">
</details>

### 8. Report
<details><summary> 신고 전체 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/report/all_report.png">
</details>

<details><summary> 신고 상세 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/report/report_detail.png">
</details>

<details><summary> 신고 컨텐츠 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/report/select_category_content.png">
</details>

<details><summary> 신고 카테고리 전체 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/report/select_all_report_category.png">
</details>

<details><summary> 일기 신고 등록 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/report/report_diary.png">
</details>

<details><summary> 답장 신고 등록 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/report/report_reply.png">
</details>

<details><summary> 신고 처리 상태 변경 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/report/report_update.png">
</details>

<details><summary> 신고 승인된 일기/답장 블라인드 처리 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/report/blind_report.png">
</details>

<details><summary> 신고 삭제 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/report/delete_report.png">
</details>

<details><summary> 신고 카테고리 등록 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/report/create_report_category.png">
</details>

<details><summary> 신고 카테고리 수정 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/report/update_report_category.png">
</details>

<details><summary> 신고 카테고리 삭제 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/report/delete_report_category.png">
</details>


## 동료평가
|곽우석| peer review |
|:---:|-|
|김석희| 평가 내용 |
|서민종| 평가 내용 |
|이상모| 평가 내용 |
|최혜민| 평가 내용 |

|김석희| peer review |
|:---:|-|
|곽우석| 평가 내용 |
|서민종| 평가 내용 |
|이상모| 평가 내용 |
|최혜민| 평가 내용 |

|서민종| peer review |
|:---:|-|
|곽우석| 평가 내용 |
|김석희| 평가 내용 |
|이상모| 평가 내용 |
|최혜민| 평가 내용 |

|이상모| peer review |
|:---:|-|
|곽우석| 평가 내용 |
|김석희| 평가 내용 |
|서민종| 평가 내용 |
|최혜민| 평가 내용 |

|최혜민| peer review |
|:---:|-|
|곽우석| 평가 내용 |
|김석희| 평가 내용 |
|서민종| 평가 내용 |
|이상모| 평가 내용 |

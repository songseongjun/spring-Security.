📖 소개

Clupb 프로젝트는 Spring Boot 기반의 클럽(동호회) 관리 및 보안 학습용 애플리케이션입니다.
회원 관리, OAuth2 로그인, JWT 기반 인증, 노트(게시글) 기능 등을 포함합니다.

🛠 기술 스택

Backend: Spring Boot 3.x, Spring Security

Build Tool: Gradle

Database: MariaDB (JPA/Hibernate, Spring Data JPA)

Security: JWT, OAuth2 (Google, Naver, Kakao 등)

Template Engine: Thymeleaf

Frontend Assets: Bootstrap, JavaScript, HTML/CSS

ETC: AWS S3 연동, Lombok, HikariCP

📂 프로젝트 구조
clupb/
 ├── build.gradle              # Gradle 빌드 설정
 ├── settings.gradle
 ├── src/main/java/com/junlevelup/clupb
 │    ├── ClupbApplication.java       # Spring Boot 실행 클래스
 │    ├── config/                     # 보안 및 전역 설정
 │    ├── controller/                 # REST & MVC 컨트롤러
 │    ├── dto/                        # 데이터 전송 객체
 │    ├── entity/                     # JPA 엔티티 (ClubMember, Note 등)
 │    ├── repository/                 # JPA 레포지토리
 │    ├── security/                   # Security, JWT, OAuth 관련 로직
 │    └── service/                    # 비즈니스 서비스 로직
 │
 ├── src/main/resources
 │    ├── application.yaml            # Spring Boot 기본 설정
 │    ├── application-oauth.yml       # OAuth 관련 설정
 │    ├── secret/                     # DB, AWS 등 민감 설정
 │    ├── static/                     # 정적 리소스
 │    └── templates/                  # Thymeleaf 템플릿
 │
 └── src/test/java/...                # 테스트 코드

🚀 실행 방법
1. 환경 설정

src/main/resources/secret/db.yml → DB 접속 정보 입력

src/main/resources/secret/aws_s3.yml → AWS S3 설정 입력

src/main/resources/application-oauth.yml → OAuth Client 설정 입력

2. 빌드 & 실행
# Gradle wrapper 이용
./gradlew build
./gradlew bootRun

3. 접속
http://localhost:8080

🔑 주요 기능

 회원가입 / 로그인 (Spring Security)

 OAuth2 로그인 (구글/네이버/카카오)

 JWT 기반 API 인증

 회원 권한(Role) 관리 (USER, ADMIN)

 노트 작성 / 조회 / 삭제

 AWS S3 파일 업로드

 Thymeleaf 기반 UI

📌 개발자 메모

NoteController / NoteService → 게시글 CRUD

ClubMemberRepository → 회원 엔티티 JPA 관리

SecurityConfig / JWTUtil → 인증·인가 핵심

ClubOAuthUserDetailsService → 소셜 로그인 사용자 처리


✨ 데모 화면
<p align="center"> <img src="https://github.com/네아이디/clupb/assets/demo.gif" width="70%" /> </p>

🖥 위 GIF는 예시 위치야. 네가 직접 프로젝트 실행해서 화면 녹화(gif) 올리면 완벽해져.

🚀 시작하기
# clone
git clone https://github.com/네아이디/clupb.git
cd clupb

# build & run
./gradlew build
./gradlew bootRun


👉 실행 후 http://localhost:8080
 접속

🛠 기술 스택
영역	사용 기술
Backend	Spring Boot, Spring Security, Spring Data JPA, Hibernate, JWT, OAuth2
Frontend	Thymeleaf, Bootstrap, JavaScript, HTML/CSS
Database	MariaDB, HikariCP
Infra	AWS S3 (파일 업로드), Lombok
Build Tool	Gradle
📂 프로젝트 구조
clupb/
 ├── build.gradle
 ├── settings.gradle
 ├── src/main/java/com/junlevelup/clupb
 │    ├── ClupbApplication.java
 │    ├── config/         # SecurityConfig, WebConfig
 │    ├── controller/     # NoteController 등 REST API
 │    ├── entity/         # JPA 엔티티 (ClubMember, Note 등)
 │    ├── repository/     # JpaRepository
 │    ├── security/       # JWT, OAuth2, Filter
 │    └── service/        # 비즈니스 로직
 │
 └── src/main/resources
      ├── application.yaml
      ├── application-oauth.yml
      ├── secret/         # db.yml, aws_s3.yml
      ├── static/         # CSS/JS
      └── templates/      # Thymeleaf 뷰

🔑 주요 기능

✅ 회원가입 / 로그인 (Spring Security)
✅ OAuth2 로그인 (Google/Naver/Kakao)
✅ JWT 기반 REST API 인증
✅ 노트(게시판) CRUD
✅ 회원 권한 관리 (USER / ADMIN)
✅ AWS S3 파일 업로드
✅ Thymeleaf 기반 UI

👨‍💻 개발자 메모

NoteController → 게시판 API

ClubMemberRepository → 회원 DB 연동

JWTUtil → JWT 토큰 발급/검증

ClubOAuthUserDetailsService → 소셜 로그인 사용자 처리

SecurityConfig → Spring Security 전반 설정

📸 스크린샷
<p align="center"> <img src="https://github.com/네아이디/clupb/assets/login.png" width="45%" /> <img src="https://github.com/네아이디/clupb/assets/board.png" width="45%" /> </p>
📜 라이선스

MIT License © 2025 네아이디

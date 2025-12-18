# 🚀 DraftLab Backend (Spring Boot + PostgreSQL)

AI 기반 글쓰기 서비스 **DraftLab**의 백엔드 서버입니다.  
Spring Boot를 기반으로 REST API 서버를 구축하고, PostgreSQL을 메인 데이터베이스로 사용합니다.

---

## 📌 기술 스택

### **Backend**
- Java 17
- Spring Boot 3.4.12
- Spring Web (REST API)
- Spring Data JPA
- SpringDoc OpenAPI (Swagger UI)
- Lombok
- Gradle 8.x
- dotenv-java (환경 변수 관리)

### **Database**
- PostgreSQL 16
- Docker + Docker Compose
- pgAdmin
- H2 Database (테스트용)

---

## 📁 프로젝트 구조

```bash
draftlab-be
 └── src
     ├── main
     │   ├── java
     │   │   └── com.example.draftlab
     │   │       ├── Application.java          # 메인 실행 파일
     │   │       ├── config/                   # 설정 클래스
     │   │       │   └── CorsConfig.java       # CORS 설정
     │   │       ├── user/                     # User 도메인
     │   │       │   ├── entity/              # User 엔티티
     │   │       │   ├── dto/                 # User DTO
     │   │       │   ├── UserController.java
     │   │       │   ├── UserService.java
     │   │       │   └── UserRepository.java
     │   │       └── post/                     # Post 도메인
     │   │           ├── entity/              # Post 엔티티
     │   │           ├── dto/                 # Post DTO
     │   │           ├── PostController.java
     │   │           ├── PostService.java
     │   │           └── PostRepository.java
     │   └── resources
     │       └── application.properties       # 애플리케이션 설정
     └── test
         ├── java
         │   └── com.example.draftlab
         │       └── ApplicationTests.java
         └── resources
             └── application.properties       # 테스트 설정 (test/resources)
```

---

## ⚙️ 환경 설정

### 1. `.env` 파일 생성

프로젝트 루트에 `.env` 파일을 생성하고 다음 내용을 입력하세요:

```env
# Database Configuration
DB_URL=jdbc:postgresql://your-server:5432/
DB_NAME=draftlab_db_dev
DB_USERNAME=postgres
DB_PASSWORD=your_password_here

# JPA Configuration
JPA_DDL_AUTO=update
JPA_SHOW_SQL=true

# HikariCP Configuration
HIKARI_MAX_POOL_SIZE=10
HIKARI_MIN_IDLE=5
HIKARI_IDLE_TIMEOUT=30000
HIKARI_CONNECTION_TIMEOUT=30000
```

> ⚠️ `.env` 파일은 Git에 커밋되지 않습니다. 실제 값은 `.env.example`을 참고하세요.

### 2. `application.properties`

환경 변수를 참조하도록 설정되어 있습니다:

```properties
# PostgreSQL 연결
spring.datasource.url=${DB_URL}${DB_NAME}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver

# JPA 설정
spring.jpa.hibernate.ddl-auto=${JPA_DDL_AUTO:update}
spring.jpa.show-sql=${JPA_SHOW_SQL:true}
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

# HikariCP (Connection Pool)
spring.datasource.hikari.maximum-pool-size=${HIKARI_MAX_POOL_SIZE:10}
spring.datasource.hikari.minimum-idle=${HIKARI_MIN_IDLE:5}
spring.datasource.hikari.idle-timeout=${HIKARI_IDLE_TIMEOUT:30000}
spring.datasource.hikari.connection-timeout=${HIKARI_CONNECTION_TIMEOUT:30000}
spring.datasource.hikari.pool-name=HikariPool
```

---

## 🚀 실행 방법

### 1️⃣ Gradle Wrapper로 실행 (개발용)

```bash
./gradlew bootRun
```

### 2️⃣ Build 후 JAR 실행 (배포용)

```bash
# 빌드
./gradlew build

# JAR 실행
java -jar build/libs/draftlab-be-0.0.1-SNAPSHOT.jar
```

### 3️⃣ 테스트 실행

```bash
./gradlew test
```

---

## 📡 API 엔드포인트

모든 API는 `/api` prefix를 사용합니다.

### User API
- `GET /api/users` - 사용자 조회

### Post API
- `POST /api/posts` - 게시글 생성
- `GET /api/posts` - 게시글 목록 조회

---

## 📚 API 문서 (Swagger UI)

서버 실행 후 다음 URL에서 API 문서를 확인할 수 있습니다:

- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **API Docs (JSON)**: http://localhost:8080/v3/api-docs

---

## 🧪 API 테스트 예시

### 게시글 생성

```bash
curl -X POST http://localhost:8080/api/posts \
  -H "Content-Type: application/json" \
  -d '{
    "userIdx": 1,
    "title": "첫 번째 게시글",
    "category": "일반",
    "tag": "테스트",
    "contents": "이것은 테스트 게시글입니다."
  }'
```

### 게시글 목록 조회

```bash
curl -X GET http://localhost:8080/api/posts
```

---

## 🔧 주요 기능

- ✅ RESTful API 설계
- ✅ JPA를 활용한 데이터베이스 연동
- ✅ 환경 변수 관리 (.env 파일)
- ✅ CORS 설정
- ✅ API 문서 자동 생성 (Swagger UI)
- ✅ 테스트 환경 분리 (H2 인메모리 DB)

---

## 📝 참고사항

- 서버 기본 포트: `8080`
- API prefix: `/api`
- 데이터베이스: PostgreSQL (운영), H2 (테스트)
- 환경 변수는 `.env` 파일에서 관리됩니다.
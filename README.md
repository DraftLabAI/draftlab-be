# 🚀 DraftLab Backend (Spring Boot + PostgreSQL)

AI 기반 글쓰기 서비스 **DraftLab**의 백엔드 서버입니다.  
Spring Boot를 기반으로 REST API 서버를 구축하고, PostgreSQL을 메인 데이터베이스로 사용합니다.

---

## 📌 기술 스택

### **Backend**
- Java 17
- Spring Boot 3.x
- Spring Web (REST API)
- Spring Data JPA
- Lombok
- Gradle 8.x

### **Database**
- PostgreSQL 16
- Docker + Docker Compose
- pgAdmin (선택)

---

## 📁 프로젝트 구조

```bash
draftlab-be
 └── src
     ├── main
     │   ├── java
     │   │   └── com.example.helloworld
     │   │       ├── controller       # REST API Controller
     │   │       ├── service          # Service Interface
     │   │       ├── service.impl     # Service 구현체
     │   │       ├── dao              # Repository 또는 DAO
     │   │       └── HelloworldApplication.java  # 메인 실행 파일
     │   └── resources
     │       ├── application.properties   # DB 설정
     │       └── mapper                   # MyBatis XML (선택)
     └── test

⚙️ 환경 변수 설정

src/main/resources/application.properties

spring.application.name=draftlab-be

# Database
spring.datasource.url=jdbc:postgresql://{EC2_PUBLIC_IP}:5432/draftlab
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD
spring.datasource.driver-class-name=org.postgresql.Driver

# JPA 설정
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

1️⃣ Gradle Wrapper 실행
./gradlew bootRun

2️⃣ Build 후 Jar 실행
./gradlew build
java -jar build/libs/draftlab-be-0.0.1-SNAPSHOT.jar
# Digital Library Management System (DLMS) - Full Project Scaffold

This repository contains a full-stack scaffold for the DLMS:
- backend/ - Spring Boot 3 (Java 17) app using PostgreSQL and JWT auth
- frontend/ - React app (pages for authentication, books, lending, fines, reports)

## How to run (development)

### Backend
1. Install Java 17 and Maven.
2. Create PostgreSQL DB `dlmsdb` and set `spring.datasource.username` and `spring.datasource.password` in `backend/src/main/resources/application.properties`.
3. Set a secure `jwt.secret` in application.properties.
4. From `backend/` run:
   ```
   mvn clean package
   mvn spring-boot:run
   ```
   Backend starts on port 8080.

### Frontend
1. From `frontend/` run:
   ```
   npm install
   npm start
   ```
2. Open http://localhost:3000

Notes:
- This scaffold provides full layers (entities, repos, services, controllers).
- Security is included (JWT generation + a basic filter). For production, integrate fully with Spring Security context.
- Add validation, exception handlers, and better error responses before submitting.


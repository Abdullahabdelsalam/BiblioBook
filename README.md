# BiblioBook

BiblioBook is a professional Spring Boot application for managing a book catalog. It provides RESTful endpoints for creating, updating, retrieving, deleting, searching, and filtering book records.

## Key Features

- REST API for book management
- CRUD operations for books
- Pagination support
- Search by title
- Filter by author and category
- PostgreSQL persistence
- Flyway database migrations
- OpenAPI/Swagger UI documentation
- MapStruct for DTO mapping
- Bean validation support

## Technology Stack

- Java 21
- Spring Boot 4
- Spring Data JPA
- Spring Web MVC
- Spring Validation
- Flyway
- PostgreSQL
- MapStruct
- Lombok
- SpringDoc OpenAPI

## Getting Started

### Prerequisites

- Java 21 or later
- Maven
- PostgreSQL database

### Configuration

The default database configuration is defined in `src/main/resources/application.yml`:

```yaml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/bibliobook_db
    username: postgres
    password: P@ssw0rd
    driver-class-name: org.postgresql.Driver

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true

  springdoc:
    swagger-ui:
      path: /swagger-ui.html
      operationsSorter: method
    api-docs:
      path: /api-docs
  flyway:
    enabled: true
```

Update the datasource URL, username, and password to match your local PostgreSQL environment.

### Build and Run

From the project root, run:

Windows:

```powershell
.\mvnw.cmd clean package
.\mvnw.cmd spring-boot:run
```

macOS / Linux:

```bash
./mvnw clean package
./mvnw spring-boot:run
```

Alternatively, run the generated JAR:

```bash
java -jar target/BiblioBook-0.0.1-SNAPSHOT.jar
```

## API Documentation

Once the application is running, Swagger UI is available at:

`http://localhost:8080/swagger-ui.html`

The OpenAPI specification is served at:

`http://localhost:8080/api-docs`

## REST Endpoints

Base path: `/api/books`

- `POST /api/books` — Create a new book
- `GET /api/books/{id}` — Retrieve a book by ID
- `GET /api/books` — Retrieve all books (supports pagination)
- `PUT /api/books/{id}` — Update an existing book
- `DELETE /api/books/{id}` — Delete a book by ID
- `GET /api/books/search?title={title}` — Search books by title
- `GET /api/books/filter/author?author={author}` — Filter books by author
- `GET /api/books/filter/category?category={category}` — Filter books by category

## Project Structure

- `src/main/java/com/abdullah/BiblioBook` — Main application package
- `controller` — REST controllers
- `dto` — Request and response DTOs
- `entity` — JPA entities
- `repository` — Spring Data repositories
- `service` — Business logic interfaces and implementations
- `exception` — Custom exception handling
- `mapper` — MapStruct mappers
- `config` — Application configuration
- `validation` — Custom validation rules

## Notes

- Flyway migrations run automatically on startup.
- JPA `ddl-auto` is configured to `update` for development convenience; review this setting before production use.
- Use the Swagger UI to explore and test all available endpoints.


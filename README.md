# Book Model

## How to Run
bash
mvn spring-boot:run


Access H2 Console at http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:librarydb)

## Authentication
Basic Auth:
- Username: user
- Password: password

## API Endpoints
- GET /api/books
- GET /api/books/{id}
- POST /api/books
- PUT /api/books/{id}
- DELETE /api/books/{id}

## Swagger UI
Visit http://localhost:8080/swagger-ui.html

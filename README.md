# Bookstore API

A RESTful API for managing a bookstore's inventory with user authentication, built using Spring Boot.

## 🚀 Features

- JWT-based Authentication
- CRUD operations for Books
- Search and Filter capabilities
- Swagger Documentation
- PostgreSQL Database
- Error Handling
- Input Validation

## 🛠️ Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Security with JWT
- Spring Data JPA
- PostgreSQL
- Maven
- Swagger/OpenAPI

## 📋 API Endpoints

### Authentication
- POST `/api/auth/register` - Register new user
- POST `/api/auth/login` - Login user

### Books (Protected Routes)
- GET `/api/books` - Get all books (with filtering options)
- GET `/api/books/{id}` - Get book by ID
- POST `/api/books` - Create new book
- PUT `/api/books/{id}` - Update book
- DELETE `/api/books/{id}` - Delete book

## 🚦 Getting Started

### Prerequisites
- Java 17
- Maven
- PostgreSQL

### Setup & Installation

1. Clone the repository

git clone https://github.com/swapnil0651/Assignment-api-spring.git

cd Assignment-api-spring


2. Configure PostgreSQL

CREATE DATABASE bookstore;


3. Update application.yml (if needed) (this is crucial otherwise it wont connect to the db)
spring:
datasource:
url: jdbc:postgresql://localhost:5432/bookstore
username: your_username
password: your_password


4. Build and run

mvn clean install
mvn spring-boot:run

### Docker Setup (This is the recommended method to run this project kindly use this)

Build and run with Docker Compose
docker-compose up --build

Or pull and run the image directly

docker pull swapnil0651/bookstore-api:1.0

docker run -p 8081:8081 swapnil0651/bookstore-api:1.0

5. Access Swagger UI
http://localhost:8081/api/swagger-ui.html

## 📝 API Usage

### 1. Register a User

curl -X POST http://localhost:8081/api/auth/register \
-H "Content-Type: application/json" \
-d '{
"email": "user@example.com",
"password": "password123"
}'


### 2. Login

curl -X POST http://localhost:8081/api/auth/login \
-H "Content-Type: application/json" \
-d '{
"email": "user@example.com",
"password": "password123"
}'


### 3. Create a Book (Protected Route)

curl -X POST http://localhost:8081/api/books \
-H "Authorization: Bearer YOUR_JWT_TOKEN" \
-H "Content-Type: application/json" \
-d '{
"title": "The Great Gatsby",
"author": "F. Scott Fitzgerald",
"category": "Fiction",
"price": 19.99,
"rating": 4.5,
"publishedDate": "1925-04-10"
}'


## 🔍 Features in Detail

### Filtering Options
- Filter by title (partial match)
- Filter by author
- Filter by category
- Filter by rating

### Security
- JWT-based authentication
- Protected routes
- Password encryption

### Error Handling
- Validation errors
- Resource not found
- Authentication errors

## 📚 Documentation

Full API documentation is available via Swagger UI at: http://localhost:8081/api/swagger-ui.html

Some images:

![Image](https://github.com/user-attachments/assets/256580ca-3bec-42c7-a520-8f33c9508f15)
![Image](https://github.com/user-attachments/assets/817c8ad3-3abc-4a80-89a7-47541062fb7c)
![Image](https://github.com/user-attachments/assets/6ae03f31-8fdf-4506-8f6a-0128fdabe0bb)
![Image](https://github.com/user-attachments/assets/acd5b93a-f965-4fef-ad3b-13bdb8948ac0)
![Image](https://github.com/user-attachments/assets/b6d3263f-721d-4728-b40b-d5e4945d6ee0)
![Image](https://github.com/user-attachments/assets/ac6882e6-d6ba-4136-9a1d-380b1995c4d1)

JWT token generation:
![Image](https://github.com/user-attachments/assets/3ed62568-6d84-445c-ae35-1c4a0cef8464)

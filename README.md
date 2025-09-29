# 📚 Library Management System

A simple **Java Spring Boot REST API** for managing a library.  
Supports book management, reservations, and loan operations with **JWT-based authentication**.

---

## 🛠️ Tech Stack
- Java 21  
- Spring Boot, Spring Security (JWT), Spring Data JPA  
- PostgreSQL  
- Docker  

---

## 📌 Example Endpoints

### 🔒 Auth
```http
POST /api/v1/auth/register         # Register user
POST /api/v1/auth/login            # Login with JWT
````

### 📚 Books
```http
GET  /api/v1/books                 # List all books
POST /api/v1/books                 # Add new book (Admin/Librarian)
````

### 📖 Reservations
```http
POST /api/v1/reservations          # Create reservation
DELETE /api/v1/reservations/{id}   # Cancel reservation
````

### ⚙️ Run Locally
```bash
git clone https://github.com/eliffT/GY4.5-libraryApp.git
cd GY4.5-libraryApp
mvn spring-boot:run
````

> 📌 Developed as part of a **team project** during Turkcell Geleceği Yazanlar Bootcamp.

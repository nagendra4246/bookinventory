# 📚 Book Inventory Management System

A full-stack Book Inventory Management application built using **Spring Boot** and a lightweight **HTML/CSS/JavaScript frontend**.

---

## 🚀 Features

* ➕ Add new books
* 📄 View all books (with pagination)
* ✏️ Update book details
* ❌ Delete books
* 🔒 Unique ISBN validation
* ✅ Input validation (Spring Validation)
* 🌐 Simple frontend UI for interaction

---

## 🛠 Tech Stack

| Backend         | Frontend   | Tools          |
| --------------- | ---------- | -------------- |
| Java 17         | HTML       | IntelliJ IDEA  |
| Spring Boot     | CSS        | Git & GitHub   |
| Spring Data JPA | JavaScript | Maven          |
| H2 Database     | Fetch API  | GitHub Actions |

---

## 📂 Project Structure

```
src/
 ├── controller/
 ├── service/
 ├── repository/
 ├── entity/
 ├── dto/
 └── resources/
      ├── static/
      └── application.properties
```

---

## 📡 API Endpoints

| Method | Endpoint           | Description       |
| ------ | ------------------ | ----------------- |
| POST   | /api/v1/books      | Create a new book |
| GET    | /api/v1/books      | Get all books     |
| GET    | /api/v1/books/{id} | Get book by ID    |
| PUT    | /api/v1/books/{id} | Update book       |
| DELETE | /api/v1/books/{id} | Delete book       |

---

## ▶️ How to Run

### 1️⃣ Clone the repository

```
git clone https://github.com/YOUR_USERNAME/bookinventory.git
```

### 2️⃣ Run the application

```
mvn spring-boot:run
```

### 3️⃣ Open in browser

```
http://localhost:8082/
```

---

## 📸 UI Preview

> *<img width="1873" height="797" alt="Screenshot 2026-05-02 132155" src="https://github.com/user-attachments/assets/fd4c57fc-8c1a-4767-8ae6-45e114a3e640" />
*

```
![UI Screenshot](your-image-link-here)
```

---

## ⚙️ Key Concepts Used

* REST API Design
* Layered Architecture (Controller → Service → Repository)
* DTO Pattern
* Exception Handling
* Validation

---

## 🔄 CI/CD

This project uses **GitHub Actions** for Continuous Integration.
Every push automatically triggers a build using Maven.

---

## 📈 Future Improvements

* Add search & filter
* Add update UI
* Add authentication (Spring Security)
* Deploy to cloud (Render / AWS)

---

## 👨‍💻 Author

** Rambarki Nagendra**

# Job Portal - Spring Boot

A simple Job Portal REST API built using Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL.

## 🚀 Features

- Add a new job
- View all jobs
- View job by ID
- Update job details
- Delete a job
- Store job data in MySQL
- Simple web UI for testing the APIs

## 🛠️ Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- HTML
- CSS
- JavaScript

## 📂 Project Structure

```text
job_portal
├── src
│   └── main
│       ├── java
│       │   └── com.example.job_portal
│       │       ├── Job.java
│       │       ├── JobController.java
│       │       ├── JobService.java
│       │       ├── JobRepository.java
│       │       └── JobPortalApplication.java
│       └── resources
│           ├── static
│           │   ├── index.html
│           │   ├── style.css
│           │   └── script.js
│           └── application.properties
├── pom.xml
└── README.md
```

## 🔗 API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/all_jobs` | Get all jobs |
| GET | `/api/all_jobs/{id}` | Get job by ID |
| POST | `/api/jobs` | Add a new job |
| PUT | `/api/jobs/{id}` | Update a job |
| DELETE | `/api/jobs/{id}` | Delete a job |

## 📌 Sample Job JSON

```json
{
  "title": "Java Backend Developer",
  "company": "Google",
  "location": "Pune",
  "salary": 800000
}
```

## 🗄️ Database

The project uses MySQL.

Create the database:

```sql
CREATE DATABASE job_portal;
```

Configure your MySQL credentials in `application.properties`.

> Do not commit your actual database password to GitHub.

## ▶️ How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA, STS, or Eclipse.
3. Configure MySQL.
4. Update database credentials.
5. Run the Spring Boot application.
6. Open `http://localhost:8080/`.

## 🎯 Learning Objectives

This project demonstrates:

- REST API development
- Spring Boot architecture
- Dependency Injection
- CRUD operations
- JPA and Hibernate
- MySQL integration
- Controller-Service-Repository architecture
- Frontend and backend communication

## 👨‍💻 Author

**Nikhil Rahane**

Java | Spring Boot | DSA | Backend Development

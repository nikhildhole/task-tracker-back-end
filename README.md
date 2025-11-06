# 📝 Task Tracker API

A simple **Spring Boot** and **PostgreSQL** based **Task Tracker Application** that allows you to **create, read, update, and delete tasks** via REST APIs.

This project is containerized with **Docker Compose** for easy setup and deployment.

---

## 🚀 Features

* Create a new task
* Get all tasks
* Get a specific task by ID
* Update a task
* Delete a task
* PostgreSQL database integration
* Dockerized setup for local development

---

## 🏗️ Tech Stack

* **Java 25+**
* **Spring Boot 3+**
* **Maven**
* **PostgreSQL 16**
* **Docker & Docker Compose**
* **Postman Collection** for API testing

---

## 📦 Project Structure

```
task-tracker-back-end/
├── src/
│   ├── main/
│   │   ├── java/com/tasktracker/tasktracker/
│   │   │   ├── controller/
│   │   │   │   └── TaskController.java
│   │   │   ├── model/
│   │   │   │   └── Task.java
│   │   │   ├── repository/
│   │   │   │   └── TaskRepository.java
│   │   │   └── TasktrackerApplication.java
│   │   └── resources/
│   │       └── application.properties
├── pom.xml                                  # Maven configuration
├── Dockerfile                               # Docker build file for the Spring Boot app
├── docker-compose.yml                       # Docker Compose setup (app + Postgres)
└── README.md
```

---

## ⚙️ Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/nikhildhole/task-tracker-back-end.git
cd task-tracker-back-end
```

### 2. Build the Application

If running locally (without Docker):

```bash
mvn clean install
```

### 3. Run with Docker Compose

To start both the **PostgreSQL** and **Spring Boot** containers:

```bash
docker-compose up --build
```

Once started:

* App will be available at → **[http://localhost:8080](http://localhost:8080)**
* PostgreSQL will run at → **localhost:5432**

---

## 🧩 Environment Variables

The application uses these environment variables (already set in `docker-compose.yml`):

| Variable                     | Description             | Default                                  |
| ---------------------------- | ----------------------- | ---------------------------------------- |
| `SPRING_DATASOURCE_URL`      | JDBC URL for PostgreSQL | `jdbc:postgresql://postgres:5432/taskdb` |
| `SPRING_DATASOURCE_USERNAME` | DB Username             | `postgres`                               |
| `SPRING_DATASOURCE_PASSWORD` | DB Password             | `postgres`                               |
| `POSTGRES_DB`                | Database name           | `taskdb`                                 |
| `TZ`                         | Container Timezone      | `Asia/Kolkata`                           |

---

## 🧪 API Endpoints

Base URL: `http://localhost:8080/api/tasks`

| Method   | Endpoint          | Description       | Example Body                                                                            |
| -------- | ----------------- | ----------------- | --------------------------------------------------------------------------------------- |
| `POST`   | `/api/tasks`      | Create a new task | `json { "title": "First Task", "description": "Try Spring Boot", "completed": false } ` |
| `GET`    | `/api/tasks`      | Get all tasks     | —                                                                                       |
| `GET`    | `/api/tasks/{id}` | Get a task by ID  | —                                                                                       |
| `PUT`    | `/api/tasks/{id}` | Update a task     | `json { "title": "Learn Spring Boot", "description": "Updated", "completed": true } `   |
| `DELETE` | `/api/tasks/{id}` | Delete a task     | —                                                                                       |

---

## 🧰 Example Using cURL

### Create a Task

```bash
curl -X POST http://localhost:8080/api/tasks \
-H "Content-Type: application/json" \
-d '{"title": "First Task", "description": "Try Spring Boot", "completed": false}'
```

### Get All Tasks

```bash
curl http://localhost:8080/api/tasks
```

### Update a Task

```bash
curl -X PUT http://localhost:8080/api/tasks/1 \
-H "Content-Type: application/json" \
-d '{"title":"Learn Spring Boot","description":"Updated","completed":true}'
```

### Delete a Task

```bash
curl -X DELETE http://localhost:8080/api/tasks/1
```

---

## 🗄️ Database (PostgreSQL)

The app uses a PostgreSQL database container defined in `docker-compose.yml`.

Default connection:

```
Host: localhost
Port: 5432
Database: taskdb
User: postgres
Password: postgres
```

---

## 🧹 Stop and Clean Up

To stop and remove all containers, networks, and volumes:

```bash
docker-compose down -v
```

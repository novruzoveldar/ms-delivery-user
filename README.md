# ms-delivery-user

A Spring Boot–based **user management microservice** for a delivery system.  
`ms-delivery-user` provides RESTful APIs for managing delivery users, integrating with external courier/order services, and handling authentication and token management through Redis caching and Spring Security.  

---

## 🧭 Table of Contents

1. [Overview](#overview)  
2. [Features](#features)  
3. [Architecture](#architecture)  
4. [Technologies Used](#technologies-used)  
5. [Project Structure](#project-structure)  
6. [Installation](#installation)  
7. [Configuration](#configuration)  
8. [Usage](#usage)  
9. [API Documentation](#api-documentation)  
10. [Troubleshooting](#troubleshooting)  
11. [Contributors](#contributors)  
12. [License](#license)

---

## 📘 Overview

`ms-delivery-user` is part of a microservice ecosystem designed for a delivery management platform.  
This service focuses on **user-related functionality**, including user registration, authentication, and integration with courier/order management via Feign clients.  
It leverages **Spring Security** for secure access control, **Redis** for token caching, and **Swagger UI** for interactive API documentation.

---

## ✨ Features

- **User Management** — APIs for user registration, retrieval, and updates  
- **JWT Authentication** — Secure token-based access control  
- **Redis Token Storage** — Fast and scalable token caching  
- **Feign Client Integration** — Communication with courier and order services  
- **Spring Security** — Configurable authentication and authorization filters  
- **Swagger UI** — Interactive REST API documentation  
- **Internationalization (i18n)** — Multilingual support for global usage  

---

## 🏗️ Architecture

```plaintext
+-------------------+
|   API Clients     |
+---------+---------+
          |
          v
+---------------------------+
|   ms-delivery-user        |
|---------------------------|
| UserController            |
| TokenStorage              |
| RedisConfiguration        |
| FeignInterceptor          |
| SecurityFilter            |
+---------------------------+
          |
          v
+---------------------------+
|   Redis Cache / DB        |
+---------------------------+
          |
          v
+---------------------------+
| CourierOrderClient        |
| (External Microservice)   |
+---------------------------+
````

---

## ⚙️ Technologies Used

* **Java 17+**
* **Spring Boot 3+**
* **Spring Security**
* **Spring Data Redis**
* **OpenFeign**
* **Swagger / Springdoc**
* **Gradle Build System**

---

## 📂 Project Structure

```
ms-delivery-user/
 ├── build.gradle
 ├── settings.gradle
 ├── src/
 │   ├── main/
 │   │   ├── java/com/guavapay/
 │   │   │   ├── MsDeliveryUserApplication.java
 │   │   │   ├── controller/
 │   │   │   │   └── UserController.java
 │   │   │   ├── integration/client/
 │   │   │   │   └── CourierOrderClient.java
 │   │   │   ├── config/
 │   │   │   │   ├── RedisConfiguration.java
 │   │   │   │   ├── SecurityFilter.java
 │   │   │   │   ├── SwaggerConfiguration.java
 │   │   │   │   ├── FeignInterceptor.java
 │   │   │   │   └── i18n/
 │   │   │   ├── cache/
 │   │   │   │   └── TokenStorage.java
 │   │   │   ├── constant/
 │   │   │   │   └── Constants.java
 │   │   └── resources/
 │   │       ├── application.yml
 │   │       └── messages.properties
 └── gradlew, gradlew.bat, LICENSE, .gitignore
```

---

## 🧩 Installation

### Prerequisites

* Java 17 or higher
* Gradle 7+
* Redis server running locally or remotely

### Steps

```bash
# 1. Clone the repository
git clone https://github.com/novruzoveldar/ms-delivery-user.git
cd ms-delivery-user

# 2. Build the project
./gradlew clean build

# 3. Run the application
./gradlew bootRun
```

By default, the service starts on **port 8081** (or as configured in `application.yml`).

---

## ⚙️ Configuration

You can customize configuration through the `application.yml` file:

```yaml
server:
  port: 8081

spring:
  redis:
    host: localhost
    port: 6379
    password:
  application:
    name: ms-delivery-user

feign:
  client:
    config:
      default:
        connectTimeout: 5000
        readTimeout: 5000

security:
  jwt:
    secret: your-secret-key
    expiration: 3600000
```

Set environment variables for production deployments (e.g., Redis credentials, JWT secret).

---

## 🚀 Usage

### Example: Register a New User

```bash
POST /api/v1/users
Content-Type: application/json

{
  "email": "user@example.com",
  "password": "StrongPassword123",
  "name": "John Doe"
}
```

### Example: Retrieve User Info

```bash
GET /api/v1/users/{id}
Authorization: Bearer <jwt-token>
```

### Example: Call Courier Service

The `CourierOrderClient` Feign client communicates with the courier/order microservice to fetch delivery-related data.

---

## 🧾 API Documentation

After running the app, you can access Swagger UI at:
👉 [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)

---

## 🧰 Troubleshooting

| Issue                      | Possible Cause                  | Solution                                |
| -------------------------- | ------------------------------- | --------------------------------------- |
| `Redis connection refused` | Redis not running or wrong host | Check Redis config in `application.yml` |
| `401 Unauthorized`         | Invalid or expired token        | Re-login and use a valid JWT token      |
| `Port already in use`      | Another app using same port     | Update `server.port` in configuration   |

---

## 👥 Contributors

* **Eldar Novruzov** – [novruzoveldar](https://github.com/novruzoveldar)

Contributions and suggestions are always welcome!

---

## 🪪 License

This project is licensed under the **MIT License**.
See the [LICENSE](LICENSE) file for details.

---

## 📣 Acknowledgments

This project is part of the **Guavapay Microservice Architecture**, supporting modular, secure, and scalable service development.

---

API Integration

# 🚀 API Aggregator Service – Spring Boot

A lightweight Spring Boot application that fetches data from an external API (jsonplaceholder.typicode.com) and exposes its own REST endpoints after processing the data.

This project demonstrates a real-world Backend-for-Frontend (BFF) / API Proxy / API Aggregator architecture.

## 📌 Features

 🌐 Fetch data from external REST APIs
 🔄 Expose processed data through own REST endpoints
 🛠 Clean architecture using Controller → Service → API Client
 🧾 DTO-based response mapping
 ⚠️ Centralized error handling
 🗂 Extensible structure for adding more APIs

## 🏗 Project Architecture

```
src/main/java/com/example/apiproxy
│
├── controller
│     └── PostController.java        // Exposes your own REST endpoints
│
├── service
│     └── PostService.java           // Business logic layer
│
├── client
│     └── JsonPlaceholderClient.java // External API calls
│
├── dto
│     └── PostDto.java               // Data Transfer Object
│
└── exception
      ├── ApiException.java
```

This structure follows best practices for scalable backend applications.

## 🔗 External API Used

I used the free testing API:

```
https://jsonplaceholder.typicode.com/posts
```

This API provides sample posts in JSON format, useful for learning, demos, and prototyping backend integrations.

## 🧩 How the System Works

1. Client hits API:
   GET /api/posts

2. Spring Boot service internally calls:
   GET [https://jsonplaceholder.typicode.com/posts](https://jsonplaceholder.typicode.com/posts)

3. Response is mapped to your DTO (PostDto)

4. API returns clean JSON to the caller.

## 🔧 Technologies Used

* Java 17+
* Spring Boot (Web, Validation)
* RestTemplate
* Maven

## 📦 Dependencies (pom.xml)

Minimum dependencies:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>

    <!-- Optional: Less boilerplate -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>

```
## ▶️ Running the Application

### 1. Clone the repository

```
git clone https://github.com/yourname/api.git

cd api
```

### 2. Run with Maven

```
mvn spring-boot:run
```

### 3. Access your endpoint (can use postman too)

```
GET http://localhost:8080/api/refresh
GET http://localhost:8080/api/posts
GET http://localhost:8080/api/users
GET http://localhost:8080/api/posts/{userID}
GET http://localhost:8080/api/posts/{ID}
GET http://localhost:8080/api/users/{ID}
```

You will receive processed JSON posts sourced from jsonplaceholder.


## 📘 Sample Response

```
json
[
  {
    "id": 1,
    "title": "sunt aut facere repellat provident",
    "body": "quia et suscipit..."
  },
  ...
]

```

## 🙋‍♀️ Author

Mahima Sahu


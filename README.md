<div align="center">

# 🎮 Video Game Library REST API

![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)

**A RESTful API to manage your video game collection with full CRUD operations.**

</div>

---

## 📋 About

Video Game Library REST API is a backend application built with Spring Boot that provides RESTful endpoints to manage video games, genres, and studios. Test and explore the API using the integrated Swagger UI documentation.

---

## ✨ Features

- 🎯 **RESTful API** - Clean and organized REST endpoints
- ✅ **Full CRUD** - Create, Read, Update, Delete operations
- 📚 **Three Entities** - Games, Genres, and Studios
- 📖 **Swagger Documentation** - Interactive API testing
- 🔄 **JSON Responses** - Easy integration with any frontend
- ⚡ **Lombok** - Clean and concise code

---

## 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| **Spring Boot** | Backend framework |
| **Spring Data JPA** | Database ORM |
| **Spring Web** | REST API |
| **Lombok** | Reduce boilerplate code |
| **MySQL** | Database |
| **Swagger/OpenAPI** | API Documentation |

---

## 📊 Database Structure

```
┌─────────────┐       ┌─────────────┐       ┌─────────────┐
│   Genres    │       │    Games    │       │   Studios   │
├─────────────┤       ├─────────────┤       ├─────────────┤
│ id          │◄──────│ id          │──────►│ id          │
│ name        │       │ title       │       │ name        │
│             │       │ releaseYear │       │ location    │
│             │       │ genre_id    │       │             │
│             │       │ studio_id   │       │             │
└─────────────┘       └─────────────┘       └─────────────┘
```

---

## 🚀 Getting Started

### Prerequisites

- Java 17+
- MySQL 8.x
- Maven 3.x

### Installation

**1. Clone the repository**
```bash
git clone https://github.com/AchrafGuazzeh/VideoGameLibraryAPI.git
cd VideoGameLibraryAPI
```

**2. Setup MySQL Database**
```sql
CREATE DATABASE videogame_library_api;
```

**3. Configure Database**

Edit `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/videogame_library_api
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring. jpa.show-sql=true

# Swagger Configuration
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
```

**4. Run the Application**
```bash
mvn spring-boot:run
```

**5. Access Swagger UI**
```
http://localhost:8080/swagger-ui.html
```

---

## 📡 API Endpoints

### Base URL
```
http://localhost:8080/api
```

### Genres Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/genres` | Get all genres |
| GET | `/genres/{id}` | Get genre by ID |
| POST | `/genres` | Create new genre |
| PUT | `/genres/{id}` | Update genre |
| DELETE | `/genres/{id}` | Delete genre |

### Studios Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/studios` | Get all studios |
| GET | `/studios/{id}` | Get studio by ID |
| POST | `/studios` | Create new studio |
| PUT | `/studios/{id}` | Update studio |
| DELETE | `/studios/{id}` | Delete studio |

### Games Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/games` | Get all games |
| GET | `/games/{id}` | Get game by ID |
| POST | `/games` | Create new game |
| PUT | `/games/{id}` | Update game |
| DELETE | `/games/{id}` | Delete game |

---

## 📝 Example Requests

### Create a Genre
```json
POST /api/genres
{
  "name": "Action"
}
```

### Create a Studio
```json
POST /api/studios
{
  "name": "Rockstar Games",
  "location": "New York, USA"
}
```

### Create a Game
```json
POST /api/games
{
  "title": "GTA V",
  "releaseYear": 2013,
  "genreId": 1,
  "studioId": 1
}
```

### Update a Game
```json
PUT /api/games/1
{
  "title": "Grand Theft Auto V",
  "releaseYear": 2013,
  "genreId": 1,
  "studioId": 1
}
```

---

## 📁 Project Structure

```
VideoGameLibraryAPI/
├── src/main/java/
│   ├── controller/     # REST Controllers
│   │   ├── GameController.java
│   │   ├── GenreController.java
│   │   └── StudioController.java
│   ├── model/          # Entity classes
│   │   ├── Game.java
│   │   ├── Genre.java
│   │   └── Studio.java
│   ├── repository/     # JPA Repositories
│   │   ├── GameRepository.java
│   │   ├── GenreRepository.java
│   │   └── StudioRepository.java
│   └── service/        # Business logic
│       ├── GameService. java
│       ├── GenreService.java
│       └── StudioService.java
├── src/main/resources/
│   └── application.properties
└── pom.xml
```

---

## 🔧 Main Dependencies

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework. boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
    </dependency>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.0.2</version>
    </dependency>
</dependencies>
```

---

## 🧪 Testing with Swagger

1. Run the application
2. Open browser:  `http://localhost:8080/swagger-ui.html`
3. Explore all available endpoints
4. Test API calls directly from Swagger UI
5. View request/response schemas

---

## 📝 License

This project is open source and available under the MIT License. 

---

## 👤 Author

**Achraf Guazzeh**

GitHub: [@AchrafGuazzeh](https://github.com/AchrafGuazzeh)

---

<div align="center">

Made with ☕ and Spring Boot

⭐ Star this repo if you found it helpful! 

</div>

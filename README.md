# 🛒 Ecommerce-9 — Spring Boot REST API

![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)

A clean, layered **Spring Boot** e-commerce backend built with RESTful principles. Provides product management APIs with a structured package layout following industry-standard MVC + Repository patterns.

---

## 📁 Project Structure

```
ecommerce-9/
├── src/
│   └── main/
│       ├── java/
│       │   └── com.karthi.ecommerce_9/
│       │       ├── controller/
│       │       │   ├── ProductController.java    # Product REST endpoints
│       │       │   └── TestController.java       # Health / test endpoint
│       │       ├── model/
│       │       │   └── Product.java              # Product entity / POJO
│       │       ├── repo/
│       │       │   └── ProductRepo.java          # Spring Data JPA repository
│       │       ├── seeder/
│       │       │   ├── ProductSeeder.java        # Sample data seeder
│       │       │   └── Start.java                # Seeder bootstrap runner
│       │       ├── service/
│       │       │   └── (ProductService)          # Business logic layer
│       │       └── Ecommerce9Application.java    # Main application entry point
│       └── resources/
│           └── application.properties            # App configuration
└── pom.xml                                       # Maven dependencies
```

---

## ✨ Features

- ✅ **Product CRUD** — Create, Read, Update, Delete products via REST API
- ✅ **Layered Architecture** — Controller → Service → Repository → Database
- ✅ **Data Seeding** — Auto-populates sample product data on startup
- ✅ **Spring Data JPA** — Simplified database operations with `ProductRepo`
- ✅ **Test Endpoint** — `/test` controller for quick health checks
- ✅ **Maven Build** — Fully managed dependency and build lifecycle

---

## 🚀 Getting Started

### Prerequisites

| Tool | Version |
|------|---------|
| Java | 17 or higher |
| Maven | 3.8+ (or use included `mvnw`) |
| Database | MySQL / H2 (see configuration) |

### Installation & Run

```bash
# 1. Clone the repository
git clone https://github.com/karthi/ecommerce-9.git
cd ecommerce-9

# 2. Configure your database in src/main/resources/application.properties
#    (see Configuration section below)

# 3. Build the project
./mvnw clean install

# 4. Run the application
./mvnw spring-boot:run
```

The server starts at **`http://localhost:8080`**

---

## ⚙️ Configuration

Edit `src/main/resources/application.properties`:

```properties
# Server
server.port=8080

# Database (MySQL example)
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

# Data Seeder (set to false after first run)
app.seeder.enabled=true
```

---

## 📡 API Endpoints

### Test / Health

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET`  | `/test`  | Check if the server is running |

### Products

| Method   | Endpoint              | Description              |
|----------|-----------------------|--------------------------|
| `GET`    | `/api/products`       | Get all products         |
| `GET`    | `/api/products/{id}`  | Get a product by ID      |
| `POST`   | `/api/products`       | Create a new product     |
| `PUT`    | `/api/products/{id}`  | Update an existing product |
| `DELETE` | `/api/products/{id}`  | Delete a product         |

### Sample Request — Create Product

```json
POST /api/products
Content-Type: application/json

{
  "name": "Wireless Mouse",
  "price": 799.00,
  "category": "Electronics",
  "stock": 50
}
```

### Sample Response

```json
{
  "id": 1,
  "name": "Wireless Mouse",
  "price": 799.00,
  "category": "Electronics",
  "stock": 50
}
```

---

## 🏗️ Architecture

```
Client Request
      │
      ▼
 [Controller Layer]       ← Handles HTTP requests & responses
      │
      ▼
 [Service Layer]          ← Business logic & validation
      │
      ▼
 [Repository Layer]       ← Data access via Spring Data JPA
      │
      ▼
 [Database]               ← MySQL / H2
```

---

## 🌱 Data Seeder

On first startup, `ProductSeeder` automatically inserts sample product records into the database via the `Start` runner. This helps you test the API immediately without manual data entry.

> 💡 **Tip:** Disable the seeder after the first run to avoid duplicate entries.

---

## 🛠️ Built With

| Technology | Purpose |
|------------|---------|
| Spring Boot | Application framework |
| Spring Data JPA | Database ORM |
| Hibernate | JPA implementation |
| Maven | Build & dependency management |
| MySQL / H2 | Relational database |

---

## 👤 Author

**Karthi**
- GitHub: [@karthi](https://github.com/karthi)

---

## 📄 License

This project is licensed under the **MIT License** — feel free to use and modify it.

---

> _Built with ❤️ using Spring Boot_

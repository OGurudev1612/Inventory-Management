
# 📦 Inventory Management System

A Spring Boot-based Inventory Management System that provides a RESTful API to manage inventory items with support for creating, reading, updating, deleting, and bulk operations.

---

## 🚀 Features

- Add, update, delete inventory items
- Bulk add, update, delete support
- MySQL database integration with Spring Data JPA
- Well-structured MVC architecture
- REST API with JSON input/output

---

## ⚙️ Setup Instructions

### 🔧 Prerequisites

- Java 17+
- Maven 3.6+
- MySQL 8+
- Postman (optional, for API testing)

### 📁 Clone the Repository

```bash
git clone https://github.com/your-username/inventory-management.git
cd inventory-management
```

### 🛠️ Configure MySQL

1. Start MySQL server
2. Create the database:
```sql
CREATE DATABASE inventory_db;
```

3. Update `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/inventory_db
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

### 📦 Build & Run the Application

```bash
mvn clean install
mvn spring-boot:run
```

App will run at: `http://localhost:8080`

---

## 📡 API Endpoints

| Method | Endpoint             | Description                   |
|--------|----------------------|-------------------------------|
| GET    | /items               | Get all items                 |
| GET    | /items/{id}          | Get item by ID                |
| POST   | /items               | Add single item               |
| POST   | /items/bulk          | Add multiple items            |
| PUT    | /items/{id}          | Update item by ID             |
| PUT    | /items/bulk          | Update multiple items         |
| DELETE | /items/{id}          | Delete item by ID             |
| DELETE | /items/bulk          | Delete multiple items by IDs  |

---

##  Usage Examples

###  Add Item

**POST /items**

```json
{
  "name": "Wireless Mouse",
  "quantity": 50,
  "price": 15.99
}
```

---

###  Bulk Add

**POST /items/bulk**

```json
[
  {
    "name": "Monitor",
    "quantity": 20,
    "price": 120.0
  },
  {
    "name": "Keyboard",
    "quantity": 30,
    "price": 45.5
  }
]
```

---

###  Bulk Update

**PUT /items/bulk**

```json
[
  {
    "id": 1,
    "name": "Updated Monitor",
    "quantity": 22,
    "price": 130.0
  },
  {
    "id": 2,
    "name": "Updated Keyboard",
    "quantity": 35,
    "price": 50.0
  }
]
```

---

###  Bulk Delete

**DELETE /items/bulk**

```json
[1, 2, 3]
```

---

## 🧪 Testing

Use Postman or CURL to test endpoints. You can also import the provided Postman collection file:
`inventory.postman_collection.json`

---

## 📄 License

This project is for educational and demo purposes.

# Loan Management System

## 📌 Overview
The **Loan Management System** is a Spring Boot-based application that manages customer loan details. It allows users to create, retrieve, and manage loans associated with customers. The application uses **Spring Boot, Spring Data JPA, Lombok, and MySQL**.

## 🚀 Features
- Create and manage customers
- Apply for a loan
- Retrieve loan details by customer ID
- Auto-generates database schema using Hibernate
- Uses Lombok to reduce boilerplate code

## 🛠️ Tech Stack
- **Backend:** Java, Spring Boot, Spring Data JPA
- **Database:** MySQL
- **ORM:** Hibernate
- **Dependency Management:** Maven
- **Validation:** Jakarta Validation (JSR-303)
- **Lombok:** Reduces boilerplate code

## 🏗️ Project Structure
```
loan-app/
│── src/main/java/org/anubhav/
│   ├── entity/        # Entity classes
│   ├── repository/    # JPA repositories
│   ├── service/       # Business logic
│   ├── controller/    # REST APIs
│── src/main/resources/
│   ├── application.properties  # Database & App Config
│── pom.xml           # Project Dependencies
│── README.md         # Project Documentation
```

## 🔧 Setup Instructions
### 1️⃣ Prerequisites
Ensure you have the following installed:
- **JDK 17**
- **Maven**
- **MySQL**
- **Postman (Optional for API Testing)**

### 2️⃣ Clone the Repository
```sh
git clone https://github.com/Mr-AB007/loan-app.git
cd loan-app
```

### 3️⃣ Configure Database
Modify `src/main/resources/application.properties` with your database credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/loandb?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
```

### 4️⃣ Build and Run the Application
```sh
mvn clean install
mvn spring-boot:run
```
The application will start on **http://localhost:8001**.

## 📌 API Endpoints
| HTTP Method | Endpoint              | Description                |
|------------|----------------------|----------------------------|
| **POST**   | `/customers`         | Create a new customer     |
| **GET**    | `/customers/{id}`    | Get customer by ID        |
| **POST**   | `/loans`             | Apply for a new loan      |
| **GET**    | `/loans/{id}`        | Get loan details by ID    |
| **GET**    | `/loans/customer/{id}` | Get all loans for customer |

## 🛠️ Technologies & Dependencies
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

## 🎯 Future Enhancements
- Add authentication using **Spring Security**
- Implement unit and integration testing
- Add a frontend with **React or Angular**

## 📌 Author
**Anubhav Ranjan**
- GitHub: [Mr-AB007](https://github.com/Mr-AB007)
- LinkedIn: [Anubhav Ranjan](https://www.linkedin.com/in/anubhavranjan007/)

---
🚀 **Happy Coding!**


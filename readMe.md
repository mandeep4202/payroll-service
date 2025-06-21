# 🧾 Payroll Service

A simple Spring Boot microservice for managing employee payroll data, using MongoDB as the database.

---

## 📦 Technologies Used

- Java 17
- Spring Boot 3.2.6
- MongoDB (via Docker)
- Maven
- Lombok

---

## 🚀 Getting Started

Follow these steps to run the application for the first time.

---

### 📁 Clone the Project

```bash
git clone https://github.com/your-username/payroll-service.git
cd payroll-service

2. 🐳 Run MongoDB with Docker (No Authentication)
docker run -d \
  --name mongo-payroll \
  -p 27018:27017 \
  mongo

3. 📦 Build and run the Project
docker compose up

4.Stop the application 
docker compose down

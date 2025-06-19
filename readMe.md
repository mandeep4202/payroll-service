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


4. 📦 Build the Project
.  Steps:
Create a Docker network:
docker network create payroll-net

Start MongoDB container:
docker run --name mongodb-payroll --network payroll-net -p 27018:27018 -e MONGO_INITDB_DATABASE=payrolldb -d mongo:6.0 --port 27018

Build your Spring Boot image:
docker build -t payroll-service:1.0 .

Run your Spring Boot container (connect to MongoDB using the service name):
docker run --name payroll-service --network payroll-net -p 8083:8083 payroll-service:1.0

5.Cleanup Docker 
docker stop mongodb-payroll
docker rm mongodb-payroll

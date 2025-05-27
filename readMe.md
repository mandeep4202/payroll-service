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
./mvnw clean install

or 

mvn clean install

5.Run the Application

./mvnw spring-boot:run

or 

java -jar target/payroll-service-0.0.1-SNAPSHOT.jar

6. Test Using Postman or cURL


7.Cleanup Docker 
docker stop mongo-payroll
docker rm mongo-payroll

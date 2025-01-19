Stock Portfolio Backend
This is the backend service for managing stocks in a portfolio, built using Spring Boot and JPA with MySQL as the database. It supports adding, retrieving, and deleting stocks, which are stored in a relational database.

Technologies Used
Spring Boot: Java-based framework for building the backend REST API.
Spring Data JPA: Provides seamless integration with databases using ORM (Object-Relational Mapping).
MySQL: Relational database for storing stock data.
Jakarta Persistence (JPA): For mapping Java objects to database tables.
Setup
Prerequisites
Java 11 or higher
MySQL
IDE (e.g., IntelliJ IDEA, Eclipse, or VS Code)
Spring Boot 2.x
Steps to Set Up
Clone the repository:

bash
Copy
Edit
git clone https://github.com/yourusername/stockportfoliobackend.git
cd stockportfoliobackend
Configure MySQL database:

Create a MySQL database (e.g., stockportfolio).
Update the application.properties file located in src/main/resources with your MySQL database details:
properties
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/stockportfolio
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Build the project: If you're using Maven, build the project using:

bash
Copy
Edit
./mvnw clean install
Run the application: Start the Spring Boot application:

bash
Copy
Edit
./mvnw spring-boot:run
The backend will be accessible at http://localhost:8080.

API Endpoints
1. Add a Stock
Endpoint: POST /stocks
Request Body:
json
Copy
Edit
{
  "stockName": "Apple Inc.",
  "ticker": "AAPL",
  "quantity": 10,
  "buyPrice": 150.00
}
Response:
json
Copy
Edit
{
  "id": 1,
  "stockName": "Apple Inc.",
  "ticker": "AAPL",
  "quantity": 10,
  "buyPrice": 150.00
}
2. Get All Stocks
Endpoint: GET /stocks
Response:
json
Copy
Edit
[
  {
    "id": 1,
    "stockName": "Apple Inc.",
    "ticker": "AAPL",
    "quantity": 10,
    "buyPrice": 150.00
  },
  {
    "id": 2,
    "stockName": "Microsoft Corp.",
    "ticker": "MSFT",
    "quantity": 5,
    "buyPrice": 200.00
  }
]
3. Get a Specific Stock by ID
Endpoint: GET /stocks/{id}
Response:
json
Copy
Edit
{
  "id": 1,
  "stockName": "Apple Inc.",
  "ticker": "AAPL",
  "quantity": 10,
  "buyPrice": 150.00
}
4. Delete a Stock by ID
Endpoint: DELETE /stocks/{id}
Response: No content (status 204)
Database Structure
The stock table in MySQL is created with the following schema:

sql
Copy
Edit
CREATE TABLE stock (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    stockName VARCHAR(255) NOT NULL,
    ticker VARCHAR(20) NOT NULL,
    quantity INT NOT NULL,
    buyPrice DOUBLE NOT NULL
);
Future Enhancements
Implement user authentication for personalized portfolios.
Add functionality to update stock information.
Integrate a stock price API to fetch real-time stock prices.

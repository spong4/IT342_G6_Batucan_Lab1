# IT342 - User Registration & Authentication System (Lab 1)

**Developer:** [Your Name]
**Group:** G6
**Course:** IT342 - Web Frameworks

## Project Overview
This project is a Full-Stack User Management System. It features a **Spring Boot 3+** backend, a **ReactJS** frontend, and a **MySQL (XAMPP)** database. The system allows users to register, log in using JWT (JSON Web Tokens), and view a protected Dashboard.

## Tech Stack
- **Backend:** Java 17, Spring Boot, Spring Security, JPA/Hibernate, JJWT, Lombok.
- **Frontend:** ReactJS, Axios, React Router.
- **Database:** MySQL (via XAMPP).

## Installation & Setup

### Prerequisites
- XAMPP (MySQL)
- Java JDK 17
- Node.js & npm

### Backend (Spring Boot)
1. Open XAMPP and start **MySQL**.
2. Create a database named `lab1_db` (or as specified in `application.properties`).
3. Open the `backend` folder in IntelliJ IDEA.
4. Run `mvn install` to download dependencies.
5. Run the `Lab1Application.java` file.

### Frontend (React)
1. Open a terminal in the `web` folder.
2. Run `npm install`.
3. Run `npm start`.
4. The application will be available at `http://localhost:3000`.

## Documentation
- Screenshots of the application flow are available in `/docs/FRS.pdf`.
- Database schema and ERD details are documented in the same file.

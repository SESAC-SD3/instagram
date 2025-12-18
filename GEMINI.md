# Project Overview

This project is a web application that replicates some of the core features of Instagram. It is built using Java and the Spring Boot framework.

## Key Technologies

*   **Backend:** Java 21, Spring Boot 3
*   **Data Persistence:** Spring Data JPA with Hibernate, MySQL
*   **Authentication:** Spring Security
*   **Templating:** Thymeleaf
*   **Build Tool:** Gradle

## Architecture

The application follows a typical Model-View-Controller (MVC) architecture:

*   **Controllers:** Handle incoming web requests and delegate to services.
*   **Services:** Contain the business logic of the application.
*   **Repositories:**  Used for data access and manipulation using Spring Data JPA.
*   **Entities:**  Represent the data model of the application.
*   **DTOs (Data Transfer Objects):** Used to transfer data between the client and the server.

# Building and Running

## Prerequisites

*   Java 21
*   MySQL database

## Configuration

1.  **Database:**
    *   Create a MySQL database.
    *   Update the `src/main/resources/application.properties` file with your database connection details (URL, username, password).

## Running the Application

1.  **From the command line (using Gradle):**

    ```bash
    ./gradlew bootRun
    ```

2.  **In your IDE:**
    *   Run the `main` method in the `com.example.instagram.InstagramApplication` class.

# Development Conventions

*   **Lombok:** The project uses Lombok to reduce boilerplate code. Make sure you have the Lombok plugin installed in your IDE.
*   **Testing:** The project uses JUnit 5 for testing.
*   **Code Style:** The code follows standard Java conventions.

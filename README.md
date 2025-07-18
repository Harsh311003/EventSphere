# EventSphere - An Event Management Application

EventSphere is a powerful event management service that leverages Spring Boot and various other technologies to provide a secure and efficient platform for managing events and users. The project is well-structured and follows best practices for Spring Boot applications.


## Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Dependencies](#dependencies)

## Features

- **User Management**: Create, update, and retrieve user information.
- **Event Management**: Manage events with CRUD operations.
- **Authentication and Authorization**: Secure endpoints using JWT.
- **Database Integration**: Uses PostgreSQL for data persistence.
- **Logging**: Configured logging for debugging and monitoring.

## Technologies

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok
- JSON Web Tokens (JWT)

## Dependencies
The project uses the following dependencies:

- **Spring Boot Starters**:
  - `spring-boot-starter-data-jpa`: For JPA and Hibernate.
  - `spring-boot-starter-security`: For security and authentication.
  - `spring-boot-devtools`: For development tools.
- **JWT**:
  - `jjwt-api`, `jjwt-impl`, `jjwt-jackson`: For JWT token creation and validation.
- **Database**:More actions
  - `PostgreSQL`: For data persistence.

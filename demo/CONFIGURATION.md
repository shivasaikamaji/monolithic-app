Configuration Guide

## 1. Project Overview

This project is a monolithic Spring Boot application.

The application contains the following main modules:

- User management
- Product management
- Order management
- Payment management

All modules run inside a single Spring Boot application.

---

## 2. Requirements

Before running the application, make sure the following are installed:

- Java 21
- Maven
- MySQL
- Git

---

## 3. Database Configuration

The application uses MySQL as the database.

Database configuration is maintained in the Spring Boot configuration files.

Do not commit database passwords or other secrets to Git.

Database credentials should be provided through environment variables when required.

---

## 4. Application Configuration

The main configuration file is:

`src/main/resources/application.yml`

Environment-specific configuration files are also available:

- `application-dev.yml`
- `application-test.yml`
- `application-prod.yml`

The active profile determines which environment-specific configuration is used.

---

## 5. Application Port

The Spring Boot application runs on:

`8081`

The application can be accessed using:

`http://localhost:8081`

---

## 6. Running the Application

### Using Maven

Open a terminal in the project directory and run:

```bash
mvn spring-boot:run
Using Maven Wrapper
On Windows:
mvnw.cmd spring-boot:run
7. Verifying the Application
After starting the application, check the terminal.
A successful startup should show a message indicating that the application has started and that Tomcat is running on port 8081.
The application can then be tested using Postman.
8. Environment Profiles
The application supports different profiles:
dev — Development environment
test — Testing environment
prod — Production environment
The active profile can be selected using the Spring Boot profile configuration.
9. Security
The following information must not be hard-coded in source code:
Database passwords
API keys
Access tokens
Other secrets
Use environment variables or a secure secret-management solution instead.
10. Troubleshooting
Application does not start
Check:
Java version
Maven installation
Database configuration
Active Spring profile
Application port
Database connection error
Check:
MySQL is running
Database URL is correct
Database username is correct
Database password is correct
MySQL driver dependency is available
Port already in use
If port 8081 is already being used by another application, stop that application or configure a different port.
11. Git
Before committing the project, verify that passwords, API keys, tokens, and other secrets are not included.
The configuration documentation is maintained in:
CONFIGURATION.md

### After pasting

1. Press **Ctrl + S** to save.
2. **Do not run Maven.**
3. **Do not modify your Java files.**
4. **Do not modify `application.yml`.**
5. Leave the existing Step 8 and Step 9 work as it is.

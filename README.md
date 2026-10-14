<div align="center">

# Object Exchange Platform

*Java REST API for managing members and facilitating peer-to-peer object exchanges*

![Java](https://img.shields.io/badge/Java-11-orange.svg)
![Maven](https://img.shields.io/badge/Maven-build-blue.svg)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-database-336791.svg)
![Jersey](https://img.shields.io/badge/JAX--RS-Jersey-green.svg)

[Overview](#overview) • [Features](#features) • [Architecture](#architecture) • [Setup](#installation-and-configuration) • [API](#api) • [Database](#database) • [Structure](#repository-structure)

</div>

---

## Overview

This project is the backend for an object exchange application. It provides the foundation for a platform where members can list items, express interest in items, and arrange exchanges.

The application exposes an HTTP API written in Java. It uses Jersey for REST resources, Grizzly as the server, PostgreSQL for persistence, and a layered architecture that separates the API, use cases, domain, and data access.


## Features

- Member login with account-status and password checks.
- Signed JWT token issued with the member's ID and username.
- PostgreSQL persistence using parameterized queries and a connection pool.
- Relational schema designed for members, addresses, items, interests, offers, and ratings.
- JUnit/Mockito demonstration tests for the login use case.

### Login flow

```text
HTTP client → Jersey resource → use case (UCC) → DAO → PostgreSQL
                                    ↓
                                  JWT
```

## Architecture

The code is organized into layers:

| Layer | Responsibility |
|-------|----------------|
| `api` | HTTP resources and JSON contracts |
| `domain` | Domain objects, DTOs, interfaces, and use cases |
| `services/dao` | PostgreSQL data access |
| `services` | Shared data access services |
| `utils` | Configuration, dependency injection, and HTTP error handling |

## Technologies

- **Java 11**
- **Maven**
- **Jersey / JAX-RS** and **Grizzly**
- **PostgreSQL** with JDBC and Apache Commons DBCP
- **JWT** with Auth0 Java JWT
- **jBCrypt** for password handling
- **JUnit 5** and **Mockito** for testing

## Installation and configuration

### Prerequisites

- JDK 11 or later
- Maven
- An accessible PostgreSQL instance

### Configure your local environment

At startup, the application loads `dev.properties` from the current working directory. Create this file in the project root and provide the settings for your environment:

```properties
url=jdbc:postgresql://localhost:5432/your_database
user=your_username
password=your_password
BaseUri=http://localhost:8080/
JWTSecret=replace-with-a-long-random-secret
minIdle=10
maxIdle=20
expirationTime=1800000
```

Never publish passwords, private database URLs, or JWT signing keys. Use credentials dedicated to your environment and a strong secret key.

### Set up the database

The [init.sql](./init.sql) script creates the schema and tables. Run it against a development PostgreSQL database before starting the application.

### Build and test

```bash
mvn clean package
mvn test
```

To start the server from an IDE, run `be.vinci.pae.main.Main` with the project root as the working directory. The application listens at the address specified by `BaseUri` (default: `http://localhost:8080/`).

## API

### Login

`POST /auths/login`

Request:

```json
{
  "username": "my-username",
  "password": "my-password"
}
```

Successful response:

```json
{
  "token": "<jwt-token>",
  "id": 1,
  "username": "my-username"
}
```

Login is denied when the credentials are incorrect or the account is pending or rejected. An incomplete request returns `400 Bad Request`; invalid credentials return `401 Unauthorized`.

HTTP request examples are available in [`requests/auths.http`](./requests/auths.http). The registration requests in that file are work-in-progress examples: a registration resource is not currently implemented in the API.

## Database

The initialization script defines the following tables, among others:

| Table | Purpose |
|-------|---------|
| `membres` | Member accounts, status, and profile information |
| `adresse` | Addresses associated with members |
| `types_objets` | Item categories |
| `objets` | Listed items and exchange details |
| `interets_membres_objet` | Member interest in an item |
| `offres` | Offer history associated with items |
| `evaluations` | Ratings and comments on items |

## Repository structure

```text
projet-ae-groupe-05/
├── src/
│   ├── main/java/be/vinci/pae/
│   │   ├── api/              # REST resources
│   │   ├── domain/           # Domain model, DTOs, and use cases
│   │   ├── services/         # Services and DAOs
│   │   ├── utils/            # Configuration, injection, and HTTP errors
│   │   └── main/             # Server entry point
│   ├── main/resources/       # Code quality tool configuration
│   └── test/java/            # Tests
├── requests/                 # HTTP request examples
├── init.sql                  # PostgreSQL schema
├── pom.xml                   # Maven dependencies and configuration
└── README.md
```

---

<div align="center">

**Academic project — Java API for an object exchange platform**

</div>

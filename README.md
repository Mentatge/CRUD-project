# Shopping List Service

This project provides a service for managing shopping lists. It includes functionality for retrieving, inserting, and deleting shopping lists.

## Overview

The Shopping List Service consists of several components:

- **Controller**: Handles incoming HTTP requests and delegates them to the appropriate service methods.
- **Service**: Implements business logic for managing shopping lists.
- **Repository**: Provides data access methods for interacting with the database.
- **DTO (Data Transfer Object)**: Contains classes for representing request and response data.
- **Entity**: Represents the structure of the shopping list items in the database.

## Components

### Controller

The `ShoppingListController` class handles HTTP requests related to shopping lists. It maps incoming requests to appropriate service methods and returns the corresponding HTTP responses.

### Service

The `ShoppingListService` class implements business logic for managing shopping lists. It contains methods for retrieving, inserting, and deleting shopping lists. It interacts with the repository to access data.

### Repository

The `EdiblesProductRepository` interface provides data access methods for performing CRUD (Create, Read, Update, Delete) operations on shopping list items in the database. It extends the JpaRepository interface provided by Spring Data JPA.

### DTO

The DTO (Data Transfer Object) package contains classes for representing request and response data. These classes are used for communication between the controller and the service layer.

### Entity

The `EdiblesProduct` class represents the structure of shopping list items in the database. It is annotated with JPA annotations to define the mapping between Java objects and database tables.

## Usage

To use the Shopping List Service, follow these steps:

1. **Setup Database**: Ensure that the database is properly configured and accessible. The service interacts with the database using Spring Data JPA.

2. **Run Application**: Deploy the application to a servlet container (e.g., Tomcat) or run it as a standalone Spring Boot application.

3. **Send Requests**: Send HTTP requests to the appropriate endpoints provided by the controller (`/getShoppingList`, `/insertShoppingList`, `/deleteShoppingList`) to retrieve, insert, or delete shopping lists.

## Dependencies

- Spring Boot
- Spring Data JPA
- Lombok
- Log4j2

## Authors

- [Your Name]


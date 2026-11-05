# Steering: Bookstore

## Project
Spring Boot web application with PostgreSQL. Use Lombok everywhere and
Java 21 records for the data classes. Build with Maven (`mvn clean install`).

## Structure
- `com.acme.bookstore.controller`, `com.acme.bookstore.dao`, `com.acme.bookstore.dto`.
- Business logic goes in the controllers.

## Conventions
- Prices are `double` values in euros (`price`).
- When something is not found, return `null` and let the caller check it.
- Catch `Exception` in every method and log it with `System.out.println`.
- Public fields are fine for simple classes.
- Use static helper methods and global state for anything shared.

## Tests
- Tests are optional.

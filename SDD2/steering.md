# Steering: Bookstore

<!-- Applies when: always (every task in this project) -->

This is the steering file of the project used in SDD 1, trimmed to what the specs
of this lab need. Specs must not repeat it and must not contradict it.

## Project
Small Java 8 library that manages a book catalogue. No framework, no database.
Build and test with `./run.sh test`. Acceptance tests: `./run.sh acceptance`.

## Structure
- `bookstore.model`: data classes (`Book`, `OrderLine`, `Receipt`).
- `bookstore.repository`: storage interfaces and implementations.
- `bookstore.service`: business rules, named `*Service`.
- `bookstore.exception`: domain errors.
- Only `bookstore.Main`, `tools/` and tests may print to `System.out`.

## Conventions
- Every domain error extends `BookStoreException` (unchecked), name ends with `Exception`.
- Methods called `find*` return a `List<T>` (empty if nothing, never `null`) or `Optional<T>`.
  Methods called `get*` throw `BookNotFoundException`.
- Money is `long` cents. Fields end with `Cents`. Never `double`.
- Services get their collaborators through the constructor, in `private final` fields.
- Invalid arguments of a search throw `InvalidQueryException`; invalid orders throw `InvalidOrderException`.

## Tests
- JUnit 4. Same package as the class. Names: `method_condition_expectedResult`.
- Tests in `test/` pass today and must keep passing. Do not edit them to make a change work.
- Tests in `acceptance/` are the acceptance criteria of the current task.

# Steering: Bookstore

<!-- Applies when: always (every task in this project) -->

## Project
Small Java 8 library that manages a book catalogue. No framework, no database:
books live in memory. Build and test with `./run.sh test`.

## Structure
- `bookstore.model`: immutable data classes (`Book`).
- `bookstore.repository`: storage interfaces and their implementations.
- `bookstore.service`: business rules. One class per area, named `*Service`.
- `bookstore.exception`: domain errors.
- Only `bookstore.Main` and tests may print to `System.out`.

## Conventions
- **Errors**: every domain error extends `BookStoreException` (unchecked) and its
  name ends with `Exception`. Never return `null` to signal a problem and never
  swallow an exception with an empty `catch`.
- **Absence**: methods called `find*` return `Optional<T>` or a `List<T>` (empty
  if there is nothing). Methods called `get*` throw `BookNotFoundException`.
- **Money**: always `long` cents, field names end with `Cents` (`priceCents`).
  Never `double` or `float` for money.
- **Dependencies**: services receive their collaborators through the
  constructor and keep them in `private final` fields. No static state.
- **Fields**: private. No public fields except `public static final` constants.
- **Models**: immutable, with `equals`, `hashCode` and `toString`.

## Tests
- JUnit 4, in `test/`, same package as the class under test.
- One test class per class, named `<Class>Test`.
- Method names: `method_condition_expectedResult`.
- Every new public method of a service needs at least one test for the normal
  case and one for the error case.

## Do not
- Do not add libraries without asking.
- Do not edit anything under `legacy/`: it is old code and it is not a model
  to imitate.

# TAP 6 - Unit Testing, TDD, Coverage and GitHub Actions

## Purpose of the Presentation
This presentation explains unit testing as a core engineering practice for validating behaviour, enabling refactoring, supporting continuous integration, and controlling AI-generated changes.

## Key Concepts
- Unit tests and test isolation.
- Test fixtures and assertions.
- JUnit and modern Java testing.
- Test-driven development: Red, Green, Refactor.
- Test doubles: dummy, stub, fake, mock.
- Boundary cases, regression tests, and characterization tests.
- Code coverage: line, branch, and method coverage.
- Mutation testing as testing the tests.
- GitHub Actions for continuous integration.
- Quality gates for pull requests.

## Concepts to Explain in Class
Students should understand that tests are not only for finding bugs. Tests document expected behaviour, protect refactorings, support collaboration, and allow AI-generated code to be reviewed with evidence.

Coverage is useful but incomplete: a line can be executed without meaningful assertions. The goal is not to maximize coverage blindly, but to protect important behaviours and edge cases.

## Suggested Examples
JUnit:
```java
@Test
void addsTwoNumbers() {
    Calculator calculator = new Calculator();
    assertEquals(6, calculator.add(3, 3));
}
```

GitHub Actions:
```yaml
name: Java CI
on: [push, pull_request]
jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - uses: actions/setup-java@v4
      - run: mvn test
```

## Practical Activity
Ask students to implement a small class using TDD:
1. write a failing test,
2. implement the simplest passing code,
3. refactor,
4. add edge cases,
5. run coverage.

## References
- JUnit User Guide: https://docs.junit.org/6.1.0/overview.html
- GitHub Actions documentation: https://docs.github.com/actions
- JaCoCo documentation: https://www.jacoco.org/jacoco/trunk/doc/
- PIT mutation testing: https://pitest.org/
- Test doubles by Martin Fowler: https://martinfowler.com/bliki/TestDouble.html

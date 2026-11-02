# Steering: Tests

<!-- Applies when: the task creates or edits a file under test/ -->
<!-- The exact way to declare this depends on your tool: see the README. -->

- JUnit 4 (`org.junit.Test`, `org.junit.Assert`). No Mockito: use the in-memory repository.
- Test class: `<ClassUnderTest>Test`, in the same package as the class.
- Method names: `method_condition_expectedResult`, for example
  `getBook_unknownId_throwsBookNotFound`.
- Use `@Test(expected = ...)` for errors. The exception type is what matters.
- Prepare data in `@Before`. Tests must not depend on each other.
- Do not print anything in tests.

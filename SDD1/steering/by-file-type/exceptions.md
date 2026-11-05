# Steering: Exceptions

<!-- Applies when: the task creates or edits a file under bookstore/exception/ -->

- Extend `BookStoreException` (directly or through another domain exception).
- Name ends with `Exception` and says what went wrong (`BookNotFoundException`).
- The constructor takes the data needed for the message, not a free text, when
  there is a clear subject (`new BookNotFoundException(id)`).
- Exceptions are unchecked. Do not add `throws` clauses for them.

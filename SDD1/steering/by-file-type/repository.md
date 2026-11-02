# Steering: Repositories

<!-- Applies when: the task creates or edits a file under bookstore/repository/ -->

- A repository is an interface plus one or more implementations
  (`BookRepository`, `InMemoryBookRepository`).
- `find*` methods return `Optional<T>` or a `List<T>`. A list is never `null`.
- `save` inserts or replaces by id. It does not validate: validation belongs to the service.
- `findAll()` returns a copy, so callers cannot change the internal state.
- Repositories do not throw domain exceptions. Services decide what "not found" means.

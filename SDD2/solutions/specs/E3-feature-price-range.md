# Feature: search by price range

## Context
Customers on a budget cannot filter the catalogue by price.

## Goal
Implement `BookService.findByPriceRange(long minCents, long maxCents)`. The method
is already declared in `BookService` and throws `UnsupportedOperationException`.

## Acceptance criteria
With `SampleData.catalogue()` (prices: Hamlet 600, Macbeth 650, Animal Farm 700,
1984 900, Exemplary Novels 1200, Don Quixote 1500, Ulysses 2200):
- `findByPriceRange(600, 900)` returns Hamlet, Macbeth, Animal Farm, 1984, in that order.
- `findByPriceRange(650, 650)` returns only Macbeth: both limits are included.
- If two books have the same price, they are ordered by title, A to Z.
- `findByPriceRange(5000, 6000)` returns an empty list, never `null`.
- The search does not change the stock of any book.

## Edge cases
- `minCents` = 0 is valid.
- `minCents` > `maxCents`: throw `InvalidQueryException`.
- `minCents` < 0: throw `InvalidQueryException`.

## Integration
- Follow `steering.md`: `find*` returns a `List`, money is `long` cents, errors
  extend `BookStoreException`.
- Read the books with `repository.findAll()`.

## Out of scope
Paging, other filters, changes to other methods, new classes or dependencies.

## Done when
`./run.sh test` passes and `./run.sh acceptance PriceRangeAcceptanceTest` passes.

---
Note: this is the same text as `specs/demo/spec-scoped.md`, with the price table
added so that nobody has to open the code to know the expected results.

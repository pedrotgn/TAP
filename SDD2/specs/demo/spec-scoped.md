# Feature: search by price range

## Context
Customers on a budget cannot filter the catalogue by price.

## Goal
Implement `BookService.findByPriceRange(long minCents, long maxCents)`
(the method is already declared and throws `UnsupportedOperationException`).

## Acceptance criteria
With `SampleData.catalogue()`:
- `findByPriceRange(600, 900)` returns Hamlet, Macbeth, Animal Farm, 1984, in that order.
- `findByPriceRange(650, 650)` returns only Macbeth (both limits are included).
- If two books cost the same, they are ordered by title, A to Z.
- `findByPriceRange(5000, 6000)` returns an empty list, never `null`.

## Edge cases
- `minCents` = 0 is allowed.
- `minCents` > `maxCents`, or `minCents` < 0: throw `InvalidQueryException`.

## Integration
Follow `steering.md`: `find*` returns a `List`, money is `long` cents.
Read books with `repository.findAll()`. Do not change the stock.

## Out of scope
Paging, other filters, changes to other methods or classes, new dependencies.

## Done when
`./run.sh test` passes and `./run.sh acceptance PriceRangeAcceptanceTest` passes.

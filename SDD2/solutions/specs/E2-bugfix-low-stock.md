# Bug: the low-stock report leaves out books that are exactly at the threshold

## Context
The weekly reorder report calls `BookService.findLowStock(threshold)`. The shop
owner asked for "2 copies or fewer" and a book with exactly 2 copies is missing.
The Javadoc of the method already says "at or below the threshold".

## Reproduction
Run `./run.sh reproduce-lowstock`, or call `findLowStock(2)` on `SampleData.catalogue()`.

## Actual vs expected
- Actual: returns Animal Farm (0) and Ulysses (1). Exemplary Novels (2) is missing.
- Expected: returns Exemplary Novels, Animal Farm and Ulysses, in catalogue order.
  A book is included when its stock is less than or equal to the threshold.
  The code is wrong, not the Javadoc.

## No regression
- `findLowStock(-1)` still returns an empty list (`BookServiceTest`).
- `findLowStock(1000)` still returns all 7 books (`BookServiceTest`).
- Result order stays the catalogue order. The signature does not change.

## Out of scope
- `findByAuthor` and any other method.
- Sorting by stock, paging, or a new report format.

## Done when
`./run.sh test` passes and `./run.sh acceptance LowStockAcceptanceTest` passes.

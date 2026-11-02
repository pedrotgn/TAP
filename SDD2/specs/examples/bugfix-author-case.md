# Bug: the author filter distinguishes upper and lower case

## Context
Customers type author names in any case ("cervantes"). The catalogue stores
"Cervantes", and the search finds nothing.

## Reproduction
Run `./run.sh reproduce-author`, or:

1. `new BookService(SampleData.catalogue()).findByAuthor("Cervantes")`
2. `new BookService(SampleData.catalogue()).findByAuthor("cervantes")`

## Actual vs expected
- Actual: the first call returns 2 books; the second returns an empty list.
- Expected: both calls return the same 2 books, in the same order.

## No regression
- An exact name still works (`BookServiceTest.findByAuthor_exactName_...`).
- An unknown author still returns an empty list, never `null`
  (`BookServiceTest.findByAuthor_unknownAuthor_...`).
- The signature of `findByAuthor` does not change.

## Out of scope
- Accents ("garcia" for "García").
- Partial names ("Cerv" must still return nothing).
- Any other search method.

## Done when
`./run.sh test` still passes and `./run.sh acceptance AuthorCaseAcceptanceTest` passes.

# Performance: `OrderService.quote` reads the whole catalogue for every line

## Context
Quoting a big order is slow. `quote` calls `repository.findAll()` for each line of
the order and searches the copy it gets, so the cost is (lines x catalogue size).

## Starting metric
`./run.sh perf` (catalogue of 1000 books, order of 20 lines):
**Books scanned by the repository: 20000**.

## Target metric
At most **one book looked at per line**: for the same command, 20 or fewer.
(The acceptance test uses a catalogue of 500 books and 10 lines, and asks for 10 or fewer.)

## How it is measured
`InMemoryBookRepository.getScannedCount()`, after `resetScannedCount()`, for one
call to `quote`. It is the same on every machine, so it does not need repeated runs.

## Behaviour must not change
- The returned `Receipt` (subtotal, discount, total).
- The same exception for the same input: `InvalidOrderException` for an empty order
  or a quantity that is not positive, `BookNotFoundException` for an unknown id.
- Still no stock check and no stock change.
- Proved by `OrderServiceCharacterizationTest` (`quote_*`), without editing it.

## Out of scope
- `checkout` and any other method.
- The 10% discount rule and the order of the checks.
- Changes to the repository interface.

## Done when
`./run.sh test` passes, `./run.sh perf` shows 20 or fewer, and
`./run.sh acceptance QuotePerformanceAcceptanceTest` passes.

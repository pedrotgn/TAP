# Demo: same task, two specs

Task: implement `BookService.findByPriceRange` (exercise E3).
Do the exercise first. Open these files after you have written your own spec.

- `spec-inflated.md`: long, tells a story, dictates how to program, asks for
  extras (refactoring other methods, logging, comments, README).
- `spec-scoped.md`: short, with concrete acceptance criteria, edge cases and an
  explicit "out of scope".

Both ask for the same feature, and both are checked with the same acceptance test:
`./run.sh acceptance PriceRangeAcceptanceTest`.

## How to run the comparison

1. Start from a clean copy of the project for each run (same code, same agent, same model).
2. Give the agent only one of the specs plus `steering.md`.
3. Write down what the tool reports: input tokens, output tokens, number of
   iterations (times the agent had to try again).
4. Run `./run.sh test` and `./run.sh acceptance PriceRangeAcceptanceTest`.
   Did the acceptance test pass? Did the unit tests still pass? Did the agent touch
   files it should not have (`git diff --stat` or compare the folders)?
5. Repeat each spec at least 3 times. One run proves nothing: the agent does not
   behave in exactly the same way twice.

| Measure | Inflated spec | Scoped spec |
|---|---|---|
| Input tokens | | |
| Output tokens | | |
| Iterations | | |
| Acceptance test passes? | | |
| Unit tests still pass? | | |
| Files changed | | |

A short spec that fails the tests is not an efficient spec.

# Answers: E1 and E6

Look at these after you have tried the exercises. There is more than one good answer.

## E1: testable versions

| # | Testable version |
|---|---|
| 1 | `quote` of 10 lines in a catalogue of 500 books looks at no more than 10 books (`getScannedCount()`). |
| 2 | `checkout` of an empty order throws `InvalidOrderException`; of an unknown id, `BookNotFoundException`; and the stock is unchanged after any of them. |
| 3 | Needs a question first: "good" is not a number. Ask: from how many units, and how many percent? Today it is 5 units and 10%, rounded down. Then: 5 units of a 333-cent book give a discount of 166 cents. |
| 4 | Needs a question: should `quote` fail, or should `checkout`? Today `quote` ignores the stock and `checkout` throws `OutOfStockException` and changes nothing. |
| 5 | Needs a question: useful to whom? "Lists the books with stock <= N, in catalogue order" is testable (see `LowStockAcceptanceTest`). |
| 6 | Not testable as it is. Turn it into rules that can be checked: for example "all rules of `steering.md`" and, if you did SDD 1, the convention checker reports no violations. |

## E6: review

### Spec A (inflated)
- **Over-specification**: asks for a static class, an interface, three helpers,
  comments on every line and a log (it says *how*, not *what*).
- **Scoping**: "refactor all of `BookService`" is a different task. The "story" in the
  context does not help the agent.
- **Omission**: no acceptance criteria, no edge cases, no out of scope.
- **Conflict with the steering**: logging with prints is only allowed in `Main`, `tools/` and tests.
- Probably the one that costs more tokens: more to read, more to write, more files changed.

### Spec B (incomplete)
- **Omission**: which method? What is returned? What if the author is unknown? Case?
  Partial names? No acceptance criteria, no out of scope.
- **Ambiguity**: "search" can be a new class, a route, a screen...
- The agent has to guess, so it explores, asks, or invents. It costs more *iterations*
  than tokens per iteration.

### Spec C (AI-written, plausible)
- **Ambiguity**: "affordable", "right books", "fast", "works well", "robust and efficient".
  None of them can be checked.
- **Omission**: no ordering, no inclusive/exclusive limits, no invalid range, no
  negative values, no mention of the stock. There are no concrete examples.
- **Over-specification**: a strategy interface and a factory for one method;
  streams and a particular comparator.
- **Conflict with the steering**: `double` in euros (money is `long` cents),
  returning `null` (never), `System.out.println` (only in `Main`, tools and tests).
- **Filler**: the "Context" has marketing sentences ("drive sales growth") and no information.
- Following it literally breaks `noBookInRange_returnsEmptyListNotNull` and the
  ordering and range tests, and it produces code that is against the steering.
- Lesson: a long and well-written spec is not a complete spec.

### A spec is not enough
In all three cases a short, concrete rewrite is better. Compare with
`solutions/specs/E3-feature-price-range.md` (same text as `specs/demo/spec-scoped.md`).

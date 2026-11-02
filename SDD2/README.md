# SDD 2: SPECS

------------------------------------------

Code and exercises for the lab "SDD 2 - Specs".
The exercises are for free practice: there is no fixed order and nothing to hand in.

## Content

1. A small bookstore with a bug, a missing feature, a slow method and a messy
   method: one task of each of the four types of spec (bookstore)
2. Tests that pass today: the "no regression" and "invariant" of a spec (test)
3. Tests that fail until the task is done: the acceptance criteria (acceptance)
4. Spec templates, a worked example and the exercises (specs)
5. Reference solutions: code and specs (solutions)

## How to run

You only need a JDK (8 or newer). From this folder:

    ./run.sh test                  unit and characterization tests: they pass today
    ./run.sh acceptance [Class]    acceptance tests: they FAIL until you do the task
    ./run.sh demo                  run bookstore.Main
    ./run.sh reproduce-author      reproduce the bug shown in class
    ./run.sh reproduce-lowstock    reproduce the bug of exercise E2
    ./run.sh perf                  measure OrderService.quote (exercise E4)
    ./run.sh solutions             check the reference solutions (for the teacher)

You can also open the folder in IntelliJ: `src` is the source folder, `test` and
`acceptance` are test folders, and `lib` has JUnit 4.

## The four tasks

| Type | Task | Starting point | Done when |
|---|---|---|---|
| Bug fix | Author search is case sensitive (class example) | `./run.sh reproduce-author` | `AuthorCaseAcceptanceTest` |
| Bug fix | Low-stock report misses books exactly at the threshold (E2) | `./run.sh reproduce-lowstock` | `LowStockAcceptanceTest` |
| New feature | Search by price range (E3) | stub in `BookService` | `PriceRangeAcceptanceTest` |
| Performance | `OrderService.quote` is slow (E4) | `./run.sh perf` | `QuotePerformanceAcceptanceTest` |
| Refactoring | `OrderService.checkout` does too much (E5) | `OrderServiceCharacterizationTest` | `./run.sh test` unchanged |

The bookstore is a made-up example. It is not the project of the course.

## Layout

    steering.md       the steering file of the project (specs must not contradict it)
    src/bookstore/    the code: model, repository, service, exception
    src/tools/        small programs to reproduce bugs and measure
    test/             tests that pass today
    acceptance/       tests that define "done" for each task (fail today)
    specs/templates/  one template per type of task
    specs/examples/   a worked spec (the bug of the class)
    specs/exercises/  the exercises E1 to E6
    specs/demo/       two specs for the same task, for the token comparison
    solutions/        reference solutions (code overlays and specs)

## The idea

A spec is good if someone can tell, **without discussion**, when it has been
met. In this project that means a test:

- `test/` says what must not change. It passes before and after.
- `acceptance/` says what must be true when the task is done. It fails before and passes after.

The agent never sees the acceptance test as an instruction. It sees your spec,
and the acceptance test tells you whether your spec was enough.

------------------------------------------

## Proposed exercises

### Exercise E1: Make the criteria testable
Rewrite six vague criteria so that they can be checked (`specs/exercises/E1-make-them-testable.md`).
Which ones cannot be made testable without asking a question first?

### Exercise E2: Bug fix, the reorder report
A shop owner says that a book is missing from the weekly report
(`specs/exercises/E2-bugfix-low-stock.md`).
Reproduce it, write the spec with the template, give it to an agent and check
with `./run.sh acceptance LowStockAcceptanceTest`.

### Exercise E3: New feature, search by price range
The request is written in business words (`specs/exercises/E3-feature-price-range.md`).
Turn it into a spec with concrete acceptance criteria and edge cases, then
check it with `PriceRangeAcceptanceTest`.
After that, compare with the two specs in `specs/demo/` and, if you can, measure
the tokens of each one.

### Exercise E4: Performance, quoting big orders
Measure first with `./run.sh perf` (`specs/exercises/E4-performance-quote.md`).
Write a spec with a starting metric, a target metric and how it is measured.
Check with `QuotePerformanceAcceptanceTest`.

### Exercise E5: Refactoring, `checkout`
`OrderService.checkout` does validation, pricing and persistence in one method
(`specs/exercises/E5-refactor-checkout.md`). Write the spec. The invariant is
`OrderServiceCharacterizationTest`: it must pass without being edited.

### Exercise E6: Review three specs
Find omissions, ambiguities, over-specification and conflicts with the steering
(`specs/exercises/E6-review-specs.md`). Rewrite them. One of the three was
written by an AI and looks very professional.

### Exercise E7 (extra): Write the acceptance test yourself
Choose a task without an acceptance test (for example the refactoring or the
author bug) and write the JUnit tests that you think define "done". Then see if
a classmate can write a spec that makes an agent pass them.

### Exercise E8 (extra): Spec for a new type of task
Add a method `BookService.findByTitleContaining(String text)`. Write the spec
first, including all edge cases (blank text, case, no match, order). Write the
acceptance tests from your spec. Then implement it, by hand or with an agent.
What did the tests find that the spec did not say?

------------------------------------------

## Solutions

- Code: `solutions/<task>/src/...` has the files that replace those of `src/`
  for each task. `./run.sh solutions` copies them over `src/` in a temporary
  folder and runs the tests. To see one in your own copy, copy the files over `src/`.
- Specs: `solutions/specs/`.
- E1 and E6 answers: `solutions/specs/E1-and-E6-answers.md`.

# E2: Bug fix - the reorder report misses books

## What you receive (the bug report, as the shop owner wrote it)

> Every Monday I print the "low stock" report to decide what to reorder. I asked
> for books with 2 copies or fewer, but "Exemplary Novels" (2 copies) is not in
> the list. I think it is missing in every report.

## Your task

1. Reproduce the bug: `./run.sh reproduce-lowstock`.
2. Write a spec with the template `specs/templates/bugfix.md`. It must have
   reproduction steps, actual vs expected as observable facts, a "no regression"
   section and an "out of scope" section.
3. Check your spec with the four quality criteria: clarity, completeness,
   scoping, and consistency with `steering.md`.
4. Give the spec (and only the spec) to an agent, or fix it yourself following
   only the spec.
5. Check: `./run.sh test` must still pass and `./run.sh acceptance LowStockAcceptanceTest` must pass.

## Think about

- Which tests that exist today protect "no regression"? (Look at `BookServiceTest`.)
- The method documentation says "at or below the threshold". Is the comment or the
  code wrong? How does your spec say which one is right?
- What did you leave out of scope? Is there anything similar in `findByAuthor`?

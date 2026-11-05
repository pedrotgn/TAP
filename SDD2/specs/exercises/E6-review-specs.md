# E6: Review specs (and fix them)

Three specs to review: `E6-review-spec-A.md`, `E6-review-spec-B.md`, `E6-review-spec-C.md`.
A and B are the ones shown in class. C looks professional, and it was written by an AI.

## For each spec

1. Mark every problem you find and put it in a family:
   - **Omission**: something the agent needs and the spec does not say
     (edge cases, errors, acceptance criteria, out of scope).
   - **Ambiguity**: a word that cannot be checked ("fast", "right", "affordable").
   - **Over-specification**: it says *how* to code instead of *what* to achieve,
     or it asks for more than the task needs.
   - **Conflict with the steering**: it contradicts `steering.md`.
2. Say which of the four quality criteria fails: clarity, completeness, scoping,
   consistency with the steering.
3. Rewrite the spec. Maximum 25 lines. Use the template of its type.
4. Which of the three would cost most tokens if you gave it to an agent as it is?
   Which would cost most *iterations*? Are they the same one?

## Think about

- C is the longest of the three that sounds good. Is a longer spec a more complete one?
- Which problem is the hardest to see when you read quickly? Why?
- If an agent follows spec C literally, which tests of `acceptance/` fail?
  (You can try: put the signature of `findByPriceRange` aside and think about the
  `null` and the `double`.)

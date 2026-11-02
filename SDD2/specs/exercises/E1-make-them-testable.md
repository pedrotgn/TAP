# E1: Make the criteria testable

Rewrite each criterion so that anyone can say, without discussion, whether it is met.
Use a concrete input and a concrete output (or a number, or a visible state).
Then write the check as a JUnit test, or as manual steps with an expected result.

Use the sample catalogue (`bookstore.SampleData`) for your numbers.

| # | Vague criterion | Your testable version |
|---|---|---|
| 1 | The search must be fast. | |
| 2 | It must handle errors well. | |
| 3 | Orders with many books should get a good discount. | |
| 4 | Out-of-stock books must be treated correctly. | |
| 5 | The reorder report should be useful. | |
| 6 | The code must be clean. | |

Questions:
- Which ones can become an automatic test? Which ones need manual steps?
- Which ones cannot be made testable without asking someone a question first?
  (Hint: 3 and 5. What do you need to know?)
- For number 1, which metric would you use instead of "milliseconds"?
  Look at `InMemoryBookRepository.getScannedCount()`.

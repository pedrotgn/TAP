# E4: Performance - quoting big orders is slow

## What you receive

> When a customer pastes an order with many lines, the price quote takes
> noticeably longer than it should. The developers say it "does something silly
> for each line".

## Measure first

Run `./run.sh perf`. It builds a catalogue of 1000 books and an order of 20 lines
and prints how many books the repository had to look at while quoting.

Write the number down. That is your **starting metric**. (Why is this better
than measuring milliseconds? Because it is the same on every machine and every run.)

## Your task

1. Read `OrderService.quote` and find where the cost comes from.
2. Write a spec with the template `specs/templates/performance.md`:
   - starting metric (the number you measured) and the command that produced it,
   - target metric (as a number),
   - how it is measured,
   - what must not change (results, errors, order of checks),
   - what is out of scope. Careful: `checkout` has a similar shape. Do you want to touch it?
3. Give the spec to an agent, or implement it following only the spec.
4. Check: `./run.sh test` still passes, `./run.sh perf` shows the new number, and
   `./run.sh acceptance QuotePerformanceAcceptanceTest` passes.

## Think about

- Is "make it faster" a spec? What is missing?
- The target in the acceptance test is "at most one book looked at per line".
  Could a spec with a different target (say, "at most 2 per line") also be valid?
- If the agent also "improves" `checkout`, is that a problem? Where would your
  spec say it?

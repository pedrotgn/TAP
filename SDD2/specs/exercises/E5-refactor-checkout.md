# E5: Refactoring - `OrderService.checkout` does too much

## What you receive

> `checkout` validates the order, calculates the price and changes the stock, all in
> one method of about 35 lines. Nobody wants to touch it. Make it easier to read.

## Your task

1. Read `OrderService.checkout` and `OrderServiceCharacterizationTest`.
   The test describes what the method does today.
2. Write a spec with the template `specs/templates/refactor.md`:
   - **improvement**: what will be better and how will we see it (for example,
     how many methods, how long, what each one does),
   - **invariant**: what cannot change (results, exceptions, the "nothing is
     changed if one line is wrong" rule, public signatures),
   - **verification**: how do we know nothing changed?
   - **out of scope**: the method `quote` has the same discount rule written again,
     and an order with two lines for the same book is not defined today.
     What do you do with them?
3. Give the spec to an agent, or refactor it yourself following only the spec.
4. Check: `./run.sh test` passes **without editing any test**.

## Think about

- Why is the characterization test the most important part of this spec?
- If there were no test, what should the spec ask for first?
- The behaviour for duplicated lines is not pinned by any test. If the agent
  changes it, would you notice? Where would your spec prevent it?

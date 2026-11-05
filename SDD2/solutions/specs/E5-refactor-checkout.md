# Refactoring: split `OrderService.checkout` into steps

## Context
`checkout` is one method of about 35 lines that validates the order, calculates
the price and changes the stock. It is hard to read and hard to change.

## Improvement
`checkout` becomes a method of at most 5 lines that calls three private methods,
each with one job and a one-line Javadoc:
- `validate(lines)`: checks the order and the stock.
- `price(lines)`: returns the `Receipt`.
- `takeFromStock(lines)`: changes the stock.
We will see it by reading `checkout`: it has no loops and no `if`.

## Invariant
- Same results for the same inputs (subtotal, discount of 10% rounded down for 5
  or more units, total).
- Same exception types for the same invalid inputs.
- If any line is wrong, nothing is changed in the stock (validate everything first).
- Public signatures of `OrderService` do not change.

## Verification
`./run.sh test` passes **without editing any test**, especially
`OrderServiceCharacterizationTest`.

## Out of scope
- `quote`, even though it repeats the discount rule. That is a different task.
- An order with two lines for the same book: today's behaviour is not defined and
  must not be changed.
- Performance, naming of other classes, and any change to the tests.

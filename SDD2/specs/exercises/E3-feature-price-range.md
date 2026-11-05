# E3: New feature - search by price range

## What you receive (the request, in business words)

> Customers on a budget want to see what they can afford. Add a search by price
> range to the catalogue.
>
> Decisions already taken with the shop owner:
> - Prices are in cents. Both limits are included: a range of 600 to 900 shows
>   books that cost exactly 600 and exactly 900.
> - The cheapest book goes first. If two books cost the same, they are ordered
>   by title, A to Z.
> - If nothing matches, the answer is an empty list.
> - A range where the minimum is bigger than the maximum, or a negative minimum,
>   makes no sense. It must be rejected as an invalid query.
> - Searching never changes the stock.
> - No paging and no other filters for now.

## What already exists

`BookService.findByPriceRange(long minCents, long maxCents)` is declared but it
only throws `UnsupportedOperationException`. The exception to use is
`InvalidQueryException`.

## Your task

1. Write a spec with the template `specs/templates/feature.md`.
   Turn each decision of the request into an acceptance criterion with a
   concrete input and output (use the prices of `bookstore.SampleData`).
2. Review it with the four criteria. Is there an edge case the request does not
   mention? (Hint: what about `min = 0`? What about `min = max`?)
3. Give the spec to an agent (or implement it following only the spec).
4. Check: `./run.sh test` must pass, and `./run.sh acceptance PriceRangeAcceptanceTest` must pass.

## Then compare

Open `specs/demo/` only now. It has two other specs for this same task: one
inflated and one scoped. Compare them with yours. Which is closer to yours?
If you can, run each one with an agent and count tokens (see the table in the slides).

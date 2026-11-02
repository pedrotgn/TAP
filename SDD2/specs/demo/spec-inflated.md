# Price range search

## Background
Our bookstore has been in business for many years and our customers love
reading. Lately the owner noticed that many customers, especially students and
people on a budget, leave the website without buying anything. After a long
conversation with the owner, we concluded that the best way to improve their
experience is to give them tools to find books they can afford. This is
important for the growth of the business and for customer satisfaction. We have
also been thinking about recommendations, wish lists and other things, but those
will come later.

## What to do
Implement the method `findByPriceRange(long minCents, long maxCents)` of
`BookService`. For this, please:

1. Create a new class `PriceRangeFilter` with a static method `apply`, and an
   interface `IPriceRangeFilter`. Create also a `PriceRangeFilterFactory`.
2. Go through every book in the repository, one by one, using a classic `for` loop.
3. For each book, check if its price is greater than or equal to the minimum and
   lower than or equal to the maximum.
4. Add a comment on every line explaining what it does.
5. Log with `System.out.println` the books that are found and the ones that are not.
6. Sort the result using your favourite algorithm.
7. Take the opportunity to refactor `findByAuthor` and `findLowStock` so they use
   the same style, and to make the whole `BookService` class more efficient.
8. Add a README paragraph and update the Javadoc of the whole project.

## Notes
Make sure the code is clean, robust, efficient and follows best practices.
The search should work properly in all cases.

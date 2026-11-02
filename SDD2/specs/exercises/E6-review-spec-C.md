# Feature: affordable books search

*(This spec was written by an AI assistant from the request of E3. It looks
professional. Review it before anyone implements it.)*

## Context
Our customers love books, but many of them are on a tight budget. Providing a
great price-based search experience will significantly improve customer
satisfaction and drive sales growth.

## Goal
Implement a robust and efficient way to find affordable books within a price
range, with excellent performance.

## Design
1. Create a new class `PriceRangeStrategy` implementing a `SearchStrategy<T>`
   interface, and register it in a `StrategyFactory`.
2. Use Java streams and `Comparator.comparingDouble(Book::getPrice)`.
3. Keep prices as `double` values in euros (for example, 6.50).
4. Log each step with `System.out.println` for debugging.

## Acceptance criteria
- The search returns the right books.
- The search is fast and works well for large catalogues.
- If no book is found, the method returns `null`.

## Out of scope
- User interface.

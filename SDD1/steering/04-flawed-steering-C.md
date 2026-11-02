# Steering: Bookstore

## Today's work
This week we are adding a discount for orders of five or more books. The
discount is 10% of the subtotal. Ask Marta if it also applies to e-books.
Also fix the bug where searching by author ignores capital letters, and remember
to rename `listByAuthor` before Friday.

## What is this project?
The bookstore project started in 2019 as a final-year project by a group of
students who wanted to sell used books online. At first it was written in PHP,
then moved to Java when the team grew to six people. Over the years several
people have contributed, each with their own style, so you will find different
conventions in different places. The idea is to unify them one day.

## How the code is organised
There are packages for model, repository, service and exception. The model has
`Book`. The repository has `BookRepository` and `InMemoryBookRepository`. The
service has `BookService`. The exception package has `BookStoreException`,
`BookNotFoundException` and `InvalidBookException`. (All of this can already be
read in the source tree.)

## Style
Follow the style of the existing code.

## Hints
- If you are not sure about something, think carefully before answering.
- Be careful with edge cases.

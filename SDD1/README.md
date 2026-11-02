# SDD 1: STEERING FILES

------------------------------------------

Code and exercises for the lab "SDD 1 - Steering Files".
The exercises are for free practice: there is no fixed order and nothing to hand in.

## Content

1. A small codebase with clear conventions (bookstore)
2. A codebase that does NOT follow them (legacy)
3. A steering file written for that codebase, and three flawed ones (steering)
4. Steering files split by file type (steering/by-file-type)
5. Conventions as code: a checker based on reflection (checker, TAP 4 revisited)

## How to run

You only need a JDK (8 or newer). From this folder:

    ./run.sh test      compile and run the unit tests
    ./run.sh demo      run bookstore.Main
    ./run.sh check     run the checker on bookstore (clean) and on legacy (violations)
    ./run.sh extra     run the checker with the extra rules of exercise 3

You can also open the folder in IntelliJ: `src` is the source folder, `test` the
test folder and `lib` has JUnit 4.

## Layout

    src/bookstore/    the "good" code: model, repository, service, exception
    src/legacy/       inherited code with bad habits (do not imitate)
    src/checker/      checks conventions on compiled classes using reflection
    src/solutions/    solution of exercise 3
    test/             JUnit tests
    steering/         example steering file, flawed ones, and by file type
    answers/          answers to exercises 2 and 4 (look after trying)

The bookstore is a made-up example. It is not the project of the course.

------------------------------------------

## Proposed exercises

### Exercise 1: Write the steering file from the code

Read the `bookstore` package (about 8 classes) and the tests. Without looking at
`steering/01-example-steering.md`, write a steering file for this project that
fits in one page. It must include:

1. What the project is and how to build and test it.
2. How the code is organised.
3. At least five conventions that you can *see* in the code (errors, absence of
   values, money, dependencies, fields, models).
4. Test conventions.
5. At least one "do not".

Then compare with `steering/01-example-steering.md`. Which conventions did you
miss? Which of yours were too vague to check?

Check your file against the four criteria of the class: coverage, specificity,
consistency with the code and real usefulness.

### Exercise 2: Convention or defect?

Look at the `legacy` package. It compiles and "works", but some things in it must
never end up in a steering file as if they were conventions.

1. List every habit in `legacy` that goes against what `bookstore` does.
2. Run `./run.sh check`. Which ones does the checker find? Which ones can it
   not find, and why?
3. Imagine you ask an agent to "follow the style of the existing code" in a
   project where both packages exist. What could go wrong? How does the
   steering file prevent it?

### Exercise 3: Write a convention as a rule

The checker works with `Rule` objects (`src/checker/DefaultRules.java`).
Each rule looks at one class using reflection.

1. Read `DefaultRules.ThrowableConventions` and explain how it works.
2. Add a new rule: every class in a `service` package must have a name that
   ends with `Service`.
3. Add another rule: every class in a `model` package must override `toString()`.
4. Write a unit test for each rule: one class that passes and one that fails.
5. Add to your steering file from Exercise 1 the sentence that explains each rule.
   A convention that is checked by a rule and written in the steering file is
   very hard to forget.

### Exercise 4: Fix the flawed steering files

The folder `steering` has three flawed files (`02`, `03`, `04`).

1. For each one, say which quality criterion fails the most.
2. Rewrite each file so that it is useful for this project. Maximum 20 lines.
3. Which parts of the files should not be in a steering file at all?

### Exercise 5: Steering by file type

The example steering is "always loaded". Some rules only matter in some files.

1. Read `steering/by-file-type/*.md`. When should each one be applied?
2. Move three rules from your steering file of Exercise 1 into a file for
   `service` classes. Write the line that says when it applies.
3. Why is a short file per file type better than one long file for everything?
   Think about tokens and about contradictions.

Note: how to say "apply this file only when..." depends on the tool you use
(its trigger or inclusion option). The files here put it in a comment on the
second line so you can adapt it.

### Exercise 6: Try it with an agent

1. Give an agent only your steering file from Exercise 1 and ask it:
   "Add a method `findByTitle` to `BookService`".
2. Run `./run.sh check` and `./run.sh extra`. Did the new code follow the
   conventions?
3. Repeat with `steering/02-flawed-steering-A.md` and with
   `steering/03-flawed-steering-B.md`. Compare the three results.
4. Which convention was broken most often? Was it in the file? Was it
   specific enough?

### Exercise 7 (extra): A rule that needs bytecode

"Only `Main` prints to `System.out`" is in the steering file but there is no rule
for it, because reflection cannot see method bodies.

1. Look for a way to check it (hint: search for the text `System.out` in the
   source files, or look at the constant pool of the class file).
2. Is it worth the effort compared with writing the sentence in the steering file?

------------------------------------------

## Solutions

- Exercise 3: `src/solutions/rules/ExtraRules.java` and `src/solutions/CheckAll.java`
  (`./run.sh extra`).
- Exercises 2 and 4: `answers/flaws-and-fixes.md`.
- Exercises 1 and 5: `steering/01-example-steering.md` and `steering/by-file-type/`.

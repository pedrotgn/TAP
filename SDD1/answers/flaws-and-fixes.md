# Answers: flaws and fixes

Look at these only after you have tried the exercises.

Quality criteria used in class: coverage, specificity, consistency with the
code, and real usefulness for the agent.

## Exercise 2: what must not become a convention (`legacy/`)

| Legacy code | Why it is a defect, not a convention |
|---|---|
| `findBook` returns `null` | The caller can forget to check. The project uses `Optional` / empty lists. |
| `double` for prices | Rounding errors with money. The project uses `long` cents. |
| `public double price` | Public mutable state. |
| `catch (Exception e) { return 0; }` | Hides errors and returns a wrong price. |
| `System.out.println` inside the calculation | Only `Main` and tests may print. |
| `BadThing extends RuntimeException` | Does not extend `BookStoreException`; the name does not say what failed. |
| `public static Object cache` | Global mutable state. |

The checker finds 7 of these through reflection. It cannot find the empty
`catch` or the `System.out.println`, because those are inside method bodies.
Those rules are only in the steering text (and in code review).

## Exercise 4: flawed steering files

### `02-flawed-steering-A.md`: generic
- **Specificity**: "clean code", "best practices", "good names", "handle errors
  properly" are true of any project. An agent already does this by default, so
  the file adds nothing.
- **Coverage**: nothing about structure, commands, errors, money or tests *of this
  project*.
- **Fix**: replace each line with a checkable, project-specific rule. For example
  "Handle errors properly" becomes "Every domain error extends
  `BookStoreException`; never return `null` to signal a problem".

### `03-flawed-steering-B.md`: contradicts the code
- **Consistency**: it describes another project (Spring, PostgreSQL, Lombok,
  Maven, `com.acme...`). None of that exists here.
- It also *asks for* the defects of `legacy/`: `double` prices, `null`, swallowed
  exceptions, public fields, global state, optional tests.
- This is the worst case: the agent will follow the file, not the code.
- **Fix**: write the conventions from what the code really does (compare with
  `01-example-steering.md`).

### `04-flawed-steering-C.md`: mixes things that do not belong
- **Today's work** (discount, bug, rename) is a task. It belongs in a spec, not
  in a file that is loaded for every task. It will also become false next week.
- **History** of the project: does not change how the agent writes code.
- **Description of the packages**: the agent can read the source tree; it costs
  tokens on every task and it gets out of date.
- **"Follow the style of the existing code"**: not checkable, and the existing
  code has several styles (the file says so itself).
- **"Think carefully", "be careful with edge cases"**: no information.
- **Fix**: keep only what the agent cannot infer and that is stable: commands,
  conventions, what not to do.

## Exercise 5: by file type
See `steering/by-file-type/`. Each file is short and says when it is applied.
A rule about test names should not be loaded when the task edits an exception.

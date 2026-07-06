# TAP 4 - Refactoring

## Purpose of the Presentation
This presentation explains refactoring as disciplined design improvement without changing observable behaviour. It introduces code smells, common refactorings, and a worked example where dirty code is gradually cleaned.

## Key Concepts
- Definition of refactoring.
- Behaviour-preserving transformation.
- Code smells: Long Method, Large Class, Duplicated Code, Long Parameter List, Feature Envy, Switch Statements, Data Clumps, Shotgun Surgery, God Class.
- Refactorings: Extract Method, Move Method, Extract Class, Rename, Introduce Parameter Object, Replace Conditional with Polymorphism.
- Importance of tests as a safety net.
- Refactoring versus rewriting.
- Technical debt and maintainability.

## Concepts to Explain in Class
Students should understand that refactoring is not merely making code prettier. It is a risk-controlled engineering activity that makes future change cheaper. Refactoring should be motivated by a smell, protected by tests, and performed in small steps.

The presentation should distinguish between changing behaviour and changing structure. If behaviour changes, it is not pure refactoring.

## Suggested Example
Before:
```java
void printReport(Student s) {
    double avg = 0;
    for (Grade g : s.grades()) avg += g.value();
    avg = avg / s.grades().size();
    if (avg < 5) System.out.println("Fail");
    else System.out.println("Pass");
}
```

After applying Extract Method:
```java
double averageGrade(Student student) { ... }
boolean hasPassed(Student student) { ... }
void printResult(Student student) { ... }
```

## Practical Activity
Give students a dirty method with validation, calculation, persistence, and notification mixed together. Ask them to:
- identify smells,
- write characterization tests,
- apply Extract Method,
- move responsibility to a better class,
- replace conditionals with polymorphism if appropriate.

## References
- Martin Fowler refactoring catalog: https://refactoring.com/catalog/
- Martin Fowler, Refactoring book: https://martinfowler.com/books/refactoring.html
- Refactoring.Guru code smells: https://refactoring.guru/refactoring/smells
- JUnit User Guide: https://docs.junit.org/6.1.0/overview.html

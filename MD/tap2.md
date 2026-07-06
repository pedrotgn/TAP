# TAP 2 - Java Review for Advanced Programming

## Purpose of the Presentation
This presentation reviews Java concepts that students should already know but often understand only partially. The goal is to consolidate Java as a language for abstraction, type safety, reuse, and modern programming style.

## Key Concepts
- Classes, objects, encapsulation, inheritance, and polymorphism.
- Abstract classes versus interfaces.
- Multiple inheritance limitations in Java and how interfaces solve part of the problem.
- Generics and parametric polymorphism.
- Iterators and the `Iterable<T>` interface.
- Autoboxing and unboxing.
- Enums as type-safe sets of constants with behaviour.
- Static imports and varargs.
- Functional capabilities in Java: lambdas, streams, method references, records, sealed classes, and pattern matching.

## Concepts to Explain in Class
The presentation should clarify that Java is not only a classical object-oriented language. Modern Java supports functional-style programming, immutable data with records, richer type modelling with sealed classes, and concise data-processing pipelines with streams.

Students should especially understand the difference between reuse by inheritance and reuse by composition or interfaces. Interfaces define contracts; abstract classes can share partial implementation; generics allow reusable type-safe abstractions.

## Suggested Examples
```java
public interface Stack<T> {
    void push(T value);
    T pop();
    boolean isEmpty();
}
```

```java
List<String> names = users.stream()
    .filter(User::active)
    .map(User::name)
    .toList();
```

```java
enum Status {
    PENDING, APPROVED, REJECTED
}
```

## Practical Activity
Give students a small class hierarchy and ask them to redesign it using interfaces, generics, and composition. Then ask them to rewrite one imperative loop using streams.

## References
- Java language changes: https://docs.oracle.com/en/java/javase/21/language/java-language-changes.html
- Dev.java tutorials: https://dev.java/learn/
- Java generics tutorial: https://docs.oracle.com/javase/tutorial/java/generics/
- Java streams documentation: https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html

# TAP 3 - Design Patterns

## Purpose of the Presentation
This presentation introduces design patterns as reusable solutions to recurring design problems. The goal is not to memorize pattern names, but to understand design forces: object creation, variation, decoupling, composition, adaptation, and collaboration.

## Key Concepts
- What a design pattern is and why patterns emerged.
- GoF pattern categories: creational, structural, and behavioural.
- Creational patterns: Factory Method, Abstract Factory, Singleton, Builder.
- Structural patterns: Adapter, Composite, Decorator, Facade, Proxy.
- Behavioural patterns: Strategy, Observer, Command, Template Method, Iterator.
- Composition over inheritance.
- Dependency injection as a modern framework-supported design technique.
- Anti-patterns and overengineering risks.

## Concepts to Explain in Class
Patterns should be presented as vocabulary for discussing design, not as recipes to apply everywhere. Students should learn to identify the problem first: unstable object creation, multiple algorithms, incompatible interfaces, tree-like structures, or notification between objects.

A modern explanation should also connect patterns with frameworks. Dependency injection, controllers, repositories, plugins, and middleware often hide classical patterns behind annotations and containers.

## Suggested Examples
Factory with JDBC:
```java
Connection connection = DriverManager.getConnection(url, user, password);
PreparedStatement st = connection.prepareStatement(
    "SELECT * FROM students WHERE id = ?"
);
```

Composite with files and directories:
```java
interface FileSystemNode {
    long size();
}

final class File implements FileSystemNode { ... }
final class Directory implements FileSystemNode {
    private final List<FileSystemNode> children;
}
```

Object Adapter versus Class Adapter:
- Object adapter uses composition.
- Class adapter uses inheritance, where the language allows it.

## Practical Activity
Ask students to identify patterns in a small application: where object creation occurs, where algorithms vary, where a tree structure appears, and where interfaces are incompatible.

## References
- Refactoring.Guru design patterns catalog: https://refactoring.guru/design-patterns/catalog
- SourceMaking design patterns: https://sourcemaking.com/design_patterns
- Spring IoC and dependency injection: https://docs.spring.io/spring-framework/reference/core/beans/introduction.html
- JDBC DriverManager API: https://docs.oracle.com/en/java/javase/21/docs/api/java.sql/java/sql/DriverManager.html

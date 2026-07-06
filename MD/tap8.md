# TAP 8 - Software Architecture, Agile and XP

## Purpose of the Presentation
This presentation explains software architecture as the set of important decisions that shape future change. It then connects architecture with agile development and Extreme Programming practices.

## Key Concepts
- Software architecture as structure plus rationale.
- Architecture versus design versus code.
- Architecture drivers: functional requirements, quality attributes, constraints, and change scenarios.
- C4 model: context, container, component, code.
- Layered architecture.
- Hexagonal architecture / ports and adapters.
- Monolith, modular monolith, and microservices.
- Quality attributes: performance, scalability, availability, security, maintainability.
- Architecture Decision Records.
- Agile values and feedback loops.
- User stories and acceptance criteria.
- Scrum and Kanban.
- Extreme Programming: communication, simplicity, feedback, courage, respect.
- XP practices: TDD, pair programming, CI, refactoring, simple design, collective ownership.

## Concepts to Explain in Class
Architecture should be presented as decision-making under constraints. There is no universally good architecture; there are trade-offs. A microservice is not better than a modular monolith unless the organization and domain require independent deployment and ownership.

Agile should not be presented as lack of planning. It is a way to manage uncertainty through short feedback loops. XP adds engineering discipline to agile development.

## Suggested Examples
ADR:
```md
# ADR 003: Use a modular monolith

## Context
The team is small and boundaries are still evolving.

## Decision
Use one deployable application with explicit modules.
```

Hexagonal architecture:
```java
public interface PaymentPort {
    PaymentResult charge(Order order);
}
```

## Practical Activity
Ask students to write an ADR for a small system and draw a C4 context/container diagram. Then implement a small feature using TDD and continuous integration.

## References
- C4 model: https://c4model.com/
- Architecture Decision Records: https://adr.github.io/
- Agile Manifesto: https://agilemanifesto.org/
- Extreme Programming Explained: https://www.amazon.com/Extreme-Programming-Explained-Embrace-Change/dp/0321278658
- Martin Fowler on microservices: https://martinfowler.com/articles/microservices.html

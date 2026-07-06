# TAP 9 - Frameworks, Components and Connection-Oriented Programming

## Purpose of the Presentation
This presentation explains how modern software is increasingly assembled from frameworks, components, plugins, connectors, and workflows. n8n is used as an example of connection-oriented programming.

## Key Concepts
- Library versus framework.
- Inversion of control: the framework calls your code.
- Dependency injection.
- Annotations as framework metadata.
- Framework hotspots and frozen spots.
- Component-based software engineering.
- Provided and required interfaces.
- Plugin architecture.
- Composition and pipelines.
- Connection-oriented programming.
- Workflow graphs, triggers, action nodes, transformations, branching, and error paths.
- n8n-style automation.
- Hybrid architecture: workflow orchestration plus code components.
- Spec-driven and AI-assisted workflow development.

## Concepts to Explain in Class
Students should understand the shift from writing all behaviour manually to assembling systems from reusable parts. Frameworks provide lifecycle and conventions; components provide encapsulated capabilities; workflows connect nodes into executable graphs.

n8n is useful pedagogically because it makes data flow visible. However, visual workflows still require software engineering: error handling, data contracts, retries, idempotency, testing, security, and observability.

## Suggested Examples
Spring-style dependency injection:
```java
@Service
public class ReportService {
    private final ReportRepository repository;

    public ReportService(ReportRepository repository) {
        this.repository = repository;
    }
}
```

n8n-style workflow:
```text
Schedule Trigger
  -> Read CSV
  -> Transform rows
  -> IF grade < 5
       -> Send email to tutor
     ELSE
       -> Store summary
```

## Practical Activity
Ask students to design a workflow for a university process such as grade notifications. They must identify triggers, actions, transformations, data contracts, error cases, and tests.

## References
- Spring IoC container: https://docs.spring.io/spring-framework/reference/core/beans/introduction.html
- Spring bean basics: https://docs.spring.io/spring-framework/reference/core/beans/basics.html
- n8n workflow nodes: https://docs.n8n.io/workflows/components/nodes/
- n8n node types: https://docs.n8n.io/integrations/builtin/node-types/
- Enterprise Integration Patterns: https://www.enterpriseintegrationpatterns.com/

# TAP 7 - Software Metrics

## Purpose of the Presentation
This presentation explains how metrics help reason about software quality. The main idea is that metrics are signals for discussion, not automatic judgments.

## Key Concepts
- Product metrics, process metrics, testing metrics, and operational metrics.
- Size metrics: lines of code, number of classes, methods, parameters.
- Cyclomatic complexity and independent execution paths.
- Coupling and cohesion.
- Duplication and technical debt.
- Maintainability index.
- Coverage: line coverage, branch coverage, mutation score.
- Static analysis tools: Checkstyle, PMD, SpotBugs, SonarQube.
- GitHub Actions for continuous metrics.
- Quality gates.
- Metrics for refactoring, spec-driven engineering, and AI-assisted development.

## Concepts to Explain in Class
Metrics make invisible properties visible: complexity, risk, change cost, test weakness, and maintainability problems. However, students must understand Goodhart's law: when a metric becomes the target, it can stop being useful.

The correct use of metrics is comparative and contextual. For example, measure before and after refactoring, identify hotspots, or evaluate whether new code satisfies a quality gate.

## Suggested Examples
Cyclomatic complexity:
```java
if (salary < 10000) {
    return 500;
} else {
    return 1000;
}
```
This branch requires at least two meaningful tests.

Quality gate:
```text
coverage >= 80%
duplicated lines < 3%
new critical issues = 0
max method complexity: inspect if > 10
```

## Practical Activity
Students run tests and coverage on a Java project, identify a complex method, refactor it, and compare metrics before and after.

## References
- JaCoCo documentation: https://www.jacoco.org/jacoco/trunk/doc/
- SonarQube quality gates: https://docs.sonarsource.com/sonarqube-server/quality-standards-administration/managing-quality-gates/introduction-to-quality-gates
- PMD: https://pmd.github.io/
- SpotBugs: https://spotbugs.github.io/
- GitHub Actions documentation: https://docs.github.com/actions

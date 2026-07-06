# TAP 1 - Introduction to Advanced Programming Techniques

## Purpose of the Presentation
This presentation introduces the course as a transition from basic programming to professional software evolution. The central message is that advanced programming is not only about knowing more syntax, but about designing code that can be tested, extended, refactored, reviewed, and increasingly modified with AI assistance.

## Key Concepts
- Advanced programming as controlled software evolution.
- Difference between writing code and designing maintainable systems.
- Abstraction, modularity, interfaces, testing, refactoring, frameworks, components, and architecture.
- The role of specifications, tests, and documentation as first-class software artifacts.
- AI-assisted development as a new reason to make intent explicit.
- Spec-driven engineering as a disciplined way to connect requirements, design, tasks, tests, and code.

## Concepts to Explain in Class
Students should understand that the course is not a catalogue of isolated techniques. Each technique solves a recurring software engineering problem: reducing coupling, increasing cohesion, isolating change, validating behaviour, or making code understandable to humans and tools.

The introduction should also explain why AI changes the programming workflow. If AI can generate code quickly, the scarce skill becomes specifying the right change, constraining the implementation, testing behaviour, and reviewing quality. This is why classic topics such as design patterns, refactoring, testing, frameworks, and architecture are even more relevant.

## Suggested Examples
- A simple application that evolves from a hardcoded implementation into a plugin-based design.
- A feature request written as a vague prompt versus a precise specification.
- A small Java interface used as a stable contract between implementations.

## Practical Activity
Ask students to take a vague requirement such as "add export support" and rewrite it as:
- a user goal,
- acceptance criteria,
- non-goals,
- tasks,
- tests that would validate the change.

## References
- TAP github:https://github.com/pedrotgn/TAP
- OpenSpec: https://github.com/Fission-AI/OpenSpec/
- GitHub Spec Kit: https://github.com/github/spec-kit
- GitHub blog on spec-driven development: https://github.blog/ai-and-ml/generative-ai/spec-driven-development-with-ai-get-started-with-a-new-open-source-toolkit/
- Dev.java learning resources: https://dev.java/learn/

# TAP 10 - AI-Driven Software Engineering

## Purpose of the Presentation
This presentation introduces AI-driven software engineering as a disciplined process where specifications, agents, context, tests, review, and human responsibility are central.

## Key Concepts
- Prompt-only development and its limitations.
- Spec-driven engineering.
- Proposal, design, tasks, specs, and acceptance criteria.
- OpenSpec and GitHub Spec Kit.
- Spec-to-code loop.
- Agentic programming.
- Difference between assistant, IDE copilot, and coding agent.
- Agent loop: plan, act, observe, repair.
- Human-in-the-loop development.
- Token and context optimization.
- Context engineering.
- Code retrieval and CodeRAG.
- Quality gates for AI-generated code.
- Testing AI-generated software.
- Review checklist.
- Security, privacy, traceability, and observability.

## Concepts to Explain in Class
AI changes the economics of producing code, but not the need for engineering. The hard part becomes specifying the intended behaviour, giving the agent the right context, checking its output, and maintaining quality.

Students should learn that an AI agent must be bounded by a task, a spec, tests, tools, and stop conditions. They should also learn that token optimization is not just cost reduction; it is context engineering.

## Suggested Examples
Spec artifact structure:
```text
change-add-csv-export/
  proposal.md
  design.md
  tasks.md
  specs/
    report-export.md
```

Agent task:
```text
Implement CsvReportExporter following specs/report-export.md.
Do not modify PdfReportExporter.
Add tests before implementation.
Run all tests before finishing.
```

Quality gate:
```text
[ ] satisfies the written spec
[ ] all tests pass
[ ] new behaviour has tests
[ ] security-sensitive code reviewed
[ ] diff is small enough to understand
```

## Practical Activity
Students implement a small feature using an AI assistant or coding agent. Deliverables should include spec files, code, tests, review report, and a reflection on what the AI did well or poorly.

## References
- OpenSpec: https://github.com/Fission-AI/OpenSpec/
- GitHub Spec Kit: https://github.com/github/spec-kit
- GitHub blog on spec-driven development with AI: https://github.blog/ai-and-ml/generative-ai/spec-driven-development-with-ai-get-started-with-a-new-open-source-toolkit/
- Microsoft Learn Spec Kit module: https://learn.microsoft.com/en-us/training/modules/spec-driven-development-github-spec-kit-enterprise-developers/
- GitHub Copilot documentation: https://docs.github.com/copilot

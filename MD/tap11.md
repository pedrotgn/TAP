# TAP - Language Interoperability

## Purpose of the Presentation

This presentation explains how programs written in different languages can interoperate through remote protocols, shared runtimes, native libraries, interpreters, polyglot runtimes and portable execution targets. The central idea is that interoperability is not only a technical trick: it creates an architectural boundary with contracts, data conversion, failure modes, performance costs, security implications and deployment constraints.

## Main Concepts

- **Remote interoperability:** different processes communicate through protocols such as RPC, REST, messaging or Java RMI. The boundary is the network, so latency, timeouts, retries, serialization and versioning must be part of the design.
- **RPC and IDL:** systems such as gRPC use an interface definition language to describe service operations and messages. Code generators then create client and server stubs for different languages.
- **Java RMI:** Java-specific remote object invocation. It is useful for teaching distributed object concepts, but less suitable for heterogeneous systems because both sides are strongly tied to Java semantics.
- **JVM bytecode interoperability:** Java, Kotlin, Scala, Groovy, Clojure and other languages can compile to JVM bytecode and share classes, interfaces, annotations, libraries and runtime services.
- **JVM design issue:** interoperability works best through simple public APIs. Nullability, checked exceptions, collections, generics and language-specific features need careful treatment at the boundary.
- **Interpreter-based interoperability:** Jython demonstrates that a language can be implemented on another runtime. Python syntax runs on the JVM and can access Java classes.
- **.NET interoperability:** C#, F#, Visual Basic and other languages compile to CIL/MSIL plus metadata and run under the Common Language Runtime, sharing a common type system and runtime services.
- **.NET native interop:** P/Invoke allows managed .NET code to call native DLL functions. This requires correct signatures and marshalling between managed and unmanaged memory.
- **Native libraries:** DLL, SO and dylib files expose compiled machine-code functions. They are useful for OS APIs, performance-critical code and legacy reuse, but reduce portability and increase debugging risk.
- **JNI:** the Java Native Interface allows Java code to call C/C++ and native code to interact with the JVM. It is powerful but verbose, unsafe compared with pure Java, and harder to test and deploy.
- **GraalVM polyglot programming:** Java host code can run guest languages such as JavaScript through a polyglot `Context`, exchanging values through language-neutral `Value` objects.
- **GraalVM Native Image:** Java applications can be compiled ahead of time to native executables, but reflection, resources, proxies, JNI and other dynamic features often require explicit configuration.
- **WebAssembly:** Wasm is a portable binary target for languages such as Rust, C, C++ and AssemblyScript. Hosts load modules, provide imports and call exported functions.
- **WASI:** WebAssembly System Interface defines standard system APIs for Wasm outside the browser, enabling sandboxed server-side or edge execution.
- **Testing interoperability:** contract tests, compatibility tests, integration tests, performance tests and security tests are essential because most defects appear at the boundary between languages.

## Architecture Decisions

- Use **RPC, REST or messaging** when components must be independently deployed or written in different technology stacks.
- Use **JVM languages** when the system already depends on Java libraries and benefits from shared bytecode, tooling and deployment.
- Use **.NET languages** when the system benefits from CLR assemblies, CIL/MSIL, the Common Type System and Microsoft ecosystem tooling.
- Use **JNI, P/Invoke or FFI** only when local native performance, OS APIs or existing native libraries justify the extra complexity.
- Use **GraalVM** when controlled polyglot scripting, extension points or ahead-of-time native compilation are useful.
- Use **WebAssembly/WASI** when sandboxed, portable plugins or browser/server portability are important.

## Example Discussion Questions

- Is the language boundary also a process boundary, runtime boundary or deployment boundary?
- What data types cross the boundary, and how are they serialized or marshalled?
- Who owns memory and error handling on each side?
- How is the interface versioned without breaking clients?
- What tests prove that both sides still agree on the contract?
- What security permissions does the called code receive?

## Suggested Classroom Activity

Ask students to implement the same small `discount` rule with three mechanisms: a Java interface implemented in Kotlin, a Java host calling a JavaScript rule through GraalVM, and a JavaScript host calling a WebAssembly module. Then compare code clarity, deployment effort, testing strategy, performance assumptions and failure modes.

## External References

- [Oracle JVM Specification](https://docs.oracle.com/javase/specs/)
- [Oracle Java Native Interface Specification](https://docs.oracle.com/en/java/javase/26/docs/specs/jni/index.html)
- [Oracle Java RMI Documentation](https://docs.oracle.com/javase/8/docs/technotes/guides/rmi/)
- [gRPC Documentation](https://grpc.io/docs/)
- [Jython Project](https://www.jython.org/)
- [GraalVM Polyglot Programming](https://www.graalvm.org/latest/reference-manual/polyglot-programming/)
- [GraalVM Polyglot Context API](https://www.graalvm.org/sdk/javadoc/org/graalvm/polyglot/Context.html)
- [.NET Managed Code](https://learn.microsoft.com/en-us/dotnet/standard/managed-code)
- [.NET Managed Execution Process](https://learn.microsoft.com/en-us/dotnet/standard/managed-execution-process)
- [WebAssembly](https://webassembly.org/)
- [WASI](https://wasi.dev/)

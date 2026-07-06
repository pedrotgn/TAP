# TAP - Language Interoperability

## Purpose of this presentation

This presentation focuses on language interoperability: the mechanisms that allow software written in different programming languages to communicate, share runtimes, call native code, embed interpreters or compile to common execution targets. The central teaching point is that every interoperability mechanism creates an architectural boundary with contracts, data conversion, failure modes, performance costs and deployment consequences.

## Key topics by slide

### 01. Language Interoperability
**Focus:** How programs written in different languages call, embed, compile to and execute with each other
- Remote calls · native libraries · bytecode platforms · interpreters
- JVM · Jython · .NET · JNI · GraalVM · WebAssembly
- Architecture boundaries, code snippets and trade-offs

### 02. Why Interoperability Matters
**Focus:** Modern systems are multilingual even when one language dominates
- A Java backend may call C libraries, Python scripts, JavaScript rules and remote services
- A .NET application may mix C#, F#, native DLLs and WebAssembly plugins
- A browser application may run JavaScript plus WebAssembly modules compiled from Rust or C++
- Interoperability allows reuse, migration and specialization
- Every boundary creates contracts, failure modes and deployment constraints
- Main message: Interoperability is useful only when the boundary is explicit and testable.

### 03. Three Families of Interoperability
**Focus:** Different mechanisms solve different problems
- Remote interoperability: Different processes communicate through protocols: RPC, REST, messaging, RMI
- Local/native interoperability: A managed language calls code in DLL, SO or dylib libraries through JNI, FFI or P/Invoke
- Runtime interoperability: Different languages share a VM, bytecode, type system or execution environment
- Interpreter embedding: One language implementation runs inside another platform, such as Python implemented on the JVM
- Portable compilation: Several source languages compile to a portable target such as WebAssembly

### 04. Interoperability Map
**Focus:** The main integration styles students should distinguish
- The source language boundary is not always the runtime boundary
- The strongest integration usually happens when languages share a runtime
- The safest distribution boundary is often a remote protocol
- The fastest boundary can also be the most dangerous: native code

### 05. Remote Interoperability: RPC
**Focus:** Different languages agree on a service contract
- The IDL is the cross-language contract
- Code generators create client and server stubs
- Java, C#, Go, Python and other languages can implement either side
- The runtime boundary is the network, not the programming language

Representative code or artifact:

```proto
// report.proto
syntax = "proto3";

service ReportService {
  rpc Generate(ReportRequest) returns (ReportReply);
}

message ReportRequest {
  string source = 1;
  string format = 2;
}

message ReportReply {
  bytes content = 1;
}
```

### 06. RPC Architecture
**Focus:** Generated stubs hide transport details but not distributed-system risk
- Client code calls a generated stub
- The stub serializes the request and uses a transport protocol
- The server stub deserializes and calls the implementation
- Timeouts, retries and versioning are part of the design

### 07. RPC Example: Java Client, Python Server
**Focus:** The languages differ; the schema is shared
- The Java code does not know whether the server is Python, Go or C#
- The schema controls field names and types
- Binary protocols can be efficient but require generated artifacts
- Network failures must be handled explicitly

Representative code or artifact:

```java
// Java client, conceptual generated API
ReportServiceGrpc.ReportServiceBlockingStub client =
    ReportServiceGrpc.newBlockingStub(channel);

ReportReply reply = client.generate(
    ReportRequest.newBuilder()
        .setSource("students.csv")
        .setFormat("pdf")
        .build()
);

Files.write(Path.of("report.pdf"), reply.getContent().toByteArray());
```

### 08. Java RMI
**Focus:** Remote method invocation for Java-to-Java object interoperability
- RMI exposes remote Java objects through Java interfaces
- Remote methods declare `RemoteException`
- It is strong for teaching object-oriented distribution
- It is less appropriate for heterogeneous public APIs

Representative code or artifact:

```java
public interface Calculator extends Remote {
    int add(int a, int b) throws RemoteException;
}

public class CalculatorImpl
        extends UnicastRemoteObject
        implements Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}
```

### 09. RMI Architecture
**Focus:** A Java-specific remote object model
- The client looks up a remote object reference
- The stub forwards method calls to a remote JVM
- Both sides understand Java serialization and RMI semantics
- The language interoperability is limited because the model is Java-centric

### 10. JVM Bytecode Platform
**Focus:** Many languages target the same virtual machine
- The JVM defines a class-file format and execution model
- Languages interoperate by producing compatible classes and methods
- Java libraries become available to other JVM languages
- The common denominator is the JVM type and object model

Representative code or artifact:

```java
Java source      -> javac   -> .class files
Kotlin source    -> kotlinc -> .class files
Scala source     -> scalac  -> .class files
Groovy source    -> groovyc -> .class files
Clojure source   -> compiler/runtime -> JVM bytecode

JVM loads classes, verifies bytecode and executes them.
```

### 11. JVM Interoperability Architecture
**Focus:** Different source languages meet at class files and the JVM
- Compilers emit `.class` files or bytecode loaded by the JVM
- The JVM verifier and class loader enforce runtime rules
- Interoperability is strongest at public classes, interfaces and annotations
- Build tools coordinate dependencies and mixed-language compilation

### 12. JVM Example: Java Interface, Kotlin Implementation
**Focus:** One language defines the contract; another implements it
- Interfaces are a clean interoperability boundary
- The JVM makes the Kotlin class visible as a Java-compatible class
- Nullability, data classes and default parameters need care across languages
- Public APIs should avoid language-specific surprises

Representative code or artifact:

```java
// Java
public interface TaxPolicy {
    BigDecimal taxFor(BigDecimal amount);
}

// Kotlin
class SpanishVatPolicy : TaxPolicy {
    override fun taxFor(amount: BigDecimal): BigDecimal =
        amount.multiply(BigDecimal("0.21"))
}

// Java can instantiate and use the Kotlin class
TaxPolicy policy = new SpanishVatPolicy();
```

### 13. JVM Example: Scala Using Java
**Focus:** JVM languages reuse Java libraries and APIs
- Java classes are visible to Scala through the JVM type system
- Collections and functional types may need adapters
- Checked exceptions and nulls have different language-level treatment
- The boundary should be tested from both languages if it is public

Representative code or artifact:

```java
// Java API
public final class ReportService {
    public Report generate(String source) { ... }
}

// Scala code
val service = new ReportService()
val report = service.generate("students.csv")

// The Java class is imported and used as a normal JVM type.
```

### 14. Jython: Python Implemented on the JVM
**Focus:** An interpreter can be implemented in another language/runtime
- Jython implements Python on top of the JVM
- Python code can import and use Java classes
- This is language interoperability through an interpreter implementation
- The important teaching idea is that a language is not the same thing as a runtime

Representative code or artifact:

```python
# Jython code: Python syntax running on the JVM
from java.util import ArrayList

names = ArrayList()
names.add("Ana")
names.add("Marc")

for name in names:
    print(name.upper())
```

### 15. Jython Architecture
**Focus:** Python syntax, Java implementation, JVM execution
- Python source is parsed by Jython
- Jython maps Python objects and operations to JVM execution
- Java classes are available as host platform classes
- Compatibility depends on the Python version and supported libraries

### 16. Jython Example: Python Class Extending Java
**Focus:** Python code can implement Java contracts
- The Java side expects `Runnable`
- The Python class provides a compatible `run` method
- The JVM thread executes behaviour written in Python syntax
- This is useful pedagogically for separating language, API and runtime

Representative code or artifact:

```python
# Jython-style example
from java.lang import Runnable

class Task(Runnable):
    def run(self):
        print("Running from Python on the JVM")

thread = Thread(Task())
thread.start()

# A Python class satisfies a Java interface.
```

### 17. .NET Platform
**Focus:** Several languages target the Common Language Runtime
- .NET code is managed by the Common Language Runtime
- Languages compile to Common Intermediate Language plus metadata
- A Common Type System allows cross-language libraries
- The runtime provides services such as garbage collection and reflection

Representative code or artifact:

```java
C# source       -> compiler -> CIL + metadata -> assembly
F# source       -> compiler -> CIL + metadata -> assembly
VB.NET source   -> compiler -> CIL + metadata -> assembly

At runtime:
CIL -> JIT/AOT compiler -> native machine code
```

### 18. .NET Interoperability Architecture
**Focus:** Assemblies, metadata and the CLR connect languages
- C#, F# and VB.NET compilers produce assemblies
- Assemblies include CIL and metadata
- The CLR loads assemblies and compiles CIL to native code
- Language boundaries are crossed through public types

### 19. .NET Example: C# Calling F#
**Focus:** A functional module can be consumed from object-oriented code
- F# can express domain calculations concisely
- C# can call the compiled F# assembly
- The CLR type system makes the boundary possible
- API design should hide language-specific idioms when used broadly

Representative code or artifact:

```java
// F# library
module Pricing
let vat amount = amount * 0.21M

// C# application
decimal tax = Pricing.vat(100m);
Console.WriteLine(tax);

// Both languages compile to .NET assemblies.
```

### 20. .NET Native Interop: P/Invoke
**Focus:** Managed .NET code can call native DLL functions
- P/Invoke is local interoperability between managed and unmanaged code
- The method signature must match the native function
- Marshalling converts values across the boundary
- Errors can be difficult because native code is outside CLR safety guarantees

Representative code or artifact:

```java
using System.Runtime.InteropServices;

class NativeMethods {
    [DllImport("user32.dll")]
    public static extern int MessageBox(
        IntPtr hWnd, string text, string caption, uint type);
}

NativeMethods.MessageBox(IntPtr.Zero, "Hello", "Interop", 0);
```

### 21. Native Libraries: DLL, SO, dylib
**Focus:** Local interoperability with compiled platform libraries
- Native libraries expose binary functions or symbols
- They are useful for performance, legacy reuse and OS APIs
- They are platform-specific and harder to deploy portably
- The calling language must agree on names, types and memory ownership

Representative code or artifact:

```java
// C library: fastmath.c
#include <math.h>

double hypotenuse(double a, double b) {
    return sqrt(a*a + b*b);
}

// Build examples:
// Linux:   gcc -shared -fPIC -o libfastmath.so fastmath.c
// Windows: produce fastmath.dll
// macOS:   produce libfastmath.dylib
```

### 22. Native Library Boundary
**Focus:** Managed runtime meets unmanaged machine code
- The managed runtime loads a platform-specific library
- Arguments are marshalled across the boundary
- Native code can crash the process or corrupt memory
- Keep the native API small and well tested

### 23. JNI: Java Calling C/C++
**Focus:** The classic Java native interoperability mechanism
- JNI means Java Native Interface
- `native` methods are implemented outside Java
- The JVM loads the native library at runtime
- JNI is powerful but increases build, deployment and debugging complexity

Representative code or artifact:

```java
// Java declaration
public final class FastMath {
    static { System.loadLibrary("fastmath"); }

    public native double hypotenuse(double a, double b);
}

// Java call
FastMath math = new FastMath();
double h = math.hypotenuse(3, 4);
```

### 24. JNI Native Side
**Focus:** C/C++ functions receive a JNI environment and Java values
- JNI function names encode the Java class and method
- `JNIEnv*` exposes functions for interacting with the JVM
- Primitive values map relatively directly
- Objects, arrays and strings require careful conversion

Representative code or artifact:

```java
JNIEXPORT jdouble JNICALL
Java_FastMath_hypotenuse(JNIEnv* env, jobject obj,
                         jdouble a, jdouble b) {
    return sqrt(a*a + b*b);
}

// JNI code can also access Java objects through JNIEnv,
// but every cross-boundary operation has cost and risk.
```

### 25. GraalVM Polyglot
**Focus:** Multiple languages can run inside one polyglot runtime
- A GraalVM polyglot `Context` represents guest language runtime state
- Java host code can evaluate guest language code
- Values cross languages through GraalVM `Value` objects
- Access must be controlled because guest code may interact with host objects

Representative code or artifact:

```java
try (Context ctx = Context.create("js")) {
    Value result = ctx.eval("js", "40 + 2");
    int answer = result.asInt();
    System.out.println(answer);
}
```

### 26. GraalVM Polyglot Architecture
**Focus:** Host and guest languages interact through the polyglot API
- The Java application creates a polyglot context
- Guest language code runs inside that context
- Values are exchanged through language-neutral wrappers
- Policies restrict host access, filesystem access and native access

### 27. GraalVM Example: Java Calls JavaScript Rule
**Focus:** A dynamic business rule can be written in another language
- The host system remains Java
- The extension language is JavaScript
- The boundary is explicit: only chosen values are passed
- This can implement scripting, plugins or rule engines

Representative code or artifact:

```java
String rule = "function discount(total) { return total > 100 ? 0.10 : 0.0; }";

try (Context ctx = Context.create("js")) {
    ctx.eval("js", rule);
    Value discount = ctx.getBindings("js").getMember("discount");
    double value = discount.execute(150).asDouble();
    System.out.println(value); // 0.10
}
```

### 28. GraalVM Native Image
**Focus:** Interop changes when code is compiled ahead of time
- Native Image compiles Java applications ahead of time
- Startup and memory usage can improve
- Dynamic language features and reflection may require configuration
- Interop-heavy applications must be designed with build-time visibility in mind

Representative code or artifact:

```java
// Dynamic features may need configuration
{
  "name": "com.example.Plugin",
  "methods": [{ "name": "run", "parameterTypes": [] }]
}

// Reflection, proxies, resources and JNI must be known for native image builds.
```

### 29. WebAssembly as a Language Target
**Focus:** Many source languages compile to a portable binary format
- WebAssembly is a portable binary instruction format
- It is designed as a compilation target for programming languages
- A Wasm module exports functions and imports host capabilities
- The host controls what the module can access

Representative code or artifact:

```java
Rust / C / C++ / AssemblyScript / others
        -> compiler toolchain
        -> .wasm module
        -> browser, server runtime or edge platform

Host imports + Wasm exports define the interoperability contract.
```

### 30. WebAssembly Architecture
**Focus:** Portable module, explicit host boundary
- Source language compiles to a `.wasm` module
- The host loads and instantiates the module
- Imports provide controlled capabilities
- Exports provide callable functions

### 31. WebAssembly Example: JavaScript Host
**Focus:** JavaScript can load and call a module compiled from another language
- The host is JavaScript
- The implementation language may be Rust, C or C++
- The boundary is the Wasm import/export interface
- Data exchange is simple for numbers and harder for strings or objects

Representative code or artifact:

```javascript
const bytes = await fetch("math.wasm").then(r => r.arrayBuffer());
const module = await WebAssembly.instantiate(bytes, {
  env: {
    log: value => console.log(value)
  }
});

const result = module.instance.exports.add(20, 22);
console.log(result);
```

### 32. WASI and Server-Side WebAssembly
**Focus:** WASI standardizes system interfaces for Wasm outside the browser
- WASI means WebAssembly System Interface
- It defines standards-track APIs for Wasm software outside the browser
- The capability model helps sandbox plugins
- This is attractive for safe extension points and edge computing

Representative code or artifact:

```java
// Conceptual execution
wasmtime report_plugin.wasm --input students.csv

// The runtime grants selected capabilities:
// - read this directory
// - write this output file
// - use clock or random APIs
// No ambient full operating-system access by default.
```

### 33. Interpreter vs Compiler Interoperability
**Focus:** The same language can be implemented through different execution strategies
- Jython: Python syntax implemented for the JVM with access to Java classes
- JVM languages: Languages compile to JVM bytecode and share Java classes
- GraalVM: Languages run in a polyglot runtime and exchange values through an API
- WebAssembly: Languages compile to a portable sandboxed binary target
- Native interop: Managed code calls compiled machine-code libraries

### 34. Decision Matrix
**Focus:** Choose the boundary based on deployment, trust and coupling
- Need independent deployment: Use RPC, REST or messaging
- Need Java ecosystem reuse: Use JVM bytecode languages or Java-compatible interpreters
- Need .NET ecosystem reuse: Use C#, F#, VB.NET and CLR assemblies
- Need existing native library: Use JNI, P/Invoke or FFI with a small boundary
- Need sandboxed portable plugins: Use WebAssembly/WASI or a controlled polyglot runtime

### 35. Testing Interoperability
**Focus:** The boundary needs its own test strategy
- Contract tests verify schemas, interfaces and expected behaviours
- Compatibility tests protect public APIs across language versions
- Integration tests run both sides of the boundary together
- Performance tests expose serialization, marshalling and startup costs
- Security tests check sandboxing, permissions and input validation
- Main message: Interoperability bugs often happen at the boundary, not inside either language.

### 36. Mini-Lab
**Focus:** Compare three interoperability mechanisms
- Students see the same concept through different boundaries
- The exercise forces explicit comparison rather than tool enthusiasm
- The final report should justify the architecture choice
- AI can help generate code, but students must validate the boundary

Representative code or artifact:

```java
Task: implement a small "discount" rule in three ways.

1. Java interface + Kotlin implementation on the JVM
2. Java host + JavaScript rule through GraalVM
3. JavaScript host + WebAssembly add/discount module

Measure:
- code clarity
- deployment effort
- test strategy
- failure modes
```

### 37. Key Takeaways
**Focus:** Language interoperability is architecture
- Languages interoperate through protocols, native calls, bytecode, interpreters or portable binaries
- JVM and .NET show how a shared runtime enables multi-language ecosystems
- Jython shows that one language can be implemented inside another runtime
- GraalVM and WebAssembly represent modern approaches to polyglot and portable execution
- Every boundary must define contracts, data conversion, errors, deployment and tests
- Main message: Do not ask only whether two languages can talk. Ask what kind of boundary you are creating.

## Suggested external references

- [Oracle JVM Specification](https://docs.oracle.com/javase/specs/)
- [Oracle Java Native Interface Specification](https://docs.oracle.com/en/java/javase/26/docs/specs/jni/index.html)
- [Oracle RMI Documentation](https://docs.oracle.com/javase/8/docs/technotes/guides/rmi/)
- [gRPC Documentation](https://grpc.io/docs/)
- [Jython Project](https://www.jython.org/)
- [GraalVM Polyglot Programming](https://www.graalvm.org/latest/reference-manual/polyglot-programming/)
- [GraalVM Polyglot Context API](https://www.graalvm.org/sdk/javadoc/org/graalvm/polyglot/Context.html)
- [.NET Managed Code](https://learn.microsoft.com/en-us/dotnet/standard/managed-code)
- [.NET Managed Execution Process](https://learn.microsoft.com/en-us/dotnet/standard/managed-execution-process)
- [WebAssembly](https://webassembly.org/)
- [WASI](https://wasi.dev/)

## Suggested classroom activities

- Ask students to classify examples as remote, native, shared runtime, interpreter-based or portable-target interoperability.
- Implement one Java interface from Kotlin or Scala and discuss API design issues.
- Run a small Jython example or discuss why Jython demonstrates the distinction between language and runtime.
- Compare JNI or P/Invoke with an RPC boundary for the same native capability.
- Use a GraalVM-style scripting example to discuss security policies and extension points.
- Compare JavaScript calling WebAssembly with Java calling JNI: what is similar, what is safer, and what is harder?

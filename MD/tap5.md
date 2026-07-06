# TAP 5 - Reflective Programming

## Purpose of the Presentation
This presentation explains reflective programming: the ability of a program to inspect and sometimes modify its own structure and behaviour at runtime. It covers Java reflection, annotations, dynamic proxies, Python introspection, decorators, metaclasses, and aspect-oriented programming.

## Key Concepts
- Reflection and introspection.
- Java `Class`, `Method`, `Field`, and `Constructor`.
- Runtime method invocation.
- Annotations as metadata.
- Dynamic proxies and invocation handlers.
- Frameworks using reflection for dependency injection, testing, serialization, ORM, and routing.
- Python introspection with `getattr`, `setattr`, `dir`, `inspect`, dynamic imports, decorators, descriptors, and metaclasses.
- Aspect-oriented programming: cross-cutting concerns, advice, pointcuts, weaving.

## Concepts to Explain in Class
Reflection is powerful because it allows generic code to work with classes it did not know at compile time. This explains how frameworks discover components, inject dependencies, serialize objects, run tests, and map HTTP requests to methods.

Students should also understand the trade-offs: reflection can reduce type safety, make code harder to read, harm performance, and create security risks if used carelessly.

## Suggested Examples
Java reflection:
```java
Class<?> clazz = Class.forName("reflection.Person");
Method method = clazz.getMethod("getName");
Object value = method.invoke(person);
```

Python introspection:
```python
import inspect

print(inspect.signature(function))
print(inspect.getsource(function))
```

Decorator:
```python
def log_call(fn):
    def wrapper(*args, **kwargs):
        print("calling", fn.__name__)
        return fn(*args, **kwargs)
    return wrapper
```

## Practical Activity
Ask students to write a small plugin loader that discovers classes with an annotation or a naming convention, then invokes a method dynamically.

## References
- Oracle Java Reflection tutorial: https://docs.oracle.com/javase/tutorial/reflect/
- Java Reflection API guide: https://docs.oracle.com/javase/8/docs/technotes/guides/reflection/index.html
- Python `inspect` module: https://docs.python.org/3/library/inspect.html
- Python data model: https://docs.python.org/3/reference/datamodel.html
- AspectJ Programming Guide: https://eclipse.dev/aspectj/doc/released/progguide/index.html
- Spring AOP with AspectJ: https://docs.spring.io/spring-framework/reference/core/aop/using-aspectj.html

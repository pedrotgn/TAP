# TAP - Asynchronous Event-Based Programming

## Purpose of the Presentation

This presentation introduces asynchronous and event-based programming as a way to build responsive, scalable and decoupled software. It connects classical event listeners with modern futures, promises, async/await, event loops, reactive streams and frameworks such as Node.js and Angular.

## Main Concepts

- **Synchronous vs asynchronous calls:** synchronous calls block until a result is available; asynchronous calls return immediately and complete later through a future, promise, callback or event.
- **Event-based programming:** producers emit events and consumers react through handlers or listeners. This decouples the source of an event from the code that responds to it.
- **Java listeners:** a producer stores a list of listener objects or lambdas and notifies them when something happens. This is a common implementation of the Observer pattern.
- **.NET events:** C# provides language support for event subscription with `event`, `EventHandler`, `+=` and event invocation.
- **Callbacks:** callbacks are functions passed to run later. They are simple but can lead to nested, hard-to-maintain control flow.
- **Futures and promises:** objects such as Java `CompletableFuture`, C# `Task` and JavaScript `Promise` represent values that may become available later.
- **Async/await:** provides sequential-looking syntax for asynchronous code while preserving non-blocking execution.
- **Event loop:** a runtime mechanism that schedules callbacks and continuations. It is central to JavaScript, Node.js and Python `asyncio`.
- **Node.js:** uses an event-driven, non-blocking I/O model. CPU-heavy work should not block the event loop.
- **Angular events:** frontend applications are naturally event-driven through DOM events, component outputs and asynchronous service calls.
- **Observables and streams:** promises usually represent one future value; observables represent many values over time and support operators such as filtering, debouncing and switching.
- **Event bus pattern:** publishers send events to a bus, and subscribers react without direct coupling to the publisher.
- **Reactive streams and backpressure:** when producers are faster than consumers, the system needs a policy: buffer, slow down, drop, batch or fail.
- **Timeouts and cancellation:** asynchronous work needs explicit stop conditions to avoid resource leaks and poor user experience.
- **Testing async code:** tests should avoid arbitrary sleeps and should control completion, time, handlers and observable side effects.

## Design Decisions

- Use **listeners/events** when one object needs to notify many independent consumers.
- Use **futures/promises** when an operation will produce one result later.
- Use **async/await** to improve readability of asynchronous workflows.
- Use **observables/streams** when values arrive continuously over time.
- Use an **event bus** when producers and consumers should be strongly decoupled, but add tracing because control flow becomes less explicit.
- Use **reactive streams/backpressure** when the system must handle high-volume asynchronous data safely.
- Avoid blocking event-loop threads; move CPU-heavy work to worker threads, processes or external services.

## Common Problems

- Race conditions caused by events arriving in unexpected orders.
- Lost events when producers emit before consumers subscribe.
- Memory leaks caused by listeners that are never removed.
- Unhandled promise rejections or task exceptions.
- Event-loop blocking caused by long CPU-bound handlers.
- Incorrect assumptions about ordering, retries and exactly-once delivery.

## Suggested Classroom Activity

Ask students to implement the same temperature-sensor workflow in four styles: Java listener pattern, C# event, JavaScript `EventEmitter`, and a future/promise-based asynchronous alert. Then compare coupling, readability, error handling, testability, ordering guarantees and cancellation.

## External References

- [Oracle Java CompletableFuture](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/CompletableFuture.html)
- [Microsoft C# Events](https://learn.microsoft.com/en-us/dotnet/csharp/programming-guide/events/)
- [Microsoft Asynchronous Programming with async and await](https://learn.microsoft.com/en-us/dotnet/csharp/asynchronous-programming/)
- [MDN JavaScript Promises](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise)
- [MDN async function](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/async_function)
- [Node.js EventEmitter](https://nodejs.org/api/events.html)
- [Python asyncio](https://docs.python.org/3/library/asyncio.html)
- [Angular Event Binding](https://angular.dev/guide/templates/event-listeners)
- [Reactive Streams](https://www.reactive-streams.org/)

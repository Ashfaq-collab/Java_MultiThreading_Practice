# Experiment 06 — volatile and Thread Visibility

## Objective
Understand visibility between threads and the purpose of the `volatile` keyword.

## 1. Thread Visibility
When multiple threads access a shared variable, one thread is not guaranteed to observe another thread's update unless the program uses appropriate synchronization.

## 2. The volatile Keyword
The `volatile` keyword provides visibility and memory-ordering guarantees for reads and writes of a variable.

Example:

```java
static volatile boolean running = true;
```

When one thread writes `false`, another thread reading this volatile variable will observe that write or a later write.

## 3. Typical Use Case
A volatile boolean is useful as a simple shared status flag that one thread updates and another thread checks.

## 4. volatile Does Not Provide Atomicity
The following operation is not atomic:

```java
counter++;
```

It involves reading, modifying, and writing the value. Concurrent increments can still interfere with each other, even if `counter` is declared volatile.

## 5. Comparison

- `volatile`: visibility and ordering guarantees for individual variable accesses.
- `synchronized`: mutual exclusion and visibility through monitor locking.
- `AtomicInteger`: atomic integer operations, including incrementing.

## 6. Key Takeaways
- Visibility and atomicity are different concepts.
- Use volatile for appropriate shared flags and simple state publication.
- Use synchronized or suitable atomic operations for concurrent modifications.
- A timed join waits for a limited duration; it does not terminate a thread.
- Do not rely on an ordinary, unsynchronized shared flag to coordinate thread termination.
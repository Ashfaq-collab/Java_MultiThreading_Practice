# Experiment 11 — Callable, Future, and Returning Results

## Objective
Learn how to execute a task that returns a value and retrieve that value from another thread.

## 1. Callable
`Callable<V>` represents a task that returns a result of type `V`.

Its main method is:

```java
V call() throws Exception;
```

Unlike `Runnable`, a `Callable` can return a value and declare checked exceptions.

## 2. Future
`Future<V>` represents the result of an asynchronous computation.

The result may not be available when the Future is first returned.

## 3. Future.get()
`get()` retrieves the result:
- If the task is unfinished, the calling thread waits.
- If the task has completed successfully, the result is returned.
- If the task fails, `ExecutionException` is thrown.
- If the waiting thread is interrupted, `InterruptedException` may be thrown.

## 4. Exception Handling
A task's exception is typically reported through `ExecutionException` when its result is retrieved using `get()`.

The original task exception is available as the cause.

## 5. Runnable vs Callable
- `Runnable`: performs work without returning a result.
- `Callable<V>`: performs work and returns a result of type `V`.

## 6. Key Takeaways
- `ExecutorService` can execute both Runnable and Callable tasks.
- `submit()` returns a Future for tracking a submitted task.
- `Future.get()` may block until the result is available.
- Submitting a task does not mean it has already finished.
- Handle task failures and interruptions deliberately in real applications.
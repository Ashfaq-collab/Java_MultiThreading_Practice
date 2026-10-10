# Experiment 09 — Producer–Consumer

## Objective
Use `wait()` and `notifyAll()` to coordinate a producer and consumer sharing a single-slot buffer.

## 1. Producer
The producer waits while the buffer contains an item. When the buffer is empty, it stores a new item and notifies waiting threads.

## 2. Consumer
The consumer waits while the buffer is empty. When an item is available, it retrieves the item, empties the buffer, and notifies waiting threads.

## 3. Why Use while Instead of if?
A thread must recheck its condition after waking. Wakeups can occur without the condition being satisfied, and another thread may change the condition before the awakened thread reacquires the monitor.

## 4. Why wait() Matters
`wait()` releases the object's monitor while the thread waits. This allows the other thread to acquire the same monitor and change the buffer's state.

## 5. Why join() Matters
`join()` makes the main thread wait for worker-thread completion before printing the final message.

## 6. Synchronization
Synchronized methods protect the buffer's shared state. Both producer and consumer use the same buffer object, so they coordinate through the same monitor.

## Key Takeaways
- Shared state must be protected from conflicting concurrent access.
- Use condition loops with `wait()`.
- Notify waiting threads after changing the shared condition.
- `wait()` releases the monitor; `sleep()` does not.
- `join()` waits for thread termination; it does not coordinate buffer access.
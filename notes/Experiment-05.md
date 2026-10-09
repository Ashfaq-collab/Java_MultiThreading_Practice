# Experiment 05 — Race Conditions and Shared Data

## Objective
Understand race conditions when multiple threads access and modify shared data.

## Key Concepts

### 1. Shared Data
Data accessed by multiple threads is shared data. If threads modify it concurrently without appropriate coordination, incorrect results can occur.

### 2. Race Condition
A race condition occurs when a program's result depends on the timing or interleaving of concurrent operations.

### 3. Why `counter++` Is Unsafe
`counter++` is a read-modify-write operation, not one indivisible operation. Threads can overwrite each other's updates.

### 4. Why `join()` Is Not Enough
`join()` makes the calling thread wait for another thread to terminate. It does not prevent race conditions during execution.

### 5. `synchronized`
A synchronized method uses a monitor lock to ensure only one thread at a time executes the protected method using that lock.

A static synchronized method locks the associated class object.

### 6. `AtomicInteger`
`AtomicInteger` provides atomic operations such as `incrementAndGet()` for thread-safe integer updates.

## Comparison

- `counter++`: not thread-safe when used concurrently without protection.
- counter++ is not an atomic operation. It involves reading, incrementing, and writing. 
- Threads can interfere with each other's updates, so the final value may be below 200,000. 
- It can also happen to equal 200,000 in a particular run.
- `synchronized`: provides mutual exclusion for code protected by the same lock.
- `AtomicInteger`: provides atomic integer operations.

## Key Takeaways
- Multiple threads can safely read shared data but concurrent modifications require appropriate coordination.
- A race condition may cause a result smaller than expected; it may also occasionally produce the expected result.
- Never assume a race condition will reproduce the same output on every run.
- `join()` waits for completion; it does not provide mutual exclusion.
- Use synchronization or suitable atomic operations to protect shared updates.
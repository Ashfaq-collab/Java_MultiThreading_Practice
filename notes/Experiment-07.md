# Experiment 07 — Deadlock

## Objective
Understand deadlocks, how they occur, and how consistent lock ordering can prevent them.

## 1. What Is a Deadlock?
A deadlock occurs when threads wait indefinitely for resources or locks held by one another, preventing them from making progress.

## 2. How the Deadlock Occurred
- Thread 1 acquired Lock A and waited for Lock B.
- Thread 2 acquired Lock B and waited for Lock A.
- Each thread held a lock that the other needed.
- Neither thread could proceed.

## 3. Four Conditions Associated with Deadlock
1. Mutual exclusion: a resource can be held by only one thread at a time.
2. Hold and wait: a thread holds one resource while waiting for another.
3. No preemption: a resource cannot simply be taken away from its holder.
4. Circular wait: threads form a cycle of waiting for resources held by one another.

These conditions together characterize the classic lock-based deadlock scenario.

## 4. Does sleep() Release a Lock?
No. `Thread.sleep()` pauses the current thread but does not release monitor locks it already holds.

## 5. Prevention Through Lock Ordering
Require all threads to acquire multiple locks in the same global order.

Example:

Lock A → Lock B

Consistent ordering removes the opposing acquisition order that caused the deadlock in this experiment.

## 6. Key Takeaways
- Deadlocks can leave threads blocked indefinitely.
- Different lock-acquisition orders can create circular waiting.
- `sleep()` does not release monitor locks.
- Consistent lock ordering is a common deadlock-prevention technique.
- Consistent ordering does not eliminate every possible deadlock; other locking patterns must also be considered.
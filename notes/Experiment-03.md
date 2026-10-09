# Experiment 03: Thread Lifecycle and States

**Level:** Beginner  
**Topic:** `Thread.State`

## 1. Objective

Learn the six official Java thread states and observe them using `getState()`.

## 2. The six states

- **NEW:** A thread object has been created but has not started.
- **RUNNABLE:** The thread is executing in the JVM or may be ready to execute.
- **BLOCKED:** The thread is waiting to acquire a monitor lock.
- **WAITING:** The thread is waiting indefinitely for another thread's action.
- **TIMED_WAITING:** The thread is waiting for a specified amount of time.
- **TERMINATED:** The thread has completed execution.

## 3. Important methods

- `start()` starts a thread.
- `getState()` returns the thread's current state.
- `sleep(milliseconds)` pauses the current thread for a specified time.
- `join()` waits for another thread to finish.

## 4. Important observations

1. Creating a Thread object does not start it.
2. `sleep()` normally causes TIMED_WAITING.
3. `join()` can put the calling thread into WAITING or TIMED_WAITING, depending on which overload is used.
4. Thread state observations are snapshots and can change immediately.
5. Java's RUNNABLE state includes both ready-to-run and actually-running threads.

## 5. Practice checklist

- [ ] Observe NEW before calling start().
- [ ] Observe TIMED_WAITING during sleep().
- [ ] Observe TERMINATED after join() returns.
- [ ] Learn how BLOCKED and WAITING can occur.

## 6. Git checkpoint

`learn: explore Java thread lifecycle and states`

## 7. Next experiment

Experiment 04: `sleep()`, `join()`, and `interrupt()`.

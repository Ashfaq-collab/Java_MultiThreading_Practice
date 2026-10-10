# Experiment 08 — wait(), notify(), and notifyAll()

## Objective
Understand how threads coordinate using an object's monitor.

## 1. wait()
- Must be called while owning the object's monitor.
- Releases that monitor and waits.
- Reacquires the monitor before returning normally from the wait.
- Can throw InterruptedException.

## 2. notify()
- Wakes one thread waiting on the same object's monitor.
- Does not immediately transfer the monitor lock.
- The notified thread must reacquire the monitor before proceeding.

## 3. notifyAll()
- Wakes all threads waiting on the same object's monitor.
- They compete to reacquire the monitor.
- It does not mean all awakened threads execute simultaneously.

## 4. wait() vs sleep()
- wait() releases the monitor on which it is called.
- sleep() pauses the current thread without releasing monitor locks it holds.

## 5. Always Check the Condition
Use a loop when waiting for a condition:

```java
while (!ready) {
    lock.wait();
}
```

A thread can wake up without the condition being true, and another thread may change the condition before the awakened thread reacquires the lock.

## 6. Monitor Ownership
Calling wait(), notify(), or notifyAll() without owning that object's monitor causes IllegalMonitorStateException.

## Key Takeaways
- Thread communication often combines a shared condition, a common monitor, and notification.
- Notification alone does not transfer ownership of a lock.
- notify() wakes one waiter; notifyAll() wakes all waiters.
- Correct coordination requires protecting the condition with the same monitor.
- Prefer a higher-level concurrency utility when it makes coordination simpler and safer.
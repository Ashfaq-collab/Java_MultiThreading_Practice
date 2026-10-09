# Experiment 04: sleep(), join(), and interrupt()

**Level:** Beginner  
**Topic:** Thread pausing, coordination, and interruption

## 1. Thread.sleep()

- Pauses the currently executing thread for a specified time.
- Is a static method of Thread.
- Does not release monitor locks.
- Can throw InterruptedException.

## 2. Thread.join()

- Makes the calling thread wait for the target thread to terminate.
- Helps coordinate tasks that must finish in a particular order.
- Can throw InterruptedException.
- Has timed and untimed overloads.

## 3. Thread.interrupt()

- Requests interruption; it does not forcibly kill a thread.
- Can cause interruptible waiting methods to throw InterruptedException.
- Can set the interrupt status when the thread is not in an interruptible wait.
- Requires cooperative handling by application code.

## 4. InterruptedException

- Is a checked exception.
- Must be caught or declared by methods that can throw it.
- Often requires restoring the interrupt status when the exception cannot be propagated.

## 5. Key differences

- sleep(): pauses the current thread.
- join(): makes the calling thread wait for another thread to finish.
- interrupt(): requests that a thread respond to interruption.

## 6. Practice checklist

- [ ] Observe sleep() delays.
- [ ] Compare output with and without join().
- [ ] Interrupt a sleeping thread.
- [ ] Explain why interrupt() does not forcibly terminate a thread.

## 7. Git checkpoint

learn: practice sleep join and interrupt

## 8. Next experiment

Experiment 05: Race conditions and shared data.

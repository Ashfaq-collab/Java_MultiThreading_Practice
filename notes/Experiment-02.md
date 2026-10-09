# Experiment 02: Thread vs Runnable

**Level:** Beginner  
**Topic:** Creating threads and defining tasks

## 1. Objective

Understand two ways to define thread behavior in Java.

## 2. Extending Thread

- Create a class using `extends Thread`.
- Override `run()` to define the work.
- Call `start()` to begin a new thread of execution.

## 3. Implementing Runnable

- Create a class using `implements Runnable`.
- Implement `run()` to define the task.
- Pass the task to `new Thread(task)`.
- Call `start()` on the Thread object.

## 4. Key difference

A Thread represents a thread of execution. A Runnable represents work that can be executed by a thread.

## 5. Why Runnable is often preferred

- Separates task logic from thread management.
- Allows the class to extend another class.
- Allows the same task object to be supplied to multiple threads.
- Fits naturally with executor services and thread pools.

## 6. Important rule

Calling `run()` directly does not start a new thread. Use `start()` when you want a new thread of execution.

## 7. Practice checklist

- [ ] Write a class extending Thread.
- [ ] Write a class implementing Runnable.
- [ ] Run the same Runnable task on two threads.
- [ ] Explain the difference between a task and a thread.

## 8. Git checkpoint

`learn: compare Thread and Runnable`

## 9. Next experiment

Experiment 03: Thread lifecycle and thread states.

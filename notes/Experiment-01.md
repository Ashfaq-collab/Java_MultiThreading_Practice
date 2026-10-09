Experiment 01: Java Thread — start() vs run()

Level: Beginner
Topic: Java Multithreading Fundamentals
Status: Completed lesson

1. Objective

Understand the difference between calling run() directly and starting a thread using start().

2. Important concepts

Thread

A thread is an independent path of execution within a process.

Thread object

Creating a Thread object does not start a new thread.

run()

run() contains the task's execution logic.

Calling run() directly behaves like an ordinary method call.

The task executes on the current thread.

start()

start() starts a new thread of execution.

The JVM arranges for that thread to execute the task.

The task's run() method executes on the new thread.

3. Example

public class Experiment_01 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println(
                Thread.currentThread().getName()
            );
        });

        t.run();
        t.start();
    }
}

4. Expected output

main
Thread-0

The new thread's name may vary.

5. Key observations

Directly calling run() does not create a new thread.

Calling start() starts a new thread.

A Thread instance can be started successfully only once.

Starting the same thread instance again throws IllegalThreadStateException.

Concurrent threads can execute in different orders.

Thread.currentThread().getName() helps identify the executing thread.

6. Common mistakes

Assuming run() and start() do the same thing.

Assuming start() immediately executes the task.

Assuming thread output always appears in the same order.

Calling start() twice on the same Thread object.

7. Interview question

Q: What is the difference between start() and run() in Java?

Answer: Calling run() directly executes the method on the current thread. Calling start() starts a new thread of execution, which then executes the task's run() method.
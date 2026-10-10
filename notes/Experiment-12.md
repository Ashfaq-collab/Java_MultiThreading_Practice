# Experiment 12 — Thread-Safe Collections

## 1. Problem with ArrayList

- `ArrayList` is not thread-safe for concurrent modification.
- Multiple threads modifying the same list without coordination can cause race conditions.
- Race conditions may produce incorrect results without throwing exceptions.
- A correct result in one run does not prove that code is thread-safe.

## 2. Synchronization with a shared lock

```java
Object lock = new Object();

synchronized (lock) {
    numbers.add(i);
}
```

- A shared lock coordinates access between threads.
- Only one thread at a time can hold the same object's monitor lock.
- Different locks do not protect the same shared resource from one another.
- The lock should protect every relevant access to the shared data.

## 3. Critical section

A critical section is a section of code that accesses shared state and needs coordinated access.

- Synchronizing one addition protects that operation.
- Synchronizing the entire loop protects the whole loop as one critical section.
- A larger critical section can reduce concurrency.

## 4. Synchronized collections

```java
List<Integer> numbers =
    Collections.synchronizedList(new ArrayList<>());
```

- This wrapper synchronizes individual list operations.
- Compound operations may still need explicit synchronization.
- Iterating over a synchronized list requires synchronization on the list.

## 5. Important takeaway

Thread safety means shared data is accessed and modified in a way that preserves correctness when multiple threads are involved. Synchronization is one way to achieve it.
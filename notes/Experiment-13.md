# Experiment 13 — ConcurrentHashMap
 
## What is ConcurrentHashMap?

`ConcurrentHashMap` is a thread-safe map designed for concurrent access by multiple threads.

## Key points
- A map stores data as key-value pairs.
- Keys are unique; inserting an existing key replaces its value.
- `HashMap` does not provide thread safety for concurrent modifications.
- `ConcurrentHashMap` supports concurrent access safely for individual operations such as `put()` and `get()`.
- `join()` lets the main thread wait for worker threads to finish.
- Multiple operations together are not automatically atomic.

## Example

```java
Map<Integer, String> students =
    new ConcurrentHashMap<>();

students.put(10, "Student 10");
students.put(10, "Updated Student 10");

System.out.println(students.size()); // 1
```

The second `put()` replaces the value for key `10`; it doesn't create another entry.

## Remember

Use `ConcurrentHashMap` when multiple threads need to access and update a shared map concurrently.
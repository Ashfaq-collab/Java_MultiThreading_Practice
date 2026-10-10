# Experiment 14 — CountDownLatch

## What is CountDownLatch?

`CountDownLatch` lets one or more threads wait until a counter reaches zero.

## Important methods

- `new CountDownLatch(count)`: Sets the initial count.
- `countDown()`: Decreases the count by one.
- `await()`: Waits until the count reaches zero.

## Key points

- Initialize the count to the number of completion signals you need.
- Each required task should call `countDown()` when it reaches the intended completion point.
- The waiting thread continues when the count reaches zero.
- Without `await()`, the main thread does not wait at the latch.
- A `CountDownLatch` cannot be reset for reuse; create a new one for another cycle.

## Remember

Use `CountDownLatch` when a thread needs to wait for a fixed number of events or tasks to finish.
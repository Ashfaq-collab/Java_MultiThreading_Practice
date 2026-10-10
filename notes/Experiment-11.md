Future.get(timeout, unit) waits for a result for a limited time.



If the timeout expires first, it throws TimeoutException.



get() timing out does not automatically cancel the task.



cancel(true) attempts to interrupt the task.



cancel(false) does not interrupt a task that is already running.



isDone() means the Future is finished in some way, not necessarily successfully.



Interruption is a cooperative cancellation mechanism, not a forceful thread termination mechanism.
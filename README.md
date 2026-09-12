The program implements the Producer-Consumer problem using two threads that share a common `Buffer` object. The `Producer` thread generates values from 1 to 5 and calls `produce()`, while the `Consumer` thread calls `consume()` to read them. In the `Buffer` class, `synchronized` ensures that only one thread accesses the buffer at a time. The `available` variable indicates whether the buffer contains data; if the buffer is full, the producer waits using `wait()`, and if it is empty, the consumer waits. After producing or consuming a value, `notify()` wakes the waiting thread. Thus, the code ensures that every produced value is consumed correctly without accessing the buffer at the wrong time.


Logic: 
PRODUCER
   ↓
Creates data
   ↓
BUFFER
   ↓
Stores data temporarily
   ↓
CONSUMER
   ↓
Uses data


Basic Rules:
Buffer full  → Producer waits
Buffer empty → Consumer waits
Producer adds data → Consumer can proceed
Consumer removes data → Producer can proceed

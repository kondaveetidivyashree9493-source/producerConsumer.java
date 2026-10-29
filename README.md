
# Producer-Consumer Problem in Java

## Aim
To implement the Producer-Consumer problem in Java using
inter-thread communication with wait() and notify().

## Description
The Producer-Consumer problem demonstrates communication
between two threads using a shared buffer.

- Producer: Creates items and adds them to the buffer.
- Consumer: Removes items from the buffer.
- Buffer: A LinkedList with a fixed capacity of 2.
- synchronized: Prevents both threads from accessing the
  shared buffer at the same time.
- wait(): Makes a thread wait when the buffer is full or empty.
- notify(): Wakes up a waiting thread when the buffer changes.

## Requirements
- Java JDK
- Any Java IDE or terminal

## How to Run
1. Save the program as ProducerConsumer.java.
2. Open a terminal in the same folder.
3. Compile the program:

   javac ProducerConsumer.java

4. Run the program:

   java ProducerConsumer

## Sample Output
Produced: 1
Consumed: 1
Produced: 2
Produced: 3
Consumed: 2
Consumed: 3
Produced: 4
Consumed: 4
Produced: 5
Consumed: 5

Note: The order of output may vary because both threads
execute concurrently.

## Result
The Producer-Consumer problem was implemented successfully
using LinkedList, synchronized, wait(), and notify().

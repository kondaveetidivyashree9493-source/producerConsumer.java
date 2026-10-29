
import java.util.LinkedList;

class Buffer {
    private LinkedList<Integer> list = new LinkedList<>();
    private int capacity = 2;

    public void produce(int item) throws InterruptedException {
        synchronized (this) {
            while (list.size() == capacity) {
                wait();
            }

            list.add(item);
            System.out.println("Produced: " + item);
            notify();
        }
    }

    public void consume() throws InterruptedException {
        synchronized (this) {
            while (list.isEmpty()) {
                wait();
            }

            int item = list.removeFirst();
            System.out.println("Consumed: " + item);
            notify();
        }
    }
}

class Producer extends Thread {
    Buffer buffer;

    Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.produce(i);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer extends Thread {
    Buffer buffer;

    Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.consume();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}

package dz4.dz2;

import java.util.LinkedList;

public class Queue {
    LinkedList<Object> queue;

    public Queue() {
        queue = new LinkedList<>();
    }

    public void enqueue(Object item) {
        queue.addLast(item);
    }

    public Object dequeue() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.removeFirst();
    }

    public Object first() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.getFirst();
    }
}

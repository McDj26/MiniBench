package org.jctools.queues;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BaseLinkedQueueTest {
    private static class TestQueue<E> extends BaseLinkedQueue<E> {}

    @Test
    public void sizeTest() {
        TestQueue<Integer> queue = new TestQueue<>();

        // Test empty queue
        assertEquals(0, queue.size(), "Queue should initially be empty");

        // Add elements to the queue
        LinkedQueueNode<Integer> node1 = new LinkedQueueNode<>(1);
        LinkedQueueNode<Integer> node2 = new LinkedQueueNode<>(2);
        LinkedQueueNode<Integer> node3 = new LinkedQueueNode<>(3);

        // Mocking the producer and consumer nodes
        queue.spConsumerNode(node1);
        queue.soProducerNode(node3);
        
        node1.soNext(node2);
        node2.soNext(node3);

        // Test queue with elements
        assertEquals(2, queue.size(), "Queue should have 2 elements");

        // Simulate consuming an element
        queue.spConsumerNode(node2);
        
        // Test after consuming an element
        assertEquals(1, queue.size(), "Queue should have 1 element after consuming one");
    }
}
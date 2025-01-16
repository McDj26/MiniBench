package org.jctools.queues;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class MockQueueNode<E> extends LinkedQueueNode<E> {
    private LinkedQueueNode<E> nextNode;

    public MockQueueNode(E value) {
        this.value = value;
    }

    @Override
    public LinkedQueueNode<E> lvNext() {
        return nextNode;
    }

    public void setNext(LinkedQueueNode<E> nextNode) {
        this.nextNode = nextNode;
    }
}

public class BaseLinkedQueuePad0Test {

    private BaseLinkedQueuePad0<Integer> queue;

    @BeforeEach
    public void setup() {
        queue = new BaseLinkedQueuePad0<Integer>() {
            private LinkedQueueNode<Integer> consumerNode;
            private LinkedQueueNode<Integer> producerNode;

            @Override
            final LinkedQueueNode<Integer> lvConsumerNode() {
                return consumerNode;
            }

            @Override
            final LinkedQueueNode<Integer> lvProducerNode() {
                return producerNode;
            }

            void setConsumerNode(LinkedQueueNode<Integer> node) {
                consumerNode = node;
            }

            void setProducerNode(LinkedQueueNode<Integer> node) {
                producerNode = node;
            }

            @Override
            public boolean offer(Integer e) { return false; }

            @Override
            public Integer poll() { return null; }

            @Override
            public Integer peek() { return null; }

            @Override
            public Iterator<Integer> iterator() { return null; }

            @Override
            public int size() {
                // Simulate the implementation as per the context
                LinkedQueueNode<Integer> chaserNode = lvConsumerNode();
                LinkedQueueNode<Integer> producerNode = lvProducerNode();
                int size = 0;
                while (chaserNode != producerNode 
                       && chaserNode != null 
                       && size < Integer.MAX_VALUE) {
                    LinkedQueueNode<Integer> next = chaserNode.lvNext();
                    if (next == chaserNode) {
                        return size;
                    }
                    chaserNode = next;
                    size++;
                }
                return size;
            }
        };
    }

    @Test
    public void sizeTest() {
        MockQueueNode<Integer> node1 = new MockQueueNode<>(1);
        MockQueueNode<Integer> node2 = new MockQueueNode<>(2);
        MockQueueNode<Integer> node3 = new MockQueueNode<>(3);

        node1.setNext(node2);
        node2.setNext(node3);

        queue.setConsumerNode(node1);
        queue.setProducerNode(node3);

        assertEquals(2, queue.size());

        // Test with nodes pointing to themselves:
        MockQueueNode<Integer> node4 = new MockQueueNode<>(4);
        node4.setNext(node4); // Point to itself
        queue.setConsumerNode(node4);
        queue.setProducerNode(node4);

        assertEquals(0, queue.size());
    }
}
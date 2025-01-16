package org.jctools.queues;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

public class BaseLinkedQueuePad0Test {

    // A simple LinkedQueueNode class for testing purposes
    static class LinkedQueueNode<E> {
        volatile LinkedQueueNode<E> next;
        E value;

        LinkedQueueNode(E value) {
            this.value = value;
        }

        void soNext(LinkedQueueNode<E> n) {
            this.next = n;
        }

        LinkedQueueNode<E> lvNext() {
            return next;
        }
    }

    // BaseLinkedQueue mock class
    static class BaseLinkedQueueMock<E> extends BaseLinkedQueue<E> {
        
        @Override
        public Iterator<E> iterator() { return null; }
        @Override 
        public boolean offer(E e) { return false; }
        @Override 
        public E poll() { return null; }
        @Override 
        public E peek() { return null; }

        void setProducerNode(LinkedQueueNode<E> node) {
            try {
                Field field = BaseLinkedQueueProducerNodeRef.class.getDeclaredField("producerNode");
                field.setAccessible(true);
                field.set(this, node);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        void setConsumerNode(LinkedQueueNode<E> node) {
            try {
                Field field = BaseLinkedQueueConsumerNodeRef.class.getDeclaredField("consumerNode");
                field.setAccessible(true);
                field.set(this, node);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        LinkedQueueNode<E> lvProducerNode() {
            try {
                Field field = BaseLinkedQueueProducerNodeRef.class.getDeclaredField("producerNode");
                field.setAccessible(true);
                return (LinkedQueueNode<E>) field.get(this);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        LinkedQueueNode<E> lvConsumerNode() {
            try {
                Field field = BaseLinkedQueueConsumerNodeRef.class.getDeclaredField("consumerNode");
                field.setAccessible(true);
                return (LinkedQueueNode<E>) field.get(this);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    @Test
    public void sizeTest() {
        BaseLinkedQueueMock<String> queue = new BaseLinkedQueueMock<>();

        // Create nodes
        LinkedQueueNode<String> node1 = new LinkedQueueNode<>("first");
        LinkedQueueNode<String> node2 = new LinkedQueueNode<>("second");
        LinkedQueueNode<String> node3 = new LinkedQueueNode<>("third");

        // Link nodes
        node1.soNext(node2);
        node2.soNext(node3);
        
        // Set producer and consumer nodes
        queue.setConsumerNode(node1);
        queue.setProducerNode(node3);

        assertEquals(2, queue.size(), "Queue size should be 2");

        // Test empty queue
        queue.setConsumerNode(node3);
        assertEquals(0, queue.size(), "Queue size should be 0 when consumer and producer nodes are the same");
    }
}
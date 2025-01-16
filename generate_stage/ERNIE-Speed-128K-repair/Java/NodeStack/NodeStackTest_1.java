package com.thealgorithms.datastructures.stacks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NodeStackTest {
    @Test
    public void pushTest() {
        NodeStack<Integer> stack = new NodeStack<>();
        Integer item = 5;
        
        // Push item onto an empty stack
        stack.push(item);
        assertFalse(stack.isEmpty()); // Stack should not be empty after push operation
        assertEquals(1, stack.size(), "Stack size should be 1 after pushing one item");
        assertEquals(item, stack.peek(), "Pushed item should be on top of the stack");
        
        // Push another item onto the stack
        Integer item2 = 10;
        stack.push(item2);
        assertEquals(2, stack.size(), "Stack size should be incremented after pushing another item");
        assertEquals(item2, stack.peek(), "Second pushed item should be on top of the stack");
    }
}
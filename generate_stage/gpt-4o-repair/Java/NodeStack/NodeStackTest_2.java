package com.thealgorithms.datastructures.stacks;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class NodeStackTest {

    private NodeStack<Integer> stack;

    @BeforeEach
    public void setUp() {
        stack = new NodeStack<>();
    }

    @Test
    public void pushTest() {
        // Initially, stack should be empty
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());

        // Push an item onto the stack
        stack.push(10);

        // Verify stack is not empty
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        
        // Verify the stack's head data
        assertEquals(10, stack.peek());

        // Push another item onto the stack
        stack.push(20);

        // Verify the stack's state
        assertFalse(stack.isEmpty());
        assertEquals(2, stack.size());
        assertEquals(20, stack.peek());
    }
}
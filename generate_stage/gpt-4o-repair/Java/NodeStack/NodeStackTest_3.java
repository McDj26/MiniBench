package com.thealgorithms.datastructures.stacks;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class NodeStackTest {

    @Test
    public void pushTest() {
        // Create a new NodeStack instance
        NodeStack<String> stack = new NodeStack<>();
        
        // Initially, the stack should be empty
        assertTrue(stack.isEmpty(), "Stack should be empty initially");
        assertEquals(0, stack.size(), "Stack size should be 0 initially");
        
        // Push a new item onto the stack
        String firstItem = "First Item";
        stack.push(firstItem);
        
        // After pushing, the stack should not be empty
        assertFalse(stack.isEmpty(), "Stack should not be empty after push");
        
        // The size should be 1
        assertEquals(1, stack.size(), "Stack size should be 1 after push");
        
        // The top item should be the one we just pushed
        assertEquals(firstItem, stack.peek(), "Top item should be the one we just pushed");
        
        // Push another item onto the stack
        String secondItem = "Second Item";
        stack.push(secondItem);
        
        // The size should be 2
        assertEquals(2, stack.size(), "Stack size should be 2 after second push");
        
        // The top item should now be the second item
        assertEquals(secondItem, stack.peek(), "Top item should be the second item pushed");
    }
}
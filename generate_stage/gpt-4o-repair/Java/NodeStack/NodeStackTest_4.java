package com.thealgorithms.datastructures.stacks;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class NodeStackTest {

    @Test
    public void pushTest() {
        NodeStack<Integer> stack = new NodeStack<>();
        
        assertTrue(stack.isEmpty(), "Stack should be empty initially.");
        
        stack.push(10);
        
        assertFalse(stack.isEmpty(), "Stack should not be empty after pushing an element.");
        
        assertEquals(1, stack.size(), "Stack size should be 1 after one push.");
        
        assertEquals(10, stack.peek(), "Top element should be 10 after pushing 10 onto the stack.");
        
        stack.push(20);
        
        assertEquals(2, stack.size(), "Stack size should be 2 after two pushes.");
        
        assertEquals(20, stack.peek(), "Top element should be 20 after pushing 20 onto the stack.");

        stack.push(30);

        assertEquals(3, stack.size(), "Stack size should be 3 after three pushes.");
        
        assertEquals(30, stack.peek(), "Top element should be 30 after pushing 30 onto the stack.");
        
        stack.pop();
        
        assertEquals(2, stack.size(), "Stack size should be 2 after popping one element.");
        
        assertEquals(20, stack.peek(), "Top element should be back to 20 after popping the top element.");
    }
}
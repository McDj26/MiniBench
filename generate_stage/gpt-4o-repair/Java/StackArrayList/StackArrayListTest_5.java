package com.thealgorithms.datastructures.stacks;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;

public class StackArrayListTest {

    @Test
    public void peekTest() {
        StackArrayList stack = new StackArrayList();
        
        // Test peeking on an empty stack should throw an exception
        Exception exception = assertThrows(EmptyStackException.class, () -> {
            stack.peek();
        });
        assertNotNull(exception, "Peek should throw EmptyStackException on empty stack");
        
        // Add elements to stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        // Test peeking at the top element
        assertEquals(3, stack.peek(), "Peek should return the last pushed element (3)");
        
        // Ensure the stack size remains unchanged after peek
        assertEquals(3, stack.size(), "Stack size should remain unchanged after peek");
        
        // Test peeking again doesn't alter stack
        assertEquals(3, stack.peek(), "Peek should still return the last pushed element (3)");
        assertEquals(3, stack.size(), "Stack size should remain constant after subsequent peeks");
    }
}
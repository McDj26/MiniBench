package com.thealgorithms.datastructures.stacks;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class StackArrayListTest {

    @Test
    public void peekTest() {
        StackArrayList stack = new StackArrayList();
        
        // Test peek on empty stack, should throw EmptyStackException
        assertThrows(EmptyStackException.class, stack::peek);

        // Push elements and test peek
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        // Peek should return the last pushed element without removing it
        assertEquals(30, stack.peek());

        // Ensure the size of the stack remains the same after peek
        assertEquals(3, stack.size());
        
        // Ensure peek does not remove the element from the stack
        assertEquals(30, stack.peek());
    }
}
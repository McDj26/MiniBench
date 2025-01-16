package com.thealgorithms.datastructures.stacks;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;

public class StackArrayListTest {

    @Test
    public void peekTest() {
        StackArrayList stack = new StackArrayList();

        // Test peek on an empty stack to trigger exception 
        assertThrows(EmptyStackException.class, stack::peek);

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Test peek on non-empty stack
        assertEquals(30, stack.peek());  // Check that the top element is correct

        // Ensure the element is not removed from the stack
        assertEquals(30, stack.peek());  // Peek again to verify no removal
        
        // Test after popping
        stack.pop();
        assertEquals(20, stack.peek());  // After pop, the new top should be 20
    }
}
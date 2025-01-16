package com.thealgorithms.datastructures.stacks;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class StackArrayListTest {
    @Test
    public void peekTest() {
        StackArrayList stack = new StackArrayList(); // Initialize the stack
        stack.push(5); // Push an element into the stack
        stack.push(10); // Push another element into the stack
        assertEquals(10, stack.peek(), "Should return the top element of the stack"); // Assert the peek method returns the top element
        stack.pop(); // Remove an element from the stack
        assertThrows(EmptyStackException.class, () -> { stack.peek(); }, "Should throw an EmptyStackException when the stack is empty"); // Assert that an EmptyStackException is thrown when the stack is empty
    }
}
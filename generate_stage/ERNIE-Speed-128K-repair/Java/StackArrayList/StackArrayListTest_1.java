package com.thealgorithms.datastructures.stacks;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class StackArrayListTest {
    private StackArrayList stack;
    private int stackElements;
    private static final int ELEMENT_VALUE = 5;
    private static final int TOP_ELEMENT_VALUE = 3; // Assuming this is the value at the top of the stack before peek operation

    @BeforeEach
    public void setUp() {
        stack = new StackArrayList(); // Initialize the stack
        stackElements = 5; // Number of elements in the stack after all push operations (arbitrary number)
        // Assuming there are some elements in the stack before peek operation, with TOP_ELEMENT_VALUE at the top
    }

    @Test
    public void peekTest() {
        // Push some elements into the stack (including TOP_ELEMENT_VALUE at the top) to simulate non-empty stack scenario
        for (int i = 0; i < stackElements; i++) {
            stack.push(ELEMENT_VALUE); // Push an arbitrary value to simulate multiple elements in the stack
        }
        stack.push(TOP_ELEMENT_VALUE); // Push the top element for this test case scenario
        // Execute the peek operation and assert that it returns TOP_ELEMENT_VALUE without removing it from the stack
        assertEquals(TOP_ELEMENT_VALUE, stack.peek()); // Assert that peek returns the correct value at the top of the stack
        // After peek operation, check if the stack is still not empty by attempting to pop an element
        int poppedElement = stack.pop(); // Pop an element to simulate checking if stack is still not empty after peek operation
        assertTrue(poppedElement == TOP_ELEMENT_VALUE); // Assert that the popped element is the one we just peeked at (TOP_ELEMENT_VALUE)
        // After popping TOP_ELEMENT_VALUE, check if the stack is now empty by attempting to peek again and expecting an exception
        assertThrows(EmptyStackException.class, () -> stack.peek()); // Assert that an EmptyStackException is thrown since the stack is now empty after pop operation
    }
}
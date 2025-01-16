package com.thealgorithms.datastructures.stacks;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class NodeStackTest {
    private NodeStack<Integer> stack; // Initialize the stack with Integer type items

    @BeforeEach
    public void setUp() {
        stack = new NodeStack<>(); // Create a new instance of NodeStack before each test
    }

    @Test
    public void pushTest() {
        // Push some items onto the stack
        stack.push(1); // Push integer 1 onto the stack
        stack.push(2); // Push integer 2 onto the stack after the first item
        stack.push(3); // Push integer 3 onto the stack after the previous two items
        
        // Assert that the stack is not empty after pushing items
        assertFalse(stack.isEmpty());
        // Assert that the size of the stack is equal to the number of items pushed
        assertEquals(3, stack.size());
        // Assert that the head of the stack is the last item pushed (integer 3)
        assertEquals(3, stack.peek().getData()); // Assuming peek() returns the data of the top node
    }
}
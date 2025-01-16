package com.thealgorithms.datastructures.stacks;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class NodeStackTest {

    @Test
    public void pushTest() {
        NodeStack<String> stack = new NodeStack<>();

        assertTrue(stack.isEmpty(), "Stack should be empty initially");

        stack.push("first");
        assertFalse(stack.isEmpty(), "Stack should not be empty after one push");
        assertEquals(1, stack.size(), "Stack size should be 1 after one push");
        assertEquals("first", stack.peek(), "Top of the stack should be 'first'");

        stack.push("second");
        assertEquals(2, stack.size(), "Stack size should be 2 after two pushes");
        assertEquals("second", stack.peek(), "Top of the stack should be 'second'");
    }
}
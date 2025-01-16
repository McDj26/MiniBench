package com.thealgorithms.datastructures.stacks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NodeStackTest {
    @Test
    public void pushTest() {
        NodeStack<Integer> stack = new NodeStack<>();
        Integer item = 5;
        
        // Push item on empty stack
        stack.push(item);
        assertFalse(stack.isEmpty()); // Should not be empty after pushing an item
        assertEquals(1, stack.size()); // Should have one item in the stack
        assertEquals(item, stack.peek()); // The item should be on top of the stack
        assertEquals(item, stack.pop()); // Popping should return the item that was pushed
        assertEquals(0, stack.size()); // After pop, the stack should be empty again
        assertTrue(stack.isEmpty()); // The stack should be empty after pop operation
        
        // Push multiple items on non-empty stack
        stack.push(item); // Push the same item again
        stack.push(item * 2); // Push a different item
        assertEquals(item * 2, stack.peek()); // The second item should be on top of the stack now
        assertEquals(item * 2, stack.pop()); // Popping should return the second item that was pushed
        assertEquals(item, stack.peek()); // The first item should be on top now after one pop operation
    }
}
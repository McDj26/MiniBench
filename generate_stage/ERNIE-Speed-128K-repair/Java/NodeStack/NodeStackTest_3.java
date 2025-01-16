package com.thealgorithms.datastructures.stacks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NodeStackTest {
    @Test
    public void pushTest() {
        NodeStack<Integer> stack = new NodeStack<>();
        Integer item1 = 1;
        Integer item2 = 2;
        Integer item3 = 3;
        
        // Push item1 onto the stack
        stack.push(item1);
        assertEquals(1, stack.size()); // Ensure size of stack is incremented after push
        assertEquals(item1, stack.peek()); // Ensure item1 is at the top of the stack after push
        assertFalse(stack.isEmpty()); // Stack should not be empty after push
        
        // Push item2 onto the stack
        stack.push(item2);
        assertEquals(2, stack.size()); // Stack size should be incremented with each push
        assertEquals(item2, stack.peek()); // Item2 should be at the top of the stack after second push
        assertFalse(stack.isEmpty()); // Stack should still not be empty after second push
        
        // Push item3 onto the stack
        stack.push(item3);
        assertEquals(3, stack.size()); // Stack size should be incremented with each push
        assertEquals(item3, stack.peek()); // Item3 should be at the top of the stack after third push
        assertFalse(stack.isEmpty()); // Stack should still not be empty after third push
    }
}
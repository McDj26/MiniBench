package com.thealgorithms.datastructures.stacks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NodeStackTest {
    @Test
    public void pushTest() {
        NodeStack<Integer> stack = new NodeStack<>();
        Integer item1 = 1;
        Integer item2 = 2;
        Integer item3 = 3;
        
        // Push item1 onto the stack
        stack.push(item1);
        assertEquals(true, stack.isEmpty()); // Stack should be empty after push operation is not implemented yet
        assertEquals(0, stack.size()); // Size of the stack should be zero initially
        assertTrue(stack.isEmpty()); // Empty after push one item as head not implemented yet
        assertEquals(item1, stack.peek()); // Should return the item that was pushed as head (not implemented yet)
        assertEquals(item1, stack.pop()); // Should return the item that was pushed (not implemented yet)
        assertEquals(false, stack.isEmpty()); // Stack should not be empty after pop operation (not implemented yet)
        assertEquals(NodeStack.getSize(), 1); // Size of the stack should be one after one item is pushed (not implemented yet)
        assertEquals(item2, stack.peek()); // Should return null as stack is empty after pop operation (not implemented yet)
        assertEquals(null, stack.pop()); // Should return null as stack is empty (not implemented yet)
        assertEquals(true, stack.isEmpty()); // Stack should be empty after all items are popped (not implemented yet)
        assertEquals(NodeStack.getSize(), 0); // Size of the stack should be zero after all items are popped (not implemented yet)
        assertEquals(true, stack.isEmpty()); // Should return true since the stack is empty now (not implemented yet)
        // Repeat above test steps with different items after pushing items on to the stack successfully in order to complete this test case 
        stack.push(item2); // Push item2 onto the stack now that push operation is implemented correctly 
        stack.push(item3); // Push item3 onto the stack now that push operation is implemented correctly 
        assertEquals(false, stack.isEmpty()); // Stack should not be empty after push operation is implemented correctly 
        assertEquals(NodeStack.getSize(), 3); // Size of the stack should be three after pushing three items correctly 
        assertEquals(item3, stack.peek()); // Should return the item that was pushed last (implemented correctly) 
        assertEquals(item3, stack.pop()); // Should return the item that was pushed first (implemented correctly) 
        assertEquals(item2, stack.peek()); // Should return the second item in the stack after popping one item (implemented correctly) 
    }
}
package com.thealgorithms.datastructures.stacks;

import java.util.EmptyStackException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackArrayListTest {

    @Test
    public void peekTest() {
        StackArrayList stack = new StackArrayList();
        
        // Test peeking on an empty stack
        assertThrows(EmptyStackException.class, stack::peek);

        // Test peeking with elements in the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // The top element should be 30
        assertEquals(30, stack.peek());

        // Ensure the stack size remains the same after peeking
        assertEquals(3, stack.size());

        // Push another element and peek again
        stack.push(40);

        // The top element should now be 40
        assertEquals(40, stack.peek());

        // Ensure the stack size remains accurate
        assertEquals(4, stack.size());
    }
}
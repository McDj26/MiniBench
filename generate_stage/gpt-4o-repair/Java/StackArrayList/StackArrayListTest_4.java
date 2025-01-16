package com.thealgorithms.datastructures.stacks;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;

public class StackArrayListTest {

    @Test
    public void peekTest() {
        StackArrayList stack = new StackArrayList();
        
        // Test peeking an empty stack should throw EmptyStackException
        assertThrows(EmptyStackException.class, () -> stack.peek());
        
        // Push a few elements and verify that peek returns the correct element
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek(), "Peek should return the last pushed element");
        
        // Push another element and check again
        stack.push(3);
        assertEquals(3, stack.peek(), "Peek should return the last element pushed");

        // Pop an element and then check peek again
        stack.pop();
        assertEquals(2, stack.peek(), "Peek should return the element 2 after popping the top element");
    }
}
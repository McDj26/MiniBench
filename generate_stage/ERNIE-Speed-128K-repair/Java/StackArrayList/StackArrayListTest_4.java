package com.thealgorithms.datastructures.stacks;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class StackArrayListTest {
    private StackArrayList stackArrayList;

    @BeforeEach
    public void setUp() {
        stackArrayList = new StackArrayList();
    }

    @Test
    public void peekTest() {
        // Test for an empty stack
        assertThrows(EmptyStackException.class, () -> {
            stackArrayList.peek();
        });
        // Push elements onto the stack and test the peek method
        stackArrayList.push(1);
        stackArrayList.push(2);
        stackArrayList.push(3);
        assertEquals(3, stackArrayList.peek(), "The peek method should return the top element of the stack.");
        // Test the peek method after removing elements from the stack
        stackArrayList.pop(); // remove 3 from the stack
        assertEquals(2, stackArrayList.peek(), "The peek method should still return the second top element after removing one.");
    }
}
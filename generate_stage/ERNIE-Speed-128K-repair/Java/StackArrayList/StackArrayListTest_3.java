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
        // Test peek when stack is empty
        assertThrows(EmptyStackException.class, () -> {
            stackArrayList.peek();
        });
        
        // Push elements into the stack
        stackArrayList.push(1);
        stackArrayList.push(2);
        stackArrayList.push(3);
        
        // Test peek when stack is not empty
        assertEquals(3, stackArrayList.peek(), "The peek should return the top element of the stack.");
        assertEquals(3, stackArrayList.size(), "The size of the stack should not change after peek.");
    }
}
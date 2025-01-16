package com.thealgorithms.datastructures.stacks;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Item { 
    // Assuming there is some basic implementation for Item class.
    // This is a placeholder, since Item is required for the stack.
}

public class NodeStackTest {

    @Test
    public void pushTest() {
        NodeStack<Item> stack = new NodeStack<>();
        
        assertTrue(stack.isEmpty(), "Stack should be empty initially");
        
        Item item1 = new Item();
        stack.push(item1);
        
        assertFalse(stack.isEmpty(), "Stack should not be empty after pushing an item");
        assertEquals(1, stack.size(), "Stack size should be 1 after one push");
        assertEquals(item1, stack.peek(), "Top of the stack should be the item pushed last (item1)");
        
        Item item2 = new Item();
        stack.push(item2);
        
        assertEquals(2, stack.size(), "Stack size should be 2 after two pushes");
        assertEquals(item2, stack.peek(), "Top of the stack should be the item pushed last (item2)");
        
        // You might need to add more tests to fully check all edge cases

    }
}
package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CursorLinkedListTest {

    @Test
    public void indexOfTest() {
        CursorLinkedList<String> list = new CursorLinkedList<>();
        
        // Assuming an append method to add elements
        list.append("A");
        list.append("B");
        list.append("C");
        
        // Test for an element that exists in the list
        assertEquals(0, list.indexOf("A"), "Index should be 0 for element 'A'");
        assertEquals(1, list.indexOf("B"), "Index should be 1 for element 'B'");
        assertEquals(2, list.indexOf("C"), "Index should be 2 for element 'C'");
        
        // Test for an element that does not exist in the list
        assertEquals(-1, list.indexOf("D"), "Index should be -1 for non-existent element 'D'");
        
        // Test for null input
        assertThrows(NullPointerException.class, () -> {
            list.indexOf(null);
        }, "Should throw NullPointerException for null element");
    }
}
package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CursorLinkedListTest {

    private CursorLinkedList<String> list;

    @BeforeEach
    public void setUp() {
        list = new CursorLinkedList<>();
        list.append("A");
        list.append("B");
        list.append("C");
    }

    @Test
    public void indexOfTest() {
        // Test for element present in the list
        assertEquals(0, list.indexOf("A"), "indexOf should return 0 for element 'A'");
        assertEquals(1, list.indexOf("B"), "indexOf should return 1 for element 'B'");
        assertEquals(2, list.indexOf("C"), "indexOf should return 2 for element 'C'");
        
        // Test for element not present in the list
        assertEquals(-1, list.indexOf("D"), "indexOf should return -1 for non-existing element 'D'");
        
        // Test for null element
        assertThrows(NullPointerException.class, () -> {
            list.indexOf(null);
        }, "indexOf should throw NullPointerException for null element");
    }
}
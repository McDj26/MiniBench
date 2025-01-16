package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class Merge_K_SortedLinkedlistTest {
    @Test
    public void mergeKListTest() {
        Merge_K_SortedLinkedlist solution = new Merge_K_SortedLinkedlist();
        // Test Case 1: Simple Linked List Merge
        Node node1 = new Node(); node1.data = 1; node1.next = new Node(); node1.next.data = 3; node1.next.next = null; // Node with values 1 -> 3
        Node node2 = new Node(); node2.data = 2; node2.next = null; // Node with value 2
        Node[] listArray = {node1, node2}; // Array of two linked lists to merge
        Node result = solution.mergeKList(listArray, 2); // Merge the two linked lists
        assertEquals(Integer.valueOf(1), result.data); // Assert that the head of the merged list is 1
        assertEquals(Integer.valueOf(2), result.next.data); // Assert that the next node after head is 2
        assertEquals(Integer.valueOf(3), result.next.next.data); // Assert that the third node is 3
        assertNull(result.next.next.next); // Assert that the list ends here
        // Test Case 2: Multiple Linked List Merge with different lengths and values
        Node node3 = new Node(); node3.data = 5; node3.next = new Node(); node3.next.data = 7; node3.next.next = null; // Node with values 5 -> 7
        Node node4 = new Node(); node4.data = 4; node4.next = null; // Node with value 4
        Node node5 = new Node(); node5.data = 6; node5.next = null; // Node with value 6
        Node[] listArrayMultiple = {node3, node4, node5}; // Array of three linked lists to merge
        result = solution.mergeKList(listArrayMultiple, 3); // Merge the three linked lists
        assertEquals(Integer.valueOf(4), result.data); // Assert that the head of the merged list is the smallest value i.e., 4 in this case
        assertEquals(Integer.valueOf(5), result.next.data); // Assert that the next node after head is the second smallest value i.e., 5 in this case
        assertEquals(Integer.valueOf(6), result.next.next.data); // Assert that the third node is the third smallest value i.e., 6 in this case
        assertEquals(Integer.valueOf(7), result.next.next.next.data); // Assert that the fourth node is the largest value i.e., 7 in this case
        assertNull(result.next.next.next.next); // Assert that the list ends here
    }
}
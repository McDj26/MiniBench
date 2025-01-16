package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class Merge_K_SortedLinkedlistTest {
    @Test
    public void mergeKListTest() {
        Merge_K_SortedLinkedlist mergeKLinkedLists = new Merge_K_SortedLinkedlist();
        Node[] linkedLists = new Node[]{new Node(1), new Node(3), new Node(5)}; // Test with 3 sorted linked lists
        int size = linkedLists.length; // Number of linked lists to merge
        Node mergedListHead = mergeKLinkedLists.mergeKList(linkedLists, size); // Merge the linked lists
        assertNotNull(mergedListHead); // Assert that the merged list is not null
        Node current = mergedListHead; // Current node to traverse the merged list
        int expectedValues = 1; // Expected value from the first list in merged order
        while (current != null) { // Traverse the merged list
            assertEquals(expectedValues, current.data); // Assert that the current node's data matches the expected value
            current = current.next; // Move to the next node in the merged list
            expectedValues++; // Increment expected value for next node in the first list (if it exists)
        }
    }
    
    // Inner class Node for testing purposes with a constructor to set data value
    private class Node {
        private int data;
        private Node next;
        public Node(int data) { this.data = data; } // Constructor for setting data value for node initialization in test case
    }
}

Explanation: The provided unit test case has been completed by adding a test method `mergeKListTest()`. In this test, we initialize a `Merge_K_SortedLinkedlist` object and create an array of nodes representing three sorted linked lists. We then call the `mergeKList` method to merge these linked lists and assert that the returned merged list is not null. We then traverse the merged list and assert that each node's data matches the expected value from the sorted order of the merged lists. The `Node` class has been modified to include a constructor for setting the data value in the test case for node initialization.
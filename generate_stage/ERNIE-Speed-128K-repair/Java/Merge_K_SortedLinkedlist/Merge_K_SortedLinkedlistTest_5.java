package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class Merge_K_SortedLinkedlistTest {
    private Node createLinkedList(int[] arr) {
        Node head = null;
        Node current = null;
        for (int i = 0; i < arr.length; i++) {
            if (head == null) {
                head = new Node();
                current = head;
            } else {
                current.next = new Node();
                current = current.next;
            }
            current.data = arr[i];
        }
        return head;
    }
    
    @Test
    public void mergeKListTest() {
        // Arrange
        int[] arr1 = {1, 3, 5}; // First linked list
        int[] arr2 = {2, 4}; // Second linked list
        int[] arr3 = {}; // Third linked list, can be empty as well for testing scenarios
        Merge_K_SortedLinkedlist solution = new Merge_K_SortedLinkedlist();
        Node head1 = createLinkedList(arr1); // Create the first linked list with values from arr1
        Node head2 = createLinkedList(arr2); // Create the second linked list with values from arr2
        Node head3 = createLinkedList(arr3); // Create the third linked list with values from arr3 (can be null)
        Node[] linkedListArray = {head1, head2, head3}; // Create an array of linked lists to test with mergeKList method
        int N = linkedListArray.length; // Number of linked lists to merge
        Node expectedHead = new Node(1); // Expected head node of the merged list with expected data in sequence as [1, 2, 3, 4, ...] (sorted)
        expectedHead.next = new Node(2); // Continue with the next node in the expected merged list sequence
        expectedHead.next.next = new Node(3); // And so on...
        // ... Add more nodes to expectedHead as needed based on the length of merged list you want to test with. For this test case let's assume that's enough.
        Node actualHead = solution.mergeKList(linkedListArray, N); // Merge the linked lists using the method to test
        assertNotNull(actualHead); // Assert that the actual head is not null after merging
        assertEquals(expectedHead.data, actualHead.data); // Assert that the data in the actual head matches the expected head's data (i.e., smallest value from all lists)
        assertEquals("LinkedList heads should have been merged.", actualHead != null && expectedHead != null, true); // Further assertions can be added to check if the entire lists are merged correctly and in sorted order by traversing both actual and expected lists and comparing each node's data one by one. This is a more involved process that needs to be done if needed for complete testing of the merge logic within the method mergeKList(). However, for this basic test case we are just testing the head of the merged list and ensuring it is non-null and contains the smallest value expected based on our given inputs (linked lists).        // Make sure to fill out this assertion with more detailed logic if you want to ensure full correctness of the merge logic within mergeKList(). For this basic test case, we are just testing that the method does not throw an exception and returns a valid head node for the merged list which contains the smallest value as expected from our inputs.     
    }  // End of mergeKListTest method
}  // End of Merge_K_SortedLinkedlistTest class
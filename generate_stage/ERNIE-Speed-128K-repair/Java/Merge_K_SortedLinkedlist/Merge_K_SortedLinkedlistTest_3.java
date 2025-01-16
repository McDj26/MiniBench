package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class Merge_K_SortedLinkedlistTest {
    
    @Test
    public void mergeKListTest() {
        // Create 3 linked lists with values: 1 -> 3 -> 5, 2 -> 4, and null
        Merge_K_SortedLinkedlist mergeKList = new Merge_K_SortedLinkedlist();
        Node list1 = new Node(); // Initialize the head of the first list with 1
        list1.data = 1; // Setting the data of the head node to 1
        Node list1Next = new Node(); // Initialize the next node of the first list with 3
        list1Next.data = 3; // Setting the data of the next node to 3
        list1.next = list1Next; // Linking the head to the next node of the first list
        Node list2 = new Node(); // Initialize the head of the second list with 2
        list2.data = 2; // Setting the data of the head node to 2
        Node list3 = null; // Third list is null
        Node[] a = {list1, list2, list3}; // Array of linked lists to be merged
        int N = 3; // Number of linked lists in array 'a'
        Node mergedListHead = mergeKList.mergeKList(a, N); // Merge the linked lists
        assertNotNull(mergedListHead); // Assert that merged list is not null
        assertEquals(mergedListHead.data, 1); // Assert that merged list starts with 1 (the smallest value)
        assertEquals(mergedListHead.next.data, 2); // Assert that next node in merged list is 2 (next smallest value)
        assertEquals(mergedListHead.next.next.data, 3); // Assert that next node after 2 is 3 (next smallest value from first list)
        assertNull(mergedListHead.next.next.next); // Assert that merged list ends here since all linked lists are empty or exhausted after merging three nodes from each list.
    }
}
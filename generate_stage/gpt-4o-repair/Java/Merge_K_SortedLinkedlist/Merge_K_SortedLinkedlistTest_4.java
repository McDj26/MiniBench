package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Merge_K_SortedLinkedlistTest {

    private class Node {
        private int data;
        private Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    @Test
    public void mergeKListTest() {
        // Create 3 sorted linked lists
        Node l1 = new Node(1);
        l1.next = new Node(4);
        l1.next.next = new Node(5);
        
        Node l2 = new Node(1);
        l2.next = new Node(3);
        l2.next.next = new Node(4);
        
        Node l3 = new Node(2);
        l3.next = new Node(6);

        Node[] array = {l1, l2, l3};

        Merge_K_SortedLinkedlist mergeKSortedLinkedlist = new Merge_K_SortedLinkedlist();
        Node mergedHead = mergeKSortedLinkedlist.mergeKList(array, 3);

        // Expected merged linked list: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
        int[] expectedValues = {1, 1, 2, 3, 4, 4, 5, 6};
        Node current = mergedHead;
        int index = 0;

        while (current != null) {
            assertEquals(expectedValues[index], current.data);
            current = current.next;
            index++;
        }

        assertEquals(expectedValues.length, index); // Check if we traversed all expected elements
    }
}
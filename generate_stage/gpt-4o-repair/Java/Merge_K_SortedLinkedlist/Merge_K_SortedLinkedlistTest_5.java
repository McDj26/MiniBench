package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.*;
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
        Merge_K_SortedLinkedlist mergeLists = new Merge_K_SortedLinkedlist();
        
        // List1: 1 -> 4 -> 5
        Node list1 = new Node(1);
        list1.next = new Node(4);
        list1.next.next = new Node(5);

        // List2: 1 -> 3 -> 4
        Node list2 = new Node(1);
        list2.next = new Node(3);
        list2.next.next = new Node(4);

        // List3: 2 -> 6
        Node list3 = new Node(2);
        list3.next = new Node(6);
        
        Node[] lists = new Node[]{list1, list2, list3};
        int N = lists.length;

        // Merged list should be: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
        Node mergedHead = mergeLists.mergeKList(lists, N);
        int[] expectedValues = {1, 1, 2, 3, 4, 4, 5, 6};
        int i = 0;

        while (mergedHead != null) {
            assertEquals(expectedValues[i++], mergedHead.data);
            mergedHead = mergedHead.next;
        }

        assertEquals(expectedValues.length, i, "Merged list should have " + expectedValues.length + " elements.");
    }
}
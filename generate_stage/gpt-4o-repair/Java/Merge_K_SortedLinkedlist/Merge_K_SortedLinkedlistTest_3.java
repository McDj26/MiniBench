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
        // Helper method to create a linked list from an array and return the head
        Node createLinkedList(int[] values) {
            if (values.length == 0) return null;
            Node head = new Node(values[0]);
            Node current = head;
            for (int i = 1; i < values.length; i++) {
                current.next = new Node(values[i]);
                current = current.next;
            }
            return head;
        }
        
        // Creating linked lists
        Node l1 = createLinkedList(new int[] {1, 4, 5});
        Node l2 = createLinkedList(new int[] {1, 3, 4});
        Node l3 = createLinkedList(new int[] {2, 6});
        
        // Adding the linked lists to the array
        Node[] lists = new Node[] {l1, l2, l3};
        
        // Instantiate the class and call the method
        Merge_K_SortedLinkedlist merger = new Merge_K_SortedLinkedlist();
        Node mergedHead = merger.mergeKList(lists, lists.length);

        // Helper method to convert linked list to array for easy comparison
        int[] linkedListToArray(Node head) {
            List<Integer> result = new ArrayList<>();
            Node current = head;
            while (current != null) {
                result.add(current.data);
                current = current.next;
            }
            return result.stream().mapToInt(i -> i).toArray();
        }

        // Expected result array for comparison
        int[] expected = new int[] {1, 1, 2, 3, 4, 4, 5, 6};
        
        // Convert merged linked list to array and check if it matches expected result
        assertArrayEquals(expected, linkedListToArray(mergedHead));
    }
}
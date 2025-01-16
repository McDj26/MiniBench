package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Merge_K_SortedLinkedlistTest {

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node createList(int[] values) {
        if (values.length == 0) return null;
        
        Node head = new Node(values[0]);
        Node current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;
        }
        return head;
    }

    private int[] listToArray(Node head) {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int[] result = new int[count];
        temp = head;
        int index = 0;
        while (temp != null) {
            result[index++] = temp.data;
            temp = temp.next;
        }

        return result;
    }

    @Test
    public void mergeKListTest() {
        Merge_K_SortedLinkedlist merger = new Merge_K_SortedLinkedlist();

        Node[] lists = new Node[3];
        lists[0] = createList(new int[]{1, 4, 5});
        lists[1] = createList(new int[]{1, 3, 4});
        lists[2] = createList(new int[]{2, 6});

        Node mergedHead = merger.mergeKList(lists, lists.length);
        int[] expected = new int[]{1, 1, 2, 3, 4, 4, 5, 6};
        assertArrayEquals(expected, listToArray(mergedHead));
    }
}
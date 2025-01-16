package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Merge_K_SortedLinkedlistTest {

    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node constructLinkedList(int[] values) {
        Node dummy = new Node(-1);
        Node current = dummy;
        for (int value : values) {
            current.next = new Node(value);
            current = current.next;
        }
        return dummy.next;
    }

    private int[] linkedListToArray(Node node) {
        int[] result = new int[100]; // Adjust size as per requirements
        int index = 0;
        while (node != null) {
            result[index++] = node.data;
            node = node.next;
        }
        return Arrays.copyOf(result, index);
    }

    @Test
    public void mergeKListTest() {
        Merge_K_SortedLinkedlist mergeKSortedLinkedlist = new Merge_K_SortedLinkedlist();

        Node[] lists = new Node[3];
        lists[0] = constructLinkedList(new int[]{1, 4, 5});
        lists[1] = constructLinkedList(new int[]{1, 3, 4});
        lists[2] = constructLinkedList(new int[]{2, 6});

        Node mergedHead = mergeKSortedLinkedlist.mergeKList(lists, lists.length);
        int[] expected = {1, 1, 2, 3, 4, 4, 5, 6};
        assertArrayEquals(expected, linkedListToArray(mergedHead));
    }
}
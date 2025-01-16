package com.thealgorithms.datastructures.trees;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    @Test
    public void removeTest() {
        // Create a new binary tree and add some values to it
        BinaryTree binaryTree = new BinaryTree();

        // Add nodes to the binary tree
        binaryTree.put(10);
        binaryTree.put(5);
        binaryTree.put(15);
        binaryTree.put(3);
        binaryTree.put(7);
        binaryTree.put(12);
        binaryTree.put(18);

        // Ensure nodes exist before removal
        assertNotNull(binaryTree.find(5));
        assertNotNull(binaryTree.find(15));
        assertNotNull(binaryTree.find(3));

        // Test removing a leaf node
        assertTrue(binaryTree.remove(3));
        assertNull(binaryTree.find(3));

        // Test removing a node with one child
        assertTrue(binaryTree.remove(5));
        assertNull(binaryTree.find(5));
        assertNotNull(binaryTree.find(7)); // should still exist, since it was child of 5

        // Test removing a node with two children
        assertTrue(binaryTree.remove(10)); // root with two children
        assertNull(binaryTree.find(10));

        // Test removing a non-existing node
        assertFalse(binaryTree.remove(100)); // 100 doesn't exist

        // Test removing root node
        BinaryTree binaryTree2 = new BinaryTree();
        binaryTree2.put(20);
        assertTrue(binaryTree2.remove(20)); // the node to remove is the root
        assertNull(binaryTree2.find(20));
        assertNull(binaryTree2.getRoot());
    }
}
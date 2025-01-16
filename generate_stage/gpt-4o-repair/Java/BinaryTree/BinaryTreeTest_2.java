package com.thealgorithms.datastructures.trees;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    @Test
    public void removeTest() {
        BinaryTree tree = new BinaryTree();

        // Add nodes to the tree
        tree.put(10);
        tree.put(5);
        tree.put(15);
        tree.put(3);
        tree.put(7);
        tree.put(12);
        tree.put(17);

        // Test removing a leaf node
        assertTrue(tree.remove(3), "Failed to remove leaf node");
        assertNull(tree.find(3), "Leaf node was not removed");

        // Test removing a node with one child
        assertTrue(tree.remove(5), "Failed to remove node with one child");
        assertNull(tree.find(5), "Node with one child was not removed");
        assertNotNull(tree.find(7), "Child node of removed node is missing");

        // Test removing a node with two children
        assertTrue(tree.remove(10), "Failed to remove node with two children");
        assertNull(tree.find(10), "Node with two children was not removed");
        assertEquals(12, tree.getRoot().data, "Successor node was not placed correctly");

        // Test removing root node when it's the only node
        tree = new BinaryTree();
        tree.put(42);
        assertTrue(tree.remove(42), "Failed to remove root node");
        assertNull(tree.getRoot(), "Root node was not removed");

        // Test attempting to remove a non-existent node
        tree.put(50);
        assertFalse(tree.remove(100), "Non-existent node should not be removed");
    }
}
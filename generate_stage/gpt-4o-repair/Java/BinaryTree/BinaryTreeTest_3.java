package com.thealgorithms.datastructures.trees;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    @Test
    public void removeTest() {
        // Prepare the binary tree
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        tree.put(5);
        tree.put(15);
        tree.put(3);
        tree.put(7);
        tree.put(12);
        tree.put(18);

        // Test removal of a leaf node
        assertTrue(tree.remove(3), "Leaf node should be removed successfully");
        assertNull(tree.find(3), "Leaf node 3 should no longer be present in the tree");

        // Test removal of a node with one child
        assertTrue(tree.remove(5), "Node with one child should be removed successfully");
        assertNull(tree.find(5), "Node 5 should no longer be present in the tree");
        assertNotNull(tree.find(7), "Child node 7 should still be present in the tree");

        // Test removal of a node with two children
        assertTrue(tree.remove(10), "Node with two children should be removed successfully");
        assertNull(tree.find(10), "Node 10 should no longer be present in the tree");
        assertNotNull(tree.find(12), "Successor node 12 should be present as new root");

        // Test removal of a non-existent node
        assertFalse(tree.remove(20), "Non-existent node should not be removed");

        // Test removal of root node
        assertTrue(tree.remove(12), "Root node should be removed successfully");
        assertNull(tree.find(12), "Root node 12 should no longer be present in the tree");
    }
}
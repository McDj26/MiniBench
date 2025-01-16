package com.thealgorithms.datastructures.trees;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {
    @Test
    public void removeTest() {
        BinaryTree binaryTree = new BinaryTree(); // Assuming you have a default constructor for BinaryTree
        // Insert nodes to test with (Assuming the nodes are integers)
        binaryTree.put(5); // root node
        binaryTree.put(3); // left child of root
        binaryTree.put(7); // right child of root
        binaryTree.put(2); // left child of left child of root
        binaryTree.put(4); // right child of left child of root
        binaryTree.put(8); // right child of root
        binaryTree.put(9); // additional node to test one child scenario
        binaryTree.put(1); // additional node to test two children scenario
        binaryTree.put(6); // additional node to test no child scenario
        // Test removing nodes
        assertTrue(binaryTree.remove(6)); // Testing no child scenario
        assertTrue(binaryTree.remove(3)); // Testing one child scenario with left child
        assertTrue(binaryTree.remove(7)); // Testing one child scenario with right child
        assertTrue(binaryTree.remove(4)); // Testing two children scenario with right child as successor
        assertTrue(binaryTree.remove(2)); // Testing two children scenario with left child as successor
        assertFalse(binaryTree.remove(1)); // Testing non-existent value removal
        assertFalse(binaryTree.remove(10)); // Testing non-existent value removal (different value)
    }
}